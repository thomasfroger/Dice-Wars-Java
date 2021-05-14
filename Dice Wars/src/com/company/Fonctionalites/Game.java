// Copyright code Thomas Froger
// L3 Project Java - 2020 - 2021


package com.company.Fonctionalites;

import java.util.ArrayList;
import java.util.Random;

public class Game {

	private Round round;
	private Player jeton;

    private int desFighter;
    private int desDefense;
    private Player Fighter;
    private Player defense;
	
	Random random = new Random();


    public Game(Round round) {
    	this.round = round;;
        initialise();
    }
    
    public void initialise() {
    	setJeton(getPlayers().getParId(0));
    }

    public int lancerDes(Ter ter) {
        int nb_des = ter.getNbDes();
        int somme_des = 0;
        for (int i = 0; i<nb_des; i++) {
            somme_des += aleatoire();
        }
        return somme_des;
    }

    public void attaque(Ter ter_attaquant, Ter ter_defenseur) {
       setDesFighter(lancerDes(ter_attaquant));
       setDesDefense(lancerDes(ter_defenseur));
       setFighter(ter_attaquant.getProprierty());
       setDefense(ter_defenseur.getProprierty());
       if (desFighter > desDefense) {
           ter_defenseur.setProprierty(ter_attaquant.getProprierty());
           ter_defenseur.setNbDes(ter_attaquant.getNbDes()-1);
           ter_attaquant.setNbDes(1);
       }
       else {
           ter_attaquant.setNbDes(1);
       }
        if (GameFinish()) {
            System.out.println("Partie terminée.");
        }
    }

    public void repartitionDes(Player player) {
        ArrayList<Ter> terr_Players = new ArrayList<>(this.getTerr().getAllPourJoueur(player));
        boolean terrPlayersall8 = true;
        for(int i = 0 ; i< terr_Players.size(); i++) {
            if (terr_Players.get(i).getNbDes() < 8) terrPlayersall8 = false;
        }
        int nb_territoires_joueur = terr_Players.size();
        int nb_des = this.getTerr().nbTerrContig(player);
        while(nb_des > 0 && !terrPlayersall8) {
            int hasard = new Random().nextInt(nb_territoires_joueur);
            Ter t = terr_Players.get(hasard);
            if (t.getNbDes()<8) {
            	t.setNbDes(t.getNbDes()+1);
            	nb_des--;
            }
            
        }
    }

	public TerCollect getTerr() {
		return this.getMap().getTerrColl();
	}

	public Round getGame() {
		return round;
	}
	
	public Map getMap() {
		return getGame().getMap();
	}
	
	public PlayerCollec getPlayers() {
		return getGame().getPlayers();
	}
	

    private int aleatoire() {
        int r = random.nextInt(6);
        return r + 1;
    }

	public Player getJeton() {
		return jeton;
	}

	public void setJeton(Player jeton) {
		this.jeton = jeton;
	}
	
	public void cycleJeton() {
        System.out.println("cycle jeton");
		repartitionDes(this.getJeton());
		int numJoueur = (this.getJeton().getId()+1) % this.getGame().getNbPlayers();
		setJeton(this.getPlayers().getParId(numJoueur));
		getGame().getAffiModel().fireTableDataChanged();
		getGame().getTerrModel().fireTableDataChanged();
		if (this.getTerr().getAllPourJoueur(getJeton()).size() == 0) {
			cycleJeton();
		}
	}
	
    public boolean GameFinish() {
        Player proprietaire = this.getTerr().getbuyNAME("A").getProprierty();
        for (Ter ter :  this.getTerr()) {
            if (ter.getProprierty() != proprietaire) {
                return false;
            }
        }
        return true;
    }

    public void setDesFighter(int desFighter) {
        this.desFighter = desFighter;
    }

    public int getDeFighter() {
        return this.desFighter;
    }

    public void setDesDefense(int desDefense) {
        this.desDefense = desDefense;
    }

    public int getDeDefense() {
        return this.desDefense;
    }

    public void setFighter(Player fighter) {
        this.Fighter = fighter;
    }

    public Player getFighter() {
        return this.Fighter;
    }

    public void setDefense(Player defense) {
        this.defense = defense;
    }

    public Player getDefense() {
        return this.defense;
    }
}
