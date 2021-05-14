// Copyright code Thomas Froger
// L3 Project Java - 2020 - 2021


package com.company.Fonctionalites;

import javax.swing.table.AbstractTableModel;

import com.company.Plateau.TerCelVal;
import com.company.App.NSEO;

import static com.company.App.Application.PlatWeidht;
import static com.company.App.Application.PlatLenght;

public class TerMod extends AbstractTableModel {

	
	private static final long serialVersionUID = 8574843896035570756L;
	
	private Round round;
	
	public TerMod(Round round) {
		this.round = round;
	}
	

	@Override
	public int getRowCount() {
		return PlatLenght;
	}

	@Override
	public int getColumnCount() {
		return PlatWeidht;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		NSEO NSEO = new NSEO(columnIndex, rowIndex);
		return new TerCelVal(round, NSEO, round.getMap().getValueAt(rowIndex, columnIndex));
	}
	

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return TerCelVal.class;
	}
	

}
