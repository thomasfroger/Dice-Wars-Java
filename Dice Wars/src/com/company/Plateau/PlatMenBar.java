// Copyright code Thomas Froger
// L3 Project Java - 2020 - 2021


package com.company.Plateau;

import javax.swing.*;

import com.company.Plateau.action.SaveGame;
import com.company.Plateau.action.NewGame;
import com.company.Plateau.action.Exit;
import com.company.Plateau.action.OpenGame;
import com.company.Fonctionalites.Round;

public class PlatMenBar extends JMenuBar {


	private static final long serialVersionUID = 6945665766226714952L;

	public PlatMenBar(Round round) {
		setMenu(round);
	}
	
	public void setMenu(Round round) {
		
		JMenu myFileMenu = new JMenu("Fichier");
		this.add(myFileMenu);

		myFileMenu.add(new JMenuItem(new SaveGame(round)));
		myFileMenu.add(new JMenuItem(new OpenGame(round)));
		
		JMenu MyNewGAME = new JMenu("Nouvelle partie");

		ButtonGroup PlayerGroupe = new ButtonGroup();
		
		
		JRadioButtonMenuItem My2PlayersItemsMenu = new JRadioButtonMenuItem(new NewGame(round, 2));
		My2PlayersItemsMenu.setSelected(true);
		PlayerGroupe.add(My2PlayersItemsMenu);
		MyNewGAME.add(My2PlayersItemsMenu);
		
		JRadioButtonMenuItem My3PlayersItemsMenu = new JRadioButtonMenuItem(new NewGame(round, 3));
		PlayerGroupe.add(My3PlayersItemsMenu);
		MyNewGAME.add(My3PlayersItemsMenu);
		
		JRadioButtonMenuItem My4PlayersItemsMenu = new JRadioButtonMenuItem(new NewGame(round, 4));
		PlayerGroupe.add(My4PlayersItemsMenu);
		MyNewGAME.add(My4PlayersItemsMenu);
		
		JRadioButtonMenuItem my5PlayersItemsMenu = new JRadioButtonMenuItem(new NewGame(round, 5));
		PlayerGroupe.add(my5PlayersItemsMenu);
		MyNewGAME.add(my5PlayersItemsMenu);
		
		JRadioButtonMenuItem my6PlayersItemsMenu = new JRadioButtonMenuItem(new NewGame(round, 6));
		PlayerGroupe.add(my6PlayersItemsMenu);
		MyNewGAME.add(my6PlayersItemsMenu);
		
		JRadioButtonMenuItem my7PlayersItemsMenu = new JRadioButtonMenuItem(new NewGame(round, 7));
		PlayerGroupe.add(my7PlayersItemsMenu);
		MyNewGAME.add(my7PlayersItemsMenu);
		
		JRadioButtonMenuItem my8PlayersItemMenu = new JRadioButtonMenuItem(new NewGame(round, 8));
		PlayerGroupe.add(my8PlayersItemMenu);
		MyNewGAME.add(my8PlayersItemMenu);
		
		myFileMenu.add(MyNewGAME);
		
		
		myFileMenu.add(new Exit());
		
		
	}

}
