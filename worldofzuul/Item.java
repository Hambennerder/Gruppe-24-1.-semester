package worldofzuul;

    public class Item extends Entity{
         
        private String itemInfo;
        private int value;
        private int weight;
        
    public Item(){

    }    
         
    public Item(String itemInfo, int value){     
        this.itemInfo = itemInfo;
        this.value = value;        
    }
   
    public String getInfo(){      
        return itemInfo; 
    }
    
    public int getValue(){   
        return value;
    }
    
    public int getWeight(){ 
        return weight;
    }
   
    
  }


