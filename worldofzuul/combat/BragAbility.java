package worldofzuul.combat;

import java.util.Random;
import worldofzuul.Encounter;
import worldofzuul.Player;

public class BragAbility extends Battlesystem{
    
    Random rand = new Random();
    Encounter encounter = new Encounter();
    Player player = new Player();
    
    private int Encounter_health = encounter.getEncounter_health();
    private int Player_health = player.getHealth();
    
    private int Encounter_experience = encounter.getEncounter_experience();
    private int Player_experience = player.getExperience();
        
    private int Damagegiven;
    private int result;
    
    public BragAbility(){
        
    }

    public int getDamagegiven() {
        return Damagegiven;
    }

    public void setDamagegiven(int Damagegiven) {
        this.Damagegiven = Damagegiven;
    }
    
    public String Dropkick_attack(){
    String s = "";
    Damagegiven = 20;
    
    result = (rand.nextInt(100)) + 1;
    
    if(result >= 50){
        
        //Success attack
        s = "Your dropkick has resulted in " + Damagegiven + " points of damage.\n";
        
        Encounter_health -= Damagegiven;
        
        s+="Your opponents has " + Encounter_health + " left in health.\n";
    
    }else if(result < 50){
        
        //fail attack
        s = "Your opponent was able to dogde your dropkick.\n"
                + "His/Her health reminds " + Encounter_health+"\n";
        
    }
    
    if (Player_health <= 0 && Encounter_health > 0 ){
	
        s += "You have lost.\n";
        
    }else if(Player_health > 0 && Encounter_health <= 0){
        
        s += "You have won.\n";
        
        Player_experience += Encounter_experience;
        
        s += "Your experience is now " + Player_experience+"\n";
        
    }else if(Player_health <= 0 && Encounter_health <= 0){
        
        s += "It's a tie.\n";
        
    }
    return s;
}
}
