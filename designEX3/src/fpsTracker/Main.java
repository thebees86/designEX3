package fpsTracker;

public class Main {
	public static void main(String args[]) {
		Tracker fortnite = new Tracker("ItsJohnny12"); //Created new stat tracker for Fortnite for the player ItsJohnny12
		
		//Each of the following is an event that occurs in Fortnite
		Match battle = new Match(); //The player (ItsJohnny12) enters a new game
		battle.kill("_bob_"); //The player kills the enemy player with username "_bob"
		battle.assist(); //The player gets and assist
		battle.kill("_bob_"); //The player kills _bob_ again, after _bob_ respawned (that's not a thing in fortnite, but for the sake of demonstration it is)
		battle.death(); //self-explanatory
		battle.death();
		battle.death();
		battle.kill("xXtommyXx");
		battle.assist();
		
		//Now the battle is over, and the stats are added to the tracker
		fortnite.addMatch(battle);
		
		System.out.println(fortnite);
		
		//Another battle
		Match battle2 = new Match();
		battle2.kill("_bob_");
		battle2.death();
		battle2.death();
		battle2.assist();
		battle2.death();
		battle2.death();
		
		fortnite.addMatch(battle2);
		
		System.out.println(fortnite);
	}
}
