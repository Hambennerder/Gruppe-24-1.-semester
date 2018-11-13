package worldofzuul;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game 
{
    int key=0;
    private Parser parser;
    private Room currentRoom;
    private Room nextRoom;
    private List<Room> rooms;

    public Game() 
    {
        rooms = new ArrayList<>();
        parser = new Parser();
    }


    private void createRooms()
    {
        Room outside, u180, canteen, library, studyhall, u55, u45, bookshop, t8,
                g1, g2, g3, g4, g5, g6, g7, g8, g9, g10, g11, g12, g13, g14, g15,
                g16, g17, g18, g19, g20, g21, g22, g23, g24, k1, k2, k3, k4, k5, k6, k7, k8;
        
        outside = new Room("outside the main entrance of the university");
        
        u180 = new Room("in u180, a rather modern room. A figure appears in the corner, the light from a computer screen lights up his face");
        u180.setDescription("This is just a showcase description of the room u180, in the room you see a \'figure\'");
        u180.setName("U180");
        rooms.add(u180);
        
        canteen = new Room("canteen");
        library = new Room("library");
        studyhall = new Room("study hall");
        u55 = new Room("u55");
        u45 = new Room("u45");
        bookshop = new Room("bookshop");
        t8 = new Room("t8");
        g1 = new Room("g1");
        g2 = new Room("g2");
        g3 = new Room("g3");
        g4 = new Room("g4");
        g5 = new Room("g5");
        g6 = new Room("g6");
        g7 = new Room("g7");
        g8 = new Room("g8");
        g9 = new Room("g9");
        g10 = new Room("g10");
        g11 = new Room("g11");
        g12 = new Room("g12");
        g13 = new Room("g13");
        g14 = new Room("g14");
        g15 = new Room("g15");
        g16 = new Room("g16");
        g17 = new Room("17");
        g18 = new Room("g18");
        g19 = new Room("g19");
        g20 = new Room("20");
        g21 = new Room("21");
        g22 = new Room("22");
        g23 = new Room("23");
        g24 = new Room("24");
        k1 = new Room("k1");
        k2 = new Room("k2");
        k3 = new Room("k3");
        k4 = new Room("k4");
        k5 = new Room("k5");
        k6 = new Room("k6");
        k7 = new Room("k7");
        k8 = new Room("k8");
    
        outside.setExit("east", g1);
        
        g1.setExit("east",u180);
        g1.setExit("west",outside);
        
        g2.setExit("east",canteen);
        g2.setExit("west",g3);
        g2.setExit("north",u180);
        g2.setExit("south",g7);
        
        g3.setExit("east",g2);
        g3.setExit("west",g4);
        
        g4.setExit("east",g3);
        g4.setExit("west",g5);
        
        g5.setExit("east",g4);
        g5.setExit("west",g6);
        
        g6.setExit("east",g5);
        g6.setExit("north",library);
        g6.setExit("south",studyhall);
        
        g7.setExit("west",g9);
        g7.setExit("north",g2);
        g7.setExit("south",g8);
        
        g8.setExit("south",bookshop);
        g8.setExit("north",g7);
        
        g9.setExit("east",g7);
        g9.setExit("west",u55);
        g9.setExit("south",u45);
        
        g10.setExit("east",u55);
        g10.setExit("south",g11);
        
        g11.setExit("north",g10);
        g11.setExit("south",g12);
        
        g12.setExit("north",g11);
        g12.setExit("south",k1);
        
        g13.setExit("east",k2);
        g13.setExit("west",k1);
        
        g14.setExit("west",k2);
        g14.setExit("east",k3);
        
        g15.setExit("north",k3);
        g15.setExit("south",g16);
        
        g16.setExit("north",g15);
        g16.setExit("west",g17);
        
        g17.setExit("west",g18);
        g17.setExit("east",g16);
        
        g18.setExit("east",g17);
        g18.setExit("west",g19);
        
        g19.setExit("north",g21);
        g19.setExit("east",g18);
        
        g20.setExit("north",k2);
        g20.setExit("west",g21);
        
        g21.setExit("east",g20);
        g21.setExit("west",g22);
        g21.setExit("south",g19);
        
        g22.setExit("east",g21);
        g22.setExit("south",t8);
        
        g23.setExit("north",k4);
        g23.setExit("south",k7);
        
        g24.setExit("north",k6);
        g24.setExit("east",k7);
        
        k1.setExit("west",k4);
        k1.setExit("east",g13);
        k1.setExit("north",g12);
        
        k2.setExit("east",g14);
        k2.setExit("west",g13);
        k2.setExit("south",g20);
        
        k3.setExit("west",g14);
        k3.setExit("south",g15);
        
        k4.setExit("west",k5);
        k4.setExit("east",k1);
        k4.setExit("south",g23);
        
        k5.setExit("east",k4);
        k5.setExit("south",k6);
        
        k6.setExit("north",k5);
        k6.setExit("south",g24);
        k6.setExit("west",k8);
        
        k7.setExit("north",g23);
        k7.setExit("west",g24);
        
        k8.setExit("east",k6);
        
        bookshop.setExit("north",g8);
        
        library.setExit("south",g6);
        
        studyhall.setExit("north",g6);
        
        canteen.setExit("west",g2);
        
        t8.setExit("north", g22);
        
        u45.setExit("north", g9);
        
        u55.setExit("east",g9);
        u55.setExit("west",g10);
        
        u180.setExit("west", g1);
        u180.setExit("south",g2);

        // this is the regular start room code currentRoom = outside;'
        // currentRoom below is for test purposes ONLY.
        currentRoom = u180;
    }
    
    public Room getRoom(int index) {
        return rooms.get(index);
    }

    public void play() 
    {    
        
        // First NPC and its respective quests
        createRooms();
        
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
        Quests quests = new Quests();
        
        quests.createQuests();
        
        andars.addQuest(quests.getQuest(0)); 
        
        andars.getQuest(0).printQuestString(0);
        
        getRoom(0).addNPC(andars);
        
        printWelcome();
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("If you want to enter the computing admins office, you have to pick up the key at the campus pub");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
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
            System.out.println(currentRoom.getDescription());
        }
        else if (commandWord == CommandWord.TAKE) {
            // code along the lines off, putting an item into player inventory
        }
        else if (commandWord == CommandWord.APPROACH) {
            approachNPC(command);
        }
        else if (commandWord == CommandWord.ACCEPT) {
            
        }
        else if (commandWord == CommandWord.DROP) {
            // code along the lines off, dropping an item from player inventory
        }
        else if (commandWord == CommandWord.LEAVE) {
            // code along the lines off, dropping an item from player inventory
        }
        else if (commandWord == CommandWord.CHOOSE) {
            processOption(command);
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
        } else if (command.getSecondWord().equals("1")) {
            for (int i = 0; i<10; i++) {System.out.println();}
            System.out.println(currentRoom.getNPC(0).getQuest(key).printQuestString(0));
            String option = getSimpleUserInput();
            if (option.equals("yes")) {
                System.out.println("You accepted a quest!");
            } else {
                System.out.println("You declined a quest!");
            }
        } else if (command.getSecondWord().equals("2")) {
            loadTradeMenu();
        } else if (command.getSecondWord().equals("3")) {
            printNPCsGoodbye();
            printPrimitiveUI();
        } else { System.out.println("That is not an option"); }
        printPrimitiveUI();
    }

    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
        System.out.println();
    }
  
    private void approachNPC(Command command) { 
        if(!command.hasSecondWord()) {
            System.out.println("Approach what?");   
        } else if (command.getSecondWord().equals("figure")) {
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
    
        if (currentRoom.getShortDescription()=="in a computing lab" && nextRoom.getShortDescription()=="in the computing admin office"){
            if (key==1){
            currentRoom=nextRoom;
            System.out.println(currentRoom.getLongDescription());
        } else {
            System.out.println("You need a key to enter this door .\n");
                System.out.println(currentRoom.getSlowDescription());
        }
        } else {
        if (nextRoom == null) {
        System.out.println("There is no door!");
        }
        else {
            //System.out.println(currentRoom.getShortDescription()+nextRoom.getShortDescription());
            System.out.println(nextRoom.getShortDescription());
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
            
        if (currentRoom.getShortDescription()=="in the campus pub"){
            if (key==0){    
            System.out.println("You have picked up the key for the computing admin office!");
            }
            key=1;    
        }
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
        System.out.println(rooms.get(0).getNPC(0).getName() + ": ");
    }
    
    private void printNPCsWelcome() {
        System.out.println(rooms.get(0).getNPC(0).getWelcome());
    }
    
    private void printNPCsGoodbye() {
        System.out.println(rooms.get(0).getNPC(0).getGoodbye());
    }
    
    private void printPrimitiveUI() {
        System.out.println("Your location: " + currentRoom.getName());
        System.out.println(currentRoom.getDescription());
    }
    
    private String getSimpleUserInput() {
        Scanner input = new Scanner(System.in);
        String tempInput = input.nextLine();
        return tempInput;
    }
    
    
    
    // just a comment to test something
}
