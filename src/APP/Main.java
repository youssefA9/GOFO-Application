package APP;


import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    private static Player Player;
    private static playground_owner playground_owner;
    private static User user;

    public static void main(String[] args) {

        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<playground_owner> owner = new ArrayList<playground_owner>();
        user = new User();
        Scanner input = new Scanner(System.in);
        int choose;
        String name;
        String password;
        String Email;
        int phone;
        double eWallet;
        String location = "";
        String userName;
        int type;
        int option;
        int playerOption;
        int choice = 0;


        //owner.add(new playground_owner("khaled", "kh", "22", "22", 22222, "ss", 500));
        // players.add(new Player("khaled", "mm", "22", "22", 22222, "ss", 500));
        Administrator admin = new Administrator();
        Booking_System sys = new Booking_System();

        System.out.println("=============== GOFO APPLICATION ==============");
        System.out.println("=============== Welcome, Select one of the options ==============");
        do {
            option = 2;
            System.out.println("1-Sign up");
            System.out.println("2-Login");
            choose = input.nextInt();
            if (choose == 1) {
                System.out.println("=============== Sign Up Page ==============");
                System.out.println("Enter Your Name : ");
                name = input.next();
                go:
                System.out.println("Enter Your Username : ");
                userName = input.next();
                while (user.check_username(userName) == 1) {
                    System.out.println("This Username is taken ,please enter another one!");
                    userName = input.next();
                }
                int Space_Handler = 0;
                do {
                    System.out.println("Enter Your Email : ");
                    if (Space_Handler == 0) {
                        Email = input.nextLine();
                        Space_Handler++;
                    }
                    Email = input.nextLine();
                    if (Email.indexOf("@") == -1 || Email.indexOf(" ") != -1) {
                        System.out.println("Invalid Email");
                    }
                } while (Email.indexOf("@") == -1 || Email.indexOf(" ") != -1);
                System.out.println("Enter Your Password : ");
                password = input.next();
                System.out.println("Enter Your Phone : ");
                phone = input.nextInt();
                Space_Handler = 0;
                do {
                    System.out.println("Enter Your Location : ");
                    if (Space_Handler == 0) {
                        location = input.nextLine();
                        Space_Handler++;
                    }
                    location = input.nextLine();
                    if (Character.isDigit(location.charAt(0)) == false) {
                        System.out.println("Invalid input");
                    }
                } while (Character.isDigit(location.charAt(0)) == false);
                System.out.println("Enter Your eWallet funds : ");
                eWallet = input.nextDouble();
                do {
                    System.out.println("Are You Player or Playground owner?..");
                    System.out.println("1-Player");
                    System.out.println("2-Playground owner");
                    type = input.nextInt();
                    if (type == 1) {
                        Player = new Player(name, userName, password, Email, phone, location, eWallet);
                        players.add(Player);
                        Player.setUsername(userName);
                        user.setPlayer(Player);
                        System.out.println("Player Registered");
                    } else if (type == 2) {

                        playground_owner = new playground_owner(name, userName, password, Email, phone, location, eWallet);
                        owner.add(playground_owner);
                        playground_owner.setUsername(userName);
                        user.setOwner(playground_owner);
                        System.out.println("Playground Owner Registered");
                    } else {
                        System.out.println("Invalid Input");
                    }
                } while (type != 1 && type != 2);


            } else if (choose == 2) {
                System.out.println("=============== Login Page ==============");
                System.out.println("Enter Username");
                userName = input.next();

                System.out.println("Enter Password");
                password = input.next();
                if (userName.equals("admin") && password.equals("admin")) {
                    System.out.println("Welcome Back Admin..");
                    int ans = 0;
                    Scanner k = new Scanner(System.in);
                    do {
                        System.out.println("1- Approve Playgrounds under revision");
                        System.out.println("2- Activate Playgrounds under revision");
                        System.out.println("3- Suspend Playgrounds under revision");
                        System.out.println("4- Delete Playground");
                        System.out.println("5- Logout");
                        choice = k.nextInt();
                        if (choice == 1) {
                            admin.Display_NonAccepted_Playgrounds();
                            int ans2 = 0;
                            if (admin.grounds.size() > 0) {
                                System.out.println("Select one of the previous playgrounds to approve ..");
                                ans2 = k.nextInt();
                                admin.Approve_Playground(sys, admin.grounds.get(ans2 - 1));
                                System.out.println("Playground is Approved Successfully");
                            }
                        } else if (choice == 2) {
                            int ans2 = 0;
                            if (admin.grounds.size() > 0) {
                                for (int i = 0; i < sys.playgrounds.size(); i++) {
                                    if (sys.playgrounds.get(i).Active == false) {
                                        System.out.println((i + 1) + "- " + sys.playgrounds.get(i) + "\n");
                                    }
                                }
                                System.out.println("Select one of the previous playgrounds to Activate ..");
                                ans2 = k.nextInt();
                                admin.Activate_Playground(sys, ans2);
                                System.out.println("Playground is Approved Successfully");
                            }
                        } else if (choice == 3) {
                            int ans2 = 0;
                            if (admin.grounds.size() > 0) {
                                sys.Display_Playgrounds();
                                System.out.println("Select one of the previous playgrounds to Suspend ..");
                                ans2 = k.nextInt();
                                admin.Suspend_Playground(sys, ans2 - 1);

                            }
                        } else if (choice == 4) {
                            int ans2 = 0;
                            if (admin.grounds.size() > 0) {
                                sys.Display_Playgrounds();
                                System.out.println("Select one of the previous playgrounds to Delete ..");
                                ans2 = k.nextInt();
                                admin.Delete_Playground(sys, ans2 - 1);
                                System.out.println("Playground is Deleted");
                            }
                        }


                    } while (choice != 5);
                }
                if (user.login(userName, password) == 1) {
                    System.out.println("Welcome Back Player..");
                    do {
                        int x = 0;
                        for (int i = 0; i < players.size(); i++) {

                            if (userName.equals(players.get(i).getUsername())) {
                                x = i;
                                break;
                            }
                        }
                        playerMenu();
                        playerOption = input.nextInt();
                        if (playerOption == 1) {
                            //  if (sys.playgrounds.size() > 0) {
                            players.get(x).book(sys, players.get(x));
                            //  }
                        } else if (playerOption == 2) {
                            players.get(x).create_team(players);
                            for (int i = 0; i < players.size(); i++) {
                                for (int j = 0; j < players.get(x).Fav_Team.Players.size(); j++) {
                                    if (players.get(i).Username.equals(players.get(x).Fav_Team.Players.get(j).Username)) {
                                        players.get(i).messages = players.get(x).Fav_Team.Players.get(j).messages;
                                    }
                                }
                            }
                        } else if (playerOption == 3) {
                            players.get(x).edit_favTeam(players);
                        } else if (playerOption == 4) {
                            players.get(x).send_inv();
                            for (int i = 0; i < players.size(); i++) {
                                for (int j = 0; j < players.get(x).Fav_Team.Players.size(); j++) {
                                    if (players.get(i).Username.equals(players.get(x).Fav_Team.Players.get(j).Username)) {
                                        players.get(i).messages = players.get(x).Fav_Team.Players.get(j).messages;
                                    }
                                }
                            }
                        } else if (playerOption == 5) {
                            players.get(x).check_messages();
                        } else if (playerOption !=6) {
                            System.out.println("Invalid input");
                        }
                    } while (playerOption != 6);

                }
                if (user.login(userName, password) == 2) {
                    System.out.println("Welcome Back Playground Owner..");
                    do {
                        int x = 0;
                        for (int i = 0; i < owner.size(); i++) {
                            if (userName.equals(owner.get(i).getUsername())) {
                                x = i;
                                break;
                            }
                        }
                        System.out.println("1-Add new playground");
                        System.out.println("2-View Your Playgrounds");
                        System.out.println("3-Logout ");
                        choice = input.nextInt();
                        if (choice == 1) {
                            owner.get(x).add_playground(admin, owner.get(x).register_Playground());
                        } else if (choice == 2) {
                            for (int i = 0; i < owner.get(x).ownPlay.size(); i++) {
                                System.out.println((i + 1) + "- " + owner.get(x).ownPlay.get(i) + "\n");
                            }

                        } else if (choice != 3) {
                            System.out.println("Invalid Input");
                        }
                    } while (choice != 3);
                } else if ((!userName.equals("admin")) && (user.login(userName, password) == 0)) {
                    System.out.println("invalid information\n");
                }
            }

            System.out.println("-------Choose Number------- \nDo you want to continue:" + '\n' + " 1-Yes 2-No");
            option = input.nextInt();
        } while (option == 1);
    }

    public static void playerMenu() {
        System.out.println("1-Booking a playground");
        System.out.println("2-Creating Team");
        System.out.println("3-Edit Team");
        System.out.println("4-Send Invitations to the Team");
        System.out.println("5-Check Messages");
        System.out.println("6-Logout");
        Scanner ans = new Scanner(System.in);
    }

}

