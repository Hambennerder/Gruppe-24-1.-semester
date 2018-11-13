package worldofzuul;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;



public class Room extends Entity
{
    private String description;
    private HashMap<String, Room> exits;
    private ArrayList<NPC> npcs;
    private ArrayList<Item> items;
    
    
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
        npcs = new ArrayList<>();
        items = new ArrayList<>();
    }

    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    public String getShortDescription()
    {
        return description;
    }

    public String getLongDescription()
    {
        return "Location: " + getName() + ".\n" + getExitString();
    }
    
    public String getSlowDescription()
    {
        return "You are still " + description + ".\n" + getExitString();
    }        

    public String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    public void addNPC(NPC npc) {
        if (npc != null) { 
            npcs.add(npc);
        }
    }
    
    public void printString(int NPCIndex, int questNum, int stringNum) {
        System.out.println(npcs.get(NPCIndex).getQuest(questNum).printQuestString(stringNum));     
    }
    
    public NPC getNPC(int index) {
        return npcs.get(index);
    }
    
    public void addItem(Item item) {
        items.add(item);
    }
   
}

