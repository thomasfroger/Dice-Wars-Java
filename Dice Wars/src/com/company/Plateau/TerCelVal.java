// Copyright code Thomas Froger
// L3 Project Java - 2020 - 2021



package com.company.Plateau;

import java.awt.Color;
import static com.company.App.Application.*;

import com.company.Fonctionalites.Map;
import com.company.Fonctionalites.Player;
import com.company.Fonctionalites.Round;
import com.company.Fonctionalites.Ter;
import com.company.App.NSEO;

public class TerCelVal {

	private Round round;
	private Map map;
	private NSEO NSEO;
	private Ter ter;

	public TerCelVal(Round round, NSEO NSEO, Ter ter) {
		this.round = round;
		this.map = round.getMap();
		this.NSEO = NSEO;
		this.ter = ter;
	}
	
	public NSEO getCoordinates() {
		return NSEO;
	}
	
	private boolean Estvoid() {
		return getTerr() == null;
	}
	
	private boolean Smallest() {
		NSEO smallestt = getTerr().getCellulesCollection().moresmall();
		NSEO NSEO = getCoordinates();
		return smallestt.x == NSEO.x && smallestt.y == NSEO.y;
	}

	public Ter getTerr() {
		return ter;
	}

	public String toString() {
		if (Estvoid()) {
			return "";
		}
		else {
			if (Smallest()) {
				return String.format("%s", getNbrDeDes());
			}
			else return "";
		}
	}

	public Player getProprierty() {
		return this.getTerr().getProprierty();
	}
	
	public Integer getPropriertyId() {
		return this.getProprierty().getId();
	}

	public int getNbrDeDes() {
		return this.getTerr().getNbDes();
	}

	public int getNeighboursTop() {
		NSEO c = this.getCoordinates();
		NSEO c_top = c.Top();
		if (c_top == null) {
			return 1;
		}
		else {
			Ter t = map.getMatriceTerr().get(c_top);
			if (t == this.getTerr()) {
				return 0;
			}
			else {
				return 1;
			}
		}
	}

	public int getNeighboursLeft() {
		NSEO c = this.getCoordinates();
		NSEO c_left = c.left();
		if (c_left == null) {
			return 1;
		}
		else {
			Ter t = map.getMatriceTerr().get(c_left);
			if (t == this.getTerr()) {
				return 0;
			}
			else {
				return 1;
			}
		}
	}

	public int getNeighboursBottom() {
		if (this.getCoordinates().y == PlatLenght -1 ) {
			return 1;
		}
		else {
			return 0;
		}
	}

	public int getNeighboursRight() {
		if (this.getCoordinates().x == PlatWeidht -1 ) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public Color color() {
		if (Estvoid()) {
			return Color.GRAY;
		}
		else {
			if ((this.getGame().getTerSelect() == this.getTerr()) &&
					(this.getCoordinates().equals(this.getTerr().getCellulesCollection().moresmall()))) {
				return Color.BLACK;
			}
			else return PlayerColor[this.getPropriertyId()];
		}
	}

	public Map getCarte() {
		return map;
	}

	public Round getGame() {
		return round;
	}



}
