package it.polito.tdp.PremierLeague.model;

import java.util.PriorityQueue;
import java.util.Random;

public class Simulator {
	
	public int nAzioni;
	private Match partita;
	
	private PriorityQueue<Event> queue;
	private String casa;
	private String ospiti;
	private String squadraMigliore;
	
	private int goalCasa;
	private int goalTrasferta;
	private int espulsiCasa;
	private int espulsiTrasferta;
	
	private int t;

	
	public void init (int nAzioni, Match partita, String squadraMigliore) {
		this.nAzioni = nAzioni;
		this.partita = partita;
		this.squadraMigliore = squadraMigliore;
		
				
		this.t = 1;
		this.espulsiCasa = 0;
		this.espulsiTrasferta = 0;
		this.goalCasa = 0;
		this.goalTrasferta = 0;
		
		this.casa = partita.getTeamHomeNAME();
		this.ospiti = partita.getTeamAwayNAME();
		
		this.queue = new PriorityQueue<Event>();
		
		this.queue.add(new Event(1,casa,ospiti,11,11));
	}
	
	public void run() {
		
		Event e;
		
		while((e = this.queue.poll())!=null) {  
			
			if (e.getT()==nAzioni+1)
				break;
			
			this.t = e.getT();
			
			int random = (int)(Math.random()*100);
			
			int gCasa = e.getGiocatoriCasa();
			int gTrasf = e.getGiocatoriOspiti();
			
			if (gCasa == gTrasf && random <=50) { // segna chi ha il giocatore migliore
				this.queue.add(new Event(this.t+1,casa,ospiti,gCasa,gTrasf));
				if (casa.compareTo(squadraMigliore)==0)
					this.goalCasa++;
				else
					this.goalTrasferta++;
				continue;
			}
			
			else if (gCasa != gTrasf && random <=50) { // segna chi ha più giocatori in campo
				this.queue.add(new Event(this.t+1,casa,ospiti,gCasa,gTrasf));
				if (gCasa>gTrasf)
					this.goalCasa++;
				else
					this.goalTrasferta++;
				continue;
			}
			
			else if (random > 50 && random <= 80) { // espulsione

				int random3 = (int)(Math.random()*100);
								
				if (random3<=60) { // 60%: espulso uno della squadra migliore
					if (casa.compareTo(squadraMigliore)==0) {
						this.espulsiCasa++;
						this.queue.add(new Event(this.t+1,casa,ospiti,gCasa-1,gTrasf));
					}
					else {
						this.espulsiTrasferta++;
						this.queue.add(new Event(this.t+1,casa,ospiti,gCasa,gTrasf-1));
					}
				} else { // 40%: espulso uno dell'altra quadra
					if (casa.compareTo(squadraMigliore)==0) {
						this.espulsiTrasferta++;
						this.queue.add(new Event(this.t+1,casa,ospiti,gCasa,gTrasf-1));
					}
					else {
						this.espulsiCasa++;
						this.queue.add(new Event(this.t+1,casa,ospiti,gCasa-1,gTrasf));
					}
				}
				continue;
			}
			
			else if (random > 80 && random <=100) { // infortunio
				
				int random4 = (int)(Math.random()*100);
				
				if (random4<=50) {
						this.queue.add(new Event(this.t+1,casa,ospiti,gCasa-1,gTrasf));
						this.nAzioni += 2;
				}
				else {
						this.queue.add(new Event(this.t+1,casa,ospiti,gCasa,gTrasf-1));
						this.nAzioni += 3;
				}
				continue;
			}
		}		
	}
	
	public String getStatistiche() {
		return "Risultato: " + goalCasa + " - " + goalTrasferta + ". Espulsi: " + espulsiCasa + " - " + espulsiTrasferta + ".";
	}

}
