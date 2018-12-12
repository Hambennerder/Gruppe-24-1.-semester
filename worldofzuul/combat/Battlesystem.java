package worldofzuul.combat;

import java.util.Random;
import worldofzuul.Encounter;
import worldofzuul.Player;
import worldofzuul.gamefunctionality.Game;

public class Battlesystem extends Game {

    private Random rand = new Random();
    private int Damagegiven;
    private int Damagetaken;
    private int Energydrink = 11;
    private int currentHealth = player.getHealth();


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
        return "Options in attack: \n"
                + "a) Dropkick \n"
                + "b) Punch \n"
                + "c) Bodyslam \n"
                + "d) Back \n";
    }
    /*
     public void attack() {
        
     Damagetaken = (rand.nextInt(25)) + 1;
     Damagegiven = (rand.nextInt(25)) + 1;
        
     Encounter_health -= Damagegiven;
     Player_health -= Damagetaken;
        
     System.out.println("You're attack resulted in " + Damagegiven + " point damage");
     System.out.println("Your opponent have been hit with a damage of " + Damagegiven + " points");
     System.out.println("Your health has decreased down to " + Player_health + " HP."
     + "\n And your opponent has " + Encounter_health + " HP left.");
        
     if (Player_health <= 0 && Encounter_health > 0 ){
     System.out.println("You have loss.");
        
     }else if(Player_health > 0 && Encounter_health <= 0){
     System.out.println("You have won.");
     Player_experience += Encounter_experience;
     System.out.println("Your experience is now " + Player_experience);
     }else if(Player_health <= 0 && Encounter_health <= 0){
     System.out.println("It's a tie.");
           
     }
        
     }
    
     */

    public String heal(int health) {
        int maximumHealth;
        int healAmount = 10;
        int currentHealth = health;
        int newHealth = currentHealth + healAmount;
        
        return "You healed for" + healAmount + " Your current health is: " + newHealth;
    }   
}
