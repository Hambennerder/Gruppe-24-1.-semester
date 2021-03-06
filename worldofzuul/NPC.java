package worldofzuul;

import java.util.ArrayList;
import java.util.Random;

public class NPC extends Entity {

    private ArrayList<Item> inventory = new ArrayList<>();
    private ArrayList<String> npcStrings = new ArrayList<>();
    private int level;
    private int experience;
    private int health;
    private int questCount;
    private int stringCount = 0;
    private int enemyBaseAttackDamage;
    private String welcome;
    private String goodbye;
    private String acceptString;
    private String declineString;
    private String onQuestString;
    private String dialogOptions;
    private String questCompletedString;
    private Boolean friendly;
    private String completeQuestString;
    private String questString;
    private String attackString;

    public NPC() {
        this.level = 1;
        this.experience = 1;
        this.health = 100;
        this.questCount = 0;
        this.welcome = "Hello student!";
        this.goodbye = "Farewell student!";
        this.friendly = true;
        this.enemyBaseAttackDamage = 2;
        this.attackString = "The enemy attacked you!";
    }

    public NPC(int level, int experience, int health, Boolean friendly) {
        this.level = level;
        this.experience = experience;
        this.health = health;
        this.friendly = friendly;
    }
    
    public void setAttackString(String input) {
        this.attackString = input;
    }
    
    public String getAttackString() {
        return this.attackString;
    }

    public void setQuestString(String input) {
        this.questString = input;
    }

    public String getQuestString() {
        return this.questString;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getExperience() {
        return this.experience;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }
    
    public String getStringHealth(){
        return ""+health;
    }

    public void addToInventory(Item item) {
        inventory.add(item);
    }

    public void removeFromInventory(int ID) {
        for (Item item : inventory) {
            if (ID == item.getEntityID()) {
                inventory.remove(item);
            }
        }
    }

    public void setWelcome(String welcome) {
        this.welcome = welcome;
    }

    public String getWelcome() {
        return welcome;
    }

    public void setGoodbye(String goodbye) {
        this.goodbye = goodbye;
    }

    public String getGoodbye() {
        return this.goodbye;
    }

    public void setFriendly(boolean friendly) {
        this.friendly = friendly;
    }

    public boolean getFriendly() {
        return this.friendly;
    }

    public void setDialogOptions(String string) {
        this.dialogOptions = string;
    }

    public String getDialogOptions() {
        return this.dialogOptions;
    }

    public void setDeclineString(String string) {
        this.declineString = string;
    }

    public String getDeclineString() {
        return this.declineString;
    }

    public void setAcceptString(String string) {
        this.acceptString = string;
    }

    public String getAcceptString() {
        return this.acceptString;
    }

    public void setOnQuestString(String string) {
        this.onQuestString = string;
    }

    public String getOnQuestString() {
        return this.onQuestString;
    }

    public void setQuestCompletedString(String string) {
        this.questCompletedString = string;
    }

    public String getQuestCompletedString() {
        return this.questCompletedString;
    }

    public void setCompleteQuestString(String string) {
        this.completeQuestString = string;
    }

    public String getCompleteQuestString() {
        return this.completeQuestString;
    }
    
    public int enemyAttack() {
        Random rand = new Random();
        int r = rand.nextInt(10) + 1;
        return this.enemyBaseAttackDamage + r;
    }
    
    public void setEnemyBaseAttackDamage(int input) {
        this.enemyBaseAttackDamage = input;
    }

    @Override
    public String toString() {
        return " " + this.getName();
    }

    // Abilities to be implemented soon
}
