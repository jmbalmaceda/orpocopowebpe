package com.criterya.orco.beans;

import java.util.HashMap;
import java.util.List;

import com.criterya.orco.model.RecorridoPersona;

public class GetRecorridosResponse {

	private List<RecorridoPersona> recorridos;
	private HashMap<String, Integer> cantidadSentidos;
	private int cantidadPickups;

	public GetRecorridosResponse() {
		cantidadSentidos = new HashMap<>();
	}
	
	public void addUnidadSentidos(String sentido){
		int value = 0;
		if (cantidadSentidos.containsKey(sentido)){
			value = cantidadSentidos.get(sentido);
		}
		value++;
		cantidadSentidos.put(sentido, value);
	}
	
	public void addPickup(){
		cantidadPickups++;
	}
	
	public void setRecorridos(List<RecorridoPersona> recorridos) {
		this.recorridos = recorridos;
	}

	public List<RecorridoPersona> getRecorridos() {
		return recorridos;
	}

	public HashMap<String, Integer> getCantidadSentidos() {
		return cantidadSentidos;
	}

	public int getCantidadPickups() {
		return cantidadPickups;
	}
	
}
