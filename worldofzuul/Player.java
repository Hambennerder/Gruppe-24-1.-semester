
package worldofzuul;

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Entity {
    
    // The arraylist inventory stores the items that the player picks up.
    private ArrayList<Item> inventory = new ArrayList<>();
    
    // The arraylist journal stores the quests that the player accepts.
    private ArrayList<Quest> journal = new ArrayList<>();
    
    // Attributes
    private String playerName;
    private int health;
    private int level;
    private int experience;
    private int age;
    private String gender;
    
    private Scanner input;
    
    
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getGender() {
        return gender;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public int getAge() {
        return age;
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
    public int getExperience() {
        return experience;
    }
    
    // Adds an item to the inventory
    public void addItem(Item item) {
        inventory.add(item);
    }
    
    // Returns the full inventory list
    public ArrayList getInventory() {
        return inventory;
    }
    
    // Adds a quest to the journal
    public void addQuest(Quest quest) {
        journal.add(quest);
    }
    
    // Removes a quest from the journal
    public void removeQuest(Quest quest) {
        journal.remove(quest);
    }
    
    // Returns the full journal list
    public ArrayList getJournal() {
        return journal;
    }
    
    // Player name conversation
    public String ConversationWord(String question) {
        input = new Scanner(System.in);
        
        System.out.println(question);
        System.out.print("> ");
        String answer = input.nextLine();
        return answer;
}
    
    // Player age conversation
    public int ConversationAge(String question) {
        input = new Scanner(System.in);
        System.out.println(question);
        System.out.print("> ");
        int answer = input.nextInt();
        
        return answer;
    }
    
}
    


        
