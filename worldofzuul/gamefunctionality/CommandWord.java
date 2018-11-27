package worldofzuul.gamefunctionality;

public enum CommandWord {
    GO("go"), QUIT("quit"), HELP("help"), TAKE("take"), CHOOSE("choose"), JOURNAL("journal"),
    INSPECT("inspect"), APPROACH("approach"), INVENTORY("inventory"), EXITS("exits"), UNKNOWN("?");

    // EQUIP("equip") to be implemented
    // DROP("drop") to be implemented
    private String commandString;

    CommandWord(String commandString) {
        this.commandString = commandString;
    }

    @Override
    public String toString() {
        return commandString;
    }

}
