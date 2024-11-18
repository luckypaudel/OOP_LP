package Examples;

public class Ex2_Actor {

private String name;
private String role;
private double sales;
private boolean isPro;


public Ex2_Actor( String n, String r ){
    name = n;
    role = r;
    sales = 0;
    isPro = false;


}//constructor
    public Ex2_Actor( String n, String r, boolean p ){
        name = n;
        role = r;
        sales = 0;
        isPro = p;

        

    }//constructor
public String toString(){
    return name + " , " + role + " , " + sales + ", " + isPro;

}
public void printMe(){

    System.out.println(name + " , " + role + " \n Ticket Sales: $ " + sales + ", " + isPro);

}

    public boolean isPro() {
        return isPro;
    }

    public void sellTix(int n){

sales += n;


}

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public double getSales() {
        return sales;
    }


}//class
