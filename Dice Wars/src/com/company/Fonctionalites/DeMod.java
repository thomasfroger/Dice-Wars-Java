// Copyright code Thomas Froger
// L3 Project Java - 2020 - 2021


package com.company.Fonctionalites;

import javax.swing.table.AbstractTableModel;

import com.company.Plateau.DeCelVal;


public class DeMod extends AbstractTableModel {

	
	private static final long serialVersionUID = -9104543677322518802L;
	
	private Round round;
	
	
	public DeMod(Round round) {
		this.round = round;
	}
	

	@Override
	public int getRowCount() {
		return 1;
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex == 0 ) {
			return new DeCelVal(round, round.getGame().getFighter(), round.getGame().getDeFighter());
		}
		else {
			return new DeCelVal(round, round.getGame().getDefense(), round.getGame().getDeDefense());
		}
	}
	

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return DeCelVal.class;
	}
	

}
