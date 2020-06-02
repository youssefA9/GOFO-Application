package APP;

import javax.naming.Name;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Presents the admin with his functionality
 */
public class Administrator {
    protected
    int ID;
    String Password;
    public ArrayList<Playground> grounds = new ArrayList<Playground>();

    /**
     * Constructor used to initialize the admin obj by ID and Password
     *
     * @param ID       Admin's ID
     * @param Password Admin's Pssword
     */
    public Administrator(int ID, String Password) {
        this.ID = ID;
        this.Password = Password;
    }

    /**
     * Empty Constructor
     */
    public Administrator() {
    }


    public int getID() {
        return ID;
    }


    public void setID(int ID) {
        this.ID = ID;
    }


    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    /**
     * This method is used to display all the playground that
     * the owners registered but not accepted yet
     */
    public void Display_NonAccepted_Playgrounds() {
        System.out.println("Number of Playgrounds : " + (grounds.size()));
        for (int i = 0; i < grounds.size(); i++) {
            System.out.println((i + 1) + "- " + grounds.get(i) + "\n");
        }
    }

    /**
     * This method is used to accept playground from the not yet approved playgrounds
     * and update the booking system with it
     *
     * @param sys Object from the booking System
     * @param p   The Desired playground
     */
    public void Approve_Playground(Booking_System sys, Playground p) {
        sys.playgrounds.add(p);
        grounds.remove(p);
    }

    /**
     * This method is used to activate the suspended playground
     * and sync that change with the booking system to make it available to the players
     *
     * @param sys   Object from the booking System
     * @param index The Number of the Desired playground
     */
    public void Activate_Playground(Booking_System sys, int index) {
        sys.playgrounds.get(index).Active = true;
    }

    /**
     * This method is used to suspend the playground
     * and sync that change with the booking system to prevent the players for seeing or booking it
     *
     * @param sys
     * @param index
     */
    public void Suspend_Playground(Booking_System sys, int index) {
        sys.playgrounds.get(index).Active = false;
    }

    /**
     * This method is used to delete the playground entirely from the system
     *
     * @param sys   Object from the booking System
     * @param index The number of the Desired Playground
     */
    public void Delete_Playground(Booking_System sys, int index) {
        sys.playgrounds.remove(index);
    }
}


