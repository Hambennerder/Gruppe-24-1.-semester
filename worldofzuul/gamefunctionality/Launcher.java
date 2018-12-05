package worldofzuul.gamefunctionality;
import GUI.FXMLMainController;
import javafx.application.Application;

import GUI.GUI;
import worldofzuul.gamefunctionality.Game;

public class Launcher {
    
    public static void main(String[] args) throws Exception{
        FXMLMainController fm = new FXMLMainController();
        
        Application.launch(GUI.class, args);
        
        Game game = new Game();
        game.play();
        
        boolean finished = false;
        
        while (!finished) {
            Command command = game.parser.getCommand(fm.getText());
            if (command.getCommandWord().equals("quit")){
                finished = true;
            } else {
            fm.setOutput(game.processCommand(command));
            }
    }
        System.out.println("Thanks for playing");
}
}

/*  1. Få vist output i Main
    2. Få 
    3. 
*/