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

        mentor.setDescription("*Short and build student, wearing a hoodie \n"
                + " and a pair of glasses,short clean cut redheaded*");
        mentor.setName("mentor");
        mentor.setWelcome(">You must be a new student, welcome! \n"
                + "\n"
                + "> Uvuvwevwevwe: As you can see below, you have two options,\n"
                + "> type \"choose 1\" to choose the first, and I'll let you figure out the rest.\n");
        mentor.setDialogOptions("> 1: talk"
                + "\n> 2: leave");
        mentor.setQuestString("You have to find your student ID card it should be around here.\n"
                + "Are you ready to face this task?\n"
                + "Type yes or no (yes/no) to accept or decline the quest.");
        mentor.setAcceptString(">Good luck student! \n"
                + "\nUvuvwevwevwe: \n"
                + "> Now that you accepted a quest, you can type journal, and the quest's name \n"
                + "> and a short description will pop up. Complete this quest to advance. To go \n"
                + "> to a room, you must type \'go\' and then the direction you want to go, there \n"
                + "> are four directions: \'north\', \'south\', \'west\' and \'east\'.\n"
                + "> Type \'go north\' to get started in your adventure!");
        mentor.setDeclineString(">Ow, well you won't be able to study properly then.. a shame");

        mentor.setOnQuestString(">Have you found your ID-card? It should be around here somewhere.");
        mentor.setQuestCompletedString(">I'm sorry, I'm busy. Go find Andars.");
        mentor.setCompleteQuestString(">Yes! you found the ID-card, \n"
                + ">now you can finally access this god awful place.\n"
                + ">Go find Andars, I've heard that he's in u180. Good luck! \n"
                + "\n"
                + ">Uvuvwevwevwe: Congratulations! You finished your very first quest.\n"
                + ">Sadly, you're on your own now. But before you go I have to warn you. \n"
                + ">As you continue your journey you'll face some powerful opponents \n"
                + ">whom you have to battle, through the means of wittyness, and brag etc. \n"
                + ">You also have the ability to heal yourself when your health happens to \n"
                + ">be low. But there are limitations. You have to inspect rooms and collect more \n"
                + ">healz when you run out.");
        npcs.add(mentor);
        // End of the first mentor NPC--------------------

        // Start of the NPC Andars INDEX: 1-------------------------------------
        NPC andars = new NPC();

        andars.setDescription("*Tall slim man, wearing a snapback cap, rocking wild fuzzy beard."
                + "\n He appears professional. His face expression seems serious.*");
        andars.setName("Andars");
        andars.setWelcome("What do you want, you peasant?!");
        andars.setGoodbye("Yes, please do leave me alone");

        andars.setDialogOptions(
                "\n < 1: talk "
              + "\n < 2: leave ");
        andars.setQuestString(">Welcome to SDU. I am Andars. I'll be teaching you, and I rock a mean cap."
                + "\n>You know, a thing between you and me.\n"
                + ">There is a book in the bookstore.\n"
                + ">It is the best book to prepare you."
                + "\n>I used this book back in my old days.\n"
                + ">It saved me tons of trouble! Find it at the bookstore."
                + "\n>I want you to complete these assignments,\n"
                + ">solve them with the book and you will be prepared"
                + "\n>Sound like a pretty good plan, right? (yes/no)");

        andars.setAcceptString(">Nice!...\n"
                + ">by the way watch out for the lady in the bookstore, she is pretty flirtatious.");
        andars.setDeclineString(">You gonna faiiil!\n"
                + ">Come back if you want the slightest chance of doing the assignments.");
        andars.setOnQuestString(">Finding the book can't be harder than solving e-tiviteter...\n"
                + ">just find it already.");

        andars.setCompleteQuestString(">Damn dude, what took you so long?! \n"
                + ">You should probably go study some more in the studyhall.");

        andars.setQuestCompletedString("> You finally found the book and handed in the assignments. \n"
                                     + "> You should go study to the study hall.");
        andars.setHealth(1000);
        andars.setEnemyBaseAttackDamage(10);
        npcs.add(andars);
        // End of the NPC Andars------------------------------------------------

        // Start of the NPC at the student bookstore INDEX: 2-------------------
        NPC bookstoreLady = new NPC();
        bookstoreLady.setName("lady");
        bookstoreLady.setWelcome(">Hello there handsome thing, What can I do you for? \n");
        bookstoreLady.setDescription("*Probably the ugliest and oldest person you've ever seen in a bookstore*");
        bookstoreLady.setDialogOptions("> 1: Talk \n"
                                     + "> 2: Leave \n");
        bookstoreLady.setQuestString(">I would love to help you find the book darling,\n"
                                   + ">but if I have to help you I have to get something in return.\n"
                                   + ">I would love to get a cup of coffee with you.\n"
                                   + ">Can you go get it from the canteen, sweetheart? (yes/no)");
        bookstoreLady.setAcceptString(">I knew a strong man like you wouldn't be afraid of a grown woman like myself.");
        bookstoreLady.setDeclineString(">Well, you can't have the book then. Return when you want to help");
        bookstoreLady.setOnQuestString(">The coffee can be found in the canteen, good looking");
        bookstoreLady.setQuestCompletedString(">It was a pleasure getting to know you honey");
        bookstoreLady.setCompleteQuestString(">Great, you found my coffee!\n"
                + "The book is back in the storage room, you can go get it.");
        npcs.add(bookstoreLady);

        // lawStudent at index 3
        NPC lawStudent = new NPC();
        lawStudent.setFriendly(false);
        lawStudent.setName("Wild law student");
        lawStudent.setDialogOptions("<1: Fight \n"
                                  + "<2: Flee \n");
        lawStudent.setHealth(30);
        lawStudent.setExperience(1000);
        lawStudent.setEnemyBaseAttackDamage(5);
        npcs.add(lawStudent);
        // End of the NPC at the student bookstore------------------------------

        // Start of NPC for study hall + library quest INDEX: 4-----------------
        NPC student = new NPC();
        student.setName("student");
        student.setWelcome(">Hey bruh! \n");
        student.setDescription("*A student in distress*");
        student.setGoodbye("You bouncin\' already? see you around.");
        student.setDialogOptions("> 1: Talk \n"
                               + "> 2: Leave \n");
        student.setQuestString(">I really need your help. I should be studying in the study hall \n"
                             + ">But there are way too many medicine students in the study hall \n"
                             + ">and I can't get the book from the library because of the law students there\n"
                             + ">Will you please help me? (yes/no)");
        student.setAcceptString(">I'm so glad to hear that, I really need to be studying for an exam");
        student.setDeclineString(">Please help. Shouldn't you be studying as well?");
        student.setOnQuestString(">You have to make room for us to study in the study hall");
        student.setCompleteQuestString(">Thanks buddy, I heard you cleard out the study hall and library\n"
                + ">we should get a beer at Nedenunder later\n"
                + ">If you're looking for something to do I've heard that Lune needs help");
        student.setQuestCompletedString(">Let me know if you wanna grab that beer");
        npcs.add(student);
        // End of student ------------------------------------------------------

        // Start of NPC Lune at u55 INDEX: 5------------------------------------
        NPC lune = new NPC();
        lune.setName("Lune");
        lune.setWelcome(">Hey there student. \n");
        lune.setDescription(">*Your teacher in introduction to Software Engineering*");
        lune.setDialogOptions("> 1: Talk \n"
                            + "> 2: Leave \n");
        lune.setQuestString(">I can't our e-moderator. He could be in T8. \n"
                          + ">The room can be quite hard to find, but I'm sure you can find it. \n"
                          + ">Oh yeah, please don't get lost down there \n"
                          + ">we have had enough rescue mission already"
                          + ">Will you go find him? (yes/no)");
        lune.setAcceptString(">That's great. Remember, he could be in T8");
        lune.setDeclineString(">You can't do your journal writing without the e-moderator");
        lune.setOnQuestString(">Go find the e-moderator");
        lune.setCompleteQuestString(">Great job finding the e-moderator \n"
                                  + ">it must have been quite difficult. \n"
                                  + ">Now get going, I've heard Eryk needs some help in u45...");
        lune.setQuestCompletedString(">You should really get going now");
        npcs.add(lune);
        // End of NPC Lune -----------------------------------------------------

        // Start of NPC Eryk at u45 INDEX: 6------------------------------------
        NPC eryk = new NPC();
        eryk.setName("Eryk");
        eryk.setWelcome(">Hello I'm your teacher in COS \n");
        eryk.setDescription("*Great man with great jokes* \n");
        eryk.setDialogOptions("> 1: Talk \n"
                            + "> 2: Leave \n");
        eryk.setQuestString(">The damn light won't work and I can't get the projector to work. \n"
                + ">It was so much easier back in the old days, when we only used blackboards \n."
                + ">Will you try and get the technology working in here? (yes/no) \n");
        eryk.setAcceptString(">Thank you very much. \n"
                           + ">There might be a cable or something missing");
        eryk.setDeclineString(">I can't teach you if we don't get the technology fixed");
        eryk.setOnQuestString(">Please fix the power");
        eryk.setCompleteQuestString(">Great job on getting the screen working,\n"
                                  + "> now we can get on with the teaching");
        eryk.setQuestCompletedString(">Remember your exam today. Head to Andars.");
        npcs.add(eryk);
        // End of Eryk ---------------------------------------------------------

        // Start of e-moderator in T8 index 7 ----------------------------------
        NPC moderator = new NPC();
        moderator.setName("Malta");
        moderator.setWelcome(">Thanks for helping me escape from the janitors \n");
        moderator.setDescription(">*Your e-moderator for journal-writing*");
        moderator.setDialogOptions("> 1: Talk \n"
                                 + "> 2: Leave \n");
        moderator.setQuestString(">I'm pretty sure I dropped my bag when I was running from the janitors \n"
                               + ">will you help me get it back? (yes/no)");
        moderator.setAcceptString(">Thank you so much I really need it for administring the journals");
        moderator.setDeclineString(">You won't be able to do your journals if I don't get my computer");
        moderator.setOnQuestString(">Please find my bag");
        moderator.setCompleteQuestString(">Great job finding my bag. Get back to Lune");
        moderator.setQuestCompletedString(">Get back to Lune");
        npcs.add(moderator);
        // End of moderator ----------------------------------------------------

        // start of janitor in room g22 janitor index at 8
        NPC janitor = new NPC();
        janitor.setName("Wild Janitor \n");
        janitor.setLevel(3);
        janitor.setHealth(10);
        janitor.setFriendly(false);
        janitor.setDialogOptions("<1: Fight \n"
                               + "<2: Flee \n");
        janitor.setExperience(6000);
        npcs.add(janitor);
        // End of janitor ------------------------------------------------------

        // start of medicine student in room g22, this student is at index 9
        NPC medicineStudent = new NPC();
        medicineStudent.setName("Arrogant \'sTuDeNt Of MeDiCiNe\' \n");
        medicineStudent.setLevel(2);
        medicineStudent.setHealth(50);
        medicineStudent.setFriendly(false);
        medicineStudent.setDialogOptions("<1: Fight \n"
                                        + "<2: Flee \n");
        medicineStudent.setExperience(2000);
        npcs.add(medicineStudent);
        // End of medicine student ------------------------------------------------------

    }

    public NPC getNPC(int index) {
        return npcs.get(index);
    }

}
