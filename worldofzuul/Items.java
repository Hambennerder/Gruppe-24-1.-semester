package worldofzuul;

    public class Items{
         
        private String name;
        private String info;
        private int value;
        private int weight;
         
    public Items(String name, String info, int value){
         
        this.name = name;
        this.info = info;
        this.value = value;
         
    }
    public String getName(){
         
        return name;
         
    }
    public String getInfo(){
         
        return info;
     
    }
    public int getValue(){
         
        return value;
     
    }
    public int getWeight(){
        
        return weight;
    }
  }


