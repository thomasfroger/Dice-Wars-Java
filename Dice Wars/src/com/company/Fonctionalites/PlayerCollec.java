// Copyright code Thomas Froger
// L3 Project Java - 2020 - 2021


package com.company.Fonctionalites;


import java.util.HashSet;
import java.util.Optional;


public class PlayerCollec extends HashSet<Player> {
	
	private static final long serialVersionUID = -1070477954738620347L;
	
	public PlayerCollec() {
		super();
	}
	
	public Optional<Player> getOptionalParId(Integer id) {
		return this.stream()
				.filter(t -> t.getId() == id)
				.findAny();
	}
	// methode dangereuse mais le null n'est pas censé exister dans ce programme donc ok
	public Player getParId(int id) {
		return getOptionalParId(id).get();
	}



}
