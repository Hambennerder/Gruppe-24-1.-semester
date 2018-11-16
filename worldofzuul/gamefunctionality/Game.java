package worldofzuul.gamefunctionality;
import java.util.Scanner;
import worldofzuul.Item;
import worldofzuul.Player;
import worldofzuul.Room;
import worldofzuul.content.NPCS;
import worldofzuul.content.Rooms;

public class Game extends Player
{
    private Parser parser;
    private Room currentRoom;
    private Room nextRoom;
    private Player player;
    private int questCounter = 0;
    private int questStringCounter = 0;

    public Game() 
    {
        parser = new Parser();
    }

    private void incrementQuestCounter() {
        this.questCounter++;
    }
    
    private void incrementQuestStringCounter() {
        this.questStringCounter++;
    }

    public void play() 
    {    
        player = new Player();
        player.setName("John Doe");
        
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
        
        Item coffee = new Item();
        coffee.setName("coffee");
        listOfRooms.getRoom(11).addItem(coffee);
 
        printWelcome();
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing. Good bye.");
    }

    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the world of SDUUL.\n");
        System.out.println("An adventurous text-based rpg game that tackles the life being a new university student\n"
            + "in the most boring of fashion, we will show you the everchanging day to day life in a \n"
            + "comedic way. The game consists of various quests and obstacles, which you as a player  \n"
            + "must overcome to continue. You might be rewarded, and ultimately be prepared for how  \n"
            + "boring studying can be. DISCLAIMER: 9/10 feminists want the creators behind this game in jail \n");


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

    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        }
        else if (commandWord == CommandWord.GO) {
            goRoom(command);
        }
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        else if (commandWord == CommandWord.INSPECT) {
            print20Lines();

            System.out.println(currentRoom.getDescription());
            try { 
            System.out.println("This room contains: " + currentRoom.getItem(0).getName());
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("\n ***No item to be found***");
            }
        }
        else if (commandWord == CommandWord.TAKE) {
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
        }
        else if (commandWord == CommandWord.APPROACH) {
            approachNPC(command);
        }      
        
        /* else if (commandWord == CommandWord.DROP) {
            // code along the lines off, dropping an item from player inventory
        }
        */
        
        else if (commandWord == CommandWord.CHOOSE) {
            processOption(command);
        }
        else if (commandWord == CommandWord.JOURNAL) {
            System.out.println(player.getJournal());
        }
        else if (commandWord == CommandWord.INVENTORY) {
            player.getInventory();
        }
        
            
        return wantToQuit;
    }
    
    
    private void loadTradeMenu() {
        // Soon to be implemented
        System.out.println("I'm sorry, I'm not selling at the moment, come back later");
    }
    
    private void processOption(Command command) {
              
        if (!command.hasSecondWord()) {
            System.out.println("Choose what?");  
        } else if (!currentRoom.getHasQuest()) {
            System.out.println("What?");
        } else if (currentRoom.getHasQuest() && command.getSecondWord().equals("1")) {
            print20Lines();
            if(!currentRoom.getHasOngoingQuest()) {
            System.out.println(currentRoom.getNPC(0).getQuestString());
            String answer = getSimpleUserInput();
            
            if (answer.equals("yes")) {
                print20Lines();
                System.out.println(currentRoom.getNPC(0).getAcceptString()); 
                currentRoom.setHasOngoingQuest(true);
                currentRoom.setHasFinishedQuest(false);
                player.setJournal(currentRoom.getJournalString());
                
                
            } else if (answer.equals("no")) {
                System.out.println(currentRoom.getNPC(0).getDeclineString());
            } else {
                System.out.println("you did not type yes or no, sadly you will have to try this again");       
            }
            } else if (currentRoom.getHasOngoingQuest() && currentRoom.getHasFinishedQuest() == false) {
                if (player.getProgress() < currentRoom.getNextQuestProgress()) {
                    System.out.println(currentRoom.getNPC(0).getName() + ": " + currentRoom.getNPC(0).getOnQuestString());
                }
                else if (player.getProgress() == currentRoom.getNextQuestProgress()) {
                    System.out.println(currentRoom.getNPC(0).getCompleteQuestString());
                    currentRoom.setHasFinishedQuest(true); 
                    player.incrementProgress(); 
                    player.setJournal("No active quests...");
                }      
            } else if (currentRoom.getHasFinishedQuest()) {
                System.out.println(currentRoom.getNPC(0).getQuestCompletedString());
            }
            // pseudokode: if (currentRoom.getQuestItem == player.getItem) then currentRoom.setHasFinishedQuest(true);
        }
    }
    
   

    private void printHelp() 
    {
        System.out.println("Solve your current quest, you can see it by typing journal");
        System.out.println("HINT: completing quests wins you the game.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
        System.out.println();
    }
  
    private void approachNPC(Command command) { 
        if(!command.hasSecondWord()) {
            System.out.println("Approach what?");   
        } 
        else if (command.getSecondWord().equals(currentRoom.getNPC(0).getName())) {
            for (int i = 0; i<10; i++) {System.out.println();}
            printLocation();
            printNPCsName();
            printNPCsWelcome();
            printDialogOptions();
            
        }                
    }
    
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);
    
        if (nextRoom == null) {
            System.out.println("There is no door!");
        
        } else if (nextRoom.getRequiredProgress() > player.getProgress()) {
            System.out.println("You can't go there yet!");
        }
        
        else {
            for (int i=0;i<10;i++) {System.out.println();}
            System.out.println(nextRoom.getShortDescription());
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }          
    
    }
  
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
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
        for (int i=0; i<10; i++) {System.out.println();}
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
        System.out.println("Are you ready to dive into this?");
        String answer = getSimpleUserInput();
        if (answer.equals("yes")) {
            for (int i=0;i<20;i++){System.out.println();}
             System.out.println(currentRoom.getLongDescription());
             System.out.println(currentRoom.getRoomIntro());
            } else if (answer.equals("no")) {
                System.out.println("Oh.. well you will have to play without the initial help text then. Type help for help."); 
            } else { System.out.println("Writing yes or no can't be that hard.."); }
            
            
        }
    private void print20Lines() {
        for (int i=0;i<20;i++){System.out.println();}
    }
    
    }
    
//}