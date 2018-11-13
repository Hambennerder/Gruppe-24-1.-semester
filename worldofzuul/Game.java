package worldofzuul;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game extends Player
{
    private Parser parser;
    private Room currentRoom;
    private Room nextRoom;
    private List<Room> rooms;
    private Player player;

    public Game() 
    {
        rooms = new ArrayList<>();
        parser = new Parser();
    }


    private void createRooms()
    {

        Room entrance, u1, u2, u3, u180, canteen, library, studyhall, u55, u45, bookshop, t8,
                       g1, g2, g3, g4, g5, g6, g7, g8, g9, g10, g11, g12, g13, g14, g15,
                       g16, g17, g18, g19, g20, g21, g22, g23, g24, k1, k2, k3, k4, k5, k6, k7, k8;
        

        u180 = new Room("");
        u180.setDescription("You are in u180. A big bright room with many rows of chairs and tables.\n"
                         + "You can feel the struggle and anxiety of the many students who have sat in this room before you."
                         + "In the room you see a figure, it looks like \'Andars\'"); 
        u180.setName("U180");
        rooms.add(u180);
        
        entrance = new Room("");
        entrance.setDescription("You are a new student in software engineering and \n"
                         + "you have just arrived outside the main entrance \n"
                         + "of the university. You look around and see cou- \n"
                         + "ntless of other university students, heading to \n"
                         + "their next class or lecture");
        entrance.setName("Entrance");
        rooms.add(entrance);

        u1 = new Room("u1");
        rooms.add(u1);
        u1.setName("u1");
        u2 = new Room("u2");
        rooms.add(u2);
        u2.setName("u2");
        u3 = new Room("u3");
        rooms.add(u3);
        u3.setName("u3");
 
        canteen = new Room("");
        canteen.setDescription("in the canteen."
                + "A place where Chaos reigns."
                + "A place where only the fittest will survive"
                + " but atleast there is food.");
        canteen.setName("Canteen");
        rooms.add(canteen);

        library = new Room("library");
        studyhall = new Room("study hall");
        u55 = new Room("u55");
        u45 = new Room("u45");
      
        bookshop = new Room("in the book store."
                + "Your first thought is that there are way too"
                + " many books in such a small area."
                + "How will you ever find the book you need in here.");
      
        t8 = new Room("t8");

        g1 = new Room("in hallway g1."
                + "It feels like you wander alone in this vast labrinth"
                + " of hallways and dead ends even though people"
                + " are all around you. Will you be able to"
                + " find the place you need to be?");
        g1.setName("g1");  
        rooms.add(g1);
        

        g2 = new Room("");
        g2.setDescription("You are in a hallway."
                + " It's dark, a little smelly, and a weird draft"
                + " keeps running down your neck. There are doors everywhere.");
        g2.setName("g2");
        rooms.add(g2);

        g3 = new Room("g3");
        g4 = new Room("g4");
        g5 = new Room("g5");
        g6 = new Room("g6");
        
        g7 = new Room("");
        g7.setDescription("You are standing in a hallway, looks like all other hallways in this damn university."
                + "\nYou must have been walking for miles by now."
                + "It's very dark in here, you are looking for a light switch"
                + " but there does not seem to be any.");
        g7.setName("g7");
        rooms.add(g7);
        
        g8 = new Room("in hallway g8. As you enter the door slams behind you."
                + "Must be the draft again... Where does it originate?");
        
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

        entrance.setExit("east", g1);
        entrance.setExit("north",u1);
        u1.setExit("south", entrance);
        u1.setExit("west", u2); 
        u2.setExit("south", u3);
        u2.setExit("east", u1);
        u3.setExit("north", u2);
        g1.setExit("east",u180);
        g1.setExit("west",entrance); 
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

        currentRoom = entrance;

    }
    
    public Room getRoom(int index) {
        return rooms.get(index);
    }

    public void play() 
    {    
        player = new Player();
        player.setName("John Doe");
        
        createRooms();
        
        NPC mentor = new NPC();
        mentor.setDescription("Short and build student, wearing a hoodie and a pair of glasses, short clean cut redheaded");
        mentor.setName("Mentor");
        mentor.setDialogOptions("< 1: talk"
                                + "\n< 2: leave");
        Quests tutorial = new Quests();
        tutorial.createQuests();
        mentor.addQuest(tutorial.getQuest(0));
        mentor.getQuest(0).printQuestString(0);
        getRoom(1).addNPC(mentor);
        
        Item id_card = new Item();
        id_card.setName("SDU id-card");
        id_card.setDescription("The id-card allows you as a student to enter the entrance of the SDU building.");
        
        getRoom(4).addItem(id_card);
        
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
        andars.setAcceptString("Very well student! Return to me when you're done.");
        andars.setDeclineString("I'm sorry to hear that, return when you're ready.");
        
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
        System.out.println("Welcome to the world of SDUUL.\n");
        System.out.println("An adventurous NCP game that tackles the life being a \n"
            + "new university student and the everchanging day to day \n"
            + "life in a comedic way.The game consists of various \n"
            + "quest and obstacles instore for the player as \n"
            + "well as various rewards and achievements. \n");


        System.out.println("These are some helpful commands: ");
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
            
        }
        else if (commandWord == CommandWord.APPROACH) {
            approachNPC(command);
        }      
        
        else if (commandWord == CommandWord.DROP) {
            // code along the lines off, dropping an item from player inventory
        }
        
        else if (commandWord == CommandWord.CHOOSE) {
            processOption(command);
        }
        else if (commandWord == CommandWord.JOURNAL) {
            player.getJournal();
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
            System.out.println(currentRoom.getNPC(0).getQuest(0).printQuestString(0));
            String option = getSimpleUserInput();
            
            if (option.equals("yes")) {
                System.out.println("You accepted a quest!");
                System.out.println(currentRoom.getNPC(0).getAcceptString());
                player.addQuest(currentRoom.getNPC(0).getQuest(0));
                System.out.println("Type continue... to continue");
                String toContinue = getSimpleUserInput();
                
                if (!toContinue.equals("continue"))
                    System.out.println("You did not type continue");
                
            } else {
                System.out.println("You declined a quest!");
                System.out.println(currentRoom.getNPC(0).getDeclineString());
                System.out.println("Type continue... to continue");
                String toContinue = getSimpleUserInput();
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
        } else if (command.getSecondWord().equals(currentRoom.getNPC(0).getName())) {
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
        }
        else {
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
        System.out.println(rooms.get(0).getNPC(0).getName() + ": ");
    }
    
    private void printNPCsWelcome() {
        System.out.println(rooms.get(0).getNPC(0).getWelcome());
    }
    
    private void printNPCsGoodbye() {
        System.out.println(rooms.get(0).getNPC(0).getGoodbye());
    }
    
    private void printPrimitiveUI() {
        for (int i=0; i<10; i++) {System.out.println();}
        System.out.println("Your location: " + currentRoom.getName());
        System.out.println(currentRoom.getDescription());
    }
    
    private String getSimpleUserInput() {
        Scanner input = new Scanner(System.in);
        String tempInput = input.nextLine();
        return tempInput;
    }
    
}
