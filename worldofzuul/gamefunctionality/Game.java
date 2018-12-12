package worldofzuul.gamefunctionality;

import worldofzuul.Encounter;
import worldofzuul.Item;
import worldofzuul.Player;
import worldofzuul.Room;
import worldofzuul.content.NPCS;
import worldofzuul.content.Rooms;
import worldofzuul.combat.Battlesystem;
import worldofzuul.combat.Bodyslam;
import worldofzuul.combat.Dropkick;
import worldofzuul.combat.EncounterAttacks;
import worldofzuul.combat.Punch;

public class Game extends Player {

    private String s = "";
    public Parser parser;
    public Room currentRoom;
    public Player player;
    private boolean finished = false;
    private boolean started = false;
    private boolean fight = false;
    boolean fleeAttempted = false;

    public Game() {
        parser = new Parser();
        player = new Player();
    }

    public void setPlayerName() {
        player.setPlayerName(player.ConversationWord("What is your name?"));
    }

    public void setGender() {
        player.setGender(player.ConversationWord("Please enter your gender: "));
    }

    public void setAge() {
        player.setAge(player.ConversationWord("Please enter your age: "));
    }

    public void play() {

        Rooms listOfRooms = new Rooms();
        listOfRooms.createRooms();
        currentRoom = listOfRooms.getRoom(0);

        NPCS npcs = new NPCS();
        npcs.createNPCS();

        Item id_card = new Item();
        id_card.setName("ID-card");
        id_card.setDescription("The id-card allows you as a student to enter the entrance of the SDU building.");

        Item book = new Item();
        book.setName("book");

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
        lawStudentEncounter.setEncounterMessage("Oh no, you have encountered" + lawStudentEncounter.getEncounterNPC() + "!");
        listOfRooms.getRoom(16).addEncounter(lawStudentEncounter);

        // Adding the constitution to the library and student to hallway g3
        Item holy_constitution = new Item();
        holy_constitution.setName("Holy-Constitution");
        listOfRooms.getRoom(16).addItem(holy_constitution);
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
        janitorEncounter.setEncounterMessage("Haha! You filthy students really "
                + "think you're something special, huh? well you are not!");
        
        // Adding medicine student encounter to study hall
        Encounter medicineEncounter = new Encounter();
        listOfRooms.getRoom(17).addEncounter(medicineEncounter);
        medicineEncounter.addEncounterNPC(npcs.getNPC(9));
        medicineEncounter.setEncounterPossibility(100);
        medicineEncounter.setEncounterMessage("You think you're smarter than me?"
                + "HA! I'm studying to become a doctor.. my grades are better than yours!");
        
    }

    public boolean getFinished() {
        return finished;
    }

    public void setFinished(boolean b) {
        this.finished = b;
    }

    public String processCommand(Command command) throws Exception {
        CommandWord commandWord = command.getCommandWord();
        if (commandWord == CommandWord.UNKNOWN) { //DONE
            s = "I don't know what you mean...";
        }
        if (commandWord == CommandWord.HELP) {//DONE
            return printHelp();
        } else if (commandWord == CommandWord.BEGIN) {//DONE
            return startScreen();
        } else if (commandWord == CommandWord.GO) {//DONE
            return goRoom(command)+"\n"
                    + encounterNPC(command);
        } else if (commandWord == CommandWord.QUIT) {//DONE
            setFinished(true);
        } else if (commandWord == CommandWord.INSPECT) {//DONE
            s = "Your location: " + currentRoom.getName()
                    + currentRoom.getExitString() + "\n"
                    + currentRoom.getDescription();
            try {
                s += "This room contains: " + currentRoom.getItem(0).getName();
            } catch (IndexOutOfBoundsException ex) {
                s += "\n ***No item to be found***";
            }
        } else if (commandWord == CommandWord.TAKE) { //DONE

            if (!command.hasSecondWord()) {
                s = "Take what?";
            }

            if (currentRoom.getItem(0) == null) {
                s = "No item to take";

            } else if (currentRoom.getItem(0).getName().equals(command.getSecondWord())) {
                player.addItem(currentRoom.getItem(0));
                s = "You picked up " + currentRoom.getItem(0).getName();
                currentRoom.removeItem(0);
                player.incrementProgress();
            }
        } else if (commandWord == CommandWord.APPROACH) {//DONE
            s = approachNPC(command);
        } else if (commandWord == CommandWord.CHOOSE) {//DONE
            s = processOption(command);
        } else if (commandWord == CommandWord.JOURNAL) {//DONE
            s = player.getJournal();
        } else if (commandWord == CommandWord.YES | commandWord == CommandWord.NO) {//DONE
            s = processChoice(command);
        } else if (commandWord == CommandWord.FIGHT
                | commandWord == CommandWord.FIGHT
                | commandWord == CommandWord.FLEE
                | commandWord == CommandWord.ATTACK
                | commandWord == CommandWord.HEAL
                | commandWord == CommandWord.DODGE
                | commandWord == CommandWord.DROPKICK
                | commandWord == CommandWord.PUNCH
                | commandWord == CommandWord.BODYSLAM
                | commandWord == CommandWord.BACK) {
            if (fight) {
                return combatOptions(command);
            } else {
                return "Why are you trying to fight?";
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
                if (!currentRoom.getHasOngoingQuest()) {
                    s = currentRoom.getNPC(0).getQuestString();
                    // check 3.5: Checks if the quest has been finished or not. if the quest has not been finished, then
                    // the "on a quest string" will be returned, otherwise the next string introducing the player to
                    // where he should go next is returned
                } else if (currentRoom.getHasOngoingQuest() && currentRoom.getHasFinishedQuest() == false) {
                    if (player.getProgress() < currentRoom.getNextQuestProgress()) {
                        s = currentRoom.getNPC(0).getName() + ": " + currentRoom.getNPC(0).getOnQuestString();
                    } else if (player.getProgress() == currentRoom.getNextQuestProgress()) {
                        s = "Your location: " + currentRoom.getName()
                                + currentRoom.getExitString() + "\n"
                                + currentRoom.getNPC(0).getCompleteQuestString();
                        currentRoom.setHasFinishedQuest(true);
                        player.incrementProgress();
                        player.setJournal("No active quests...");
                    }
                } // check 3.6: Checks whether or not a quest has been completed in that room
                // if a quest has been completed, it will return the string that explains
                // to the player that the quest in that room has been finished
                else if (currentRoom.getHasFinishedQuest()) {
                    s = "Your location: " + currentRoom.getName()
                            + currentRoom.getExitString() + "\n"
                            + currentRoom.getNPC(0).getQuestCompletedString();
                }
            } else if (currentRoom.getHasQuest() && command.getSecondWord().equals("2")) {
                s = currentRoom.getNPC(0).getGoodbye();
            }
        } else {
            return "Choose what?";
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
                s = "Your location: " + currentRoom.getName()
                        + currentRoom.getExitString() + "\n"
                        + currentRoom.getNPC(0).getAcceptString();
                currentRoom.setHasOngoingQuest(true);
                currentRoom.setHasFinishedQuest(false);
                player.setJournal(currentRoom.getJournalString());

            // stage 3.4: Checks if the answer is no, if the answer is no a decline string will be returned
                // and player must choose 1 again to accept the quest.
            } else if (command.getCommandWord().equals(CommandWord.NO)) {
                s = "Your location: " + currentRoom.getName()
                        + currentRoom.getExitString() + "\n"
                        + currentRoom.getNPC(0).getDeclineString();

            }
        } catch (IndexOutOfBoundsException ex) {
            s += currentRoom.getLongDescription();
        }
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
                s = printLocation()
                        + printNPCsName()
                        + printNPCsWelcome()
                        + printDialogOptions();
            }
        } catch (IndexOutOfBoundsException ex) {
            s = "There is no one here to talk to.";
        }
        return s;
    }

    private String goRoom(Command command) {
        if (currentRoom.getIsLocked()){
            s = "You can't escape from this encounter!\n";
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
            s = nextRoom.getShortDescription()+"\n";
            currentRoom = nextRoom;
            s += currentRoom.getLongDescription();
        }
        }
        return s;
    }

    private String encounterNPC(Command command) {
        String s = "";
        //ENCOUNTER - COMBATSYSTEM!!
        if (currentRoom.hasEncounter()) {
            Battlesystem battle = new Battlesystem();
            if (currentRoom.getEncounter().encounterMet()) {
                
                if (!fleeAttempted) {
                s = currentRoom.getEncounter().getEncounterMessage()
                        + battle.Decision();
                
                fight = true;
                currentRoom.setIsLocked(true);
            } else {
                return "Something just moved in the shadows! Seems like it's gone now...";
            }
        }
        } else if (fleeAttempted) {
            s = "You already tried fleeing once you coward";
        }
        return s;
    }

    private String combatOptions(Command command) {
        Battlesystem battle = new Battlesystem();
        Dropkick dropkick = new Dropkick(player.getLevel());
        Punch punch = new Punch(player.getLevel());
        Bodyslam bodyslam = new Bodyslam(player.getLevel());
        EncounterAttacks encounterturn = new EncounterAttacks();
        
         int enemyHealth = currentRoom.getEncounter().getEncounterNPC().getHealth();
         
        if (fight){
            switch (command.getCommandWord()) {
                case FIGHT:
                    s = battle.Combatoptions();
                    break;
                case FLEE:
                    if (fleeAttempted) {
                        s = "Sorry, you already tried escaping once.\n"
                            + battle.Combatoptions();       
                    } else {
                    
                    if (!currentRoom.getEncounter().encounterMet()) {
                    s = "You escaped! \n"
                            + currentRoom.getDescription();
                    fight = false;
                    currentRoom.setIsLocked(false);
                    } else {
                        s = "Oh no, you werent quick enough!" + battle.Combatoptions();
                    }
                    }
                    break;
                case ATTACK:
                    s = battle.attackoptions();
                    break;
                case PUNCH:
                    
                    s = "You punched" + currentRoom.getEncounter().getEncounterNPC();
                    s += "\nit resulted in" + punch.getDamageAmount() + " damage!";
                    currentRoom.getEncounter().getEncounterNPC().setHealth(enemyHealth - punch.getDamageAmount());
                    
                    if (enemyHealth <= 0) {
                        s = "You defeated " + currentRoom.getEncounter().getEncounterNPC() + "!\n"
                                + "You were rewarded with " + currentRoom.getEncounter().getEncounterNPC().getExperience() + "XP!";
                        currentRoom.setIsLocked(false);
                        player.incrementProgress();
                        currentRoom.setHasEncounter(false);
                        
                    } else {
                        // if (attack instance off specialAbility) {
                        //   loadSpecialAbilityMethod();
                        // }
                        // else {
                        //   loadNormalAttackMethod();
                        // }
                        
                        s += battle.Combatoptions();
                    }
                    break;
                case DROPKICK:
                    
                    s = "You have dropkicked" + currentRoom.getEncounter().getEncounterNPC() + " \n";
                    s += " the kick resulted in" + dropkick.getDamageAmount() + "points in damage.";
                    currentRoom.getEncounter().getEncounterNPC().setHealth(enemyHealth - dropkick.getDamageAmount());
                    
                    if (enemyHealth <= 0) {
                        s = "You defeated the opponent " + currentRoom.getEncounter().getEncounterNPC() + "!\n"
                                + "You were rewarded with " + currentRoom.getEncounter().getEncounterNPC().getExperience() + "XP!";
                       
                    }
                         s += battle.Combatoptions();
                    
                    break;
                case BODYSLAM:
                    
                    s = "You have bodyslam" + currentRoom.getEncounter().getEncounterNPC() + " \n";
                    s += " the slam resulted in" + bodyslam.getDamageAmount() + "points in damage.";
                    currentRoom.getEncounter().getEncounterNPC().setHealth(enemyHealth - bodyslam.getDamageAmount());
                    
                    if (enemyHealth <= 0) {
                        s = "You defeated the opponent " + currentRoom.getEncounter().getEncounterNPC() + "!\n"
                                + "You were rewarded with " + currentRoom.getEncounter().getEncounterNPC().getExperience() + "XP!";
                        
                    }
                    s += battle.Combatoptions();
                    
                    break;
                case BACK:
                    s = battle.Combatoptions();
                    break;
                case HEAL:
                    int healAmount = 10;
                    player.setHealth(player.getHealth() + healAmount);  
                    s += "You healed for the amount: 10. Current health: " + player.getHealth()
                            +print3Lines()
                            +battle.Combatoptions();
                    break;
                case DODGE:
                    //s = battle.dodge()
                    //        + encounterturn.EncounterTurn();
                    //s += print3Lines()
                    //        +battle.Combatoptions();
                    break;
                default:
                    break;
            }
        }
       return s;
    } 


    private String printLocation() {
        return "Your location: " + currentRoom.getName();
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
            s = currentRoom.getLongDescription()
                    + currentRoom.getRoomIntro();
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
