package worldofzuul.combat;

import java.util.Random;
import worldofzuul.Encounter;
import worldofzuul.Player;

public class Battlesystem {

    Random rand = new Random();
    Encounter encounter = new Encounter();
    Player player = new Player();

    private int Encounter_health = encounter.getEncounter_health();
    private int Player_health = player.getHealth();
    private int PlayerMax_health = player.getMaxHealth();

    private int Encounter_experience = encounter.getEncounter_experience();
    private int Player_experience = player.getExperience();

    private int Damagegiven;
    private int Damagetaken;

    private int Energydrink = 11;

    public String Contact() {
        return "In the outskirts of the universitety building something emerges from the shadow."
                + "\n a tall figur covered in darkness.";
    }

    public String Decision() {
        return "Make a descision: \n"
                + " a) Fight \n"
                + " b) Flee \n";
    }

    public String Combatoptions() {
        return "Combatoptions: \n"
                + "a) Attack \n"
                + "b) Heal \n"
                + "c) Dogde \n";
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

    public String heal() {
        String s = "";
        Player_health += 11;

        s = "Your health is now " + Player_health;

        if (Player_health == PlayerMax_health) {

            s += "You health is already full";

        } else if (Player_health > PlayerMax_health) {

            Player_health = PlayerMax_health;

            s += "" + Player_health;
        }
        return s;
    }

    public String dodge() {
        String s = "";
        int possibility = (rand.nextInt(100)) + 1;

        if (possibility >= 50) {

            s = "You have dodge the attack. Your health is still " + Player_health;

        } else if (possibility < 50) {

            Player_health -= 11;

            s = "You weren't fast enough to dogde to the attack. You health is now " + Player_health;

        }
        return s;
    }
}
