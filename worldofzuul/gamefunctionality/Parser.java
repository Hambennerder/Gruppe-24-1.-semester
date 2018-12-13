package worldofzuul.gamefunctionality;

import worldofzuul.gamefunctionality.CommandWords;
import worldofzuul.gamefunctionality.Command;
import java.util.Scanner;

public class Parser {

    private CommandWords commands;
    private Scanner reader;

    public Parser() {
        commands = new CommandWords();
    }

    public Command getCommand(String s) {

        String word1 = null;
        String word2 = null;

        String[] ar = s.split(" ");

        word1 = ar[0];
        try {
            word2 = ar[1];
        } catch (ArrayIndexOutOfBoundsException ex) {

        }

        return new Command(commands.getCommandWord(word1), word2);
    }

    public String showCommands() {
        return commands.showAll();
    }
}
