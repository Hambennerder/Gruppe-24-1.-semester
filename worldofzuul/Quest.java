
package worldofzuul;
import java.util.ArrayList;

//Tanker angående klassen og dens sammenhæng:

// 1: Skal questen have en ArrayList til at gemme objekter som er rewards?
// 2: Skal NPC'en som udbyder questen, give dig et item ud fra en boolean
// 2.a som er defineret som en attribut i quest-klassen?
// 3: Angående player klasse, skal player klassen have følgende ArrayLister?:
// 3.a: En liste over completed quests
// 3.b: En liste over aktuelle quests, som player har accepteret. 

//This class defines a quest, the Quest-class inherits from the entity class.
//After a quest has been completed, you must se the attribute isCompleted equal to true.

public class Quest extends Entity {
    
    private String objective;
    private ArrayList<String> questStrings;
    private boolean isCompleted = false;
    
    public Quest() {
       questStrings =  new ArrayList<>();
    }
    
    public void setObjective(String objective) {
        this.objective = objective;
    }
    
    public String getObjective() {
        return objective;
    }
    
    public void addQuestString(String input) {
        if (input != null && questStrings != null){
            questStrings.add(input);
        }
    }
    
    public void printQuestString(int n) {
        if (n >= 0 && questStrings.get(n) != null) {  
            System.out.println(questStrings.get(n));
        }
    }
    
    public void completeQuest() {
        this.isCompleted = true;
    }
    
}
