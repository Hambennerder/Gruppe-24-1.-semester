package worldofzuul.combat;

import java.util.Random;
import worldofzuul.Encounter;
import worldofzuul.Player;

public class OptionalAbility extends Battlesystem{
 
    private Random rand = new Random();
    private int damageAmount;
    private String attackSuccessString;
    
    
    public OptionalAbility(int playerLevel) {
        damageAmount = (playerLevel * 2) + 10;
    }
    public int getDamageAmount() {
        return damageAmount;
    }

    public void setDamageAmount(int damageAmount) {
        this.damageAmount = damageAmount;
    }

    public String getAttackSuccessString() {
        return attackSuccessString;
    }
      
}