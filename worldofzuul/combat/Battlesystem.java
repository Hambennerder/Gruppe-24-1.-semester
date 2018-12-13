package worldofzuul.combat;

import java.util.Random;
import worldofzuul.Encounter;
import worldofzuul.Player;
import worldofzuul.gamefunctionality.Game;

public class Battlesystem {
    
    private Random rand = new Random();
    private int Damagegiven;
    private int Damagetaken;
    private int Energydrink = 11;


    public String Decision() {
        return "Make a descision: \n"
                + " a) Fight \n"
                + " b) Flee \n";
    }

    public String Combatoptions() {
        return "Combatoptions: \n"
                + "a) Attack \n"
                + "b) Heal \n"
                + "c) Dodge \n";
    }

    public String attackoptions() {
        return "Attack options: \n"
                + "a) 'Witty' remark \n"
                + "b) 'Brag' about being an engineer \n"
                + "c) 'Optional' \n"
                + "d) 'Back' \n";
    }

    public String heal(int health) {
        int maximumHealth;
        int healAmount = 10;
        int currentHealth = health;
        int newHealth = currentHealth + healAmount;
        
        return "You healed for" + healAmount + " Your current health is: " + newHealth;
    }   
}
