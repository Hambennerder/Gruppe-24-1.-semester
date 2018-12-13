package worldofzuul;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Encounter extends Entity {

    private List<NPC> encountedNPC;
    private String encounterMessage;
    private int encounterPossibility;
    private Boolean isFleeable;
    private int fleePossibility;
    private int encounter_health;
    private int encounter_experience;

    public Encounter() {
        this.encountedNPC = new ArrayList<>();
        this.encounterPossibility = 25;
        this.fleePossibility = 50;
        this.isFleeable = true;
    }

    public void addEncounterNPC(NPC npc) {
        this.encountedNPC.add(npc);
    }

    public NPC getEncounterNPC() {
        return encountedNPC.get(0);
    }

    public void setEncounterMessage(String input) {
        this.encounterMessage = input;
    }

    public String getEncounterMessage() {
        return this.encounterMessage;
    }

    public void setEncounterPossibility(int input) {
        this.encounterPossibility = input;
    }

    public double getEncounterPossibility() {
        return this.encounterPossibility;
    }

    public int getEncounter_health() {
        return encounter_health;
    }
    
    public String getStringEncounter_health(){
        return ""+encounter_health;
    }

    public void setEncounter_health(int encounter_health) {
        this.encounter_health = encounter_health;
    }

    public int getEncounter_experience() {
        return encounter_experience;
    }

    public void setEncounter_experience(int encounter_experience) {
        this.encounter_experience = encounter_experience;
    }

    
    public boolean encounterMet() {
        Random rand = new Random();
        boolean flag;
        int value = (rand.nextInt(100)) + 1;

        if (value > this.encounterPossibility) {
            flag = false;
        } else {
            flag = true;
        }
        return flag;
    }

    public boolean tryFlee() {
        Random rand = new Random();
        boolean flag;
        int value = (rand.nextInt(100)) + 1;

        if (value > this.fleePossibility) {
            flag = false;
        } else {
            flag = true;
        }
        return flag;
    }

    @Override
    public String toString() {
        return "" + this.getName();
    }

}
