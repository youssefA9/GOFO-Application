package APP;

import java.util.ArrayList;
import java.util.Scanner;

public class Booking_System {
    public ArrayList<Playground> playgrounds = new ArrayList<Playground>();
    public void Display_Playgrounds() {
        System.out.println("Number of Playgrounds : " + (playgrounds.size()));
        for (int i = 0; i < playgrounds.size(); i++) {
            if(playgrounds.get(i).Active==true){
            System.out.println((i + 1) + "- " + playgrounds.get(i) + "\n");
        }}
    }

    public double Cal_TotalPrice(int time, Playground m) {
        double total;
        total = m.getPrice_perHour() * time;
        return total;
    }

    public void pay(double price, User m) {
        if (m.eWallet < price) {
            System.out.println("Payment failed!");
        } else {
            m.eWallet -= price;
            System.out.println("Payment is successful!");
        }
    }

    public void Filter_Playgrounds() {
        String filt;
        Scanner m = new Scanner(System.in);
        System.out.println("Enter the location of the Playground (City) : ");
        filt = m.nextLine();
        int count = 1;
        for (int i = 0; i < playgrounds.size(); i++) {
            if (filt.equals(playgrounds.get(i).Location)&&playgrounds.get(i).Active==true){
                System.out.println((count) + "- " + playgrounds.get(i).toString() + "\n");
                count++;}
        }
        if (count == 1) {
            System.out.print("There are no playgrounds in this area!");
        }
    }

    public void View_Hours(Playground m) {
        for (int i = 0; i <m.getAvailable_Hours() ; i++) {
            if(m.Booked[i]==false){
                System.out.println((i+1) + "- " + m.Hours[i] + "\n");
            }
        }

    }
    public int Filter_Hours(String slot){
        int s=20;
        int count=1;

        for(int i=0;i<15;i++){
            if(playgrounds.get(0).Hours[i].equals(slot)){
                s=i;
            }
        }
        if(s!=20) {
            for (int i = 0; i < playgrounds.size(); i++) {
                if (playgrounds.get(i).Booked[s] == false&&playgrounds.get(i).Active==true) {
                    System.out.println((count) + "- " + playgrounds.get(i).toString() + "\n");
                    count++;
                }
            }
            return s;
        }
        else{
            System.out.println("No available Playgrounds available in this slot");
            return 0;
        }
    }
}


