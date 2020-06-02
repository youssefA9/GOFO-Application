package APP;

import java.util.Vector;

/**
 * This class describes the team and it's functionality
 */
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

    /**
     * This method is used to add a new player to team
     *
     * @param x        The player who wanted to be added to the team
     * @param username The username team leader
     */
    void Add_Player(Player x, String username) {
        Players.add(x);
        size++;
        Players.get(size - 1).messages.add(username + ": Added you to his Favourite Team");
    }

    /**
     * This method is used to remove an existing player from the team
     *
     * @param x The player who wanted to be removed to the team
     */
    void Remove_Player(Player x) {
        Players.remove(x);
        size--;
    }

    /**
     * This method is used to Replace and old member in the team with a new one
     *
     * @param x The player who wanted to be removed to the team
     * @param y The player who wanted to be added to the team
     */
    void Replace_Player(Player x, Player y) {
        for (int i = 0; i < Players.size(); i++) {
            if (Players.get(i) == x) {
                Players.set(i, y);
            }
        }
    }

    /**
     * This method is used to display the team name as while as it's members
     */
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
