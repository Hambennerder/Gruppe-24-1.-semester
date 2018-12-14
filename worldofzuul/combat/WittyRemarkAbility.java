package worldofzuul.combat;

import java.util.Random;

public class WittyRemarkAbility extends Battlesystem {

    private Random rand = new Random();
    private int baseDamage = 5;
    private String attackSuccessString;

    public WittyRemarkAbility(int playerLevel) {
        this.baseDamage += playerLevel;
    }

    public int getBaseDamage() {
        return this.baseDamage;
    }
    
    public void setBaseDamage(int damageAmount) {
        this.baseDamage = damageAmount;
    }
    
    public String getAttackSuccessString() {
        return " ";
    }
    
    public int remarkAttack() { 
        rand = new Random();
        int r = rand.nextInt(5) + 1;
        return this.baseDamage + r;
    }
}

