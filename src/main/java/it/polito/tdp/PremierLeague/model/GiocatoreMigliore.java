package it.polito.tdp.PremierLeague.model;

import java.text.DecimalFormat;

public class GiocatoreMigliore {
	
	private Player p;
	private double delta;
	
	public GiocatoreMigliore(Player p, double delta) {
		super();
		this.p = p;
		this.delta = delta;
	}

	public Player getP() {
		return p;
	}

	public void setP(Player p) {
		this.p = p;
	}

	public double getDelta() {
		return delta;
	}

	public void setDelta(Double delta) {
		this.delta = delta;
	}

	@Override
	public String toString() {
		return p + ", delta = " + (new DecimalFormat("#.000")).format(delta);
	}
	
	

}
