package APP;

import java.util.Vector;

public class Team {
    protected
    String name;
    Vector<Player> Players = new Vector<Player>(1);
    int size = 0;

    public Team() {
    }

    Team(String x) {
        name = x;
    }

    String getName() {
        return name;
    }

    void setName(String x) {
        name = x;
    }

    void Add_Player(Player x, String username) {
        Players.add(x);
        size++;
        Players.get(size - 1).messages.add(username + ": Added you to his Favourite Team");
    }

    void Remove_Player(Player x) {
        Players.remove(x);
        size--;
    }

    void Replace_Player(Player x, Player y) {
        for (int i = 0; i < Players.size(); i++) {
            if (Players.get(i) == x) {
                Players.set(i, y);
            }
        }
    }
    void Display() {
        System.out.println("Team: " + getName());
        for (int i = 0; i < Players.size(); i++) {
            System.out.println((i + 1) + "- " + Players.get(i).name);
        }
    }
    int getSize() {
        return size;
    }
}
