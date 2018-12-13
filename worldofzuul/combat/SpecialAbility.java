package worldofzuul.combat;

import java.util.Random;

public class SpecialAbility extends Battlesystem{
 
    private Random rand = new Random();
    private int baseDamage = 20;
    private String attackSuccessString;
    
    
    public SpecialAbility(int playerLevel) {

        this.baseDamage += playerLevel;

    }
    public void setBaseDamage(int damageAmount) {
        this.baseDamage = damageAmount;
    }

    public int specialAttack() {
        rand = new Random();
        int r = rand.nextInt(10) + 1;
        return this.baseDamage + r;
    }

    public String getAttackSuccessString() {
        return attackSuccessString;
    }
      
}