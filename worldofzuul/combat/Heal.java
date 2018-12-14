package worldofzuul.combat;

import java.util.Random;

public class Heal {
    
    private int currentHealth;
    private int maxHealth;
    private int healAmount;
    
    private Random rand;

    public Heal(int currentHealth, int maxHealth, int playerLevel) {
        this.healAmount = 25     + (playerLevel * 2);
    }

    public int heal(){
        rand = new Random();
        int r = rand.nextInt(10) + 1;
        return this.healAmount + r;
    }
    
    
}
