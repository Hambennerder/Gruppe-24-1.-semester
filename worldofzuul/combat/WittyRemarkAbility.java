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
        
        
        
        
        

        
        
        /*Damagegiven = 17;

        result = (rand.nextInt(100)) + 1;

        if (result >= 50) {

            //Success attack
            s = "Your punch has resulted in " + Damagegiven + " points of damage.\n";

            Encounter_health -= Damagegiven;

            s += "Your opponents has " + Encounter_health + " left in health.\n";

        } else if (result < 50) {

            //fail attack
            s = "Your opponent was able to dogde your punch\n."
                    + "His/Her health reminds " + Encounter_health;

        }
        
        if (Player_health <= 0 && Encounter_health > 0) {

            s = "You have lost.\n";

        } else if (Player_health > 0 && Encounter_health <= 0) {

            s = "You have won.\n";

            Player_experience += Encounter_experience;

            s += "Your experience is now " + Player_experience+"\n";

        } else if (Player_health <= 0 && Encounter_health <= 0) {

            s = "It's a tie.\n";
        }
        return s; */
    }
}
