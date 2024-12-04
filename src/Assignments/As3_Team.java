package Assignments;

public class As3_Team {
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

    public void divisionFinder() {

    }

    public String getDivision() {
        return Division;
    }
}

