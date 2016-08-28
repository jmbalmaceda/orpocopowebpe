package com.criterya.orco.beans;

import java.util.Date;

public class Histograma {
	private static final int MAX_Y = 480;
	private static final int MAX_X = 640;
	private int minValue = 0;
	private int maxValue = 0;
	/**
	 * datos expresados en x,y
	 */
	int[][] values = new int[MAX_X][MAX_Y];
	Date start;
	Date finish;
	
	public void setValue(int x, int y, int value){
		values[x][y] = value;
		updateMaxMin(value);
	}

	private void updateMaxMin(int value) {
		if (value > maxValue)
			maxValue = value;
		if (value<minValue)
			minValue = value;
	}
	
	public int getValue(int x, int y){
		return values[x][y];
	}

	public int getMinValue() {
		return minValue;
	}

	public int getMaxValue() {
		return maxValue;
	}
	
	private int getSmoothValue(int x, int y, int range){
		int xInit = x-range;
		int xFinish = x+range;
		int yInit = y-range;
		int yFinish = y+range;
		int value = values[x][y];
		int count = 1;
		int sum = value;
		for(int xi=xInit; xi<=xFinish; xi++)
			if (xi>=0 && xi <MAX_X)
				for (int yi=yInit; yi<=yFinish; yi++)
					if (yi>=0 && yi < MAX_Y && values[xi][yi]>value){
						count++;
						sum += values[xi][yi];
					}
		return sum / count;
	}
	
	public Histograma getSmooth(int range){
		Histograma salida = new Histograma();
		for (int x=0; x<MAX_X; x++)
			for (int y=0; y<MAX_Y; y++){
				int newValue = getSmoothValue(x, y, range);
				salida.values[x][y] = newValue;
				salida.updateMaxMin(newValue);
			}
		return salida ;
	}
}
