package worldofzuul.gamefunctionality;


public enum CommandWord
{
    GO("go"), QUIT("quit"), HELP("help"), TAKE("take"), EQUIP("equip"), CHOOSE("choose"), JOURNAL("journal"),
    DROP("drop"), INSPECT("inspect"), APPROACH("approach"), INVENTORY("inventory"), UNKNOWN("?");
    
    private String commandString;
    
    CommandWord(String commandString){
        this.commandString = commandString;
    }
    
    @Override
    public String toString() {
      return commandString;
    } 

}
