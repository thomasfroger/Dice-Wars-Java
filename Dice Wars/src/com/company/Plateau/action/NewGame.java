// Copyright code Thomas Froger
// L3 Project Java - 2020 - 2021


package com.company.Plateau.action;


import javax.swing.*;

import com.company.Fonctionalites.Round;

import java.awt.event.ActionEvent;

public class NewGame extends AbstractAction {

	private static final long serialVersionUID = -9164139140359559561L;
	
	private Round round;
	private int nbJoueurs;

	public NewGame(Round round, int nbJoueurs) {
        super(String.format("%s joueurs", nbJoueurs));
		this.round = round;
		this.nbJoueurs = nbJoueurs;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	round.NouvGame(getNbJoueurs());
    }

	public Round getPartie() {
		return round;
	}

	public int getNbJoueurs() {
		return nbJoueurs;
	}
}