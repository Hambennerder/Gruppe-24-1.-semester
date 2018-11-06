package worldofzuul;

public class Game 
{
    int key=0;
    private Parser parser;
    private Room currentRoom;
    private Room nextRoom;

    public Game() 
    {
        createRooms();
        parser = new Parser();
    }


    private void createRooms()
    {
        Room outside, theatre, pub, lab, office;
      
        outside = new Room("outside the main entrance of the university");
        theatre = new Room("in a lecture theatre");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
    
        outside.setExit("east", theatre);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theatre.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);
        
        office.setExit("west", lab);

        currentRoom = outside;
    }

    public void play() 
    {    
        
        NPC John = new NPC();
        Quest q = new Quest();
        q.addQuestString("Go find the duck!");
        q.addQuestString("Now that you found the duck, roast it");
        
        John.addQuest(q);
        John.getQuest(0).printQuestString(0);
        John.getQuest(0).printQuestString(1);
        
        
        
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
        return wantToQuit;
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
    
    // just a comment to test something
}
