package bbc.news.elections.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import bbc.news.elections.model.ConstituencyResult;
import bbc.news.elections.model.Scoreboard;

@Service
public interface IScoreboardService {
	
	public Scoreboard  countSeats(Map<Integer, ConstituencyResult> seatCount);

}
