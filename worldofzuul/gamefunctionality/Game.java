package worldofzuul.gamefunctionality;

import GUI.FXMLMainController;
import java.util.Scanner;
import worldofzuul.Encounter;
import worldofzuul.Item;
import worldofzuul.Player;
import worldofzuul.Room;
import worldofzuul.content.NPCS;
import worldofzuul.content.Rooms;

public class Game extends Player {

    private Parser parser;
    private Room currentRoom;
    private Room nextRoom;
    private Player player;
    private FXMLMainController g;

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
        player.setAge(player.ConversationAge("Please enter your age: "));
    }

    public void play() {
        /*
        System.out.println("#");
        System.out.println("#  ██╗    ██╗ ██████╗ ██████╗ ██╗     ██████╗      ██████╗ ███████╗    ███████╗██████╗ ██╗   ██╗██╗   ██╗██╗     ");
        System.out.println("#  ██║    ██║██╔═══██╗██╔══██╗██║     ██╔══██╗    ██╔═══██╗██╔════╝    ██╔════╝██╔══██╗██║   ██║██║   ██║██║     ");
        System.out.println("#  ██║ █╗ ██║██║   ██║██████╔╝██║     ██║  ██║    ██║   ██║█████╗      ███████╗██║  ██║██║   ██║██║   ██║██║     ");
        System.out.println("#  ██║███╗██║██║   ██║██╔══██╗██║     ██║  ██║    ██║   ██║██╔══╝      ╚════██║██║  ██║██║   ██║██║   ██║██║     ");
        System.out.println("#  ╚███╔███╔╝╚██████╔╝██║  ██║███████╗██████╔╝    ╚██████╔╝██║         ███████║██████╔╝╚██████╔╝╚██████╔╝███████╗");
        System.out.println("#   ╚══╝╚══╝  ╚═════╝ ╚═╝  ╚═╝╚══════╝╚═════╝      ╚═════╝ ╚═╝         ╚══════╝╚═════╝  ╚═════╝  ╚═════╝ ╚══════╝");
        System.out.println("#");
        
        setPlayerName();
        setGender();
        setAge();
        */
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

        // test code
        Encounter encounter = new Encounter();
        encounter.addEncounterNPC(npcs.getNPC(3));
        encounter.setEncounterMessage("Oh no, you have encountered" + encounter.getEncounterNPC() + "!");
        listOfRooms.getRoom(4).addEncounter(encounter);

        Item coffee = new Item();
        coffee.setName("coffee");
        listOfRooms.getRoom(11).addItem(coffee);

        printWelcome(player.getPlayerName());

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing. Good bye.");
    }

    private void printWelcome(String playername) {
        g.setOutput("Welcome " + playername + ", to the world of SDUUL.\n"
                +"An adventurous text-based rpg game that tackles the life\n"
                + "being a new university student in the most boring of \n"
                + "fashion, we will show you the everchanging day to day\n"
                + "life in a comedic way. This game consists of various\n"
                + "quests and obstacles, which you as a player must over-\n"
                + "come to continue. You might be rewarded, and ultimately\n"
                + "be prepared for how boring studying can be. \n"
                + "DISCLAIMER: 9/10 feminists want the creators behind this game in jail \n");

        // Code below is a result of a possible outstanding conflict in the group, will be handled shortly
        /* System.out.println("These are some helpful commands: ");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help and additional information.");
        System.out.println("Type '" + CommandWord.QUIT + "' if you don't want to play the game anymore.");
        System.out.println("Type '" + CommandWord.GO + "' if you want to move at certain direction.");
        System.out.println("Type '" + CommandWord.TAKE + "' if you want to pick up an item near you.");
        System.out.println("Type '" + CommandWord.EQUIP + "' if you want to equip and use the item.");
        System.out.println("Type '" + CommandWord.DROP + "' if you want to drop an item you.");
        System.out.println("Type '" + CommandWord.INSPECT + "' if you want to inspect a room.");
        System.out.println("Type '" + CommandWord.APPROACH + "' if you want to approach someone.");
        System.out.println("Type '" + CommandWord.CHOOSE + "' if you want to choose an option.");
        System.out.println("Type '" + CommandWord.JOURNAL + "' if you want to known the objective of the quest.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
         */
        startScreen();

    }

    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if (commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        } else if (commandWord == CommandWord.GO) {
            goRoom(command);
        } else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        } else if (commandWord == CommandWord.INSPECT) {
            print20Lines();
            System.out.println("Your location: " + currentRoom.getName());
            System.out.println(currentRoom.getExitString() + "\n");
            System.out.println(currentRoom.getDescription());
            try {
                System.out.println("This room contains: " + currentRoom.getItem(0).getName());
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("\n ***No item to be found***");
            }
        } else if (commandWord == CommandWord.TAKE) {

            if (!command.hasSecondWord()) {
                System.out.println("Take what?");
            }

            if (currentRoom.getItem(0) == null) {
                System.out.println("No item to take");

            } else if (currentRoom.getItem(0).getName().equals(command.getSecondWord())) {
                player.addItem(currentRoom.getItem(0));
                System.out.println("You picked up " + currentRoom.getItem(0).getName());
                currentRoom.removeItem(0);
                player.incrementProgress();
            }
        } else if (commandWord == CommandWord.APPROACH) {
            approachNPC(command);
        } /* else if (commandWord == CommandWord.DROP) {
            // code along the lines off, dropping an item from player inventory
        }   // will be implemented in next iteration
         */ else if (commandWord == CommandWord.CHOOSE) {
            processOption(command);
        } else if (commandWord == CommandWord.JOURNAL) {
            System.out.println(player.getJournal());
        } else if (commandWord == CommandWord.INVENTORY) {
            player.getInventory();
        }

        return wantToQuit;
    }

    private void processOption(Command command) {

        // Check 1: checks if there is a second word, aka a choice between 1 or 2
        if (!command.hasSecondWord()) {
            System.out.println("Choose what?");
        } // Check 2: checks if a room does not have a quest, so you cant "choose" in that room
        else if (!currentRoom.getHasQuest()) {
            System.out.println("What?");
        } // Check 3: Checks where you are in a quest by multiple stages (!primitive and basic state machine!)
        // Check 3.1: Checks if room has a quest and that second word is the option talk
        else if (currentRoom.getHasQuest() && command.getSecondWord().equals("1")) {
            print20Lines();

            // stage 3.2:
            // checks whether or not a room has an ongoing quest, if the room does not have
            // an ongoing quest, then the player will be presented the quest, and have an option
            // between yes and no
            if (!currentRoom.getHasOngoingQuest()) {
                System.out.println(currentRoom.getNPC(0).getQuestString());
                String answer = getSimpleUserInput();

                // stage 3.3: checks if the answer is yes, if the player types in yes
                // then the the NPC's string acceptString will be returned
                // and that room will now have an ongoing quest, which makes it possible
                // to return another string when they player comes back without completing it
                // also the string that explains the quest will be added to the players journal
                if (answer.equals("yes")) {
                    print20Lines();
                    System.out.println("Your location: " + currentRoom.getName());
                    System.out.println(currentRoom.getExitString() + "\n");
                    System.out.println(currentRoom.getNPC(0).getAcceptString());
                    currentRoom.setHasOngoingQuest(true);
                    currentRoom.setHasFinishedQuest(false);
                    player.setJournal(currentRoom.getJournalString());

                    // stage 3.4: Checks if the answer is no, if the answer is no a decline string will be returned
                    // and player must choose 1 again to accept the quest.
                } else if (answer.equals("no")) {
                    System.out.println("Your location: " + currentRoom.getName());
                    System.out.println(currentRoom.getExitString() + "\n");
                    System.out.println(currentRoom.getNPC(0).getDeclineString());

                } else {
                    System.out.println("you did not type yes or no, sadly you will have to try this again");
                }
            } // check 3.5: Checks if the quest has been finished or not. if the quest has not been finished, then
            // the "on a quest string" will be returned, otherwise the next string introducing the player to
            // where he should go next is returned
            else if (currentRoom.getHasOngoingQuest() && currentRoom.getHasFinishedQuest() == false) {
                if (player.getProgress() < currentRoom.getNextQuestProgress()) {
                    System.out.println(currentRoom.getNPC(0).getName() + ": " + currentRoom.getNPC(0).getOnQuestString());
                } else if (player.getProgress() == currentRoom.getNextQuestProgress()) {
                    System.out.println("Your location: " + currentRoom.getName());
                    System.out.println(currentRoom.getExitString() + "\n");
                    System.out.println(currentRoom.getNPC(0).getCompleteQuestString());
                    currentRoom.setHasFinishedQuest(true);
                    player.incrementProgress();
                    player.setJournal("No active quests...");
                }
            } // check 3.6: Checks whether or not a quest has been completed in that room
            // if a quest has been completed, it will return the string that explains
            // to the player that the quest in that room has been finished
            else if (currentRoom.getHasFinishedQuest()) {
                System.out.println("Your location: " + currentRoom.getName());
                System.out.println(currentRoom.getExitString() + "\n");
                System.out.println(currentRoom.getNPC(0).getQuestCompletedString());
            }
        }
    }

    private void printHelp() {
        System.out.println("Solve your current quest, you can see it by typing journal");
        System.out.println("HINT: completing quests wins you the game.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
        System.out.println();
    }

    private void approachNPC(Command command) {
        try {
            if (!command.hasSecondWord()) {
                System.out.println("Approach what?");

            } else if (command.getSecondWord().equals(currentRoom.getNPC(0).getName())) {
                for (int i = 0; i < 10; i++) {
                    System.out.println();
                }
                printLocation();
                printNPCsName();
                printNPCsWelcome();
                printDialogOptions();
            }
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Thers is no one here to talk to.");
        }
    }

    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");

        } else if (nextRoom.getRequiredProgress() > player.getProgress()) {
            System.out.println("You can't go there yet!");

        } else {
            for (int i = 0; i < 10; i++) {
                System.out.println();
            }
            System.out.println(nextRoom.getShortDescription());
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
        if (currentRoom.hasEncounter()) {

            if (currentRoom.getEncounter().encounterMet()) {
                System.out.println(currentRoom.getEncounter().getEncounterMessage());
                System.out.println(currentRoom.getEncounter().getEncounterNPC().getDialogOptions());

                Scanner input = new Scanner(System.in);
                boolean acceptableAnswer = false;
                while (!acceptableAnswer) {
                    String answer = input.nextLine();

                    if (answer.equals("1")) {
                        System.out.println("You defeated " + currentRoom.getEncounter().getEncounterNPC() + "!");
                        // Load combat system
                        acceptableAnswer = true;

                    } else if (answer.equals("2")) {
                        if (currentRoom.getEncounter().tryFlee()) {
                            System.out.println("You escaped!!");
                            // print some sort of UI
                            acceptableAnswer = true;
                        } else {
                            // load combat system
                            System.out.println("BAM you won the fight.");
                        }

                    } else {
                        System.out.println("Type in either 1 or 2");
                    }
                }

            } else {
                System.out.println("Something just moved in the shadows! Seems like it's gone now...");
            }

        }

    }

    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }

    private void printLocation() {
        System.out.println("Your location: " + currentRoom.getName());
    }

    private void printDialogOptions() {
        System.out.println(currentRoom.getNPC(0).getDialogOptions());
    }

    private void printNPCsName() {
        System.out.println(currentRoom.getNPC(0).getName() + ": ");
    }

    private void printNPCsWelcome() {
        System.out.println(currentRoom.getNPC(0).getWelcome());
    }

    private void printNPCsGoodbye() {
        System.out.println(currentRoom.getNPC(0).getGoodbye());
    }

    private void printPrimitiveUI() {
        // will be used for next iteration, and also improved upon
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
        System.out.println("Your location: " + currentRoom.getName());
        System.out.println(currentRoom.getExitString());
        System.out.println(currentRoom.getDescription());
    }

    private String getSimpleUserInput() {
        Scanner input = new Scanner(System.in);
        String tempInput = input.nextLine();
        return tempInput;
    }

    private void startScreen() {
        System.out.println("Are you ready to dive into this? type (yes/no)");
        String answer = getSimpleUserInput();

        if (answer.equals("yes")) {
            for (int i = 0; i < 20; i++) {
                System.out.println();
            }
            System.out.println(currentRoom.getLongDescription());
            System.out.println(currentRoom.getRoomIntro());

        } else if (answer.equals("no")) {
            System.out.println("Oh.. well you will have to play without the initial help text then. Type help for help.");

        } else {
            System.out.println("Writing yes or no can't be that hard..");
        }
    }

    private void print20Lines() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }

}
