
package worldofzuul;

import java.util.ArrayList;
import java.util.List;


public class Quests extends Quest {
    private List<Quest> quests;
    
    public Quests() { 
        quests = new ArrayList<>();   
    }
    
    public void createQuests() {
        
        Item bestJavaBook = new Item();
        bestJavaBook.setName("Best Book for Learning Java, EVER");
        bestJavaBook.setDescription("An ole' book, seems extremely worn and some pages are even missing");
        
        Item firstAssignments = new Item();
        firstAssignments.setName("Inheritence and polymorphism");
        firstAssignments.setDescription("A set of assignments regarding inheritence and polymorphism");
        
        Item id_card = new Item();
        id_card.setName("SDU id-card");
        id_card.setDescription("The id-card allows you as a student to enter the entrance of the SDU building.");
        
        Quest tutorial = new Quest();
        tutorial.setName("Enter SDU");
        tutorial.setDescription("Find your " +id_card.getName()+ " in u1-u3");
        tutorial.setObjective("Find mentor");
        tutorial.addQuestString("< Hello there!"
                + "\n< Welcome to SDU. My name is Morten. I'll be your mentor for today."
                + "\n< Before you can enter the entrance of the SDU building, you have "
                + "\n< to find your " + id_card.getName() + ". To do that you have to"
                + "\n< inspect room u1-u3. These rooms are outside the SDU building."
                + "\n< To find the first room you have to head north. Are you ready for this? (yes/no)");
        
        quests.add(tutorial);
        
        Quest firstQuest = new Quest();
        firstQuest.setName("git gud at java");
        firstQuest.setDescription("Find the book at the bookstore, and use it to solve the assignments");
        firstQuest.setObjective("Find Andars");
        firstQuest.addQuestString("< Hello student!"
            + "\n< Welcome to SDU. I am Andars, a very skilled programmer and I am going to teach you how to program."
            + "\n< You know, a thing between you and me. The book \"" + bestJavaBook.getName() + "\" is the best book to prepare you"
            + "\n< I used this book back in my ole' days. It saved me tons of trouble! Find it at the bookstore."
            + "\n< I want you to solve these assignments \"" + firstAssignments.getName() + "\", solve these with the book and you will be prepared "
            + "\n< Are you ready to face this challenge? (yes/no) ");
        
        //The quest string from the NPC at the bookstore
        firstQuest.addQuestString("So you're looking for " + bestJavaBook.getName() + ", hmm?"
                                  + "\n We might have one left out in the back.. but first..."
                                  + "\n can you get me some coffee from the canteen? (yes/no)");
        
        
        firstQuest.addQuestString("< WHAT CAN I GET YOU.");
        firstQuest.addQuestString("< THAT WILL BE 8 DANISH CROWNS.");
        firstQuest.addQuestString("< Well, that is something YOU SHOULD HAVE THOUGHT ABOUT BEFORE, GET OUT! ");
        firstQuest.addQuestString("< HERE YOU GO");
        firstQuest.addQuestString("< Ah I see you got the coffee, thank you very much. Here's your book!");
        firstQuest.addQuestString("< Ah \" John Doe \", you're back. And you haven't completed the assignments? Shameful.. ");
        firstQuest.addQuestString("< You're back! And you completed the assignments? How very nice, I am proud of you. "
        + "Here, take this \" INSERT REWARD \" " );
        quests.add(firstQuest);
        
    }
    
    public Quest getQuest(int index) {
        
        return quests.get(index);
        
    }
}
    
    
    
