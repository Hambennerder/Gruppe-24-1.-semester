package worldofzuul.gamefunctionality;

import worldofzuul.gamefunctionality.CommandWord;
import java.util.HashMap;

public class CommandWords {

    private HashMap<String, CommandWord> validCommands;

    public CommandWords() {
        validCommands = new HashMap<String, CommandWord>();
        for (CommandWord command : CommandWord.values()) {
            if (command != CommandWord.UNKNOWN) {
                validCommands.put(command.toString(), command);
            }
        }
    }

    public CommandWord getCommandWord(String commandWord) {
        CommandWord command = validCommands.get(commandWord);
        if (command != null) {
            return command;
        } else {
            return CommandWord.UNKNOWN;
        }
    }

    public boolean isCommand(String aString) {
        return validCommands.containsKey(aString);
    }

    public String showAll() {
        
        String s = "'go' to go to a room\n"
                + "'quit' to quit the game\n"
                + "'take' to take an item from a room\n"
                + "'choose' to choose from a dialogue option\n"
                + "'journal' to look at your current quest\n"
                + "'inspect' to inspect the current room\n"
                + "'approach' to approach a given NPC \n";
        
        return s;
    }
}
