// Copyright code Thomas Froger
// L3 Project Java - 2020 - 2021


package com.company.Plateau.action;


import com.company.Fonctionalites.Round;
import com.company.App.Save;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

public class OpenGame extends AbstractAction {

	private static final long serialVersionUID = -2911777040642109125L;

	public OpenGame(Round round) {
        super("Ouvrir une partie");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            ArrayList<String> sauvegarde = new Save("sauvegarde").read();
            String partieS = sauvegarde.get(0);
            Round.fromTxt(partieS);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}