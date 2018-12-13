package worldofzuul.combat;

import java.util.Random;
import worldofzuul.Encounter;
import worldofzuul.Player;

public class EncounterAttacks {

    Random rand = new Random();
    Encounter encounter = new Encounter();
    Player player = new Player();
    Battlesystem battle = new Battlesystem();

    private int Encounter_health = encounter.getEncounter_health();
    private int Player_health = player.getHealth();

    private int Encounter_experience = encounter.getEncounter_experience();
    private int Player_experience = player.getExperience();

    private int Damagegiven;

    public EncounterAttacks() {

    }

    public String Encounterattack() {
        String s = "";
        Damagegiven = (rand.nextInt(20)) + 1;

        Player_health -= Damagegiven;

        s = "Your opponent attack resulted in a damage of " + Damagegiven + " points\n"
        + "Your health has decreased down to " + Player_health + " HP.";

        if (Player_health <= 0 && Encounter_health > 0) {

            s += "You have lost.\n";

        } else if (Player_health > 0 && Encounter_health <= 0) {

            s += "You have won.\n";


            Player_experience += Encounter_experience;

            s += "Your experience is now " + Player_experience+"\n";
            
            player.setExperience(Player_experience);

        } else if (Player_health <= 0 && Encounter_health <= 0) {

            s += "It's a tie.\n";

        }
        return s;
    }

    public String Encounterdodge() {
        String s = "";
        int possibility = (rand.nextInt(100)) + 1;

        if (possibility >= 50) {

            s = "Your opponent has dodged the attack.\n"
                    + "His/Her health is still " + Encounter_health;
            EncounterTurn();

        } else if (possibility < 50) {

            Encounter_health -= 11;

            s = "Your opponent weren't fast enough to dogde to the attack.\n"
                    + "His/Her health is now " + Encounter_health;
            battle.Combatoptions();

        }
        return s;
    }

    public String EncounterTurn() {
        String s = "";
        int choice = (rand.nextInt(90)) + 1;

        if (choice <= 40) {

            s = Encounterattack();

        } else if (choice > 40 && choice <= 80) {

            s = Encounterdodge();

        } else if (choice >= 90 && choice <= 100) {
            //specialability
        }
        return s;
    }
}
