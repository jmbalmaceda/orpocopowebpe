package com.criterya.orco.spring.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.criterya.orco.beans.GetRecorridosResponse;
import com.criterya.orco.commons.RecorridoConstants;
import com.criterya.orco.spring.dto.DashboardFilter;
import com.criterya.orco.spring.services.TimesService;
import com.criterya.orco.spring.services.UtilsService;
import com.criterya.orco.spring.utils.ChartUtils;
import com.keypoint.PngEncoder;

@Controller
public class ActivitiesController {

	@Autowired
	@Qualifier("timesService")
	TimesService timesService;

	@Autowired
	UtilsService utilsService;
	
	@Autowired
	ChartUtils chartUtils;

	Date inicio;
	Date fin;
	
	public ActivitiesController() {
	}


	@InitBinder
  	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(
	            dateFormat, false));
  		//binder.setValidator(elementFormValidator);
  	}
	
	
	@RequestMapping(value="/activities", method = RequestMethod.GET)
	public String show(Model model) {
		if (inicio==null || fin ==null){
			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();
			c1.set(2015, 7, 10,0,0,0);
			c2.set(2015, 7, 15,23,59,59);
			inicio = c1.getTime();
			fin = c2.getTime();
		}
		DashboardFilter filter = new DashboardFilter();
		filter.setStart(inicio);
		filter.setFinish(fin);
		model.addAttribute("dashboardFilter", filter);
		Calendar calInicio = Calendar.getInstance();
		calInicio.setTime(inicio);
		String startParam = calInicio.get(Calendar.YEAR)+"-"+(1+calInicio.get(Calendar.MONTH))+"-"+calInicio.get(Calendar.DAY_OF_MONTH)+
				"T"+calInicio.get(Calendar.HOUR_OF_DAY)+":"+calInicio.get(Calendar.MINUTE)+":"+calInicio.get(Calendar.SECOND);
		Calendar calFin = Calendar.getInstance();
		calFin.setTime(fin);
		String finishParam = calFin.get(Calendar.YEAR)+"-"+(1+calFin.get(Calendar.MONTH))+"-"+calFin.get(Calendar.DAY_OF_MONTH)+
				"T"+calFin.get(Calendar.HOUR_OF_DAY)+":"+calFin.get(Calendar.MINUTE)+":"+calFin.get(Calendar.SECOND);;
		model.addAttribute("startParam", startParam);
		model.addAttribute("finishParam", finishParam);
		
		GetRecorridosResponse recorrido = utilsService.getRecorridos(inicio, fin);
		model.addAttribute("cantidadVisitantes", recorrido.getRecorridos().size());
		HashMap<String, Integer> sentidos = recorrido.getCantidadSentidos();
		model.addAttribute("sentidoDI", sentidos.get(RecorridoConstants.DERECHA_IZQUIERDA));
		model.addAttribute("sentidoID", sentidos.get(RecorridoConstants.IZQUIERDA_DERECHA));
		model.addAttribute("shoppers", recorrido.getCantidadPickups());
		
		return "activities/show";
	}
	
	@RequestMapping(value = "activities/updateTimes", method = RequestMethod.POST)
	public String updateTime(@ModelAttribute("dashboardFilter") DashboardFilter filter, BindingResult result1) {
		this.inicio = filter.getStart();
		this.fin = filter.getFinish();
		return "redirect:/activities.htm";
	}
	
	@ResponseBody
	@RequestMapping(value="/getPromedioVisitantesDiaSemana", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getPromedioVisitantesDiaSemana(@RequestParam(value="start") @DateTimeFormat(pattern="yyyy-MM-dd'T'hh:mm:ss") Date start, @RequestParam(value="finish") @DateTimeFormat(pattern="yyyy-MM-dd'T'hh:mm:ss") Date finish)
	{
		JFreeChart chart = chartUtils.dataset_PromedioVisitantesDia(start, finish);
		chart.setBackgroundPaint(Color.white);

		final CategoryPlot plot = chart.getCategoryPlot();
		plot.setForegroundAlpha(0.5f);

		plot.setBackgroundPaint(Color.lightGray);
		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.white);
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.white);

		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();

		rangeAxis.setLabelAngle(1 * Math.PI / 2.0);

		ChartRenderingInfo info = null;

		info = new ChartRenderingInfo(new StandardEntityCollection());
		//response.setContentType("image/png");
		BufferedImage chartImage = chart.createBufferedImage(700, 400, info);

		PngEncoder encoder = new PngEncoder(chartImage, false, 0, 9);

		//response.getOutputStream().write(encoder.pngEncode());
		
		return ResponseEntity.ok()
	            //.contentLength(gridFsFile.getLength())
	            .contentType(MediaType.IMAGE_PNG)
	            .body(encoder.pngEncode());
	}
	
	@ResponseBody
	@RequestMapping(value="/getPromedioVisitantesDiario", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getPromedioVisitantesDiario(@RequestParam(value="start") @DateTimeFormat(pattern="yyyy-MM-dd") Date start, @RequestParam(value="finish") @DateTimeFormat(pattern="yyyy-MM-dd") Date finish)
	{
		JFreeChart chart = chartUtils.dataset_CantidadVisitantesDiario(start, finish);
		chart.setBackgroundPaint(Color.white);
		final XYPlot plot = chart.getXYPlot();
		plot.setForegroundAlpha(0.5f);

		plot.setBackgroundPaint(Color.lightGray);
		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.white);
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.white);

		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();

		rangeAxis.setLabelAngle(1 * Math.PI / 2.0);

		ChartRenderingInfo info = null;

		info = new ChartRenderingInfo(new StandardEntityCollection());
		//response.setContentType("image/png");
		BufferedImage chartImage = chart.createBufferedImage(700, 400, info);

		PngEncoder encoder = new PngEncoder(chartImage, false, 0, 9);

		//response.getOutputStream().write(encoder.pngEncode());
		
		return ResponseEntity.ok()
	            //.contentLength(gridFsFile.getLength())
	            .contentType(MediaType.IMAGE_PNG)
	            .body(encoder.pngEncode());
	}
	
	@ResponseBody
	@RequestMapping(value="/getPromedioVisitantesHora", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getPromedioVisitantesHora(@RequestParam(value="start") @DateTimeFormat(pattern="yyyy-MM-dd") Date start, @RequestParam(value="finish") @DateTimeFormat(pattern="yyyy-MM-dd") Date finish)
	{
		JFreeChart chart = chartUtils.dataset_CantidadVisitantesHora(start, finish);
		chart.setBackgroundPaint(Color.white);
		final XYPlot plot = chart.getXYPlot();
		plot.setForegroundAlpha(0.5f);

		plot.setBackgroundPaint(Color.lightGray);
		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.white);
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.white);

		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();

		rangeAxis.setLabelAngle(1 * Math.PI / 2.0);

		ChartRenderingInfo info = null;

		info = new ChartRenderingInfo(new StandardEntityCollection());
		//response.setContentType("image/png");
		BufferedImage chartImage = chart.createBufferedImage(700, 400, info);

		PngEncoder encoder = new PngEncoder(chartImage, false, 0, 9);

		//response.getOutputStream().write(encoder.pngEncode());
		
		return ResponseEntity.ok()
	            //.contentLength(gridFsFile.getLength())
	            .contentType(MediaType.IMAGE_PNG)
	            .body(encoder.pngEncode());
	}


	@RequestMapping(value="/getBarChartView", method = RequestMethod.GET)
	public void getBarChartView(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		dataset.addValue(1.0, "1985-90", "1985-90");

		dataset.addValue(2.5, "1990-95", "1990-95");

		dataset.addValue(4.0, "1995-2000", "1995-2000");

		dataset.addValue(5.0, "2000-05", "2000-05");

		final JFreeChart chart = ChartFactory.createBarChart("Bar Chart", "Year", "Population (in millions)",
				dataset, PlotOrientation.VERTICAL, true, true, false);

		chart.setBackgroundPaint(Color.white);
		final TextTitle subtitle = new TextTitle(
				" The below Bar Chart shows population growth in Chennai(India), every 5 years from 1985 .");
		subtitle.setFont(new Font("SansSerif", Font.PLAIN, 12));

		chart.addSubtitle(subtitle);

		final CategoryPlot plot = chart.getCategoryPlot();
		plot.setForegroundAlpha(0.5f);

		plot.setBackgroundPaint(Color.lightGray);
		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.white);
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.white);

		final CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
		domainAxis.setLowerMargin(0.0);
		domainAxis.setUpperMargin(0.0);

		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();

		rangeAxis.setLabelAngle(1 * Math.PI / 2.0);

		ChartRenderingInfo info = null;

		info = new ChartRenderingInfo(new StandardEntityCollection());
		response.setContentType("image/png");
		BufferedImage chartImage = chart.createBufferedImage(700, 400, info);

		PngEncoder encoder = new PngEncoder(chartImage, false, 0, 9);

		response.getOutputStream().write(encoder.pngEncode());
	}

	
	@RequestMapping(value="/getPieChartView", method = RequestMethod.GET)
	public void getPieChartView(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		System.out.println("In Chart View Controller");

		final DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("1985-90", new Double(1.02));
		dataset.setValue("1990-95", new Double(2.5));
		dataset.setValue("1995-2000", new Double(4.0));
		dataset.setValue("2000-2005", new Double(5.0));

		final JFreeChart chart = ChartFactory.createPieChart3D("Pie Chart ", dataset, true, true, false);

		chart.setBackgroundPaint(Color.white);
		final TextTitle subtitle = new TextTitle(
				" The below Pie Chart shows population growth in Chennai(India), every 5 years from 1985 .");
		subtitle.setFont(new Font("SansSerif", Font.PLAIN, 12));

		chart.addSubtitle(subtitle);

		ChartRenderingInfo info = null;

		info = new ChartRenderingInfo(new StandardEntityCollection());
		response.setContentType("image/png");
		BufferedImage chartImage = chart.createBufferedImage(700, 400, info);

		PngEncoder encoder = new PngEncoder(chartImage, false, 0, 9);

		response.getOutputStream().write(encoder.pngEncode());
	}


	/*
	@RequestMapping(value = "/times/{id}/show", method = RequestMethod.GET)
	public String showTime(@PathVariable("id") Integer id, Model model) {
		Times time = timesService.getTime(id);
		model.addAttribute("time", time);
		return "/times/form";
	}

	@RequestMapping(value = "/times/update", method = RequestMethod.POST)
	public String updateTime(@Validated @ModelAttribute("time") Times time, BindingResult result, Model model) {
		timesService.saveOrUpdate(time);
		return "redirect:/times.htm";
	}
	 */
}
