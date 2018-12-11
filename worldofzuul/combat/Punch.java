package worldofzuul.combat;

import java.util.Random;
import worldofzuul.Encounter;
import worldofzuul.Player;

public class Punch extends Battlesystem{
    
    Random rand = new Random();
    Encounter encounter = new Encounter();
    Player player = new Player();
    
    private int Encounter_health = encounter.getEncounter_health();
    private int Player_health = player.getHealth();
    
    private int Encounter_experience = encounter.getEncounter_experience();
    private int Player_experience = player.getExperience();
     
    private int Damagegiven;
    private int result;
    
    public Punch(){
        
    }

    public int getDamagegiven() {
        return Damagegiven;
    }

    public void setDamagegiven(int Damagegiven) {
        this.Damagegiven = Damagegiven;
    }
    
    public void Punch_attack(){
    
    Damagegiven = 17;
    
    result = (rand.nextInt(100)) + 1;
    
    if(result >= 50){
        
        //Success attack
        System.out.println("Your punch has resulted in " + Damagegiven + " points of damage.");
        
        Encounter_health -= Damagegiven;
        
        System.out.println("Your opponents has " + Encounter_health + " left in health.");
    
    }else if(result < 50){
        
        //fail attack
        System.out.println("Your opponent was able to dogde your punch. His/Her health reminds " + Encounter_health);
        
    }
    
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
}
