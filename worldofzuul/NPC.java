
package worldofzuul;

import java.util.ArrayList;

public class NPC extends Entity {
    
    private ArrayList<Item> inventory = new ArrayList<>();
    private ArrayList<Quest> quests = new ArrayList<>();
    private ArrayList<String> npcStrings = new ArrayList<>();
    private int level;
    private int experience;
    private int health;
    private int questCount;
    private int stringCount = 0;
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
    
    public NPC() {
        this.level = 1;
        this.experience = 1;
        this.health = 100;
        this.questCount = 0;
        this.welcome = "Hello traveler!";
        this.goodbye = "Farewell traveler!";
        this.friendly = true;
    }
    
    public NPC(int level,int experience,int health,Boolean friendly) {
        this.level = level;
        this.experience = experience;
        this.health = health;
        this.friendly = friendly;
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
    
    public void addQuest(Quest q) {
        if (q != null) {
            quests.add(q);
        }
    }
    
    public Quest getQuest(int n) {
        return quests.get(n);
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
    
    
    
    // Abilities to be implemented soon
    
}
