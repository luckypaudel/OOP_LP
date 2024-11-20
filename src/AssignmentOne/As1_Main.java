package AssignmentOne;

import Examples.Ex2_Actor;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class As1_Main {
    public static void run(){
        ArrayList<As1_Crop> allCrops = new ArrayList<>();
        allCrops.add(new As1_Crop("Avocados", 75, "kg", 1.99));
        allCrops.add(new As1_Crop("Bananas", 41, "tonnes", 1670));
        allCrops.add(new As1_Crop("Lychees" ,5250, "pounds", 5.99));
        allCrops.add(new As1_Crop("Guava", 105, "kg", 4.76));
        allCrops.add(new As1_Crop ("Canola", 1000, "bushell", 13.42));
allCrops.get(0).setAcres(500);
allCrops.get(1).setAcres(200);
allCrops.get(2).setAcres(100);
allCrops.get(3).setAcres(50);
allCrops.get(4).setAcres(150);
        for (As1_Crop cropTemp: allCrops) {
            System.out.println(cropTemp);
        }
        while(true) {
            int choice = Library.input.nextInt();
            Library.input.nextLine();
            System.out.println("Press 1 for a farm summary");
            System.out.println("Press 2 to search & Harvest a crop");
            System.out.println("Press 3 for Get total revenue");
            for (As1_Crop cropTemp: allCrops) {
                System.out.println(cropTemp);
            }

            if (choice == 1) {
                System.out.println("Press 1 for a farm summary");
                for (As1_Crop cropTemp: allCrops) {
                    System.out.println(cropTemp);
                }

            }
            if (choice == 2) {
                System.out.println("Yeehaw!");
            }
            if (choice == 3) {
                System.out.println("Cool dadio!");
            }
            if (choice == 4) {
                break;
            }
            System.out.println();

        }//while

        System.out.println("Good bye");

    }//run
    }

}
