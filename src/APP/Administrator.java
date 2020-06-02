package APP;

import javax.naming.Name;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Scanner;

public class Administrator {
        protected
        int ID;
        String Password;
        public ArrayList<Playground> grounds = new ArrayList<Playground>();
        public Administrator(int ID, String Password) {
            this.ID = ID;
            this.Password = Password;
        }

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
        public void setPassword(String password) { this.Password = password;}
        public void Display_NonAccepted_Playgrounds(){
            System.out.println("Number of Playgrounds : " + (grounds.size()));
            for (int i = 0; i < grounds.size(); i++) {
                System.out.println((i + 1) + "- " + grounds.get(i) + "\n");
        }}
        public void Approve_Playground(Booking_System sys,Playground p) {
            sys.playgrounds.add(p);
            grounds.remove(p);
        }
        public void Activate_Playground(Booking_System sys,int index) {
            sys.playgrounds.get(index).Active=true;
        }
        public void Suspend_Playground(Booking_System sys,int index) {
            sys.playgrounds.get(index).Active=false;
        }
        public void Delete_Playground(Booking_System sys,int index) {
            sys.playgrounds.remove(index);
        }
    }


