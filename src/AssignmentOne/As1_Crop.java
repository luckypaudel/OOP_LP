package AssignmentOne;
import java.io.*;
import java.util.ArrayList;
public class As1_Crop {
    private String name;
    private double yield;
    private String units;
    private double price;
    private int acres;
public As1_Crop(String n, int y, String u, double p){
    name = n;
    yield = y;
    units = u;
    price = p;
    acres = 0;

}
public String toString(){
     return name + " , " + yield + " , " + units + ", " + price + ", " + acres;
}


public void setAcres( int number){
    this.acres = number;
}
public double harvest(String n , int y, String u, double p){
    double total = p * y * acres;
}




public String getallNames(){
    return name;
}
public double harvest(){

    return 0;
}

    public String getName() {
        return name;
    }

    public double getYield() {
        return yield;
    }

    public String getUnits() {
        return units;
    }

    public double getPrice() {
        return price;
    }

    public int getAcres() {
        return acres;
    }
}
