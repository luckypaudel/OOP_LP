package Assignments;

import Examples.Ex3_Client;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class As3_LeagueMain {
public static void run() {
    ArrayList<As3_Team> allTeams = new ArrayList<>();

    loadFile("data/TeamsData.csv", allTeams);
    while(true) {

        System.out.println("Press 1 to print a list of teams\nPress 2 to for country\nPress 3 for jazzy grooves\nPress 4 to exit.");


         int choice = Library.input.nextInt();
         Library.input.nextLine();

        if (choice == 1) {
            System.out.println("Not implemented Yet");

        }
        if (choice == 2) {
            System.out.println("Not implemented Yet");
        }
        if (choice == 3) {
            System.out.println("Not implemented Yet");
        }
        if (choice == 4) {
            System.out.println("Not implemented Yet");
        }
        if (choice == 5) {
            System.out.println("Not implemented Yet");
        }
        if (choice == 6) {
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
                list.add(new As3_Team(tempArray[0], tempArray[1], tempArray[3], Integer.parseInt(tempArray[2]),Integer.parseInt(tempArray[4] ), Integer.parseInt(tempArray[5] ) ));

            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }//end loadFile
}

