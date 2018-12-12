package worldofzuul.combat;

public class Heal {
    
    private int healAmount;

    public int getHealAmount() {
        return healAmount;
    }

    public void setHealAmount(int healAmount) {
        this.healAmount = healAmount;
    }

    public void heal(int currenthealth, int maxhealth, int newhealth){
        
    healAmount = 10;
    
    newhealth = healAmount + currenthealth;
    
    }
    
    
}
