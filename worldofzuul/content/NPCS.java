
package worldofzuul.content;

import java.util.ArrayList;
import java.util.List;
import worldofzuul.NPC;

public class NPCS extends NPC {

private List<NPC> npcs;    
    public NPCS() {
        npcs = new ArrayList<>();
    }
    
    public void createNPCS() {
        
        // Start of the first mentor NPC INDEX: 0--------------------
        NPC mentor = new NPC();
        mentor.setDescription("Short and build student, wearing a hoodie and a pair of glasses, short clean cut redheaded");
        mentor.setName("mentor");
        mentor.setWelcome("You must be a new student, welcome! \n"
                + "\nAs you can see below, you have two options, type \"choose 1\" to choose the first, and I'll let you figure out the rest.\n");
        mentor.setDialogOptions("< 1: talk"
                                + "\n< 2: leave");
        mentor.setAcceptString("Good luck student! \n"
                             + "\nUvuvwevwevwe: Now that you accepted a quest, you can type journal, and the quest's name \n"
                             + "and a short description will pop up. Complete this quest to advance.");
        mentor.setDeclineString("Ow, well you won't be able to study properly then.. a shame");
        mentor.setQuestString("< Hello there!"
                + "\n< Welcome to SDU. My name is Morten. I'll be your mentor for today."
                + "\n< Before you can enter the entrance of the SDU building, you have "
                + "\n< to find your ID-card. To do that you have to"
                + "\n< inspect rooms u1-u3. These rooms are outside the SDU building."
                + "\n< To find the first room you have to head north. Are you ready for this? (now choose whether or not you accept this mission by typing yes/no)");
        mentor.setOnQuestString("Have you found your ID-card? It should be around here somewhere.");
        mentor.setQuestCompletedString("I'm sorry, I'm busy. Go find Andars.");
        mentor.setCompleteQuestString("Yes! you found the ID-card, now you can finally access this god awful place.\n"
                + "now you must go find Andars, I've heard that he's in u180. Good luck! \n"
                + "Uvuvwevwevwe: Congratulations! You finished your very first quest. Sadly, you're on your own now. Bye.");
        
        npcs.add(mentor);
        // End of the first mentor NPC--------------------
        
        // Start of the NPC Andars INDEX: 1--------------------
        NPC andars = new NPC();    
        andars.setDescription("*Tall slim man, wearing a snapback cap, rocking wild fuzzy beard. He appears proffessionel."
                + "His face expression seems serious.*");
        andars.setName("Andars");
        andars.setDescription("Tall slim man, wearing a snapback cap, rocking wild fuzzy beard. He appears proffessionel."
                + "His face expression seems serious.");
        andars.setDialogOptions(
                  "< 1: talk"
                + "\n< 2: trade"
                + "\n< 3: leave");
        
        andars.setQuestString("< Welcome to SDU. I am Andars. a very skilled programmer, and I am going to teach you how to program"
                + "\n< You know, a thing between you and me. The book, called Best Java Book for learning Java EVER!. It is the best book to prepare you"
                + "\n< I used this book back in my ole' days. It saved me tons of trouble! Find it at the bookstore."
                + "\n< I want you to solve these assignments, solve these with the book and you will be prepared"
                + "\n< Are you ready to face this challenge? (yes/no)");
        
        andars.setAcceptString("Very well student! Return to me when you're done.");
        andars.setDeclineString("I'm sorry to hear that, return when you're ready.");
        andars.setOnQuestString("Finding the book can't be harder than solving e-tiviteter... just find it already..");
        andars.setCompleteQuestString("Good job on finding the book!");
        andars.setQuestCompletedString("You already handed in the assignments, bugger off");
        
        npcs.add(andars);
        // End of the NPC Andars--------------------
        
        // Start of the NPC at the student bookstore INDEX: 2--------------------
        NPC bookstoreLady = new NPC();
        bookstoreLady.setName("lady");
        bookstoreLady.setWelcome("What can I do you for?");
        bookstoreLady.setDescription("Just a description");
        bookstoreLady.setDialogOptions("< 1: Talk"
                                       + "\n< 2: Trade"
                                       + "\n< 3: Leave");
        bookstoreLady.setQuestString("Hello, find me coffee and I give u book");
        bookstoreLady.setAcceptString("I'm so glad to hear that! I'll hurry if you hurry.");
        bookstoreLady.setDeclineString("Well, you can have the book when I get my coffee then.");
        npcs.add(bookstoreLady);
        // End of the NPC at the student bookstore--------------------
        
        // Start of NPC at the canteen INDEX: 3-------------------
       /* 
        NPC canteenLady = new NPC();
        canteenLady.setName("lunch-lady");
        canteenLady.setWelcome("Hello there handsome!");
        canteenLady.setDescription("She is quite hot!");
        canteenLady.setDialogOptions("< 1: Talk"
                                      +"\n< 2: Trade"
                                      + "\n< 3: Leave");
       
        canteenLady.setQuestString("I could really use a hand with a food trolley in the hallway. \n"
               + "I'm way too busy here, and my colleagues are all sick \n"
               + "Will you help me (yes/no)");
       
        canteenLady.setAcceptString("That's great, come back when you got it");
        canteenLady.setDeclineString("Then you can't have the coffee");
        canteenLady.setOnQuestString("Can you help me... please");
        canteenLady.setCompleteQuestString("Thank you so much on returning the trolley");
        canteenLady.setQuestCompletedString("You did a good job, I'll owe you");
      */ 
      
               
        
       
        
    }
    
    public NPC getNPC(int index) {
        return npcs.get(index);
    }
    
}
