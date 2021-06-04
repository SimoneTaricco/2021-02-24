package it.polito.tdp.PremierLeague.model;

public class Event implements Comparable<Event>{
	
	private int t;
	private String teamCasa;
	private String teamOspiti;
	
	private int giocatoriCasa;
	private int giocatoriOspiti;
	
	public Event(int t, String teamCasa, String teamOspiti, int giocatoriCasa, int giocatoriOspiti) {
		this.t = t;
		this.teamCasa = teamCasa;
		this.teamOspiti = teamOspiti;
		this.giocatoriCasa = giocatoriCasa;
		this.giocatoriOspiti = giocatoriOspiti;
	}
	
	public int compareTo(Event other) { 
		return this.t - other.t;
	}

	public int getT() {
		return t;
	}

	public void setT(int t) {
		this.t = t;
	}

	public String getTeamCasa() {
		return teamCasa;
	}

	public void setTeamCasa(String teamCasa) {
		this.teamCasa = teamCasa;
	}

	public String getTeamOspiti() {
		return teamOspiti;
	}

	public void setTeamOspiti(String teamOspiti) {
		this.teamOspiti = teamOspiti;
	}

	public int getGiocatoriCasa() {
		return giocatoriCasa;
	}

	public void setGiocatoriCasa(int giocatoriCasa) {
		this.giocatoriCasa = giocatoriCasa;
	}

	public int getGiocatoriOspiti() {
		return giocatoriOspiti;
	}

	public void setGiocatoriOspiti(int giocatoriOspiti) {
		this.giocatoriOspiti = giocatoriOspiti;
	}

	@Override
	public String toString() {
		return "Event [t=" + t + ", giocatoriCasa="	 + giocatoriCasa + ", giocatoriOspiti=" + giocatoriOspiti + "]";
	}
	
	

	

}
