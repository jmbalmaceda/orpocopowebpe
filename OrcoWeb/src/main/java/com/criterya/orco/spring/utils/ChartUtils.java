package com.criterya.orco.spring.utils;

import java.awt.Color;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.criterya.orco.beans.GetRecorridosResponse;
import com.criterya.orco.model.RecorridoPersona;
import com.criterya.orco.spring.daos.RecorridoPersonaDao;

@Component("chartUtils")
public class ChartUtils {
	@Autowired
	private RecorridoPersonaDao recorridoPersonaDao;
	
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

	
	public JFreeChart dataset_PromedioVisitantesSemana(Date inicio, Date fin){
		GetRecorridosResponse recorridoResponse = recorridoPersonaDao.getRecorridos(inicio, fin);
		List<RecorridoPersona> recorridos = recorridoResponse.getRecorridos();
		TimeSeries pop = new TimeSeries("Population", Day.class);
		for (RecorridoPersona recorridoPersona : recorridos) {
			pop.addOrUpdate(new Day(recorridoPersona.getEntrada()), recorridoPersona.getDuracionRecorrido());
		}
				
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(pop);
		JFreeChart chart = ChartFactory.createTimeSeriesChart(
				"Population of CSC408 Town",
				"Date",
				"Population",
				dataset,
				true,
				true,
				false);
		return chart;
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		ApplicationContext appContext = new FileSystemXmlApplicationContext("C:/Users/cito/workspace/orpocopowebpe/OrcoWeb/src/main/webapp/WEB-INF/spring-services.xml");
		ChartUtils utils = (ChartUtils) appContext.getBean("chartUtils");
		Calendar cal = Calendar.getInstance();
		cal.set(2015, 6, 1);
		Date inicio = cal.getTime();
		cal.set(2015, 7, 1);
		Date fin = cal.getTime();
		JFreeChart chart = utils.dataset_PromedioVisitantesSemana(inicio, fin);
		ChartPanel chartPanel = new ChartPanel(chart);
		frame.add(chartPanel);
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
}
