// Copyright code Thomas Froger
// L3 Project Java - 2020 - 2021


package com.company.Plateau.action;


import com.company.Fonctionalites.Round;
import com.company.App.Save;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

public class SaveGame extends AbstractAction {

   
	private static final long serialVersionUID = -2962032530123680689L;
    private final Round round;

    public SaveGame(Round round) {
	    super("Enregistrer la partie");
	    this.round = round;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            ArrayList<String> sauvegarde = new ArrayList<>();
            sauvegarde.add(round.toTxt());
            new Save("sauvegarde").write(sauvegarde);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}