
package worldofzuul;

public class NPCS extends NPC {
    
    public NPCS() {
              
    }
    
    public void createNPCS() {
     
        NPC andars = new NPC(20,2000,100,true);
        andars.setName("Andars");
        // Abilities and items in inventory to be implemented
        
        NPC lune = new NPC(10,1000,100,true);
        lune.setName("Lune");
        // Abilities and items in inventory to be implemented
        
        NPC eryk = new NPC(15,1500,100,true);
        eryk.setName("Lune");
        // Abilities and items in inventory to be implemented
        
        NPC malta = new NPC(5,200,100,true);
        malta.setName("Malta");
        // Abilities and items in inventory to be implemented
        
        // Enemies and other NPCS to be implemented in the future
        
        
    }
    
}
