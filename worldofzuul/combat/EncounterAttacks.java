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
    
    public EncounterAttacks(){
        
    }


    public void Encounterattack() {
        
        Damagegiven = (rand.nextInt(20)) + 1;
 
        Player_health -= Damagegiven;
        
        System.out.println("Your opponent attack resulted in a damage of " + Damagegiven + " points");
        System.out.println("Your health has decreased down to " + Player_health + " HP.");
        
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
    
    public void Encounterdodge(){
        
        int possibility = (rand.nextInt(100)) + 1;
        
        if(possibility >= 50){
            
            System.out.println("Your opponent have dodge the attack. He/She health is still " + Encounter_health);
            System.out.println();
            System.out.println("");
            EncounterTurn();
            
        } else if(possibility < 50){
            
            Encounter_health -= 11;
            
            System.out.println("Your opponent weren't fast enough to dogde to the attack. His/Her health is now " + Encounter_health);
            System.out.println();
            System.out.println();
            battle.Combatoptions();
            
        }
        
    }
    
 
    public void EncounterTurn(){
        
    int choice = (rand.nextInt(90)) + 1;
    
    if(choice <= 40){
        
        Encounterattack();
            
    }else if(choice > 40 && choice <= 80){
        
        Encounterdodge();
        
    }else if(choice >= 90 && choice <= 100){
        //specialability
    }
    }
}
