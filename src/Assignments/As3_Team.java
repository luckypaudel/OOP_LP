package Assignments;

public class As3_Team {
    private String Nickname;
    private String City;
    private String Division;
    private int Wins;
    private int Losses;
    private int gamesPlayed;


    public As3_Team(String n, String c, String d, int w, int l, int gp){
        Nickname = n;
        City = c;
        Division = d;
        Wins = w;
        Losses = l;
        gamesPlayed = gp;

    }
    public void printMe(){
//        System.out.println("Team: " + Nickname, "City :" + City, "Division: " + Division, "Wins: " + Wins, "Losses  " +  Losses, "Games Played " + gamesPlayed );
    }


}