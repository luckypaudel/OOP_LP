package Assignments;

import java.util.ArrayList;

public class As1_Main {
    public static void run() {
        ArrayList<As1_Crop> allCrops = new ArrayList<>();
        allCrops.add(new As1_Crop("Avocados", 75, "kg", 1.99));
        allCrops.add(new As1_Crop("Bananas", 41, "tonnes", 1670));
        allCrops.add(new As1_Crop("Lychees", 5250, "pounds", 5.99));
        allCrops.add(new As1_Crop("Guava", 105, "kg", 4.76));
        allCrops.add(new As1_Crop("Canola", 1000, "bushell", 13.42));
        allCrops.get(0).setAcres(500);
        allCrops.get(1).setAcres(200);
        allCrops.get(2).setAcres(100);
        allCrops.get(3).setAcres(50);
        allCrops.get(4).setAcres(150);
int totalRevenue = 0;
        while (true) {
            System.out.println("Press 1 for a farm summary");
            System.out.println("Press 2 to search & Harvest a crop");
            System.out.println("Press 3 to Get total revenue");
            System.out.println("Press 4 to Plant a crop");
            System.out.println("Press 5 to exit");

            int choice = Library.input.nextInt();
            Library.input.nextLine();


            if (choice == 1) {
                for (int i = 0; i < allCrops.size(); i++) {
                    System.out.println(allCrops.get(i));
                }

            }

           if (choice == 2) {
                System.out.println("Enter a crop name");
                String name = Library.input.nextLine();

               System.out.println("Do you want to harvest " + name);
               String ans = Library.input.nextLine();
               if(ans.startsWith("Y")) {


                   int foundClient = searchByName(allCrops, name);
                   System.out.println(allCrops.get(foundClient));
                   if (foundClient == -1) {
                       System.out.println("Crop was not found, Try again!");
                   } else {

                       System.out.println("When you harvested it, you made " + allCrops.get(foundClient).harvest());
                        totalRevenue += allCrops.get(foundClient).harvest();
                       allCrops.get(foundClient).setAcres(0);
                       System.out.println(allCrops.get(foundClient));
                   }
               }
           }
            if (choice == 3) {
                System.out.println(" Total revenue from the harvest: " + totalRevenue);
            }
            if (choice == 4) {
                System.out.println("What is the name of the crop");
                String response = Library.input.nextLine();
                System.out.println("How many acres would you like to plant");
                int aResponse = Library.input.nextInt();
                Library.input.nextLine();
                int index = searchByName(allCrops,response);
                if(index == -1){
                    System.out.println("What is the yield?");
                   int nYield = Library.input.nextInt();
                   Library.input.nextLine();
                    System.out.println("In what units is this yield?");
                    String nUnits = Library.input.nextLine();
                    System.out.println("How much do we get per unit?");
                    Double nPrice = Library.input.nextDouble();
                    Library.input.nextLine();
                    allCrops.add(new As1_Crop(response, nYield, nUnits, nPrice));
                    allCrops.get(allCrops.size()-1).setAcres(aResponse);
                }
                else{
                    allCrops.get(index).setAcres(aResponse);
                }
            }
            if(choice == 5){
                break;
            }


        }//while

        System.out.println("Good bye");

    }//run

    public static int searchByName(ArrayList<As1_Crop> list, String searchTerm) {
        for (int i = 0; i < list.size(); i++) {
            if (searchTerm.equalsIgnoreCase(list.get(i).getallNames())) {
                return i;
            }
        }
        return -1;
    }


}


