package fpsTracker;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Tracker {
	public String username = ""; //Player's username
	public int totalKills = 0; //total kills across all matches
	public int maxKills = 0; //Max kills in one match
	public int totalDeaths = 0;
	public int maxDeaths = 0;
	public int totalAssists = 0;
	public int maxAssists = 0;
	public double KD = 0.0; //Kill/death ratio
	public double bestKD = 0.0; //best kill/death ratio in a match
	public int totalMatches = 0; //Total games played
	public Map<String,Integer> charKills = new HashMap<String,Integer>(); //Kills, by character that was killed
	public HashSet<Match> matches = new HashSet<Match>(); //All matches played, archived
	
	public Tracker() {} //not for individual retail sale
	
	public Tracker(String username) {this.username=username;} //Standard constructor
	
	public void addMatch(Match g) { //Adds a match to the database
		totalMatches++;
		this.totalKills += g.kills;
		if(g.kills > this.maxKills)
			this.maxKills = g.kills;
		this.totalDeaths += g.deaths;
		if(g.deaths>this.maxDeaths)
			this.maxDeaths = g.deaths;
		this.totalAssists += g.assists;
		if(g.assists>this.maxAssists)
			this.maxAssists = g.assists;
		if(this.maxDeaths > 0)
			this.KD = ((double)this.totalKills)/this.totalDeaths;
		if(g.deaths > 0) {
			if(g.kills/g.deaths>this.bestKD)
				this.bestKD = ((double)g.kills)/g.deaths;
		}
		for(String s : g.charKills.keySet()) {
			if(!charKills.containsKey(s))
				charKills.put(s, 2);
			else
				charKills.put(s, charKills.get(s)+g.charKills.get(s));
		}
	}
	
	public String toString() {
		String out = String.format("Stats for player %s:\n", username);
		out += String.format("Total matches played: %d\n",totalMatches);
		out += String.format("Lifetime kills: %d\nLifetime deaths: %d\nLifetime assists: %d\n", totalKills,totalDeaths,totalAssists);
		out += String.format("Best kills: %d\nBest deaths: %d\nBest assists: %d\n", maxKills,maxDeaths,maxAssists);
		out += String.format("Current K/D: %s\nBest K/D: %s\n", new DecimalFormat("#.##").format(KD), new DecimalFormat("#.##").format(bestKD));
		int max = 0;
		String name = "null";
		for(String s : charKills.keySet()) {
			if(charKills.get(s) > max) {
				max = charKills.get(s);
				name = s;
			}
		}
		out += String.format("Most killed player: %s (%d kills)\n",name,max);
		return out;
	}
}
