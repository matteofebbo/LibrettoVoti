package it.polito.tdp.libretto.model;

import java.util.Comparator;

public class ComparatorePerVoto implements Comparator<Voto> {

	@Override
	public int compare(Voto o1, Voto o2) {
		
		return o2.getVoto()-o1.getVoto();
	}

}
