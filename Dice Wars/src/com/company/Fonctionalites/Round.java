// Copyright code Thomas Froger
// L3 Project Java - 2020 - 2021


package com.company.Fonctionalites;

import com.company.App.NSEO;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
// singleton une seule partie à la fois

public class Round {

    public static Round instance;

    private int nbPlayers;
    private Map map;
    private TerMod terMod;
    private AffModel affModel;
    private DeMod deMod;
    private PlayerCollec players = new PlayerCollec();
    private Ter terSelection;
    private Game game;

    private Round() {
    }
    
   
    public static Round getInstance()  {
        if (instance == null) {
           instance = new Round();
        }
        return instance;
    }

	public int getNbPlayers() {
		return nbPlayers;
	}

	public void setNbPlayers(int nbPlayers) {
		this.nbPlayers = nbPlayers;
	}
	
	public void NouvGame(int nbPlayers) {
		setNbPlayers(nbPlayers);
		setPlayers(createPlayers());
		setMap(new MapGen(this).execute());
		setTerrModel(new TerMod(this));
		setAffiModel(new AffModel(this));
		setDesModel(new DeMod(this));
		setJeu(new Game(this));
	}
	


	public Map getMap() {
		return map;
	}


	private void setMap(Map map) {
		this.map = map;
	}


	public TerMod getTerrModel() {
		return terMod;
	}


	private void setTerrModel(TerMod terMod) {
		this.terMod = terMod;
	}


	public PlayerCollec getPlayers() {
		return players;
	}


	private void setPlayers(PlayerCollec players) {
		this.players = players;
	}
	
	private PlayerCollec createPlayers() {
		PlayerCollec joueurs = new PlayerCollec();
		for(int i = 0; i < this.getNbPlayers(); i++) {
			joueurs.add(new Player(i));
		}
		return joueurs;
	}


	public AffModel getAffiModel() {
		return affModel;
	}


	public void setAffiModel(AffModel affModel) {
		this.affModel = affModel;
	}
	
	public void setTerrSelection(Ter terSelection) {
		boolean selectionLoading = this.terSelection != null;
		boolean selectionIdemSelectionLoading = this.terSelection == terSelection;
		boolean selectionTerrJeton = terSelection.getProprierty() == this.getGame().getJeton();
		boolean selectionTerrNbDesSup1 = terSelection.getNbDes() > 1;
		boolean selectionTerrNOJeton = terSelection.getProprierty() != this.getGame().getJeton();
		boolean selectionAdjacentSelection = selectionTerrNOJeton && selectionLoading && getTerSelect().getAdjacents().geOptionalParNom(terSelection.getName()).isPresent();
		

		this.getGame().setFighter(null);
		this.getGame().setDefense(null);

		if (selectionIdemSelectionLoading) {
			this.terSelection = null;
		}
		
		if (selectionTerrJeton && selectionTerrNbDesSup1) {
			this.terSelection = terSelection;
		}
		
		if (selectionLoading && selectionTerrNOJeton &&  selectionAdjacentSelection) {
			this.getGame().attaque(getTerSelect(), terSelection);
		}
			

		NSEO plusPetite = terSelection.getCellulesCollection().moresmall();
		this.getTerrModel().setValueAt(terSelection, plusPetite.y, plusPetite.x);
		this.getTerrModel().fireTableDataChanged();
		this.getAffiModel().fireTableDataChanged();
		this.getDesModel().fireTableDataChanged();
	}
	
	public Ter getTerSelect() {
		return this.terSelection;
	}


	public Game getGame() {
		return game;
	}


	public void setJeu(Game game) {
		this.game = game;
	}


	public DeMod getDesModel() {
		return deMod;
	}


	public void setDesModel(DeMod deMod) {
		this.deMod = deMod;
	}

	public String toTxt() {
    	String str="Partie(";
    	str+= String.valueOf(this.getNbPlayers());
		str+=";";
    	str+= this.getMap().getTerrColl().toTxt();
    	str+=")";
    	return str;
	}

	public static Round fromTxt(String partieS) {
		Pattern p = Pattern.compile("Partie\\((.*)\\)") ;
		Matcher m = p.matcher(partieS) ;
		boolean b = m.matches() ;
		String match = m.group(1);
		Pattern p2 = Pattern.compile("(\\d+);(.*)") ;
		Matcher m2 = p2.matcher(match) ;
		boolean b2 = m2.matches() ;

		System.out.println(b2);

		System.out.println(m2.group(2));
		int nbPlayers = Integer.parseInt(m2.group(1));
		TerCollect terCollect = TerCollect.fromTxt(m2.group(2));


		return new Round();
	}
}
