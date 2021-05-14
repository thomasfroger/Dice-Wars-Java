// Copyright code Thomas Froger
// L3 Project Java - 2020 - 2021


package com.company.Plateau;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.*;

import com.company.Fonctionalites.*;

import static com.company.App.Application.*;


public class Plat extends JPanel {

	private static final long serialVersionUID = -8152427017297677853L;

	private TerMod terMod;
	private AffModel affModel;
	private DeMod deMod;
	private JTable terrain;
	private JTable afficheur;
	private JTable des;

	private Round round;

	public Plat(Round round) {
		this.round = round;
		this.setTerrModel(round.getTerrModel());
		this.setAffiModel(round.getAffiModel());
		this.setDesModel(round.getDesModel());

		BoxLayout boxlayout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
		this.setLayout(boxlayout);
		this.setBorder(new EmptyBorder(new Insets(celluleTaille*zoom, celluleTaille*zoom, celluleTaille*zoom, celluleTaille*zoom)));

		JPanel haut = new JPanel();
		setTerr();
		haut.add(this.getTerr());
		this.add(haut);
		JPanel centre = new JPanel();
		setAffi();
		centre.add(this.getAffi());
		this.add(centre);
		JPanel bas = new JPanel();
		setDes();
		bas.add(this.getDes());
		this.add(bas);

	}



	private void setTerr() {

		terrain = new JTable(this.getTerrModel());

		terrain.setPreferredSize(new Dimension(PlatWeidht *celluleTaille*zoom, PlatLenght *celluleTaille*zoom));
		terrain.setRowHeight(celluleTaille*zoom);
		TableColumnModel columnModel = terrain.getColumnModel();
		for(int i = 0; i< PlatWeidht; i++ ) {
			columnModel.getColumn(i).setWidth(celluleTaille*zoom);
		}
		terrain.setDefaultRenderer(TerCelVal.class, new TerTabCelRend());

		terrain.setFocusable(false);
		terrain.setShowGrid(false);
		terrain.setRowMargin(0);
		terrain.setIntercellSpacing(new Dimension(0, 0));


		terrain.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row = terrain.rowAtPoint(evt.getPoint());
				int col = terrain.columnAtPoint(evt.getPoint());
				if (row >= 0 && col >= 0) {
					System.out.println(String.format("(%s, %s)", row, col));
					TerCelVal valeur = (TerCelVal) terrain.getValueAt(row, col);
					Ter ter = valeur.getTerr();
					if (ter != null) round.setTerrSelection(valeur.getTerr());
				}
			}
		});
		terrain.setVisible(true);
	}


	public JTable getTerr() {
		return terrain;
	}

	public JTable getAffi() {
		return afficheur;
	}

	public JTable getDes() {
		return des;
	}

	private void setAffi() {

		afficheur = new JTable(this.getAffiMod());
		afficheur.setPreferredSize(new Dimension(PlatWeidht *celluleTaille*zoom, celluleTaille*zoom*2));
		afficheur.setRowHeight(celluleTaille*zoom);
		TableColumnModel columnModel = afficheur.getColumnModel();
		for(int i=0;i<4;i++ ) {
			columnModel.getColumn(i).setWidth(celluleTaille*zoom);
		}
		afficheur.setDefaultRenderer(AffCelVal.class, new AffTabCellRend());

		afficheur.setFocusable(false);
		afficheur.setShowGrid(false);
		afficheur.setRowMargin(0);
		afficheur.setIntercellSpacing(new Dimension(0, 0));
		afficheur.setRowSelectionAllowed(true);
		afficheur.setBorder(new LineBorder(Color.BLACK));

		afficheur.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row = afficheur.rowAtPoint(evt.getPoint());
				int col = afficheur.columnAtPoint(evt.getPoint());
				if (row >= 0 && col >= 0) {
					System.out.println(String.format("(%s, %s)", row, col));
					AffCelVal valeur = (AffCelVal) afficheur.getValueAt(row, col);
					if (valeur.playerJeton()) {
						round.getGame().cycleJeton();
					}
				}
			}
		});

		afficheur.setVisible(true);


	}

private void setDes() {

		des = new JTable(this.getDesModel());
		des.setPreferredSize(new Dimension(PlatWeidht *celluleTaille*zoom/2, celluleTaille*zoom));
		des.setRowHeight(celluleTaille*zoom);
		TableColumnModel columnModel = des.getColumnModel();
		for(int i=0;i<2;i++ ) {
			columnModel.getColumn(i).setWidth(celluleTaille*zoom);
		}
		des.setDefaultRenderer(DeCelVal.class, new DeTabCelRend());

		des.setFocusable(false);
		des.setShowGrid(false);
		des.setRowMargin(0);
		des.setIntercellSpacing(new Dimension(0, 0));
		des.setRowSelectionAllowed(true);
		des.setBorder(new LineBorder(Color.BLACK));

		des.setVisible(true);


	}

	public static void createAndShowUI(Round round) {
		JFrame frame = new JFrame("DICE WARS");
		frame.getContentPane().add(new Plat(round));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize((PlatWeidht +4)*celluleTaille*zoom, (PlatLenght +6)*celluleTaille*zoom);
		frame.setJMenuBar(new PlatMenBar(round));
		frame.pack();
		frame.setVisible(true);
	}

	public TerMod getTerrModel() {
		return terMod;
	}

	public void setTerrModel(TerMod terMod) {
		this.terMod = terMod;
	}

	public AffModel getAffiMod() {
		return affModel;
	}

	public void setAffiModel(AffModel affModel) {
		this.affModel = affModel;
	}

	public DeMod getDesModel() {
		return this.deMod;
	}

	public void setDesModel(DeMod deMod) {
		this.deMod = deMod;
	}

}

