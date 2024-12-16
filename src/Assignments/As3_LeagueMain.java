package Assignments;

import Examples.Ex3_Client;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class As3_LeagueMain {
    static ArrayList<As3_Team> allTeams;
    public static void run() {

       allTeams = new ArrayList<>();
        loadFile("data/TeamsData.csv", allTeams);


        teamFromName(allTeams, "Oilers").addPlayer(new As3_Player("Leon Draisaitl", 1003, 28, 40));
        teamFromName(allTeams, "Oilers").addPlayer(new As3_Player("Ryan Nugent-Hopkins", 1004, 18, 25));
        teamFromName(allTeams, "Oilers").addPlayer(new As3_Player("Zach Hyman", 1005, 15, 32));
        teamFromName(allTeams, "Oilers").addPlayer(new As3_Player("Evander Kane", 1006, 20, 22));
        teamFromName(allTeams, "Oilers").addPlayer(new As3_Player("Connor McDavid", 1001, 25, 30));

        teamFromName(allTeams, "Maple Leafs").addPlayer(new As3_Player("Auston Matthews", 1002, 35, 28));
        teamFromName(allTeams, "Maple Leafs").addPlayer(new As3_Player("Mitch Marner", 1007, 21, 25));
        teamFromName(allTeams, "Capitals").addPlayer(new As3_Player("Alex Ovechkin", 1014, 38, 25));
        teamFromName(allTeams, "Capitals").addPlayer(new As3_Player("John Carlson", 1015, 34, 22));
        teamFromName(allTeams, "Penguins").addPlayer(new As3_Player("Sidney Crosby", 1026, 37, 30));

        teamFromName(allTeams, "Blackhawks").addPlayer(new As3_Player("Patrick Kane", 1014, 35, 25));
        teamFromName(allTeams, "Blackhawks").addPlayer(new As3_Player("Jonathan Toews", 1016, 36, 20));
        teamFromName(allTeams, "Flames").addPlayer(new As3_Player("Johnny Gaudreau", 1023, 23, 27));
        teamFromName(allTeams, "Flames").addPlayer(new As3_Player("Matthew Tkachuk", 1024, 26, 22));
        teamFromName(allTeams, "Penguins").addPlayer(new As3_Player("Evgeni Malkin", 1027, 38, 29));

        teamFromName(allTeams, "Kings").addPlayer(new As3_Player("Anze Kopitar", 1030, 36, 21));
        teamFromName(allTeams, "Kings").addPlayer(new As3_Player("Dustin Brown", 1031, 39, 17));
        teamFromName(allTeams, "Avalanche").addPlayer(new As3_Player("Nathan MacKinnon", 1032, 28, 30));
        teamFromName(allTeams, "Avalanche").addPlayer(new As3_Player("Cale Makar", 1020, 25, 23));
        teamFromName(allTeams, "Bruins").addPlayer(new As3_Player("David Pastrnak", 1008, 33, 20));




        while (true) {

            System.out.println("Press 1 to print a list of teams\nPress 2 to find the team with highest or lowest wins\nPress 3 to view teams in a divison\nPress 4 to sort by Wins \nPress 5 to update stats \nPress 6 to print players. \n Press 7 to print team stats \n Press 8 to add player stats \n Press 9 to save and exit");


            int choice = Library.input.nextInt();
            Library.input.nextLine();

            if (choice == 1) {
                for(int i = 0; i < allTeams.size(); i++) {
                    System.out.println(allTeams.get(i));
                }

            }
            if (choice == 2) {
                System.out.println("Find the team with the highest number of wins!");
                System.out.println("Do you want to find the highest or lowest amount of wins?");
                String response = Library.input.nextLine();
                if(response.equalsIgnoreCase("Highest")) {
                    int lowestIndex = 0;
                    for (int i = 0; i < allTeams.size() - 1; i++) {
                        lowestIndex = i;
                        for (int j = i + 1; j < allTeams.size(); j++) {
                            if (allTeams.get(j).getWins() < allTeams.get(lowestIndex).getWins()) {
                                lowestIndex = j;
                            }
                        }
//swaps the lowest to the beginning
                        As3_Team temp = allTeams.get(i);
                        allTeams.set(i, allTeams.get(lowestIndex));
                        allTeams.set(lowestIndex, temp);
                    }
                    System.out.println(allTeams.get(lowestIndex));
                }
                else {
                    int lowestIndex = 0;
                    for (int i = 0; i < allTeams.size() - 1; i++) {
                        lowestIndex = i;
                        for (int j = i + 1; j < allTeams.size(); j++) {
                            if (allTeams.get(j).getWins() > allTeams.get(lowestIndex).getWins()) {
                                lowestIndex = j;
                            }
                        }
//swaps the lowest to the beginning
                        As3_Team temp = allTeams.get(i);
                        allTeams.set(i, allTeams.get(lowestIndex));
                        allTeams.set(lowestIndex, temp);
                    }
                    System.out.println(allTeams.get(lowestIndex));
                }
            }
            if (choice == 3) {
                System.out.println("What division are you looking for?");
                String response = Library.input.nextLine();


                for (As3_Team allTeam : allTeams) {
                    if (allTeam.getDivision().equalsIgnoreCase(response)) {
                        System.out.println(allTeam);

                    }
                }
            }
            if (choice == 4) {
                System.out.println("You have chosen to sort by Wins");
                sortByWins(allTeams);
                for (As3_Team allTeam : allTeams) {
                    System.out.println(allTeam);
                }

            }
            if (choice == 5) {
                System.out.println("Add stats for a team");
               updateStats(allTeams);
            }
            if (choice == 6) {
                System.out.println("Print the players");
                System.out.println("What team do you want to print?");
                String response = Library.input.nextLine();

                As3_Team team = teamFromName(allTeams, response);
                if (team != null) {
                    team.printPlayers();
                } else {
                    System.out.println("Team not found!");
                }

  }
            if (choice == 7 ){
                System.out.println("Print the total stats for the teams");
                for (As3_Team allTeam : allTeams) {
                    allTeam.printTeamTotals();
                }
            }
            if (choice == 8){
                updatePlayerStats(allTeams);

            }
            if(choice == 9){
                saveFile("data/TeamsData.csv", allTeams);
                break;
            }

            System.out.println();

        }//while
    }



    public static void loadFile(String filename, ArrayList<As3_Team> list) {

        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));

            String dataToRead;
            while (file.ready()) {
                dataToRead = file.readLine();

                String tempArray[] = dataToRead.split(",");
//the next line is customized for whatever class you are creating.
//Here we create a new STUDENT so there are 5 variables
//Unfortunately, you need to Parse any variable that is not a String.  Integers, doubles and booleans are all demonstrated below.
                list.add(new As3_Team(tempArray[0], tempArray[1], tempArray[2], Integer.parseInt(tempArray[3]), Integer.parseInt(tempArray[4]), Integer.parseInt(tempArray[5])));

            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }//end loadFile
    public static void saveFile(String filename, ArrayList <As3_Team> tempList ) {
        try {
            PrintWriter file = new PrintWriter(new FileWriter(filename));

            for (int i = 0; i < tempList.size(); i++) {
//the next lines are customized for whatever data you are getting.
                String toSave = "";
                toSave = tempList.get(i).getNickname();  //assumes getter method are used for private variables
                toSave +="," + tempList.get(i).getCity();
                toSave += "," + tempList.get(i).getDivision();
                toSave +="," + tempList.get(i).getWins();
                toSave +="," + tempList.get(i).getLosses();
                toSave +="," + tempList.get(i).getGamesPlayed();

//The above 6 lines could be replaced by a call to a carefully made toString() function

                file.println(toSave);

            }
            file.close();
        }
        catch (IOException ex) {
            System.out.println(ex.toString());
        }

    }//end saveFile

    public static void sortByWins(ArrayList<As3_Team> arr){
        for(int i=0; i<arr.size()-1; i++){
            int lowestIndex = i;
            for(int j=i+1; j<arr.size(); j++){
                if(arr.get(j).getWins() < arr.get(lowestIndex).getWins()){
                    System.out.println(arr.get(j).getWins() + " vs lowestIndex " + arr.get(lowestIndex).getWins());
                    lowestIndex = j;
                }
            }
            //swap the data
            As3_Team temp = arr.get(i);
            arr.set(i, arr.get(lowestIndex));
            arr.set(lowestIndex, temp);

        }
    }
    static As3_Team teamFromName(ArrayList<As3_Team> list, String name){
        for(int i = 0; i < list.size(); i++){
            if(name.equalsIgnoreCase((list.get(i)).getNickname())){
                return list.get(i);
            }
        }
        System.out.println("!!! no team with name "+name+" !!!");
        return null;
    }

    public static void updateStats(ArrayList<As3_Team> allTeams) {
        System.out.println("Enter the first team nickname:");
        String team1Name = Library.input.nextLine();
        System.out.println("Enter the second team nickname:");
        String team2Name = Library.input.nextLine();
        System.out.println("Enter the goals scored by " + team1Name + ":");
        int team1Goals = Library.input.nextInt();
        System.out.println("Enter the goals scored by " + team2Name + ":");
        int team2Goals = Library.input.nextInt();
        Library.input.nextLine();
        int team1Index = -1;
        int team2Index = -1;

        for (int i = 0; i < allTeams.size(); i++) {
            if (allTeams.get(i).getNickname().equalsIgnoreCase(team1Name)) {
                team1Index = i;
            } else if (allTeams.get(i).getNickname().equalsIgnoreCase(team2Name)) {
                team2Index = i;
            }
        }

        if (team1Index == -1 || team2Index == -1) {
            System.out.println("One or both teams not found. Please try again.");
            return;
        }

        As3_Team team1 = allTeams.get(team1Index);
        As3_Team team2 = allTeams.get(team2Index);

        // Increment games played for both teams
        team1.setGamesPlayed(team1.getGamesPlayed() + 1);
        team2.setGamesPlayed(team2.getGamesPlayed() + 1);

        if (team1Goals > team2Goals) {
            team1.setWins(team1.getWins() + 1);
            team2.setLosses(team2.getLosses() + 1);
            System.out.println(team1.getNickname() + " wins!");
        } else if (team2Goals > team1Goals) {
            team2.setWins(team2.getWins() + 1);
            team1.setLosses(team1.getLosses() + 1);
            System.out.println(team2.getNickname() + " wins!");
        } else {
            System.out.println("It's a draw! No team gets a win.");
        }
    }
    public static void updatePlayerStats(ArrayList<As3_Team> allTeams){
        System.out.println("Enter player name that you would like to change stats for");
        String response = Library.input.nextLine();
        System.out.println("How many goals does " + response +  " have now?");
        boolean playerFound = false;
        int newG = Library.input.nextInt();
        Library.input.nextLine();
        System.out.println("How many hits does " + response +  " have now?");
        int newH = Library.input.nextInt();
        Library.input.nextLine();
for(As3_Team team: allTeams) {
    for (As3_Player player : team.getPlayers()) {
        if (player.getpName().equalsIgnoreCase(response)) {
            player.updateStats(newG, newH);
            System.out.println("Stats have been updated for " + player.getpName());
             playerFound = true;
            break;
        }
    }
    if (playerFound)
        break;


}
if(!playerFound){
    System.out.println("Player was not found");

    }

}



























}







