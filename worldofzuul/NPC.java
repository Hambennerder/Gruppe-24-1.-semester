
package worldofzuul;

//This class creates the NPCs

import java.util.ArrayList;

public class NPC extends Entity {
    // Entity which is the type that inventory stores, is to be changed to item
    // Shortly after the item class has been introduced
    private ArrayList<Entity> inventory = new ArrayList<>();
    private int level;
    private int experience;
    private int health;
    private String welcome;
    private String goodbye;
    private Boolean friendly;
    private String quest;
    
    public NPC() {
        this.level = 1;
        this.experience = 1;
        this.health = 100;
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
    
    public void addToInventory(Entity entity) {
        inventory.add(entity);
    }
    
    public void removeFromInventory(int ID) {
        for (Entity entity : inventory) {
            if (ID == entity.getEntityID()) {
                inventory.remove(entity);
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
    
    
    
}
