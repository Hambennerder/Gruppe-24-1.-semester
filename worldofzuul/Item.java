package worldofzuul;

    public class Item extends Entity{
        
        private int value;
        private int weight;
        private String information;
        
    public Item(int value, int weight, String information){
        this.value = value;
        this.weight = weight;
        this.information = information;

    }
        
    public String getInformation(){      
        return information; 
    }
    
    public int getValue(){   
        return value;
    }
    
    public int getWeight(){ 
        return weight;
    }
        
        // Consumable:
    public static boolean isConsumable(int playerLevel, int itemLevel){
        if(playerLevel >= itemLevel){
            return true;
      }else{
            return false;
        }
    }
    
        //Equipable
    public static boolean isEquipable(int playerLevel, int itemLevel){
        if(playerLevel >= itemLevel){
            return true;
       }else{
            return true;
        }
    }
        
       //Storable
    public boolean isStorable(int itemweight, int maxweight){
        if(itemweight < maxweight){ 
            return true;
      }else{
            return false;
       }
   }
       // Still not yet finished with the if statements for isTakeable, isDropable and isInspectable.
      // We need to decide the conditions.
     //Takeable
    public static boolean isTakeable(){
        if(){
            return true;
        }
    }

    //Dropable
    public static boolean isDropable(){
        if(){
             return true;
        } 
   }

    //Inspectable
    public static boolean isInspectable(){
        if(){
            return true;
        }
    }

}


