package com.criterya.orco.commons;

import java.util.ArrayList;
import java.util.List;

import com.criterya.orco.model.Pickup;
import com.criterya.orco.model.Posicion;
import com.criterya.orco.model.RecorridoPersona;

public class RecorridoPersonaCommons {

	/**
	 * Devuelve la cantidad de RecorridoPersona en los cuales hubo interacción del cliente con la góndola.
	 * @param listaRecorridos
	 * @return
	 */
	public static int getCantidadPickups(List<RecorridoPersona> listaRecorridos){
		int count = 0;
		for (RecorridoPersona recorridoPersona : listaRecorridos) {
			if (recorridoPersona.getPickup())
				count++;
		}
		return count;
	}

	public static List<Posicion> getRecorrido(ArrayList<Pickup> bp) {
		List<Posicion> salida = new ArrayList<>();
		for (Pickup pickup : bp) {
			Posicion pos = new Posicion(pickup.getBlobX(), pickup.getBlobY(), pickup.getBlobDepth());
			pos.setMoment(pickup.getCurrentTime());
			salida.add(pos);
		}
		return salida;
	}

	public static String getSentidoRecorrido(RecorridoPersona rp) {
		List<Posicion> recorrido = rp.getRecorrido();
		Posicion p0 = recorrido.get(0);
		Posicion p1 = recorrido.get(1);
		
		Posicion pn_1 = recorrido.get(recorrido.size()-2);
		Posicion pn = recorrido.get(recorrido.size()-1);
		
		// Analizar el comienzo
		boolean comienzoHaciaDerecha = false;
		if (p0.getX()<=p1.getX())
			comienzoHaciaDerecha = true;
		// Analizar el final
		boolean finalHaciaDerecha = false;
		if (pn_1.getX()<=pn.getX())
			finalHaciaDerecha=true;
		
		if (comienzoHaciaDerecha)
			if (finalHaciaDerecha)
				return RecorridoConstants.IZQUIERDA_DERECHA;
			else
				return RecorridoConstants.IZQUIERDA_IZQUIERDA;
		else
			if (finalHaciaDerecha)
				return RecorridoConstants.DERECHA_DERECHA;
			else
				return RecorridoConstants.DERECHA_IZQUIERDA;
	}
	
}
