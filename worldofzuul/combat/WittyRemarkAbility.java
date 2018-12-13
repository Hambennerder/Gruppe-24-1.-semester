package worldofzuul.combat;

import java.util.Random;
import worldofzuul.Encounter;
import worldofzuul.Player;

public class WittyRemarkAbility extends Battlesystem {

    private Random rand = new Random();
    private int damageAmount;
    private String attackSuccessString;

    public WittyRemarkAbility(int playerLevel) {

        rand = new Random();
        int r = rand.nextInt(3) + 1;
        damageAmount = (playerLevel * 2) * r + 5;

    }

    public int getDamageAmount() {
        return this.damageAmount;
    }
    
    public void setDamageAmount(int damageAmount) {
        this.damageAmount = damageAmount;
    }
    
    public String getAttackSuccessString() {
        return " ";
    }
    
    public String punchAttack() { 
        
        String s = null;
        int damageAmount = 15;
        
        return "M";

    }
}

