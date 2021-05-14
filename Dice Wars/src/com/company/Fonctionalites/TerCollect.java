// Copyright code Thomas Froger
// L3 Project Java - 2020 - 2021


package com.company.Fonctionalites;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TerCollect extends HashSet<Ter> {
	
	private static final long serialVersionUID = 1920693883334995492L;
	
	public TerCollect() {
		super();
	}
	
	public Optional<Ter> geOptionalParNom(String nom) {
		return this.stream()
				.filter(t -> t.getName().equals(nom))
				.findAny();
	}
	// methode dangereuse mais le null n'est pas censé exister dans ce programme donc ok
	public Ter getbuyNAME(String nom) {
		return geOptionalParNom(nom).get();
	}

	public TerCollect getAllPourJoueur(Player player) {
		TerCollect terCollect = new TerCollect();
		this.forEach(t -> {
			if (t.getProprierty().equals(player)) {
				terCollect.add(t);
			}
		});
		return terCollect;
	}

	public int nbTerrContig(Player player) {
		TerCollect ensemble_territoires = getAllPourJoueur(player);
		int max = 0;
		for (Ter ter : ensemble_territoires) {
			int nb_territoires = ter.terrContigus(this).size();
			if (nb_territoires > max) {
				max = nb_territoires;
			}
		}
		return max;
	}

	public String toTxt() {
		String str = "TerritoiresCollection(";
		Iterator<Ter> it = this.iterator();
		while(it.hasNext()){
			str+=it.next().toTxt();
			if (it.hasNext()) str+=";";
		}
		str+=")";
		return str;
	}

	public static TerCollect fromTxt(String terrCollectS) {
		Pattern p = Pattern.compile("TerritoiresCollection\\((.*)\\)") ;
		Matcher m = p.matcher(terrCollectS) ;
		boolean b = m.matches() ;
		String match = m.group(1);
		System.out.println(match);
		Pattern p2 = Pattern.compile("(\\d+);(.*)") ;
		Matcher m2 = p2.matcher(match) ;
		boolean b2 = m2.matches() ;

		System.out.println(b2);

		System.out.println(m2.group(2));
		int nbJoueurs = Integer.parseInt(m2.group(1));
		TerCollect terCollect = TerCollect.fromTxt(m2.group(2));


		return new TerCollect();
	}

}
