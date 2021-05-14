// Copyright code Thomas Froger
// L3 Project Java - 2020 - 2021


package com.company.Fonctionalites;


import static com.company.App.Application.PlatLenght;
import static com.company.App.Application.PlatWeidht;


public class MapFacto {

	private TerCollect terCollect;
	private Map map;

	public MapFacto(TerCollect terCollect) {
		this.terCollect = terCollect;
		this.map = new Map();
	}

	public Map create() {
		setTerr();
		setMatriceTerr();
		setAdjacence();
		return map;
	}

	private void setTerr() {
		map.setTerritoiresCollection(terCollect);
	}

	private void setMatriceTerr() {
		Matrice<Ter> matriceTerr = new Matrice<Ter>(PlatLenght, PlatWeidht) ;
		map.getTerrColl().forEach(t -> {
			t.getCellulesCollection().forEach(c -> {
				matriceTerr.set(c, t);
			});
		});
		map.setMatriceTerr(matriceTerr);
	}

	private  void setAdjacence() {
		
		map.getTerrColl().forEach(t -> {
			TerCollect terrAdjacents = new TerCollect();
			t.getCellulesCollection().forEach(c -> {
				c.neighbours().forEach(cv -> {
					Ter neighbours = map.getMatriceTerr().get(cv);
					if (neighbours != null) terrAdjacents.add(neighbours);
				});
			});
			t.setAdjacents(terrAdjacents);
		});
	}

}
