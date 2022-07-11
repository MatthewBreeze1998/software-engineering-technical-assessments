package bbc.news.elections.model;

import java.math.BigDecimal;

public class ScoreboardEntry {
	

	
	private int seats;
	
	private Integer Votes;
	
	private BigDecimal share;
	
	public ScoreboardEntry(int seats, int Votes ,BigDecimal share) {
	
		this.seats = seats;
		this.Votes = Votes;
		this.share = share;
	}
	
	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public Integer getVotes() {
		return Votes;
	}

	public void setVotes(Integer votes) {
		Votes = votes;
	}

	public BigDecimal getShare() {
		return share;
	}

	public void setShare(BigDecimal share) {
		this.share = share;
	}


}
