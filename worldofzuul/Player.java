
package worldofzuul;

import java.util.ArrayList;


    public class Player extends Entity {
    
    // The arraylist inventory stores the items that the player picks up.
    private ArrayList<Item> inventory = new ArrayList<>();
    
    // The arraylist journal stores the quests that the player accepts.
    private ArrayList<Quest> journal = new ArrayList<>();
    
    // Players attributes
    private String playerName;
    private int health;
    private int level;
    private int experience;
    private int progress = 0;
    private int indexOfLastAdded = 0;
    
    public Player() {
        this.level = 1;
        this.health = 100;
        this.experience = 0;
    }
    
    // Player constructor
    public Player(int health,int level,int experience,String playerName) {
        this.health = health;
        this.level = level;
        this.experience = experience;
        this.playerName = playerName;       
      
    }

    // Set player name
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    
    // Return player name
    public String getPlayerName() {
        return playerName;
    }
    
    // Set the players level
    public void setLevel(int level) {
        this.level = level;
    }
    
    // Return players level
    public int getLevel() {
        return level;
    }
    
    // Set the players health
    public void setHealth(int health) {
        this.health = health;
    }
    
    // Return players health
    public int getHealth() {
        return health;
    }
    
    // Set players experience points
    public void setExperience(int experience) {
        this.experience = experience;
    }
    
    // Return players experience points
    public int getExperience(int experience) {
        return experience;
    }
    
    // Adds an item to the inventory
    public void addItem(Item item) {
        inventory.add(item);
        this.indexOfLastAdded++;
    }
    
    // Returns the full inventory list
    public void getInventory() {
        System.out.println("Inventory:");
        for (Item item : inventory) {
            System.out.println("-" + item.getName());
        }
    }
    
    // Adds a quest to the journal
    public void addQuest(Quest quest) {
        if (journal.contains(quest)) {
            System.out.println("You already have that quest!");
        } else {
            journal.add(quest);
        }
    }
    
    // Removes a quest from the journal
    public void removeQuest(Quest quest) {
        journal.remove(quest);
    }
    
    // Returns the full inventory list
    public void getJournal() {
        int counter = 1;
        for (Quest quest : this.journal) {     
            if (quest != null) {
            System.out.println(counter + ": " + quest.getName() + ": " + quest.getDescription());
            counter++;
            }
        }
    }
    
    public void setProgress(int input) {
        this.progress = input;
    }
    
    public int getProgress() {
        return this.progress;
    }
    
    public void incrementProgress() {
        this.progress++;
    }
}
