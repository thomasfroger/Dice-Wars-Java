// Copyright code Thomas Froger
// L3 Project Java - 2020 - 2021


package com.company.Fonctionalites;

import static com.company.App.Application.PlatWeidht;


import java.util.*;

import com.company.App.NSEO;

public class CelCollect extends HashSet<NSEO> {
	

	private static final long serialVersionUID = 5314974788024886171L;

	public CelCollect() {
		super();
	}
	
	public CelCollect(ArrayList<NSEO> list) {
		super(list);
	}
	
	public boolean include(NSEO NSEO) {
		return this.contains(NSEO);
	}
	
	public NSEO moresmall() {
		NSEO NSEO = new NSEO(999, 999);
		this.forEach( c -> {
			if (c.x+c.y* PlatWeidht < NSEO.x+ NSEO.y* PlatWeidht) {
				NSEO.x = c.x;
				NSEO.y = c.y;
			}
		});
		return NSEO;
	}

	public static CelCollect fromTxt(String txt) {

		return new CelCollect();
	}

	public String toTxt() {
		String str = "CellulesCollection(";
		Iterator<NSEO> it = this.iterator();
		while(it.hasNext()){
			str+=it.next().toString();
			if (it.hasNext()) str+=";";
		}
		str+=")";
		return str;
	}


}
