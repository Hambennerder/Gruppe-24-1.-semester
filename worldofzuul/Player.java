
package worldofzuul;

import java.util.ArrayList;
import java.util.Scanner;


    public class Player extends Entity {
    
    // The arraylist inventory stores the items that the player picks up.
    private ArrayList<Item> inventory = new ArrayList<>();
    
    
    // Players attributes
    private String playerName;
    private int health;
    private int level;
    private int experience;
    private int age;
    private String gender;    
    private Scanner input;
    private int progress = 0;
    private int indexOfLastAdded = 0;
    private String journal;
    

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
        this.indexOfLastAdded++;
    }
    
    // Returns the full inventory list
    public void getInventory() {
        System.out.println("Inventory:");
        for (Item item : inventory) {
            System.out.println("*" + item.getName());
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
    
    public String getJournal() {
        return this.journal;
    }
    
    public void setJournal(String input) {
        this.journal = input;
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
