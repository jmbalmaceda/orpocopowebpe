package com.criterya.orco.utils;

import java.awt.Color;
import java.util.Date;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimePeriodValues;
import org.jfree.data.time.TimePeriodValuesCollection;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import com.criterya.orco.beans.GetRecorridosResponse;
import com.criterya.orco.model.RecorridoPersona;
import com.criterya.orco.spring.daos.RecorridoPersonaDao;

public class ChartUtils {
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
		TimeSeries pop = new TimeSeries("Population", Day.class);		
		pop.addOrUpdate(new Day(10, 1, 2004), 100);
		pop.addOrUpdate(new Day(11, 1, 2004), 120);
		pop.addOrUpdate(new Day(12, 1, 2004), 150);
		pop.addOrUpdate(new Day(13, 1, 2004), 250);
		pop.addOrUpdate(new Day(14, 1, 2004), 275);
		pop.addOrUpdate(new Day(15, 1, 2004), 325);
		pop.addOrUpdate(new Day(16, 1, 2004), 425);
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

}
