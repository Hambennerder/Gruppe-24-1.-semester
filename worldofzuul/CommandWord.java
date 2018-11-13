package worldofzuul;

public enum CommandWord{
    GO("go"), QUIT("quit"), HELP("help"), TAKE("take"), EQUIP("equip"), DROP("drop"), UNKNOWN("?");
    
    private String commandString;
    
    CommandWord(String commandString){
        this.commandString = commandString;
    }
    
    public String toString(){
        return commandString;
    }
}
