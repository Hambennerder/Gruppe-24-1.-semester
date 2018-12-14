package worldofzuul.combat;

import java.util.Random;

public class BragAbility extends Battlesystem{

    private Random rand = new Random();
    private int baseDamage = 10;
    private String attackSuccessString;
    
   
    public BragAbility(int playerLevel) {
        this.baseDamage += playerLevel;
    }

    public void setBaseDamage(int damageAmount) {
        this.baseDamage = damageAmount;
    }

    public String getAttackSuccessString() {
        return "";
    }
    
    public int bragAttack() {
        rand = new Random();
        int r = rand.nextInt(10) + 1;
        return this.baseDamage + r;
    }
   

}

