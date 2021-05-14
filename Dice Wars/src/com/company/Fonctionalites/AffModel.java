// Copyright code Thomas Froger
// L3 Project Java - 2020 - 2021


package com.company.Fonctionalites;

import java.util.Optional;

import javax.swing.table.AbstractTableModel;

import com.company.Plateau.AffCelVal;


public class AffModel extends AbstractTableModel {

	
	private static final long serialVersionUID = -9104543677322518802L;
	
	private Round round;
	
	
	public AffModel(Round round) {
		this.round = round;
	}
	

	@Override
	public int getRowCount() {
		return 2;
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Optional<Player> Player = round.getPlayers().getOptionalParId(rowIndex*4+columnIndex);
		return new AffCelVal(round, Player);
	}
	

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return AffCelVal.class;
	}
	

}
