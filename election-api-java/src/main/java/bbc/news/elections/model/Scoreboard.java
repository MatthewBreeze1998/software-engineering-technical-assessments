package bbc.news.elections.model;

import java.util.HashMap;



public class Scoreboard {
	
	private HashMap<String , ScoreboardEntry> seatValue;
	
	private String winner;
	
	
	public Scoreboard(HashMap<String , ScoreboardEntry> seatValue, String winner) {
		this.seatValue = seatValue;
		this.winner = winner;

	}
	
	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public HashMap<String , ScoreboardEntry> getSeatValue() {
		return seatValue;
	}

	public void setSeatValue(HashMap<String , ScoreboardEntry> seatValue) {
		this.seatValue = seatValue;
	}


}
