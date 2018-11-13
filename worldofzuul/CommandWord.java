package worldofzuul;

public enum CommandWord
{
    GO("go"), QUIT("quit"), HELP("help"), TAKE("take"), EQUIP("equip"), LEAVE("leave"), CHOOSE("choose"),
    DROP("drop"), INSPECT("inspect"), TALK("talk"), ACCEPT("accept"), APPROACH("approach"), UNKNOWN("?");
    
    private String commandString;
    
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    @Override
    public String toString()
    {
        return commandString;
    }
}
