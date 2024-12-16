package Assignments;
import java.util.ArrayList;

public class As3_Team {

    ArrayList<As3_Player> players = new ArrayList<>();



    private String Nickname;
    private String City;
    private String Division;
    private int Wins;
    private int Losses;
    private int gamesPlayed;


    public As3_Team(String n, String c, String d, int w, int l, int gp) {
        Nickname = n;
        City = c;
        Division = d;
        Wins = w;
        Losses = l;
        gamesPlayed = gp;

    }
public void addPlayer(As3_Player player){

players.add(player);

}




    public String toString() {
        return " Name: " + Nickname + " City: " + City + " Division: " + Division + " Wins: " + Wins + " Losses: " + Losses + " Games Played: " + gamesPlayed;
    }

    public void findAverage(int size, int total) {

    }

    public String getNickname() {
        return Nickname;
    }

    public String getCity() {
        return City;
    }

    public int getWins() {
        return Wins;
    }

    public int getLosses() {
        return Losses;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }



    public void setLosses(int losses) {
        Losses = losses;
    }

    public void setWins(int wins) {
        Wins = wins;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public String getDivision() {
        return Division;
    }

public  void printPlayers(){

    if (players.isEmpty()) {
        System.out.println("No players on this team.");
    } else {
        for (As3_Player player : players) {
            System.out.println(player);
        }
    }
}
public int printTotalGoals(){
        int totalGoals = 0;
        for(As3_Player player: players){
            totalGoals += player.getgScored();
        }
return totalGoals;

}
    public int printTotalHits(){
        int totalHits = 0;
        for(As3_Player player: players){
            totalHits += player.getHits();
        }
        return totalHits;

    }
    public void printTeamTotals(){
        System.out.println("Team: " + getNickname() + "has scored " + printTotalGoals () + " goals and has " + printTotalHits() + " hits ");

    }

    public ArrayList<As3_Player> getPlayers() {
        return players;
    }
}



