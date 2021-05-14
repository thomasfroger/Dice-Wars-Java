// Copyright code Thomas Froger
// L3 Project Java - 2020 - 2021


package com.company.Fonctionalites;

import java.awt.*;
import java.util.ArrayList;

public class Ter {

    //txt : A;(1,3);4;3;...
	private String nom; //txt : A
	private CelCollect celCollect; // txt : (1,3)
    private int nbDes; // txt : 4
    private Player proprierty; //txt : 3
    private TerCollect adjacents ;
    private Color color = Color.WHITE;

    public Ter(String name, CelCollect celCollect, int nbDes, Player proprierty) {
        this.nom = name;
        this.celCollect = celCollect;
        this.nbDes = nbDes;
        this.proprierty = proprierty;
    }

    public Ter(String name, CelCollect celCollect) {
       this(name, celCollect, 0, null);
    }

    public String toTxt() {
        String str = "Territoire(";
        str = str + getName() + ";";
        str = str + getCellulesCollection().toTxt() + ";";
        str = str + getNbDes() + ";";
        str = str + getProprierty().getId();
        str = str + ")";
        return str;
    }

    public Ter buildFromTxt(Round round, String csv) {
        String[] parts = csv.split(";", -1);
        String name = parts[0];
        CelCollect celCollect = CelCollect.fromTxt(parts[1]);
        int nbDes = Integer.parseInt(parts[2]);
        int idProprierty = Integer.parseInt(parts[3]);
        Player proprierty = round.getPlayers().getParId(idProprierty);
        return new Ter(name , celCollect, nbDes, proprierty);
    }

    public int getNbDes() {
        return nbDes;
    }

    public void setNbDes(int nbDes) {
        this.nbDes = nbDes;
    }

    public Player getProprierty() {
        return proprierty;
    }

    public void setProprierty(Player proprierty) {
        this.proprierty = proprierty;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

	public String getName() {
		return nom;
	}

	public TerCollect getAdjacents() {
		return adjacents;
	}

	public void setAdjacents(TerCollect adjacents) {
		this.adjacents = adjacents;
	}

    public ArrayList<Ter> terrContigus(TerCollect terCollect) {
    	terCollect.forEach(t -> t.setColor(Color.WHITE));
        ArrayList<Ter> file = new ArrayList<>();
        ArrayList<Ter> contigus = new ArrayList<>();
        Ter explore;
        this.setColor(Color.BLACK);
        file.add(this);
        contigus.add(this);
        while (! file.isEmpty()) {
            explore = file.get(file.size()-1);
            file.remove(file.size()-1);
            TerCollect voisins = explore.getAdjacents().getAllPourJoueur(this.getProprierty());
            for (Ter parcours : voisins) {
                if (parcours.getColor() != Color.BLACK) {
                    parcours.setColor(Color.BLACK);
                    file.add(parcours);
                    contigus.add(parcours);
                }
            }
        }

        return contigus;
    }

	public CelCollect getCellulesCollection() {
		return celCollect;
	}

}