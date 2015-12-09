package com.criterya.orco.model;

import java.util.Date;
import java.util.List;

public class RecorridoPersona {
	private Integer blobId;
	private Date entrada;
	private Date salida;
	private List<Posicion> recorrido;
	private Boolean pickup;
	private String sentido;
	
	/**
	 * Devuelve el tiempo que duró el recorrido de la persona frente a la góndola.
	 * Devuelve un valor expresado en segundos;
	 * @return
	 */
	public int getDuracionRecorrido(){
		long finish = salida.getTime();
		long start = entrada.getTime();
		long diff = finish-start;
		return (int)diff / 1000;
	}
	
	public Integer getBlobId() {
		return blobId;
	}
	public void setBlobId(Integer blobId) {
		this.blobId = blobId;
	}
	public Date getEntrada() {
		return entrada;
	}
	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}
	public Date getSalida() {
		return salida;
	}
	public void setSalida(Date salida) {
		this.salida = salida;
	}
	public List<Posicion> getRecorrido() {
		return recorrido;
	}
	public void setRecorrido(List<Posicion> recorrido) {
		this.recorrido = recorrido;
	}

	public Boolean getPickup() {
		return pickup;
	}

	public void setPickup(Boolean pickup) {
		this.pickup = pickup;
	}

	public String getSentido() {
		return sentido;
	}

	public void setSentido(String sentido) {
		this.sentido = sentido;
	}
	
	
}
