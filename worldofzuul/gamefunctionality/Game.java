package worldofzuul.gamefunctionality;

import worldofzuul.Consumable;
import worldofzuul.Encounter;
import worldofzuul.Item;
import worldofzuul.Player;
import worldofzuul.Room;
import worldofzuul.content.NPCS;
import worldofzuul.content.Rooms;
import worldofzuul.combat.Battlesystem;
import worldofzuul.combat.SpecialAbility;
import worldofzuul.combat.BragAbility;
import worldofzuul.combat.EncounterAttacks;
import worldofzuul.combat.Heal;
import worldofzuul.combat.WittyRemarkAbility;

public class Game extends Player {

    private String s = "";
    public Parser parser;
    public Room currentRoom;
    public Player player;
    public NPCS npcs;
    Rooms listOfRooms;
    private Battlesystem battle;
    private boolean finished = false;
    private boolean started = false;
    private boolean fight = false;
    private boolean conversation = false;
    private boolean questQuestion = false;
    boolean fleeAttempted = false;

    public Game() {
        parser = new Parser();
        player = new Player();
        battle = new Battlesystem();
        npcs = new NPCS();
        listOfRooms = new Rooms(player.getPlayerName());
    }

    public void play() {

        listOfRooms.createRooms();
        currentRoom = listOfRooms.getRoom(0);

        npcs.createNPCS();

        Item id_card = new Item();
        id_card.setName("ID-card");
        id_card.setDescription("The id-card allows you as a student to enter the entrance of the SDU building.");

        Item book = new Item();
        book.setName("book");

        // Adding heals to different rooms.
        Consumable healz = new Consumable();
        healz.setName("healz");
        listOfRooms.getRoom(15).addItem(healz);
        listOfRooms.getRoom(21).addItem(healz);
        listOfRooms.getRoom(25).addItem(healz);
        listOfRooms.getRoom(29).addItem(healz);
        listOfRooms.getRoom(37).addItem(healz);
        listOfRooms.getRoom(41).addItem(healz);
        listOfRooms.getRoom(7).addItem(healz);
        listOfRooms.getRoom(44).addItem(healz);
        listOfRooms.getRoom(42).addItem(healz);
        listOfRooms.getRoom(4).addItem(healz);
        

        // Adding mentor NPC to entrance, and adding ID-card to u3.
        listOfRooms.getRoom(0).addNPC(npcs.getNPC(0));
        listOfRooms.getRoom(3).addItem(id_card);

        // Adding Andars NPC to U180
        listOfRooms.getRoom(5).addNPC(npcs.getNPC(1));

        // Adding Bookstore lady to student bookstore, and adding book to student bookstore backroom
        listOfRooms.getRoom(10).addItem(book);
        listOfRooms.getRoom(9).addNPC(npcs.getNPC(2));

        // Adding coffee to the canteen
        Item coffee = new Item();
        coffee.setName("coffee");
        listOfRooms.getRoom(11).addItem(coffee);

        // Adding law student encounter to library
        Encounter lawStudentEncounter = new Encounter();
        lawStudentEncounter.addEncounterNPC(npcs.getNPC(3));
        lawStudentEncounter.setEncounterPossibility(100);
        lawStudentEncounter.setEncounterMessage("> Oh no, you have encountered "+ npcs.getNPC(3).getName()+ "!\n"
                + "");
        listOfRooms.getRoom(16).addEncounter(lawStudentEncounter);

        // Adding student to hallway g3
        listOfRooms.getRoom(12).addNPC(npcs.getNPC(4));

        // Adding Lune to u55
        listOfRooms.getRoom(18).addNPC(npcs.getNPC(5));

        // Adding Eryk and cable to u45
        Item cable = new Item();
        cable.setName("cable");
        listOfRooms.getRoom(19).addItem(cable);
        listOfRooms.getRoom(19).addNPC(npcs.getNPC(6));

        // Adding Malta to T8 and his bag to k7
        Item bag = new Item();
        bag.setName("bag");

        listOfRooms.getRoom(20).addNPC(npcs.getNPC(7));
        listOfRooms.getRoom(43).addItem(bag);

        // Adding the janitor encounter to room g22
        Encounter janitorEncounter = new Encounter();
        listOfRooms.getRoom(34).addEncounter(janitorEncounter);
        janitorEncounter.addEncounterNPC(npcs.getNPC(8));
        janitorEncounter.setEncounterPossibility(100);
        janitorEncounter.setEncounterMessage("> Haha! You filthy students really \n"
                + ">think you're something special, huh? well you are not!");

        // Adding medicine student encounter to study hall
        Encounter medicineEncounter = new Encounter();
        medicineEncounter.addEncounterNPC(npcs.getNPC(9));
        medicineEncounter.setEncounterPossibility(100);
        medicineEncounter.setEncounterMessage("> You think you're smarter than me?\n"
                + ">HA! I'm studying to become a doctor.. my grades are better than yours!");
        listOfRooms.getRoom(17).addEncounter(medicineEncounter);

        Encounter bossFight = new Encounter();
        bossFight.addEncounterNPC(npcs.getNPC(1));
        bossFight.setEncounterPossibility(0);
        bossFight.setEncounterMessage("Exam time!");
        listOfRooms.getRoom(5).addEncounter(bossFight);
    }

    public boolean getFinished() {
        return finished;
    }

    public void setFinished(boolean b) {
        this.finished = b;
    }

    public String processCommand(Command command) throws Exception {
        System.out.println(player.getProgress());
        CommandWord commandWord = command.getCommandWord();
        if (commandWord == CommandWord.UNKNOWN) {
            s = "I don't know what you mean...";
        }
        if (commandWord == CommandWord.HELP) {
            return printHelp();

        } else if (commandWord == CommandWord.BEGIN) {
            return startScreen();

        } else if (commandWord == CommandWord.GO) {
            if (fight) {
                return "You can't go anywhere\n"
                        + "You're still in a fight, perhaps try to flee?\n\n"
                        + battle.Combatoptions();
            } else if (questQuestion) {
                s = "You can't just run away from your problems like this!\n"
                        + "please type 'yes' or 'no' instead.\n\n"
                        + checkQuest();
            } else if (conversation) {
                s = "It's really rude to just walk away, please choose the leave option instead.\n\n";
                try {
                    s += currentRoom.getNPC(0).getWelcome()
                            + "\n" + currentRoom.getNPC(0).getDialogOptions();
                } catch (IndexOutOfBoundsException ex) {

                }
            } else {
                conversation = false;
                questQuestion = false;
                s = goRoom(command);
                if (player.getProgress() == 15 && currentRoom.getName().equals("U180")) {

                    currentRoom.getNPC(0).setFriendly(false);
                    currentRoom.getEncounter().setEncounterPossibility(100);
                    currentRoom.setHasEncounter(true);

                }
                s += "\n" + encounterNPC(command);
            }

        } else if (commandWord == CommandWord.QUIT) {
            setFinished(true);

        } else if (commandWord == CommandWord.INSPECT) {
            if (fight) {
                return "What are you trying to inspect?\n"
                        + "You're still in a fight, perhaps try to flee?\n"
                        + battle.Combatoptions();
            } else {
                s = currentRoom.getDescription();
            }

            try {
                if (currentRoom.getItem(0) instanceof Consumable) {
                    s += "\nConsumeable item: healz\n";
                } else {
                    s += "\nThis room contains: " + currentRoom.getItem(0).getName();
                }
            } catch (IndexOutOfBoundsException ex) {
                s += "\n ***No item to be found***";
            }

        } else if (commandWord == CommandWord.TAKE) {
            if (fight) {
                return "What are you trying to take?\n"
                        + "You're still in a fight, perhaps try to flee?\n\n"
                        + battle.Combatoptions();
            } else {
                try {
                    if (!command.hasSecondWord()) {
                        s = "Take what?";
                    }

                    if (currentRoom.getItem(0) == null) {
                        s = "No item to take" + "\n";

                    } else if (currentRoom.getItem(0).getName().equals(command.getSecondWord())) {
                        if (currentRoom.getItem(0) instanceof Consumable) {
                            if (player.getHeals() == player.getMaxHeals()) {
                                s = "You can't carry anymore heals!";
                            } else {
                                player.replenishHeal(1);
                                currentRoom.removeItem(0);
                                s = "You found a heal! Now you have " + player.getHeals() + " heals.";
                            }
                        } else {

                            player.addItem(currentRoom.getItem(0));
                            s = "You picked up " + currentRoom.getItem(0).getName() + "\n";
                            currentRoom.removeItem(0);
                            player.incrementProgress();
                        }
                    }
                } catch (IndexOutOfBoundsException ex) {

                }
            }

        } else if (commandWord == CommandWord.APPROACH) {
            try {
                if (fight) {
                    return "Are you trying to approach your enemy?\n"
                            + "You're still in a fight, just attack!\n\n"
                            + battle.Combatoptions();
                } else if (questQuestion) {
                    s = "Don't you start approaching anything,\n"
                            + "it's a simple yes/no question, just answer it!\n\n"
                            + checkQuest();
                } else {
                    conversation = true;
                    s = approachNPC(command);
                }
            } catch (IndexOutOfBoundsException ex) {
                s = "There is no NPC to approach.";
            }
        } else if (commandWord == CommandWord.CHOOSE) {
            if (fight) {
                return "Just write the option without 'chose'\n\n"
                        + battle.Combatoptions();
            } else {
                if (conversation) {
                    s = processOption(command);
                } else {
                    s = "Approach a NPC first, to choose dialogue options.\n\n";
                    s += currentRoom.getShortDescription() + "\n";
                }
            }

        } else if (commandWord == CommandWord.JOURNAL) {
            if (fight) {
                return "You can't go anywhere, you're still in a fight, perhaps try to flee?\n\n"
                        + battle.Combatoptions();
            } else if (questQuestion){
               s = "Please accept or decline the quest before checking your journal!\n"
                        + "Please type 'yes' or 'no' to do so.\n\n"
                        + checkQuest();
            } else if (conversation){
                s= "Please finish your conversation before checking your journal.\n";
                try {
                    s += currentRoom.getNPC(0).getWelcome()
                            + "\n" + currentRoom.getNPC(0).getDialogOptions();
                } catch (IndexOutOfBoundsException ex) {

                }  
            }else {
                if (!player.getJournal().equals("")) {
                    s = player.getJournal();
                } else {
                    s = "You have no current quests.\n"
                            + "Explore to find the next quest!";
                }
            }

        } else if (commandWord == CommandWord.YES | commandWord == CommandWord.NO) {
            if (fight) {
                return "What are you even trying to do?\n"
                        + "You're still in a fight, perhaps try to flee?\n\n"
                        + battle.Combatoptions();
            } else if (questQuestion) {
                return processChoice(command);
            } else if (conversation) {
                try {
                    s = "Please pick a dialogue option\n\n";
                    s += currentRoom.getNPC(0).getWelcome();
                } catch (IndexOutOfBoundsException ex) {

                }
            } else {
                s = currentRoom.getShortDescription() + "\n";
            }

        } else if (commandWord == CommandWord.FIGHT
                | commandWord == CommandWord.FIGHT
                | commandWord == CommandWord.FLEE
                | commandWord == CommandWord.ATTACK
                | commandWord == CommandWord.HEAL
                | commandWord == CommandWord.WITTY
                | commandWord == CommandWord.BRAG
                | commandWord == CommandWord.SPECIAL
                | commandWord == CommandWord.BACK) {
            if (fight) {
                return combatOptions(command);
            } else {
                return "You are not battling with anyone, so you can't use combatoptions.";
            }
        }
        return s;
    }

    private String processOption(Command command) {
        // Check 1: checks if there is a second word, aka a choice between 1 or 2
        if (command.hasSecondWord()) {
            // Check 2: checks if a room does not have a quest, so you cant "choose" in that room
            if (!currentRoom.getHasQuest()) {
                return "What?";
            } // Check 3: Checks where you are in a quest by multiple stages (!primitive and basic state machine!)
            // Check 3.1: Checks if room has a quest and that second word is the option talk
            else if (currentRoom.getHasQuest() && command.getSecondWord().equals("1")) {
                // stage 3.2:
                // checks whether or not a room has an ongoing quest, if the room does not have
                // an ongoing quest, then the player will be presented the quest, and have an option
                // between yes and no
                s = checkQuest();
            } else if (currentRoom.getHasQuest() && command.getSecondWord().equals("2")) {
                questQuestion = false;
                conversation = false;
                s = currentRoom.getNPC(0).getGoodbye() + "\n\n";
                s += currentRoom.getShortDescription() + "\n";
            }
        } else {
            return "Choose what?";
        }
        return s;
    }

    private String checkQuest() {
        if (!currentRoom.getHasOngoingQuest()) {
            s = currentRoom.getNPC(0).getQuestString();
            // check 3.5: Checks if the quest has been finished or not. if the quest has not been finished, then
            // the "on a quest string" will be returned, otherwise the next string introducing the player to
            // where he should go next is returned
            questQuestion = true;
        } else if (currentRoom.getHasOngoingQuest() && currentRoom.getHasFinishedQuest() == false) {
            if (player.getProgress() < currentRoom.getNextQuestProgress()) {
                s = currentRoom.getNPC(0).getName() + ": " + currentRoom.getNPC(0).getOnQuestString();
            } else if (player.getProgress() == currentRoom.getNextQuestProgress()) {
                s = currentRoom.getNPC(0).getCompleteQuestString();

                currentRoom.setHasFinishedQuest(true);
                player.incrementProgress();
                questQuestion = false;
                conversation = false;
                if (player.getProgress() == 4 && currentRoom.getName().equals("Bookstore")){
                    player.setJournal("A Programmers Bible:\n"
                            + "The lady has received her coffee, and is very thankful.\n"
                            + "She has unlocked the storage room, where all the books are.\n\n"
                            + "You may now with her permission enter the storage room and take the book.\n"
                            + "Afterwards return to Andars with the book!");
                } else if (player.getProgress() == 12 && currentRoom.getName().equals("T8")) {
                    player.setJournal("You have returned Maltas bag.\n"
                            + "Return to Lune.");
                } else {
                player.setJournal("You have no current quest.\n"
                                + "Explore to find the next quest!");
                }  
            }
            // check 3.6: Checks whether or not a quest has been completed in that room
            // if a quest has been completed, it will return the string that explains
            // to the player that the quest in that room has been finished
        } else if (currentRoom.getHasFinishedQuest()) {
            s = currentRoom.getNPC(0).getQuestCompletedString();
            questQuestion = false;
            conversation = false;
        }
        return s;
    }

    private String processChoice(Command command) {
        try {
            // stage 3.3: checks if the answer is yes, if the player types in yes
            // then the the NPC's string acceptString will be returned
            // and that room will now have an ongoing quest, which makes it possible
            // to return another string when they player comes back without completing it
            // also the string that explains the quest will be added to the players journal
            if (command.getCommandWord().equals(CommandWord.YES)) {
                s = currentRoom.getNPC(0).getAcceptString() + "\n";
                currentRoom.setHasOngoingQuest(true);
                currentRoom.setHasFinishedQuest(false);
                player.setJournal(currentRoom.getJournalString());

                // stage 3.4: Checks if the answer is no, if the answer is no a decline string will be returned
                // and player must choose 1 again to accept the quest.
            } else if (command.getCommandWord().equals(CommandWord.NO)) {
                s = currentRoom.getNPC(0).getDeclineString() + "\n";
            }
        } catch (IndexOutOfBoundsException ex) {
            s += currentRoom.getShortDescription();
        }
        questQuestion = false;
        conversation = false;
        return s;
    }

    private String printHelp() {
        return "Solve your current quest, you can see it by typing journal.\n"
                + "HINT: completing quests wins you the game.\n\n"
                + "Your command words are:\n"
                + parser.showCommands();
    }

    private String approachNPC(Command command) {
        try {
            if (!command.hasSecondWord()) {
                s = "Approach what?";

            } else if (command.getSecondWord().equals(currentRoom.getNPC(0).getName())) {
                s = printNPCsName()
                        + printNPCsWelcome()
                        + printDialogOptions();
            }
        } catch (IndexOutOfBoundsException ex) {
            s = "There is no one here to talk to.";
        }
        return s;
    }

    private String goRoom(Command command) {
        if (currentRoom.getIsLocked()) {
            s = "You can't escape from this encounter!\n";
            return "Combatoptions: \n"
                    + "a) Attack \n"
                    + "b) Heal \n"
                    + "c) Dodge \n";
        } else {

            if (!command.hasSecondWord()) {
                return "Go where?";
            }

            String direction = command.getSecondWord();

            Room nextRoom = currentRoom.getExit(direction);

            if (nextRoom == null) {
                s = "There is no door!";

            } else if (nextRoom.getRequiredProgress() > player.getProgress()) {
                s = "You can't go there yet!";

            } else {
                s = nextRoom.getShortDescription() + "\n";
                currentRoom = nextRoom;
            }
        }
        return s;
    }

    private String encounterNPC(Command command) {
        //ENCOUNTER - COMBATSYSTEM!!
        if (currentRoom.hasEncounter()) {
            if (currentRoom.getEncounter().encounterMet()) {

                if (!fleeAttempted) {
                    s = currentRoom.getEncounter().getEncounterMessage()
                            + battle.Decision();

                    fight = true;
                    currentRoom.setIsLocked(true);
                }
            } else {
                s = "";
            }
        } else if (fleeAttempted) {
            s = "You already tried fleeing once you coward";
        } else {
            s = "";
        }
        return s;
    }

    private String combatOptions(Command command) {

        Battlesystem battle = new Battlesystem();
        BragAbility brag = new BragAbility(player.getLevel());
        WittyRemarkAbility wittyRemark = new WittyRemarkAbility(player.getLevel());
        SpecialAbility specialAbility = new SpecialAbility(player.getLevel());
        EncounterAttacks encounterturn = new EncounterAttacks();
        Heal healAbility = new Heal(player.getHealth(), player.getMaxHealth(), player.getLevel());

        int enemyHealth = currentRoom.getEncounter().getEncounterNPC().getHealth();

        if (fight) {
            switch (command.getCommandWord()) {
                case FIGHT:
                    s = battle.Combatoptions();
                    fleeAttempted = true;
                    break;
                case FLEE:
                    if (fleeAttempted) {
                        s = "You can't escape!.\n"
                                + battle.Combatoptions();

                    } else if (!currentRoom.getEncounter().tryFlee()) {
                        s = "You escaped! \n"
                                + currentRoom.getDescription();
                        fight = false;
                        currentRoom.setIsLocked(false);

                    } else {
                        s = "Oh no, you werent quick enough!\n" + battle.Combatoptions();
                        fleeAttempted = true;
                    }

                    break;

                case ATTACK:
                    s = battle.attackoptions();
                    break;
                // Witty remark
                case WITTY:
                    int damage = wittyRemark.remarkAttack();
                    s = "You used a witty remark insulting" + currentRoom.getEncounter().getEncounterNPC() + "!";
                    s += "\nit resulted in " + damage + " points of damage!\n";
                    currentRoom.getEncounter().getEncounterNPC().setHealth(enemyHealth - damage);

                    if (enemyHealth > 0) {

                        s += currentRoom.getEncounter().getEncounterNPC().getAttackString() + "\n";
                        player.setHealth(player.getHealth() - currentRoom.getEncounter().getEncounterNPC().enemyAttack());
                        s += "Ouch! Your health has decreased to " + player.getHealth() + "HP\n\n";
                        s += battle.Combatoptions();
                    } else {
                        s = "something went wrong";
                    }
                    break;

                // Brag about being an engineer
                case BRAG:
                    if (player.hasMinorSpecial()) {
                        int damage2 = brag.bragAttack();
                        s = "You bragged about being an engineer and agitated" + currentRoom.getEncounter().getEncounterNPC() + " \n";
                        s += "The bragging resulted in " + damage2 + " points of damage.\n";
                        currentRoom.getEncounter().getEncounterNPC().setHealth(enemyHealth - damage2);
                        player.decrementMinorSpecial();
                        if (enemyHealth > 0) {

                            s += currentRoom.getEncounter().getEncounterNPC().getAttackString() + "\n";
                            player.setHealth(player.getHealth() - currentRoom.getEncounter().getEncounterNPC().enemyAttack());
                            s += "Ouch! Your health has decreased to " + player.getHealth() + "HP\n\n";
                            s += battle.Combatoptions();
                        } else {
                            s = "something went wrong";
                        }

                    } else {
                        s = "You already exhausted your brag ability!\n";
                        s += battle.attackoptions();
                    }
                    break;

                // Optional
                case SPECIAL:
                    if (player.hasSpecial()) {
                        int damage3 = specialAbility.specialAttack();
                        s = "You used your special ability on" + currentRoom.getEncounter().getEncounterNPC() + " \n";
                        s += "It resulted in " + damage3 + " points of damage.\n";
                        currentRoom.getEncounter().getEncounterNPC().setHealth(enemyHealth - damage3);
                        player.decrementSpecial();

                        if (enemyHealth > 0) {

                            s += currentRoom.getEncounter().getEncounterNPC().getAttackString() + "\n";
                            player.setHealth(player.getHealth() - currentRoom.getEncounter().getEncounterNPC().enemyAttack());
                            s += "Ouch! Your health has decreased to " + player.getHealth() + "HP\n\n";
                            s += battle.Combatoptions();
                        } else {
                            s = "something went wrong";
                        }
                    } else {
                        s = "You already exhausted your special ability!\n";
                        s += battle.attackoptions();
                    }

                    break;
                case BACK:
                    s = battle.Combatoptions();
                    break;
                case HEAL:
                    if (!player.hasHeals()) {
                        s = "You don't have any heals.\n";
                        s += battle.Combatoptions();
                    } else {

                        if (player.getHealth() == player.getMaxHealth()) {
                            s = "Your health is already full!";
                            s += battle.attackoptions();
                        } else {
                            int tempHealAmount = healAbility.heal();
                            player.setHealth(player.getHealth() + tempHealAmount);

                            if (player.getHealth() > player.getMaxHealth()) {
                                player.setHealth(player.getMaxHealth());
                            }
                            s = ("Your healed for " + tempHealAmount + "!" + "\nYour current health is " + player.getHealth() + "HP\n");
                            s += ((player.getHeals() - 1) + " heal(s) remaining!\n\n");
                            player.decrementHeal();
                            s += battle.Combatoptions();
                        }
                    }
                    break;
        
                default:
                    break;
            }
        }
       if (currentRoom.getEncounter().getEncounterNPC().getHealth() <= 0 && player.getHealth() > 0) {
           s = "You defeated the opponent " + currentRoom.getEncounter().getEncounterNPC() + "\n"
                                + "You were rewarded with " + currentRoom.getEncounter().getEncounterNPC().getExperience() + "XP!";
           player.gainExperience(currentRoom.getEncounter().getEncounterNPC().getExperience());
           fight = false;
           currentRoom.setIsLocked(false);
           player.incrementProgress();
           currentRoom.setHasEncounter(false);
           fleeAttempted = false;

       } else if (player.getHealth() < 0) {
           s = "You got rekt son, game over.";
           finished = true;
       } 
       return s;
    }

    private String printDialogOptions() {
        return currentRoom.getNPC(0).getDialogOptions();
    }

    private String printNPCsName() {
        return currentRoom.getNPC(0).getName() + ": ";
    }

    private String printNPCsWelcome() {
        return currentRoom.getNPC(0).getWelcome();
    }

    private String printNPCsGoodbye() {
        return currentRoom.getNPC(0).getGoodbye();
    }

    public String getSimpleUserInput(String s) {
        return s;
    }

    private String startScreen() {
        if (!started) {
            s = currentRoom.getRoomIntro();
        } else {
            s = "What are you trying to do?";
        }
        return s;
    }

    private String print3Lines() {
        for (int i = 0; i < 3; i++) {
            s += "\n";
        }
        return s;
    }

    public Player getPlayer() {
        return this.player;
    }
}
