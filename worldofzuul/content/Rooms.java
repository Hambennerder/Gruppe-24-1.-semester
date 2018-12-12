package worldofzuul.content;

import java.util.ArrayList;
import java.util.List;
import worldofzuul.Encounter;
import worldofzuul.Room;

public class Rooms extends Room {

    private List<Room> rooms;
    private String name;
    
    public Rooms(String name) {
        rooms = new ArrayList<>();
        this.name = name;
        
    }

    public void createRooms() {
        

        Room entrance, u1, u2, u3, u180, canteen, library, studyhall, u55, u45, bookstore, storage, t8,
                g1, g2, g3, g4, g5, g6, g7, g8, g9, g10, g11, g12, g13, g14, g15,
                g16, g17, g18, g19, g20, g21, g22, g23, g24, k1, k2, k3, k4, k5, k6, k7, k8;

        // Entrance index 0
        entrance = new Room("");
        entrance.setDescription("You are a new student in software engineering and \n"
                + "you have just arrived outside the main entrance \n"
                + "of the university. You look around and see cou- \n"
                + "ntless of other university students, heading to \n"
                + "their next class or lecture, you see a man wearing a red shirt saying \'mentor\'");

        entrance.setRoomIntro("Hello " + this.name + ", my name is Uvuvwevwevwe, and I will guide you \n"
                + "through the first steps of this tutorial. Above this message you \n"
                + "will see two things, location and exits. Location shows your current \n"
                + "location. If you haven't guessed it already, exits show our possible exits \n"
                + "Before we show you how to use the exits, let me first introduce you to \n"
                + "the command, inspect. Type in inspect and you will get a detailed description \n"
                + "of the current room, and also which elements it contains. Everything surrounded \n"
                + "by \'single quotation marks\', are interactable. You can interact by typing in \n"
                + "approach and the figures name, be aware, this system IS case sensitive. \n"
                + "If you want to take an item in a room, the same applies but with the command take. \n"
                + "Start the game by typing inspect, and then approach the given figure. \n"
                + " type help if you need help");

        entrance.setJournalString("A quest for the holy ID-card: Start by heading north \n"
                + " find the card and return to the mentor");

        entrance.setName("Entrance");
        entrance.setHasQuest(true);
        entrance.setQuestItemName("ID-card");
        entrance.setNextQuestProgress(1);
        rooms.add(entrance);

        // u1 index 1
        u1 = new Room("A small room, rather empty and quiet. \n"
                + "HINT: inspecting a room reveals interactable objects.");
        u1.setName("u1");
        u1.setDescription("I don't think there is an ID card in here..");

        rooms.add(u1);

        // u2 index 2
        u2 = new Room("White painted walls, probably painted recently due to the smell of fresh paint");
        u2.setDescription("No ID card here...");
        u2.setName("u2");
        rooms.add(u2);

        // u3 at index 3
        u3 = new Room("Room full of people, they seem like new students as I.\n"
                + "Maybe the ID-card is in here.. try inspecting the room?");
        u3.setDescription("The ID-card is here!. Type \'take ID-card\' to pick it up.\n"
                + "You can type inventory to make sure you picked it up.\n"
                + "Remember to turn your quest in at the mentor");
        u3.setName("u3");
        rooms.add(u3);

        // g1 at index 4
        g1 = new Room("in hallway g1."
                + "It feels like you wander alone in this vast labrinth"
                + " of hallways and dead ends even though people"
                + " are all around you. Will you be able to"
                + " find the place you need to be?");
        g1.setDescription("in hallway g1."
                + "It feels like you wander alone in this vast labrinth"
                + " of hallways and dead ends even though people"
                + " are all around you. Will you be able to"
                + " find the place you need to be?");
        g1.setName("g1");
        g1.setRequiredProgress(2);
        g1.setHasEncounter(true);
        rooms.add(g1);

        // u180 index 5
        u180 = new Room("You are in u180. A big bright room with many rows of chairs and tables.\n"
                + "You can feel the struggle and anxiety of the many students \n"
                + " who have sat in this room before you.");
        u180.setDescription("In the room you see a figure, it looks like \'Andars\'");
        u180.setName("U180");
        u180.setRequiredProgress(2);
        u180.setHasQuest(true);
        u180.setNextQuestProgress(5);
        u180.setQuestItemName("Java Book");
        u180.setJournalString("A Programmers Bible: Find the book, it should be at the bookstore\n "
                + " which is somewhere south, remember Andars' warning.");
        rooms.add(u180);

        // index 6
        g2 = new Room("You are in a hallway."
                + " It's dark, a little smelly, and a weird draft"
                + " keeps running down your neck. There are doors everywhere.");
        g2.setDescription("wow... inspecting this really was a waste of time");
        g2.setName("g2");
        g2.setRequiredProgress(2);
        rooms.add(g2);

        // g7 at index 7
        g7 = new Room("You are standing in a hallway, looks like all other\n"
                + " hallways in this damn university."
                + "\nYou must have been walking for miles by now."
                + "It's very dark in here, you are looking for a light switch"
                + " but there doesn't seem to be any.");
        g7.setDescription("Just your average dark hallway at SDU");
        g7.setName("g7");
        rooms.add(g7);

        // g8 at index 8
        g8 = new Room("You are in hallway g8. As you enter the door slams behind you."
                + "Must be the draft again... Where does it originate?");
        g8.setDescription("Nothing really exciting in this hallway");
        g8.setName("g8");
        rooms.add(g8);

        // Student bookstore at index 9
        bookstore = new Room("in the book store."
                + "Your first thought is that there are way too"
                + " many books in such a small area.");
        bookstore.setDescription("How will you ever find the book you need in here. \n"
                + " Maybe that 'lady' over there can help?");
        bookstore.setName("Student Bookstore");
        bookstore.setHasQuest(true);
        bookstore.setRequiredProgress(2);
        bookstore.setNextQuestProgress(3);
        bookstore.setJournalString("A Programmers Bible: Find the book, it should be at the bookstore\n "
                + " which is somewhere south, remember Andars' warning."

                + "The lady in the bookstore wants you to get her some coffee, head up to the canteen.");        

        rooms.add(bookstore);

        // student bookstores storage at index 10
        storage = new Room("You shouldnt be back here... unless");
        storage.setDescription("Is that a \'book\'?");
        storage.setName("Student bookstore storage");
        rooms.add(storage);

        // canteen at index 11
        canteen = new Room("in the canteen."
                + "A place where Chaos reigns."
                + "A place where only the fittest will survive"
                + " but atleast there is food.");
        canteen.setDescription("You see some \'coffee'.\n"
                + "It might or might not be useful in some situations");
        canteen.setName("Canteen");
        rooms.add(canteen);

        
        
        
                // Index 12
        g3 = new Room("you are in hallway g3");
        rooms.add(g3);
        g3.setRequiredProgress(6);
        g3.setDescription("another part of the maze that is SDU");
        g3.setName("g3");
        g3.setHasQuest(true);
        g3.setJournalString("Clear the studyhall and library of students from other faculties");
        
        
        // Index 13
        g4 = new Room("you are in hallway g4");
        rooms.add(g4);
        g4.setRequiredProgress(6);
        g4.setDescription("wow... how long are these hallways");
        g4.setName("g4");
        
        // Index 14
        g5 = new Room("you are in hallway g5");
        rooms.add(g5);
        g5.setRequiredProgress(6);
        g5.setDescription("You wonder how students have gotten lost at the university \n"
                + "some of them must still be walking around here looking for an exit");
        g5.setName("g5");
        
        // Index 15
        g6 = new Room("you are in hallway g6");
        rooms.add(g6);
        g6.setRequiredProgress(6);
        g6.setDescription("Finally a part of the hallway which is bright");
        g6.setName("g6");
        
        // library at index 16
        library = new Room("library");
        rooms.add(library);
        library.setDescription("You have arrived at the library...\n"
                + " Those law students don't look nice \n"
                + "but that \'Holy Constitution\' might be useful");
        library.setName("library");
        library.setRequiredProgress(6);
        
        // study hall at index 17


        studyhall = new Room("study hall");
        studyhall.setHasEncounter(true);

        rooms.add(studyhall);
        studyhall.setRequiredProgress(6);
        studyhall.setDescription("The studyhall is full of people who study medicin \n"
                + "You probably need to get them out of here, if you want a place to study");
        studyhall.setName("Studyhall");
        
        
        // index at index 18
        u55 = new Room("u55");
        rooms.add(u55);
        u55.setDescription("You are in a big auditorium desgined for teaching\n"
                + " a large number of distressed students\n"
                + "You see your teacher \'Lune\' ");
        u55.setName("u55");
        u55.setRequiredProgress(8);
        u55.setHasQuest(true);
        u55.setJournalString("Find your e-moderator. Maybe he's in t8.\n"
                + "Return to Lune when you're done");
        
        // index at 19
        u45 = new Room("u45");
        rooms.add(u45);
        u45.setDescription("You are in a huge auditorium known for it's technical problems \n"
                + "you can see your teacher \'Eryk\' and a \'cable\' ");
        u45.setName("u45");
        u45.setRequiredProgress(11);
        u45.setHasQuest(true);
        u45.setJournalString("Fix the technology in u45");
        
        
        // Index at 20
        t8 = new Room("t8");
        rooms.add(t8);
        t8.setDescription("The most feared room on campus.\n"
                + "It's dark, smelly and almost impossible to find\n"
                + "You see a figure that looks like \'Malta\'");
        t8.setName("T8");
        t8.setRequiredProgress(8);
        t8.setNextQuestProgress(10);
        t8.setHasQuest(true);
        t8.setJournalString("Find Malta's bag and bring it back to him");
       
                
        
        //index at 21   
        g9 = new Room("you are in hallway g9");
        rooms.add(g9);
        g9.setRequiredProgress(8);
        g9.setDescription("You should have worn a pedometer...");
        g9.setName("g9");
        
        g10 = new Room("you are in hallway g10");
        rooms.add(g10);
        g10.setDescription("Luckily you don't have to go to the gym anymore\n"
                + "with all the walking you have been doing here");
        g10.setName("g10");
        
        g11 = new Room("you are in hallway g11");
        rooms.add(g11);
        g11.setDescription("You should be at the basement floor soon");
        g11.setName("g11");
        
        g12 = new Room("you are in hallway g12");
        rooms.add(g12);
        g12.setDescription("You are almost at the basement. T8 Should be down there");
        g12.setName("g12");
        
        g13 = new Room("you are in hallway g13");
        rooms.add(g13);
        g13.setDescription("It's really dark down here... ");
        g13.setName("g13");
        
        g14 = new Room("you are in hallway g14");
        rooms.add(g14);
        g14.setDescription("It's really dark down here... Watch out for the angry janitors");
        g14.setName("g14");
        
        g15 = new Room("you are in hallway g15");
        rooms.add(g15);
        g15.setDescription("It's really dark down here... Watch out for the angry janitors");
        g15.setName("g15");
        
        g16 = new Room("you are in hallway g16");
        rooms.add(g16);
        g16.setDescription("It's really dark down here... The doors can be quite tricky to open");
        g16.setName("g16");
        
        g17 = new Room("you are in hallway 17");
        rooms.add(g17);
        g17.setDescription("It's really dark down here... Watch out for the angry janitors");
        
        g18 = new Room("you are in hallway g18");
        rooms.add(g18);
        g18.setDescription("It's really dark down here... Watch out for the angry janitors");
        g18.setName("g18");
        
        g19 = new Room("you are in hallway g19");
        rooms.add(g19);
        g19.setDescription("It's really dark down here... Is that a dead body over there?");
        g19.setName("g19");
        
        g20 = new Room("you are in hallway g20");
        rooms.add(g20);
        g20.setDescription("It's really dark down here... Watch out for the angry janitors");
        g20.setName("g20");
        
        g21 = new Room("you are in hallway g21");
        rooms.add(g21);
        g21.setDescription("It's really dark down here... Wow! Is that an original banksy?");
        g21.setName("g21");
        
        g22 = new Room("you are in hallway g22");
        rooms.add(g22);
        g22.setDescription("It's really dark down here... Maybe you can find a switch somewhere");
        g22.setName("g22");
        
        g23 = new Room("you are in hallway g23");
        rooms.add(g23);
        g23.setDescription("It's really dark down here... Watch out for the angry janitors");
        g23.setName("g23");
        
        g24 = new Room("you are in hallway g24");
        rooms.add(g24);
        g24.setDescription("It's really dark down here... You might be stuck down here forever");
        g24.setName("g24");
        
        k1 = new Room("you are in the basement in room k1");
        rooms.add(k1);
        k1.setDescription("The basement is dark and scary\n"
                + "You proably shouldn't linger for too long");
        k1.setName("k1");
        
        k2 = new Room("you are in the basement in room k2");
        rooms.add(k2);
        k2.setDescription("This basement is impossible to navigate");
        k2.setName("k2");
        
        k3 = new Room("you are in the basement in room k3");
        rooms.add(k3);
        k3.setDescription("Will you ever find T8?");
        k3.setName("k3");
        
        k4 = new Room("you are in the basement in room k4");
        rooms.add(k4);
        k4.setDescription("How come you have to be down here... it's all smelly and old");
        k4.setName("k4");
        
        k5 = new Room("you are in the basement in room k5");
        rooms.add(k5);
        k5.setDescription("This might be the right way... wait, where are you going?");
        k5.setName("k5");
        
        k6 = new Room("you are in the basement in room k6");
        rooms.add(k6);
        k6.setDescription("This basement much be pretty huge");
        k6.setName("k6");
        
        k7 = new Room("you are in the basement in room k7");
        rooms.add(k7);
        k7.setDescription("Is that Malta's \'bag\' over there?");
        k7.setName("k7");
        
        k8 = new Room("you are in the basement in room k8");
        rooms.add(k8);
        k8.setDescription("What is that weird smell in here?");
        k8.setName("k8");
        


        entrance.setExit("east", g1);
        entrance.setExit("north", u1);
        u1.setExit("south", entrance);
        u1.setExit("west", u2);
        u2.setExit("south", u3);
        u2.setExit("east", u1);
        u3.setExit("north", u2);
        g1.setExit("east", u180);
        g1.setExit("west", entrance);
        g2.setExit("east", canteen);
        g2.setExit("west", g3);
        g2.setExit("north", u180);
        g2.setExit("south", g7);

        g3.setExit("east", g2);
        g3.setExit("west", g4);

        g4.setExit("east", g3);
        g4.setExit("west", g5);

        g5.setExit("east", g4);
        g5.setExit("west", g6);

        g6.setExit("east", g5);
        g6.setExit("north", library);
        g6.setExit("south", studyhall);

        g7.setExit("west", g9);
        g7.setExit("north", g2);
        g7.setExit("south", g8);

        g8.setExit("south", bookstore);
        g8.setExit("north", g7);

        g9.setExit("east", g7);
        g9.setExit("west", u55);
        g9.setExit("south", u45);

        g10.setExit("east", u55);
        g10.setExit("south", g11);

        g11.setExit("north", g10);
        g11.setExit("south", g12);

        g12.setExit("north", g11);
        g12.setExit("south", k1);

        g13.setExit("east", k2);
        g13.setExit("west", k1);

        g14.setExit("west", k2);
        g14.setExit("east", k3);

        g15.setExit("north", k3);
        g15.setExit("south", g16);

        g16.setExit("north", g15);
        g16.setExit("west", g17);

        g17.setExit("west", g18);
        g17.setExit("east", g16);

        g18.setExit("east", g17);
        g18.setExit("west", g19);

        g19.setExit("north", g21);
        g19.setExit("east", g18);

        g20.setExit("north", k2);
        g20.setExit("west", g21);

        g21.setExit("east", g20);
        g21.setExit("west", g22);
        g21.setExit("south", g19);

        g22.setExit("east", g21);
        g22.setExit("south", t8);

        g23.setExit("north", k4);
        g23.setExit("south", k7);

        g24.setExit("north", k6);
        g24.setExit("east", k7);

        k1.setExit("west", k4);
        k1.setExit("east", g13);
        k1.setExit("north", g12);

        k2.setExit("east", g14);
        k2.setExit("west", g13);
        k2.setExit("south", g20);

        k3.setExit("west", g14);
        k3.setExit("south", g15);

        k4.setExit("west", k5);
        k4.setExit("east", k1);
        k4.setExit("south", g23);

        k5.setExit("east", k4);
        k5.setExit("south", k6);

        k6.setExit("north", k5);
        k6.setExit("south", g24);
        k6.setExit("west", k8);

        k7.setExit("north", g23);
        k7.setExit("west", g24);

        k8.setExit("east", k6);

        bookstore.setExit("north", g8);
        bookstore.setExit("south", storage);
        storage.setExit("north", bookstore);

        library.setExit("south", g6);

        studyhall.setExit("north", g6);

        canteen.setExit("west", g2);

        t8.setExit("north", g22);

        u45.setExit("north", g9);

        u55.setExit("east", g9);
        u55.setExit("west", g10);

        u180.setExit("west", g1);
        u180.setExit("south", g2);
    }

    public Room getRoom(int index) {
        return rooms.get(index);
    }

}
