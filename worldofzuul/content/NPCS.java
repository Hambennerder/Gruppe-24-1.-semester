
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
                + "\nUvuvwevwevwe: As you can see below, you have two options, type \"choose 1\" to choose the first, and I'll let you figure out the rest.\n");
        mentor.setDialogOptions("< 1: talk"
                                + "\n< 2: leave");
        mentor.setAcceptString("Good luck student! \n"
                             + "\nUvuvwevwevwe: Now that you accepted a quest, you can type journal, and the quest's name \n"
                             + "and a short description will pop up. Complete this quest to advance. To go to a room, you must \n "
                             + "type \'go\' and then the direction you want to go, there are four directions:\n"
                             + "\'north\', \'south\', \'west\' and \'east\'. Type \'go north\'");
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
        
        andars.setDialogOptions(
                  "< 1: talk"
                + "\n< 2: leave");
        
        andars.setQuestString("< Welcome to SDU. I am Andars. a very skilled programmer, and I rock a mean cap"
                + "\n< You know, a thing between you and me. The book, called Best Java Book for learning Java EVER!. It is the best book to prepare you"
                + "\n< I used this book back in my ole' days. It saved me tons of trouble! Find it at the bookstore."
                + "\n< I want you to solve these assignments, solve these with the book and you will be prepared"
                + "\n< Sound like a pretty good plan, right? (yes/no)");
        
        andars.setAcceptString("Nice!... by the way watch out for the lady in the bookstore, she is pretty flirtatious.");
        andars.setDeclineString("You gonna faiiil! Come back if you want the slightest chance of doing the assignments.");
        andars.setOnQuestString("Finding the book can't be harder than solving e-tiviteter... just find it already..");
        andars.setCompleteQuestString("Damn dude, what took you so long?!");
        andars.setQuestCompletedString("You finally found the book and handed in the assignments, bugger off");
        
        npcs.add(andars);
        // End of the NPC Andars--------------------
        
        // Start of the NPC at the student bookstore INDEX: 2--------------------
        NPC bookstoreLady = new NPC();
        bookstoreLady.setName("lady");
        bookstoreLady.setWelcome("Hello there handsome thing, What can I do you for?");
        bookstoreLady.setDescription("Probably the ugliest and oldest person you've ever seen in a bookstore");
        bookstoreLady.setDialogOptions("< 1: Talk"
                                       + "\n< 2: Trade"
                                       + "\n< 3: Leave");
        bookstoreLady.setQuestString("I would love to help you finding the book darling, but if I have to help you I have to get something in return.\n"
                + "I would love to get a cup of coffee with you, can you go get it from the canteen, sweetheart? (yes/no)");
        bookstoreLady.setAcceptString("I knew a strong man like you, wouldn't be afraid of a grown woman like myself.");
        bookstoreLady.setDeclineString("Well, you can have the book when I get my coffee then.");
        bookstoreLady.setOnQuestString("The coffee should be found in the canteen, good looking");
        bookstoreLady.setQuestCompletedString("It was a pleasure getting to know you honey");
        bookstoreLady.setCompleteQuestString("Thx for the coffee. The book is back in the storage room, you can go get it.");
        
        npcs.add(bookstoreLady);
        
        // lawStudent at index 3
        NPC lawStudent = new NPC();
        lawStudent.setFriendly(false);
        lawStudent.setName("Wild law student");
        lawStudent.setDialogOptions("<1: Fight\n"
                                  + "<2: Flee");
        npcs.add(lawStudent);
        
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
      
       // adding zzz NPC for quick fix INDEX: 3-----------------------
       NPC zzz = new NPC();
       zzz.setName("dude");
       npcs.add(zzz);
       
       
       
       
                
        
       
        
    }
    
    public NPC getNPC(int index) {
        return npcs.get(index);
    }
    
}
