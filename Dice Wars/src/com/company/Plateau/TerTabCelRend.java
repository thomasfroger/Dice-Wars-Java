// Copyright code Thomas Froger
// L3 Project Java - 2020 - 2021


package com.company.Plateau;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;

// Comme d'habitude nous importons tous les packages etc utile au code

class TerTabCelRend extends DefaultTableCellRenderer {

	private static final long serialVersionUID = 1L;


	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int col) {
		Component c = super.getTableCellRendererComponent(table, value,
				isSelected, hasFocus, row, col);

		TerCelVal valueAt =(TerCelVal)table.getModel().getValueAt(row, col);

		int weidght = 5;
		int top = valueAt.getNeighboursTop()*weidght;
		int left = valueAt.getNeighboursLeft()*weidght;
		int bottom = valueAt.getNeighboursBottom()*weidght;
		int right = valueAt.getNeighboursRight()*weidght;
		MatteBorder border = new MatteBorder(top, left, bottom, right, Color.BLACK);
		JComponent result = (JComponent)c;
		result.setBorder(border);
		c.setBackground(valueAt.color());
        c.setForeground(Color.WHITE);
        Font  font  = new Font(Font.SANS_SERIF,  Font.BOLD, 35);
        c.setFont(font);
        setHorizontalAlignment( JLabel.CENTER );
		return c;
	}
}