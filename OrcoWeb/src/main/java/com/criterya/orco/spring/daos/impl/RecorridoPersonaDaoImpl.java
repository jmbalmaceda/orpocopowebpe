package com.criterya.orco.spring.daos.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.criterya.orco.beans.GetRecorridosResponse;
import com.criterya.orco.commons.RecorridoConstants;
import com.criterya.orco.commons.RecorridoPersonaCommons;
import com.criterya.orco.model.Pickup;
import com.criterya.orco.model.RecorridoPersona;
import com.criterya.orco.spring.daos.AbstractDao;
import com.criterya.orco.spring.daos.RecorridoPersonaDao;

@Transactional("transactionManager")
public class RecorridoPersonaDaoImpl extends AbstractDao implements RecorridoPersonaDao {
	/* (non-Javadoc)
	 * @see com.criterya.orco.spring.daos.impl.RecorridoPersonaDao#getRecorridos(java.util.Date, java.util.Date)
	 */
	@Override
	public GetRecorridosResponse getRecorridos(Date inicio, Date fin){
		GetRecorridosResponse salida = new GetRecorridosResponse();
		List<RecorridoPersona> recorridos = new ArrayList<RecorridoPersona>();
		Session s = getSession();
		@SuppressWarnings("unchecked")
		List<Pickup> l = s.createCriteria(Pickup.class).add(Restrictions.between("currentTime", inicio, fin)).add(Restrictions.or(Restrictions.isNull("blobHandId"),Restrictions.not(Restrictions.eqProperty("blobId", "blobHandId")))).list();

		// Agrupo por blobId
		HashMap<Integer, ArrayList<Pickup>> blob_arrayPickup = new HashMap<>();
		HashSet<Integer> blob_hasPickup = new HashSet<>();
		Integer blobId = null;
		ArrayList<Pickup> bp = null;
		for (Pickup p : l) {
			blobId = p.getBlobId();
			if (!blob_arrayPickup.containsKey(blobId)){
				bp = new ArrayList<>();
				blob_arrayPickup.put(blobId, bp);
			}else
				bp = blob_arrayPickup.get(blobId);
			bp.add(p);
			if (p.getBlobHandId()!=null && !blob_hasPickup.contains(p.getBlobId()))
				blob_hasPickup.add(p.getBlobId());
		}
		// Ordeno los pickup por id
		Iterator<Integer> it = blob_arrayPickup.keySet().iterator();
		while (it.hasNext()) {
			blobId = (Integer) it.next();
			bp = blob_arrayPickup.get(blobId);
			// Elimino aquellas personas para las cuales tengo menos de N cantidad de frames
			if (bp.size()>=RecorridoConstants.MIN_COUNT_FRAMES){
				Collections.sort(bp, new Comparator<Pickup>(){

					@Override
					public int compare(Pickup o1, Pickup o2) {
						return o1.getId().compareTo(o2.getId());
					}

				});
				// Genero una instancia de RecorridoPersona por cada blobId
				RecorridoPersona rp = new RecorridoPersona();
				rp.setBlobId(blobId);
				rp.setEntrada(bp.get(0).getCurrentTime());
				rp.setSalida(bp.get(bp.size()-1).getCurrentTime());
				rp.setPickup(blob_hasPickup.contains(blobId));
				// Agrego el recorrido de la persona
				rp.setRecorrido(RecorridoPersonaCommons.getRecorrido(bp));
				// Analizar el sentido del recorrido
				String sentido = RecorridoPersonaCommons.getSentidoRecorrido(rp);
				salida.addUnidadSentidos(sentido);
				rp.setSentido(sentido);

				recorridos.add(rp);
			}
		}
		
		salida.setRecorridos(recorridos);
		return salida;
	}

}
