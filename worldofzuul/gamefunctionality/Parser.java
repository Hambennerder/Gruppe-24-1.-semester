package worldofzuul.gamefunctionality;

import worldofzuul.gamefunctionality.CommandWords;
import worldofzuul.gamefunctionality.Command;
import java.util.Scanner;

public class Parser {

    private CommandWords commands;
    private Scanner reader;

    public Parser() {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    public Command getCommand(String inputLine) {
        
        String word1 = null;
        String word2 = null;       
        
        String[] ar = inputLine.split(" ");
        
        word1 = ar[0];
        word2 = ar[1];

        return new Command(commands.getCommandWord(word1), word2);
    }

    public String showCommands() {
        return commands.showAll();
    }
}
