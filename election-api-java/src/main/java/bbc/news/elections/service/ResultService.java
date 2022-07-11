package bbc.news.elections.service;

import bbc.news.elections.model.ConstituencyResult;
import bbc.news.elections.model.Scoreboard;

import java.util.List;
import java.util.Map;

public interface ResultService {
    ConstituencyResult GetResult(Integer id);
    void NewResult(ConstituencyResult result);
    Map<Integer,ConstituencyResult> GetAll();
    Scoreboard getScoreBaord();
    
    void reset();
}
