// Copyright code Thomas Froger
// L3 Project Java - 2020 - 2021


package com.company;
import com.company.Plateau.Plat;
import com.company.Fonctionalites.Round;

// Nous importons les packages etc qui seront utiles au lancement de la class main

public class Main {

	
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				// Nous allons définir le nombre de joueur de base du 4
				int nbJoueurs = 4;
				Round round = Round.getInstance();
				// Nous appelons NouvGame de "round" et initions le nombre de joueurs
				round.NouvGame(nbJoueurs);
				//Le plateau se crée en fonction
				Plat.createAndShowUI(round);
			}
		});

		System.out.println("");
	}

}
