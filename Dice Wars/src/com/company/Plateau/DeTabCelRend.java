// Copyright code Thomas Froger
// L3 Project Java - 2020 - 2021


package com.company.Plateau;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

class DeTabCelRend extends DefaultTableCellRenderer {

	private static final long serialVersionUID = 1L;


	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int col) {
		Component c = super.getTableCellRendererComponent(table, value,
				isSelected, hasFocus, row, col);

		DeCelVal valueAt =(DeCelVal)table.getModel().getValueAt(row, col);

		c.setForeground(valueAt.color());
		c.setBackground(valueAt.BackgroundColor());
        Font  font  = new Font(Font.SANS_SERIF,  Font.BOLD, 35);
        c.setFont(font);
        setHorizontalAlignment( JLabel.CENTER );
		return c;
	}
}