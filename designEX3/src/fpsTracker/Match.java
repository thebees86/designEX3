package fpsTracker;

import java.util.HashMap;
import java.util.Map;

public class Match {
	public int kills;
	public int deaths;
	public int assists;
	public Map<String,Integer> charKills = new HashMap<String,Integer>();
	
	public Match() {}
	
	public Match(int kills, int deaths, int assists) { //for testing
		this.kills = kills;
		this.deaths = deaths;
		this.assists = assists;
	}
	
	public Match(int kills, int deaths, int assists, Map<String,Integer> charKills) {
		this.kills = kills;
		this.deaths = deaths;
		this.assists = assists;
		this.charKills = charKills;
	}
	
	public void kill(String username) {
		kills++;
		if(!charKills.containsKey(username))
			charKills.put(username, 1);
		else
			charKills.put(username, charKills.get(username)+1);
	}
	
	public void death() {deaths++;}
	
	public void assist() {assists++;}
	
	public String toString() {
		return String.format("%d kills, %d deaths, %d assists, K/D ratio: %f", kills,deaths,assists,((double)kills/deaths));
	}
	
	public int points() {
		return 100*kills+30*assists-50*deaths;
	}
	
	public int compareTo(Match g) {
		if(this.points()>g.points())
			return 1;
		return -1;
	}
}
