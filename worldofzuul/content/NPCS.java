
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
        andars.setCompleteQuestString("Damn dude, what took you so long?! \n"
                + "You should probably go study some more in the studyhall.");
        andars.setQuestCompletedString("You finally found the book and handed in the assignments. \n"
                + "You should go study to the study hall.");
        
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
        // End of the NPC at the student bookstore--------------------
        

        // Start of NPC for study hall + library quest INDEX: 3--------------
        NPC student = new NPC();
        student.setName("student");
        student.setWelcome("Hey! Please I need your help!");
        student.setDescription("A student in distress");
        student.setDialogOptions("< 1: Talk"
                                      +"\n< 2: Trade"
                                      + "\n< 3: Leave");
       
        student.setQuestString("I really need you help. I should be studying in the study hall \n"
               + "But there are way to many medicin students in the study hall \n"
               + "and I can't get the book from the library because of the law students in there"
               + "Will you please help me? (yes/no)");
       
        student.setAcceptString("I'm so glad to hear that, I really need to be studying for an exam");
        student.setDeclineString("Please help. Shouldn't you be studying as well?");
        student.setOnQuestString("We have to make room for us to study in the study hall");
        student.setCompleteQuestString("Thank you so much, now there is a slight chance I'll pass the exam.");
        student.setQuestCompletedString("You did a good job, I'll owe you");
        
        npcs.add(student);
        
        // End of student -------------------------------------------------------
        
        // Start of NPC Lune at u55 INDEX: 4------------------------------------
        NPC lune = new NPC();
        lune.setName("Lune");
        lune.setWelcome("Hey there student.");
        lune.setDescription("Your teacher in introduction to Software Engineering");
        lune.setDialogOptions("< 1: Talk"
                                      +"\n< 2: Trade"
                                      + "\n< 3: Leave");
        lune.setQuestString("I can't your my e-moderator. He could be in the T8. \n"
                + "The room can be quite hard to find, but I'm sure you can find it. \n"
                + "Will you go find him? (yes/no)");
        lune.setAcceptString("That´s great. Remember, he could be in room T8");
        lune.setDeclineString("You can't do your journal-writing wihtout the E-moderator");
        lune.setOnQuestString("Go find the e-moderator");
        lune.setCompleteQuestString("Great job finding the e-moderator \n"
                + "It must have been quite difficult \n"
                + "Now get going, I've heard Eryk needs some help in u45... oh and Remember your e-tivities");
        lune.setQuestCompletedString("You should really get going now");
        
        npcs.add(lune);
        
        // End of NPC Lune ----------------------------------------------------
        
        // Start of NPC Eryk at u45 INDEX: 5------------------------------------
        NPC eryk = new NPC();
        eryk.setName("Eryk");
        eryk.setWelcome("Hello I'm your teacher in COS");
        eryk.setDescription("Great man with great jokes");
        eryk.setDialogOptions("< 1: Talk"
                                      +"\n< 2: Trade"
                                      + "\n< 3: Leave");
        eryk.setQuestString("The damn light won't work and I can't get the projector to work \n"
                + "Will try and get the technology working in here? (yes/no)");
        eryk.setAcceptString("Thank you very much. \n "
                + "There might be a cable or something missing");
        eryk.setDeclineString("I can't teach you if we don't get the technology fixed");
        eryk.setOnQuestString("Please fix the power");
        eryk.setCompleteQuestString("Great job on getting the screen working, now we can get on with the teaching");
        eryk.setQuestCompletedString("You should try helping the other students.");
        
        npcs.add(eryk);
        
        
        // End of Eryk -------------------------------------------------------------------
        
        // Start of e-moderator in T8 index 6 ----------------------------------------------------
        NPC moderator = new NPC();
        moderator.setName("Malta");
        moderator.setWelcome("Thanks for helping me escape from the janitors");
        moderator.setDescription("Your e-moderator for journal-writing");
        moderator.setDialogOptions("< 1: Talk"
                                      +"\n< 2: Trade"
                                      + "\n< 3: Leave");
        moderator.setQuestString("I'm pretty sure I dropped my bag when I was running from the janitors \n"
                + "will you help me get it back? (yes/no)");
        moderator.setAcceptString("Thank you so much I really need it for administring the journals");
        moderator.setDeclineString("You won't be able to do your journals if I don't get my computer");
        moderator.setOnQuestString("Please find my bag");
        moderator.setCompleteQuestString("Great job finding my bag. Get back to Lune");
        moderator.setQuestCompletedString("Get back to Lune");
        
        npcs.add(moderator);
        
        
        // End of moderator --------------------------------------------------------------
        
        
    
      
       
       
       
                
        
       
        
    }
    
    public NPC getNPC(int index) {
        return npcs.get(index);
    }
    
}
