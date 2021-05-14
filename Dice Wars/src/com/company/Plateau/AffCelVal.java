// Copyright code Thomas Froger
// L3 Project Java - 2020 - 2021


package com.company.Plateau;

import static com.company.App.Application.PlayerColor;

import java.awt.Color;
import java.util.Optional;

import com.company.Fonctionalites.Player;
import com.company.Fonctionalites.Round;

public class AffCelVal {


	private Round round;
	private Optional<Player> joueur;

	public AffCelVal(Round round, Optional<Player> joueur) {
		this.round = round;
		this.joueur = joueur;
	}
	

	public String toString() {
		if (joueur.isPresent()) return String.format("%s %s", nbTerrContig(), button());
		return "";
	}


	public Round getGame() {
		return round;
	}
	
	public Optional<Player> getPlayer() {
		return joueur;
	}
	
	public Color Color() {
		if (joueur.isPresent()) {
			if (playerJeton()) return Color.GRAY;
			else return PlayerColor[joueur.get().getId()];
			
		}
		return Color.GRAY;
	}
	
	public Color FondCouleur() {
		if (joueur.isPresent()) {
			if (playerJeton()) return PlayerColor[joueur.get().getId()];
			else return Color.WHITE;
		}
		return Color.WHITE;
	}
	
	public int nbTerrContig() {
		return round.getMap().getTerrColl().nbTerrContig(joueur.get());
	}
	
	public boolean playerJeton() {
		if (this.getPlayer().isPresent()) return getJeton() == this.getPlayer().get();
		else return false;
	}
	
	public Player getJeton() {
		return this.getGame().getGame().getJeton();
	}
	
	public String button() {
		return playerJeton() ? "[fin]" : "";
	}



}
