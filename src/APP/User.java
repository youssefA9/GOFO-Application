package APP;

import java.util.ArrayList;

public class User {
    protected String name;
    protected String password;
    protected String Email;
    protected int phone;
    protected String location;
    protected String Username;
    protected double eWallet;
    private ArrayList<Player> player = new ArrayList<Player>();
    private ArrayList<playground_owner> owner = new ArrayList<playground_owner>();

    public User() {
    }

    public User(String name, String Username, String password, String Email, int phone, String location, double eWallet) {
        this.name = name;
        this.Username = Username;
        this.password = password;
        this.Email = Email;
        this.phone = phone;
        this.location = location;
        this.eWallet = eWallet;
    }

    public double geteWallet() {
        return eWallet;
    }

    public void seteWallet(double eWallet) {
        this.eWallet = eWallet;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    /*
    public  void Edit_info(){}
      public  void Sign_up(){}*/
    public int login(String userName, String password) {
        for (int i = 0; i < player.size(); i++) {
            if (userName.equals(player.get(i).getUsername()) && password.equals(player.get(i).getPassword())) {
                return 1;

            }

        }
        for (int i = 0; i < owner.size(); i++) {
            if (userName.equals(owner.get(i).getUsername()) && password.equals(owner.get(i).getPassword())) {
                return 2;

            }

        }
        return 0;
    }

    public int check_username(String userName) {
        for (int i = 0; i < player.size(); i++) {
            if (userName.equals(player.get(i).getUsername())) {
                return 1;
            }
        }
        for (int i = 0; i < owner.size(); i++) {
            if (userName.equals(owner.get(i).getUsername())) {
                return 1;
            }
        }
        return 0;
    }

    public void setPlayer(Player player1) {
        player.add(player1);
    }


    public void setOwner(playground_owner owner1) {
        owner.add(owner1);
    }


}
