package com.criterya.orco.spring.utils;

import java.awt.Color;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.StatisticalBarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.statistics.DefaultStatisticalCategoryDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.criterya.orco.beans.PromedioYDesviacion;
import com.criterya.orco.spring.daos.RecorridoPersonaDao;
import com.criterya.orco.spring.services.UtilsService;

@Component("chartUtils")
public class ChartUtils {
	@Autowired
	private RecorridoPersonaDao recorridoPersonaDao;
	@Autowired
	private UtilsService utilsService;
	
	static String[] diasSemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
	
	public RecorridoPersonaDao getRecorridoPersonaDao() {
		return recorridoPersonaDao;
	}

	public void setRecorridoPersonaDao(RecorridoPersonaDao recorridoPersonaDao) {
		this.recorridoPersonaDao = recorridoPersonaDao;
	}
	
	public JFreeChart createChart(final CategoryDataset dataset) {

		final JFreeChart chart = ChartFactory.createBarChart(
				"", 
				"Fecha", 
				"Cantidad", 
				dataset, 
				PlotOrientation.VERTICAL, 
				true, 
				true, 
				false
				);

		chart.setBackgroundPaint(Color.white);

		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		plot.setAnchorValue(2);
		//*
		plot.setBackgroundPaint(Color.white);
		plot.setDomainGridlinePaint(Color.lightGray);
		plot.setRangeGridlinePaint(Color.lightGray);
		plot.setDomainCrosshairVisible(true);
		plot.setRangeCrosshairVisible(false);
		CategoryAxis xAxis = plot.getDomainAxis();
		xAxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);

		//*/
		return chart;

	}

	
	public JFreeChart dataset_CantidadVisitantesDiario(Date inicio, Date fin){
		Map<Date, Long> map = utilsService.getPersonasPeriodo(inicio, fin);
		TimeSeries pop = new TimeSeries("Population", Day.class);
		Iterator<Date> itKey = map.keySet().iterator();
		while (itKey.hasNext()) {
			Date periodo = (Date) itKey.next();
			pop.addOrUpdate(new Day(periodo), map.get(periodo));
		}
				
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(pop);
		JFreeChart chart = ChartFactory.createTimeSeriesChart(
				"",
				"Fecha",
				"",
				dataset,
				true,
				true,
				false);
		return chart;
	}
	
	public JFreeChart dataset_CantidadVisitantesHora(Date inicio, Date fin){
		//StatisticalLineAndShapeRenderer chart = new StatisticalLineAndShapeRenderer();
		
		Map<Integer, Long> map = utilsService.getPersonasHora(inicio, fin);
		TimeSeries pop = new TimeSeries("Promedio visitantes por hora", Integer.class);
		Iterator<Integer> itKey = map.keySet().iterator();
		while (itKey.hasNext()) {
			Integer hora = (Integer) itKey.next();
			pop.addOrUpdate(new Hour(hora, new Day()), map.get(hora));
		}
				
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(pop);
		JFreeChart chart = ChartFactory.createTimeSeriesChart(
				"",
				"Hora",
				"",
				dataset,
				true,
				true,
				false);
		return chart;
	}
	
	public JFreeChart dataset_PromedioVisitantesDia(Date inicio, Date fin){
		Map<Integer, PromedioYDesviacion> map = utilsService.getPersonasSemana(inicio, fin);
		//DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		DefaultStatisticalCategoryDataset dataset = new DefaultStatisticalCategoryDataset();

		for (int i=0; i<7; i++){
			Number cant = 0L;
			Number std = 0L;
			if (map.containsKey(i)){
				cant = map.get(i).promedio;
				std = map.get(i).desviacion;
			}
			dataset.add((Number)cant, std, "Promedio Visitantes", diasSemana[i]);
		}
		//*
		
		CategoryPlot plot = new CategoryPlot(
                dataset,
                new CategoryAxis("Día de la Semana"),
                new NumberAxis(),
                new StatisticalBarRenderer());
          plot.setOrientation(PlotOrientation.VERTICAL);
          plot.setBackgroundPaint(Color.lightGray);

          JFreeChart chart = new JFreeChart("",JFreeChart.DEFAULT_TITLE_FONT,plot,true);

          chart.setBackgroundPaint(Color.white);
		
		/*/
		JFreeChart chart = ChartFactory.createBarChart("Promedio por día de semana", "", "", dataset, PlotOrientation.VERTICAL, true, true, false);
		chart.getCategoryPlot().getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(120d));
		//*/
		return chart;
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		ApplicationContext appContext = new FileSystemXmlApplicationContext("C:/Users/cito/workspace/orpocopowebpe/OrcoWeb/src/main/webapp/WEB-INF/spring-services.xml");
		ChartUtils utils = (ChartUtils) appContext.getBean("chartUtils");
		Calendar cal = Calendar.getInstance();
		cal.set(2015, 6, 1);
		Date inicio = cal.getTime();
		cal.set(2015, 8, 1);
		Date fin = cal.getTime();
		//JFreeChart chart = utils.dataset_PromedioVisitantesSemana(inicio, fin);
		JFreeChart chart = utils.dataset_PromedioVisitantesDia(inicio, fin);
		ChartPanel chartPanel = new ChartPanel(chart);
		frame.add(chartPanel);
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}

	public UtilsService getUtilsService() {
		return utilsService;
	}

	public void setUtilsService(UtilsService utilsService) {
		this.utilsService = utilsService;
	}
}
