package APP;

import javax.xml.stream.FactoryConfigurationError;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

/**
 * Desicribes the player  with his functionality
 */
public class Player extends User {
    private ArrayList<String> Booked_playground = new ArrayList<String>();
    private ArrayList<Float> Booked_Times = new ArrayList<Float>();
    protected Team Fav_Team = new Team();
    protected Vector<String> messages = new Vector<String>();

    /**
     * Empty constructor
     */
    public Player() {
    }

    /**
     * This constructor is used to set the information of the player
     *
     * @param name
     * @param Username
     * @param password
     * @param Email
     * @param phone
     * @param location
     * @param eWallet
     */
    public Player(String name, String Username, String password, String Email, int phone, String location, double eWallet) {
        super(name, Username, password, Email, phone, location, eWallet);
    }

    public ArrayList<String> getBooked_playground() {
        return Booked_playground;
    }


    public void setBooked_playground(ArrayList<String> Booked_playground) {
        this.Booked_playground = Booked_playground;
    }

    public ArrayList<Float> getBooked_Times() {
        return Booked_Times;
    }

    public void setBooked_Times(ArrayList<Float> Booked_Times) {
        this.Booked_Times = Booked_Times;
    }

    /**
     * This method is used to Show the player all the available playgrounds
     * and let him make operations on them to choose which one he wanted to book
     *
     * @param sys
     * @param m
     */
    public void book(Booking_System sys, User m) {
        System.out.println("Select one of the options below : ");
        System.out.println("1- Show all Playgrounds ");
        System.out.println("2- Filter Playgrounds ");
        System.out.println("3- Filter Playing hours ");
        Scanner k = new Scanner(System.in);
        int ans = 0;
        int x = 1, counter = 1;
        int ans2 = 0;
        int PgIndex = 0;
        int SlotIndex = 0;
        ans = k.nextInt();
        if (ans == 1) {
            sys.Display_Playgrounds();
            System.out.println("Select one of the playgrounds above : ");
            PgIndex = k.nextInt();
            while (x == 1) {
                sys.View_Hours(sys.playgrounds.get(PgIndex - 1));
                System.out.println("Select one of the slots above : ");
                SlotIndex = k.nextInt();
                sys.playgrounds.get(PgIndex - 1).Booked[SlotIndex - 1] = true;
                System.out.println("Do you want to pick another slot ?");
                System.out.println("1-Yes 2- No");
                ans2 = k.nextInt();
                if (ans2 == 1) {
                    counter++;

                } else if (ans2 == 2) {
                    x = 2;
                }

            }
            System.out.println("Total Price : " + sys.Cal_TotalPrice(counter, sys.playgrounds.get(PgIndex - 1)) + '\n');
            sys.pay(sys.Cal_TotalPrice(counter, sys.playgrounds.get(PgIndex - 1)), m);
            System.out.println("Your eWallet Balance after Payment : " + m.geteWallet());
        } else if (ans == 2) {
            sys.Filter_Playgrounds();
            System.out.println("Select one of the playgrounds above : ");
            PgIndex = k.nextInt();
            while (x == 1) {
                sys.View_Hours(sys.playgrounds.get(PgIndex - 1));
                System.out.println("Select one of the slots above : ");
                SlotIndex = k.nextInt();
                sys.playgrounds.get(PgIndex - 1).Booked[SlotIndex - 1] = true;
                System.out.println("Do you want to pick another slot ?");
                System.out.println("1-Yes 2- No");
                ans2 = k.nextInt();
                if (ans2 == 1) {
                    counter++;

                } else if (ans2 == 2) {
                    x = 2;
                }

            }
            System.out.println("Total Price : " + sys.Cal_TotalPrice(counter, sys.playgrounds.get(PgIndex - 1)) + '\n');
            sys.pay(sys.Cal_TotalPrice(counter, sys.playgrounds.get(PgIndex - 1)), m);
            System.out.println("Your eWallet Balance after Payment : " + m.geteWallet());

        } else if (ans == 3) {
            System.out.println("Enter specific slot you want to book at");
            String slot;
            int id = -1;
            slot = k.next();
            id = sys.Filter_Hours(slot);
            System.out.println("Select one of the playgrounds above : ");
            PgIndex = k.nextInt();
            sys.playgrounds.get(PgIndex - 1).Booked[id] = true;
            System.out.println("Total Price : " + sys.Cal_TotalPrice(1, sys.playgrounds.get(PgIndex - 1)) + '\n');
            sys.pay(sys.Cal_TotalPrice(1, sys.playgrounds.get(PgIndex - 1)), m);
            System.out.println("Your eWallet Balance after Payment : " + m.geteWallet());
        }
    }

    /**
     * This method is used to send invitation notification to all the player in the favourite team
     */
    public void send_inv() {
        for (int i = 0; i < Fav_Team.Players.size(); i++) {
            System.out.println("Invitation was sent to " + Fav_Team.Players.get(i).Username);
            Fav_Team.Players.get(i).messages.add(Username + ": Invited you to play a match");
        }
    }

    /**
     * This method is used to check if there any received messages or invitations from other players
     */
    public void check_messages() {
        if (messages.size() == 0) {
            System.out.println("No Messages was received");
        }
        for (int i = 0; i < messages.size(); i++) {
            System.out.println(messages.get(i));
        }
        System.out.println("\n");
    }

    /**
     * This method is used to make operation on the favourite team from adding to removing players
     *
     * @param player_list
     */
    public void edit_favTeam(ArrayList<Player> player_list) {
        Scanner input = new Scanner(System.in);
        int option = 0;
        boolean flag = false;
        boolean choice = false;
        int x = 0, y = 0;
        String ans, username;

        String answer1, answer2;
        System.out.println("1-Change Team name");
        System.out.println("2-add Player");
        System.out.println("3-Replace Player");
        System.out.println("4-Remove Player");
        System.out.println("5-Display Players");
        option = input.nextInt();
        while (option > 5 || option < 1) {
            System.out.println("Invalid Input");
            option = input.nextInt();
        }
        if (option == 1) {
            System.out.println("Enter the new name of the team: ");
            answer1 = input.next();
            Fav_Team.setName(answer1);
        } else if (option == 2) {
            choice = true;
            if (Fav_Team.getSize() < 6) {
                while (choice == true && Fav_Team.getSize() < 6) {
                    boolean checker = false;
                    System.out.println("Enter the username of the player: ");
                    username = input.next();
                    flag = false;
                    for (int i = 0; i < player_list.size(); i++) {
                        if (player_list.get(i).Username.equals(username)) {
                            for (int j = 0; j < Fav_Team.Players.size(); j++) {
                                if (Fav_Team.Players.get(j).equals(player_list.get(i))) {
                                    checker = true;
                                    break;
                                }
                            }
                            if (checker == false) {
                                Fav_Team.Add_Player(player_list.get(i), Username);
                                flag = true;
                            }
                            break;
                        }
                    }
                    if (flag == false) {
                        System.out.println("Sorry! There is no player with that username or already exists in the team");
                    }
                    System.out.println("Do you want to add more players ? (Y/N)");
                    ans = input.next();
                    if (ans.equalsIgnoreCase("y")) {
                        choice = true;
                    } else {
                        choice = false;
                    }
                }
            } else {
                System.out.println("Can't add more players to the team");
            }
        } else if (option == 3) {
            do {
                boolean checker = false;
                System.out.println("Enter username of the new player: ");
                answer1 = input.next();
                flag = false;
                for (int i = 0; i < player_list.size(); i++) {
                    if (player_list.get(i).Username.equals(answer1)) {
                        for (int j = 0; j < Fav_Team.Players.size(); j++) {
                            if (Fav_Team.Players.get(j).equals(player_list.get(i))) {
                                checker = true;
                                break;
                            }
                        }
                        if (checker == false) {
                            x = i;
                            flag = true;
                        }
                        break;
                    }
                }
                if (flag == false) {
                    System.out.println("Sorry! There is no player with that username please enter another username or already exists in the team");
                }
            } while (flag != true);
            do {
                System.out.println("Enter username of the old player: ");
                answer2 = input.next();
                flag = false;
                for (int i = 0; i < player_list.size(); i++) {
                    if (Fav_Team.Players.get(i).Username.equals(answer2)) {
                        y = i;
                        flag = true;
                        break;
                    }
                }
                if (flag == false) {
                    System.out.println("Sorry! There is no player with that username please enter another username");
                }
            } while (flag != true);
            if (flag == true) {
                Fav_Team.Replace_Player(Fav_Team.Players.get(y), player_list.get(x));
            }
        } else if (option == 4) {
            if (Fav_Team.getSize() > 0) {
                do {
                    System.out.println("Enter username of the player you want to remove: ");
                    answer2 = input.next();
                    flag = false;
                    for (int i = 0; i < player_list.size(); i++) {
                        if (Fav_Team.Players.get(i).Username.equals(answer2)) {
                            Fav_Team.Players.get(i).messages.add(Username + ": Removed you from his Favourite Team");
                            System.out.println(Fav_Team.Players.get(i).Username + ": was Successfully Removed");
                            Fav_Team.Remove_Player(Fav_Team.Players.get(i));
                            flag = true;
                            break;
                        }
                    }
                    if (flag == false) {
                        System.out.println("Sorry! There is no player with that username please enter another username");
                    }
                } while (flag != true && Fav_Team.getSize() > 0);
            } else {
                System.out.println("Can't Remove more players there is nobody left");
            }
        } else if (option == 5) {
            Fav_Team.Display();
        }
    }

    /**
     * This method is used to create new team and put a name to it
     * as while as the players
     *
     * @param player_list
     */
    public void create_team(ArrayList<Player> player_list) {
        if (Fav_Team.getSize() == 0) {
            Scanner input = new Scanner(System.in);
            String username;
            String name;
            boolean choice = false;
            boolean flag = false;
            String ans;
            System.out.println("Please Enter the Name of the team: ");
            name = input.next();
            Fav_Team.setName(name);
            choice = true;
            while (choice == true && Fav_Team.getSize() < 5) {
                boolean checker = false;
                System.out.println("Enter the username of the player: ");
                username = input.next();
                flag = false;
                for (int i = 0; i < player_list.size(); i++) {
                    if (player_list.get(i).getUsername().equals(username)) {
                        for (int j = 0; j < Fav_Team.Players.size(); j++) {
                            if (Fav_Team.Players.get(j).equals(player_list.get(i))) {
                                checker = true;
                                break;
                            }
                        }
                        if (checker == false) {
                            Fav_Team.Add_Player(player_list.get(i), Username);
                            flag = true;
                        }
                        break;
                    }
                }
                if (flag == false) {
                    System.out.println("Sorry! There is no player with that username");
                }
                if (Fav_Team.getSize() < 5) {
                    System.out.println("Do you want to add more players ? (Y/N)");
                    ans = input.next();
                    if (ans.equalsIgnoreCase("y")) {
                        choice = true;
                    } else {
                        choice = false;
                    }
                } else {
                    choice = false;
                }
            }
        } else {
            System.out.println("You have already created one Can't create another");
        }
    }


    public Team getFav_team() {
        return Fav_Team;
    }

}
