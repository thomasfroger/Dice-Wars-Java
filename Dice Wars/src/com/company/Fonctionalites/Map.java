// Copyright code Thomas Froger
// L3 Project Java - 2020 - 2021


package com.company.Fonctionalites;

import java.util.ArrayList;
import java.util.stream.Collectors;
import com.company.App.BinaireS;


public class Map {

    private TerCollect terCollect = new TerCollect();
    
    // la matrice_territoire contient le territoire auquel la cellule appartient, null si pas de territoire (cellule vide)
    private Matrice<Ter> matriceTerritoires;
    private ArrayList<String>  matriceAdjacence;


    public Map() {}


    public Ter getValueAt(int ligne, int colonne) {
    	return matriceTerritoires.get(ligne, colonne);
    }
    
  
    public TerCollect getTerrColl() {
        return terCollect;
    }


    public void setTerritoiresCollection(TerCollect terCollect) {
        this.terCollect = terCollect;
    }

    public ArrayList<Integer> neighbors(int territoire) {
        BinaireS bs = new BinaireS(getMatriceAdjacence().get(territoire));
        return bs.to_position();
    }

    public ArrayList<Integer> neighbors(ArrayList<Integer> territoires) {
        ArrayList<Integer> adjacents = new ArrayList<>();
        for (int i : territoires) {
            adjacents.addAll(neighbors(i));
        }
        return adjacents.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
    }

    public int nb_des_pour_territoire(String TerrName) {
        return terCollect.getbuyNAME(TerrName).getNbDes();
    }

    public Player proprietaire_territoire(String TERNAME) {
        return terCollect.getbuyNAME(TERNAME).getProprierty();
    }

    public void modifier_nb_des_pour_territoire(String territoireNom, int nb_des) {
    	terCollect.getbuyNAME(territoireNom).setNbDes(nb_des);
    }

    public void modifier_proprietaire_territoire(String territoireNom, Player proprietaire) {
    	terCollect.getbuyNAME(territoireNom).setProprierty(proprietaire);
    }


	public String getCarteSerialisee() {
		return null;
	}


	public Matrice<Ter> getMatriceTerr() {
		return matriceTerritoires;
	}


	public void setMatriceTerr(Matrice<Ter> matriceTerritoires) {
		this.matriceTerritoires = matriceTerritoires;
	}

	public ArrayList<String> getMatriceAdjacence() {
		return matriceAdjacence;
	}


	public void setMatriceAdjacence(ArrayList<String> matriceAdjacence) {
		this.matriceAdjacence = matriceAdjacence;
	}
}
