package APP;

import java.util.ArrayList;
import java.util.Scanner;

public class playground_owner extends User {
    public playground_owner() {
    }

    public playground_owner(String name, String Username, String password, String Email, int phone, String location, double eWallet) {
        super(name, Username, password, Email, phone, location, eWallet);
    }

    public ArrayList<Playground> ownPlay = new ArrayList<Playground>();

    public Playground register_Playground() {
        Playground p = new Playground();
        Scanner k = new Scanner(System.in);
        System.out.println("Enter Playground's information : ");
        System.out.println("Enter Playground's Name : ");
        p.setName(k.next());
        int Space_Handler = 0;
        do {
            System.out.println("Enter Playground's Location : ");
            if (Space_Handler == 0) {
                p.setLocation(k.nextLine());
                Space_Handler++;
            }
            p.setLocation(k.nextLine());
            if (p.getLocation().indexOf(" ") != -1) {
                System.out.println("Invalid Input please enter only the City");
            }
        } while (p.getLocation().indexOf(" ") != -1);
        System.out.println("Enter Playground's Size : ");
        p.setSize(k.nextDouble());
        System.out.println("Enter Price Per Hour : ");
        p.setPrice_perHour(k.nextDouble());
        p.setAvailable_Hours(15);
        System.out.println("Enter Cancellation Period (Hours) : ");
        p.setCancellation_period(k.nextInt());
        return p;
    }

    public void add_playground(Administrator admin, Playground p) {
        admin.grounds.add(p);
        ownPlay.add(p);
    }


}