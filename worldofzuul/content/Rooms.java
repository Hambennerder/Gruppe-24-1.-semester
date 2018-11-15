
package worldofzuul.content;

import java.util.ArrayList;
import java.util.List;
import worldofzuul.Room;


public class Rooms extends Room {
    
    private List<Room> rooms;
    
    public Rooms() {
        rooms = new ArrayList<>();
    }
    
    public void createRooms()
    {

        Room entrance, u1, u2, u3, u180, canteen, library, studyhall, u55, u45, bookstore, t8,
                       g1, g2, g3, g4, g5, g6, g7, g8, g9, g10, g11, g12, g13, g14, g15,
                       g16, g17, g18, g19, g20, g21, g22, g23, g24, k1, k2, k3, k4, k5, k6, k7, k8;
        
        // u180 index 0
        u180 = new Room("");
        u180.setDescription("You are in u180. A big bright room with many rows of chairs and tables.\n"
                         + "You can feel the struggle and anxiety of the many students who have sat in this room before you."
                         + "In the room you see a figure, it looks like \'Andars\'"); 
        u180.setName("U180");
        u180.setRequiredProgress(1);
        u180.setHasQuest(true);
        u180.setHasOngoingQuest(false);
        
        rooms.add(u180);
        
        // Entrance index 1
        entrance = new Room("");
        entrance.setDescription("You are a new student in software engineering and \n"
                         + "you have just arrived outside the main entrance \n"
                         + "of the university. You look around and see cou- \n"
                         + "ntless of other university students, heading to \n"
                         + "their next class or lecture, you see a man wearing a red shirt saying \'mentor\'");
        entrance.setName("Entrance");
        entrance.setHasQuest(true);
        entrance.setQuestItemName("ID-card");
        entrance.setNextQuestProgress(1);
        rooms.add(entrance);

        // u1 index 2
        u1 = new Room("u1");
        u1.setName("u1");
        u1.setDescription("I don't think there is an ID card in here..");
        rooms.add(u1);
        
        // u2 index 3
        u2 = new Room("u2");
        u2.setDescription("No ID card here...");
        u2.setName("u2");
        rooms.add(u2);

        // u3 at index 4
        u3 = new Room("u3");
        u3.setDescription("Maybe the ID card is in here... try inspecting the room?");
        u3.setName("u3");
        rooms.add(u3);
 
        // canteen at index 5
        canteen = new Room("");
        canteen.setDescription("in the canteen."
                + "A place where Chaos reigns."
                + "A place where only the fittest will survive"
                + " but atleast there is food.");
        canteen.setName("Canteen");
        rooms.add(canteen);

        // library at index 6
        library = new Room("library");
        
        // studyhall at index 7
        studyhall = new Room("study hall");
        
        // index 8
        u55 = new Room("u55");
        
        // index 9
        u45 = new Room("u45");
      
        // Student bookstore at index 10
        bookstore = new Room("");
        bookstore.setDescription("in the book store."
                + "Your first thought is that there are way too"
                + " many books in such a small area.\n"
                + "How will you ever find the book you need in here. Maybe that 'lady' over there can help?");
        bookstore.setName("Student Bookstore");
        rooms.add(bookstore);
      
        t8 = new Room("t8");

        g1 = new Room("in hallway g1."
                + "It feels like you wander alone in this vast labrinth"
                + " of hallways and dead ends even though people"
                + " are all around you. Will you be able to"
                + " find the place you need to be?");
        g1.setName("g1"); 
        g1.setRequiredProgress(2);   
        rooms.add(g1);
        

        g2 = new Room("");
        g2.setDescription("You are in a hallway."
                + " It's dark, a little smelly, and a weird draft"
                + " keeps running down your neck. There are doors everywhere.");
        g2.setName("g2");
        g2.setRequiredProgress(2);
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
        
        g8 = new Room("");
        g8.setDescription("You are in hallway g8. As you enter the door slams behind you."
                + "Must be the draft again... Where does it originate?");
        g8.setName("g8");
        rooms.add(g8);
        
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
        
        g8.setExit("south",bookstore);
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
        
        bookstore.setExit("north",g8);
        
        library.setExit("south",g6);
        
        studyhall.setExit("north",g6);
        
        canteen.setExit("west",g2);
        
        t8.setExit("north", g22);
        
        u45.setExit("north", g9);
        
        u55.setExit("east",g9);
        u55.setExit("west",g10);
        
        u180.setExit("west", g1);
        u180.setExit("south",g2);
    }
    
    public Room getRoom(int index) {
        return rooms.get(index);
    }
    
}