// Copyright code Thomas Froger
// L3 Project Java - 2020 - 2021


package com.company.Plateau.action;


import javax.swing.*;
import java.awt.event.ActionEvent;

public class Exit extends AbstractAction {

    
	private static final long serialVersionUID = -7745430765417604733L;

	public Exit() {
        super("Quitter");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}