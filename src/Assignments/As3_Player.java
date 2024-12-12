package Assignments;
import java.io.*;
import java.util.ArrayList;

public class As3_Player {
    private String pName;
    private int pId;
    private int gScored;
    private int Hits;

    public As3_Player(String n, int i, int g, int h) {
        pName = n;
        pId = i;
        gScored = g;
        Hits = h;


    }
    public String toString(){

        return pName + " , " + pId + " , " + gScored + ", " + Hits;
    }

}
