// Copyright code Thomas Froger
// L3 Project Java - 2020 - 2021


package com.company.App;

import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.company.App.Application.*;

// ici nous allons gérer tout ce qui est cordonnee d'ou Nord Sud Est Ouest


public class NSEO {
	
	public int x;
	public int y;
	
	public NSEO(int x, int y) {
		this.x = x;
		this.y=y;
	}
	
	
    public  ArrayList<NSEO> neighbours() {
        ArrayList<NSEO> neighbours = new ArrayList<>();
        NSEO nord = new NSEO(x-1, y);
        NSEO est = new NSEO(x, y+1);
        NSEO sud = new NSEO(x+1, y);
        NSEO ouest = new NSEO(x, y-1);
        if (coordinates_valid(nord)) neighbours.add(nord);
        if (coordinates_valid(est)) neighbours.add(est);
        if (coordinates_valid(sud)) neighbours.add(sud);
        if (coordinates_valid(ouest)) neighbours.add(ouest);
        return neighbours;
    }
    
    public NSEO Top() {
    	NSEO c = new NSEO(x, y-1);
    	if (coordinates_valid(c)) return c;
    	return null;
    }
    
    public NSEO right() {
    	NSEO c = new NSEO(x+1, y);
    	if (coordinates_valid(c)) return c;
    	return null;
    }
    
    public NSEO bottom() {
    	NSEO c = new NSEO(x, y-1);
    	if (coordinates_valid(c)) return c;
    	return null;
    }
    
    public NSEO left() {
    	NSEO c = new NSEO(x-1, y);
    	if (coordinates_valid(c)) return c;
    	return null;
    }


    private static boolean coordinates_valid(NSEO coordinates) {
        if ((coordinates.x < 0) || (coordinates.x >= PlatWeidht) || (coordinates.y < 0) || (coordinates.y >= PlatLenght)) {
            return false;
        }
        return true;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NSEO NSEO = (NSEO) o;
        return Objects.equals(this.x, NSEO.x) & Objects.equals(this.y, NSEO.y);
    }

    public static NSEO fromTxt(String coordinatesS) {
        Pattern p = Pattern.compile("Coordonnees\\((\\d+)\\,(\\d+)\\)");
        Matcher m = p.matcher(coordinatesS);
        return new NSEO( Integer.parseInt(m.group(1)),  Integer.parseInt(m.group(2)));
    }

    @Override
    public int hashCode() {
        return Objects.hash(String.format("x y", this.x, this.y));
    }
    
    public String toString() {
    	return String.format("Coordonnees(%s , %s)", this.x, this.y);
    }

}
