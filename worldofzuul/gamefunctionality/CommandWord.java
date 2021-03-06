package worldofzuul.gamefunctionality;

public enum CommandWord {
    GO("go"), QUIT("quit"), HELP("help"), TAKE("take"), CHOOSE("choose"), JOURNAL("journal"),
    INSPECT("inspect"), APPROACH("approach"), BEGIN("begin"),YES("yes"), NO("no"), FIGHT("fight"),
    FLEE("flee"), ATTACK("attack"), HEAL("heal"), WITTY("witty"),
    BRAG("brag"), SPECIAL("special"), BACK("back"), UNKNOWN("?");

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
