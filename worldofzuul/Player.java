package worldofzuul;

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Entity {

    public ArrayList<Item> inventory = new ArrayList<>();

    private String playerName;
    private int currentHealth = 100;
    private int maxHealth = 100;
    private int level = 1;
    private int experience;
    private String age;
    private String gender;
    private Scanner input;
    private int progress = 0;
    private int indexOfLastAdded = 0;
    private String journal;
    private int heals = 1;
    private int maxHeals = 1;
    
    public boolean hasHeals() {
        boolean flag;
        if (this.heals > 0) {
           flag =  true;
        } else {
            flag = false;
        }
        return flag;
    }
    
    public void decrementHeal() {
        this.heals--;
        if (this.heals < 0) {
           this.heals = 0; 
        }
    }
    
    public void replenishHeal(int amount) {
        this.heals += amount;
        if (this.heals > this.maxHeals) {
            this.heals = this.maxHeals;
        }
    }
    
    public int getHeals() {
        return this.heals;
    }

    public void setGender(String gender) {

        this.gender = gender;

    }

    public String getGender() {

        return this.gender;

    }

    public void setAge(String age) {

        this.age = age;

    }

    public String getAge() {

        return this.age;

    }

    public void setPlayerName(String playerName) {

        this.playerName = playerName;

    }

    public String getPlayerName() {

        return this.playerName;

    }

    public void setLevel(int level) {

        this.level = level;

    }

    public int getLevel() {

        return level;

    }

    public void setHealth(int currentHealth) {

        this.currentHealth = currentHealth;

    }

    public int getHealth() {

        return currentHealth;

    }

    public String getStringHealth() {
        return "" + currentHealth;
    }

    public void setMaxHealth(int maxHealth) {

        this.maxHealth = maxHealth;

    }

    public int getMaxHealth() {

        return maxHealth;

    }

    public void setExperience(int experience) {

        this.experience = experience;

    }

    public int getExperience() {

        return experience;

    }

    public void addItem(Item item) {

        inventory.add(item);

        this.indexOfLastAdded++;

    }

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

    /*

    // Player age conversation

    public int ConversationAge(String question) {

        input = new Scanner(System.in);

        System.out.println(question);

        System.out.print("> ");

        int answer = input.nextInt();

        

        return answer;

    }

     */
    public void gainExperience(int amount) {

        getExperience();

        int currentExperience;

        currentExperience = experience + amount;

        double levelSystem = 0.04 * Math.sqrt(currentExperience);

        if ((int) levelSystem == 0) {

            setLevel(1);

            levelUp();

        } else if ((int) levelSystem == 1) {

            setLevel(2);

            levelUp();

        } else if ((int) levelSystem == 2) {

            setLevel(3);

            levelUp();

        } else if ((int) levelSystem == 3) {

            setLevel(4);

            levelUp();

        } else if ((int) levelSystem == 4) {

            setLevel(5);

            levelUp();

        } else if ((int) levelSystem == 5) {

            setLevel(6);

            levelUp();

        } else if ((int) levelSystem == 6) {

            setLevel(7);

            levelUp();

        } else if ((int) levelSystem == 7) {

            setLevel(8);

            levelUp();

        } else if ((int) levelSystem == 8) {

            setLevel(9);

            levelUp();

        } else if ((int) levelSystem >= 9) {

            setLevel(10);

            levelUp();

        } else {

            System.out.println("Something not good is happening.");

        }

        setExperience(currentExperience);

    }

    public void levelUp() {

        getMaxHealth();

        getHealth();

        int healthLevel = maxHealth + 10;

        setMaxHealth(healthLevel);

        setHealth(healthLevel);
        
        this.maxHeals++;

    }

}
