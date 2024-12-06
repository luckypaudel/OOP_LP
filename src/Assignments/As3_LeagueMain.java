package Assignments;

import Examples.Ex3_Client;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class As3_LeagueMain {
    public static void run() {
        ArrayList<As3_Team> allTeams = new ArrayList<>();
        loadFile("data/TeamsData.csv", allTeams);
        while (true) {

            System.out.println("Press 1 to print a list of teams\nPress 2 to find the team with highest or lowest wins\nPress 3 to view teams in a divison\nPress 4 to sort by Wins \nPress 5 to update stats \nPress 6 to save and exit.");


            int choice = Library.input.nextInt();
            Library.input.nextLine();

            if (choice == 1) {
                for (int i = 0; i < allTeams.size(); i++) {
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
                System.out.println(" What division are you looking for? ");
                String response = Library.input.nextLine();
            for(int i = 0; i<allTeams.size(); i++){
                if(allTeams.get(i).getDivision().equals(response))
                {
                    System.out.println(allTeams.get(i));
                }
            }


            }
//            if (choice == 4) {
//                System.out.println("You have chosen to sort by Wins");
//                System.out.println("Do you want the highest first or lowest first");
//                for(int i = 0; i<allTeams.size() -1 ; i++){
//                    int i = lowestIndex;
//                    for(int j = 0l j<allTeams.size(); j++) {
//                        if (list.get(j).getWins() < list.get(lowestIndex).getAcres()) {
//
//
//                        }
//                    }
//            }
            if (choice == 5) {
                System.out.println("Not implemented Yet");
            }
            if (choice == 6) {
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
                list.add(new As3_Team(tempArray[0], tempArray[1], tempArray[3], Integer.parseInt(tempArray[2]), Integer.parseInt(tempArray[4]), Integer.parseInt(tempArray[5])));

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

public static void sortWins(){



}











}







