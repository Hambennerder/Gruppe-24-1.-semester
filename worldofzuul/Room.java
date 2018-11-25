package worldofzuul;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;



public class Room extends Entity
{
    private String description;
    private String roomIntro;
    private HashMap<String, Room> exits;
    private ArrayList<NPC> npcs;
    private ArrayList<Item> items;
    private ArrayList<Encounter> encounters;
    private int requiredProgress;
    private boolean hasQuest;
    private boolean hasOngoingQuest = false;
    private boolean hasFinishedQuest = false;
    private boolean hasEncounter = false;
    private String questItemName;
    private int nextQuestProgress = 0;
    private String journalString;
    
    public Room() {
    
    }
    
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
        npcs = new ArrayList<>();
        items = new ArrayList<>();
        encounters = new ArrayList<>();
        this.requiredProgress = 0;
        this.roomIntro = "A room description";
    }
    
    public void setJournalString(String input) {
        this.journalString = input;
    }
    
    public String getJournalString() {
        return this.journalString;
    }
    
    public void setRoomIntro(String input) {
        this.roomIntro = input;
    }
    
    public String getRoomIntro() {
        return this.roomIntro;
    }
    
    public void setNextQuestProgress(int input) {
        this.nextQuestProgress = input;
    }
    
    public int getNextQuestProgress() {
    
        return nextQuestProgress;
    }
    
    public void setQuestItemName(String input) {
        this.questItemName = input;
    }
    
    public String getQuestItemName() {
        return this.questItemName;
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
    
    public NPC getNPC(int index) {
        return npcs.get(index);
    }
    
    public void addItem(Item item) {
        items.add(item);
    }
    
    public Item getItem(int n) {
        return items.get(n);
    }
    
    public int getRequiredProgress() {
        return this.requiredProgress;
    }
    
    public void setRequiredProgress(int input) {
        this.requiredProgress = input;
    }
    
    public void setHasQuest(boolean input) {
        this.hasQuest = input;
    }
    
    public boolean getHasQuest() {
        return this.hasQuest;
    }
    
    public void setHasOngoingQuest(boolean input) {
        this.hasOngoingQuest = input;
    }
    
    public boolean getHasOngoingQuest() {
        return this.hasOngoingQuest;
    }
    public void setHasFinishedQuest(boolean input) {
        this.hasFinishedQuest = input;
    }
    
    public boolean getHasFinishedQuest() {
        return this.hasFinishedQuest;
    }
    
    public void removeItem(int index) {
        items.remove(index);
    }
    
    public void addEncounter(Encounter encounter) {
        this.encounters.add(encounter);
    }
    
    public Encounter getEncounter() {
        return this.encounters.get(0);
    }
    
    public boolean hasEncounter() {
        return this.hasEncounter;
    }
    
    public void setHasEncounter(boolean input) {
        this.hasEncounter = input;
    }
   
    
    
   
}

