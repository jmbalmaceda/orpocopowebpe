package com.criterya.orco.model;

import java.util.Date;

public class Posicion {
	private Integer x;
	private Integer y;
	private Integer depth;
	private Date moment;
	
	public Posicion() {}

	public Posicion(Integer x, Integer y, Integer depth) {
		super();
		this.x = x;
		this.y = y;
		this.depth = depth;
	}
	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	public Integer getDepth() {
		return depth;
	}
	public void setDepth(Integer depth) {
		this.depth = depth;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}
}
