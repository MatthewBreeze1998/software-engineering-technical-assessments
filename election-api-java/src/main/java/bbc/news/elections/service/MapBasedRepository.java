package bbc.news.elections.service;

import bbc.news.elections.model.ConstituencyResult;
import bbc.news.elections.model.PartyResult;
import bbc.news.elections.model.Scoreboard;
import bbc.news.elections.model.ScoreboardEntry;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MapBasedRepository implements ResultService {

    private final Map<Integer,ConstituencyResult> results;

    public MapBasedRepository() {
        results = new ConcurrentHashMap<>();
    }

    @Override
    public ConstituencyResult GetResult(Integer id) {
        return results.get(id);
    }

    @Override
    public void NewResult(ConstituencyResult result) {
        results.put(result.getId(), result);
    }

    @Override
    public Map<Integer, ConstituencyResult> GetAll() {
        return results;
    }

    @Override
    public void reset() {
        results.clear();
    }

	@Override
	public Scoreboard getScoreBaord() {
		HashMap<String, ScoreboardEntry> testing = new HashMap<String, ScoreboardEntry>();
		String constituencyWinner = "";
		int topVoted = 0;
		
		for(ConstituencyResult cr : results.values()) {
			for(PartyResult pr : cr.getPartyResults()) {
				if(pr.getVotes() > topVoted) {
					topVoted = pr.getVotes();
					constituencyWinner = pr.getParty();
				}
				if(testing.containsKey(pr.getParty())) {
					ScoreboardEntry temp = 	testing.get(pr.getParty());
					temp.setVotes(temp.getVotes() + pr.getVotes());
					testing.replace(pr.getParty(), temp);
					
				}else {
					testing.put(pr.getParty(), new ScoreboardEntry(0,pr.getVotes(),pr.getShare()));
				}						
			}
				
			ScoreboardEntry temp = 	testing.get(constituencyWinner);
			temp.setSeats(temp.getSeats() + 1);
			testing.replace(constituencyWinner, temp);
		}
		
		
		Scoreboard result = new Scoreboard(testing, getWinner(testing));

		return result;
	}
	
	private String getWinner(HashMap<String, ScoreboardEntry> testing) {
		String partWinner = "noone";
		int seats = 0;
		
		for(String key :testing.keySet() ) {
			ScoreboardEntry sbe = testing.get(key); 
			if(sbe.getSeats()  >seats  ) {
				partWinner = key;
				seats = sbe.getSeats();			
		}		
	}
		if(seats >= 325) {
			return partWinner;
		}else {
			return "noone";
		}
}
}
