package ADVANCED.EXAMS.EXAM_22_Feb_2020.guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getRoster() {
        return roster.size();
    }

    public void addPlayer(Player player) {
        if (capacity > getRoster()) {
            roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        Player playerToRemove = null;
        for (Player p : roster) {
            if (p.getName().equals(name)) {
                playerToRemove = p;
            }
        }
        if (playerToRemove == null) {
            return false;
        } else {
            roster.remove(playerToRemove);
            return true;
        }
    }

    //!
    public void promotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                player.setRank("Member");
                break;
            }
        }
    }

    //!
    public void demotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                player.setRank("Trial");
                break;
            }
        }
    }

    //!!!
    public Player[] kickPlayersByClass(String clazz){
        List<Player> toRemove = new ArrayList<>();
        for (Player player : roster) {
            if (player.getClazz().equals(clazz)){
                toRemove.add(player);
            }
        }
        roster.removeIf(player -> player.getClazz().equals(clazz));
        Player[] p = new Player[toRemove.size()];
        return toRemove.toArray(p);
    }

    public int count() {
        return roster.size();
    }

    public String report(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Players in the guild: %s:\n",this.name));
        for (Player player : roster) {
            builder.append(player.toString()).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }

}
