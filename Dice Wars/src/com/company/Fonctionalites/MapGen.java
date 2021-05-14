// Copyright code Thomas Froger
// L3 Project Java - 2020 - 2021


package com.company.Fonctionalites;

import static com.company.App.Application.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

import com.company.App.NSEO;

public class MapGen {
	
	private Matrice<String> matrice = new Matrice<>(PlatLenght, PlatWeidht);
	private TerCollect terrs = new TerCollect();
	private int nbPlayers;
	private PlayerCollec players;
	
	public MapGen(Round round) {
		this.nbPlayers = round.getNbPlayers();
		this.players = round.getPlayers();
		set();
        createTerr();
        attribuateProprierties();
        attribuateDes();
	}
	
	public Map execute() {
		return new MapFacto(terrs).create();
	}
	
	
	private void set() {
        for (int line = 0; line< PlatLenght; line++) {
            for (int column = 0; column< PlatWeidht; column++) {
                matrice.set(line, column, "0");
            }
        }
	}
	
    private void createTerr() {
        int indice_letter = 0;
        for (int line = 0; line< PlatLenght; line++) {
            for (int column = 0; column< PlatWeidht; column++) {
                if (matrice.get(line, column) == "0") {
                    ArrayList<NSEO> attribues = new ArrayList<>();
                    NSEO coordinates = new NSEO(column, line);
                    attribues.add(coordinates);
                    for (int indice = 0; indice < TerrLenght -1; indice++) {
                        if (prochaineCase(attribues) == null) {
                            break;
                        } else {
                        	NSEO next_attribue = prochaineCase(attribues);
                            attribues.add(next_attribue);
                        }
                    }
                    String remplissage;
                    if (attribues.size() == TerrLenght) {
                        remplissage = Letters[indice_letter];
                        Ter ter = new Ter(remplissage, new CelCollect(attribues));
                        terrs.add(ter);
                        indice_letter += 1;
                    } else {
                        remplissage = "*";
                    }
                    for (NSEO NSEO : attribues) {
                        matrice.set(NSEO, remplissage);
                    }
                }
            }
        }
    }
    
    
    private void attribuateProprierties() {
    	TerCollect clone = (TerCollect) terrs.clone();
    	ArrayList<Ter> melangeTers = new ArrayList<Ter>(clone);
    	Collections.shuffle(melangeTers);
    	// on cycle sur les joueurs grace au reste de la division euclidienne en attribuant un territoire à chaque joueur à chaque cycle
    	// jusqu'à épuisement
    	int i=0;
    	while (melangeTers.size() > 0) {
    		melangeTers.remove(0).setProprierty(players.getParId(i%this.nbPlayers));
    		i++;
    	}
    }
    

    // on attribue 3 dés en moyenne par territoire, un dé minimum par territoire 
    private void attribuateDes() {
    	terrs.forEach(t -> t.setNbDes(1));
    	int nbDesParJoueursMoins1 = (terrs.size() * 2) / nbPlayers; // moins 1 car 1 déjà attribué
    	// 1 de à chaque territoire
    	// affectation des dés restants aleatoirement
    	Random random = new Random();
    	players.forEach(j -> {
    		int desAAttribuer = nbDesParJoueursMoins1;
    		ArrayList<Ter> territoiresJoueur = new ArrayList<Ter>(terrs.getAllPourJoueur(j));
    		int nbTerritoiresJoueur = territoiresJoueur.size();
    		while (desAAttribuer> 0) {
				int alea = random.nextInt(nbTerritoiresJoueur);
				Ter t = territoiresJoueur.get(alea);
				t.setNbDes(t.getNbDes()+1);
				desAAttribuer--;
			}
    	});
    }
    
    private NSEO prochaineCase(ArrayList<NSEO> attribues) {
        HashSet<NSEO> next_cases_possibles = new HashSet<>();
        for (NSEO coordonnee : attribues) {
            ArrayList<NSEO> possibles = voisinesEtVides(coordonnee);
            next_cases_possibles.addAll(possibles);
        }
        attribues.forEach(c -> {
        	next_cases_possibles.remove(c);
        });
        if (next_cases_possibles.size() > 0) {
            int random = new Random().nextInt(next_cases_possibles.size());
            ArrayList<NSEO> next_cases_possiblesAL = new ArrayList<NSEO>(next_cases_possibles);
            return next_cases_possiblesAL.get(random);
        }
        return null;
    }
    
    private ArrayList<NSEO> voisinesEtVides(NSEO c) {
        ArrayList<NSEO> voisines = c.neighbours();
        ArrayList<NSEO> voisines_et_vides = new ArrayList<NSEO>();
        for (NSEO parcours : voisines) {
            if (caseVide(parcours)) {
                voisines_et_vides.add(parcours);
            }
        }
        return voisines_et_vides;
    }

    private boolean caseVide(NSEO coordonnee) {
        if (matrice.get(coordonnee) != "0") {
            return false;
        }
        return true;
    }
    
	public int getNbPlayers() {
		return nbPlayers;
	}

}
