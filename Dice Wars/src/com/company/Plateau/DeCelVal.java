// Copyright code Thomas Froger
// L3 Project Java - 2020 - 2021


package com.company.Plateau;

import static com.company.App.Application.PlayerColor;

import java.awt.Color;

import com.company.Fonctionalites.Player;
import com.company.Fonctionalites.Round;

public class DeCelVal {


	private Round round;
	private int des ;
	private Player player;

	public DeCelVal(Round round, Player player, int des) {
		this.round = round;
		this.des = des;
		this.player = player;
	}
	

	public String toString() {
		if (getgame().getGame().GameFinish()) return "Fin";
		if ( getPlayer()!= null) return String.format("%s", getDes());
		return "";
	}


	public Round getgame() {
		return round;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public Color color() {
		return Color.GRAY;
	}
	
	public Color BackgroundColor() {
		if (getPlayer() != null) {
			return PlayerColor[getPlayer().getId()];

		}
		return Color.WHITE;
	}

	public int getDes() {
		return des;
	}
}
