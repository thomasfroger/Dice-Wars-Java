// Copyright code Thomas Froger
// L3 Project Java - 2020 - 2021


package com.company.Fonctionalites;
import java.util.ArrayList;

import com.company.App.NSEO;

public class Matrice<T> {
	
	private int nbColumns;
	private int nbLines;
	private ArrayList<T> matrice = new  ArrayList<>();
	
	public Matrice(int nbLines, int nbColumns) {
		this.nbLines = nbLines;
		this.nbColumns = nbColumns;
		for(int i = 0; i < nbColumns * nbLines; i++) {
			matrice.add(null);
		}
	}
	
	public void set(int lines, int columns, T value) {
		matrice.set(columns+lines* nbColumns, value);
	}
	
	// coordonnées fonctionnent  "à l'envers" x est la colonne, y la ligne
	public void set(NSEO c, T value) {
		set(c.y, c.x, value);
	}
	
	public T get(int lines, int columns) {
		return matrice.get(columns+lines* nbColumns);
	}
	
	public T get(NSEO c) {
		return get(c.y, c.x);
	}

	public int getNbColonness() {
		return nbColumns;
	}
	
	public int getNbLines() {
		return nbLines;
	}

}
