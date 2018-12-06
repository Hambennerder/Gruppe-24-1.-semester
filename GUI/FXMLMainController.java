/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import worldofzuul.gamefunctionality.Command;
import worldofzuul.gamefunctionality.Game;
import worldofzuul.gamefunctionality.Launcher;

/**
 * FXML Controller class
 *
 * @author joakim
 */
public class FXMLMainController implements Initializable{
    Game g = new Game();
    
    String text;
    
    private boolean finished = false;
    @FXML
    private TextArea output;
    @FXML
    private TextField console;
    @FXML
    private Button sendBtn;
    @FXML
    private ListView<?> lvInv;
    @FXML
    private ListView<?> lvEx;

    public String loop (String s){
        if (!finished) {
            Command command = g.parser.getCommand(s);
            System.out.println(g.processCommand(command));
            s = g.processCommand(command);
        } else {
        System.out.println("Thank you for playing. Good bye.");
        }
        return s;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
   public void initialize(URL url, ResourceBundle rb) {
        // TODO
                output.setText("Welcome blargh, to the world of SDUUL.\n\n"
                + "An adventurous text-based rpg game that tackles the life being a new\n"
                + "university student in the most boring of fashion, we will show you the\n"
                + "everchanging day to day life in a comedic way.\n\n"
                + "This game consists of various quests and obstacles, which you as a\n"
                + "player must overcome continue. You might be rewarded, and\n"
                + "ultimately be prepared for how boring studying can be.\n\n"
                + "DISCLAIMER: 9/10 feminists want the creators behind this game in jail."
                + "\n\nType begin to start your adventure!");
                g.play();
    }

    
    
    public void setOutput(String text) {
        output.setText(text);
    }

    public void addLine(String line) {
        output.setText(output.getText() + " " + line);
    }

    public void clearOutput() {
        output.clear();
    }
    
    public String getText(){
        return text;
    }

    @FXML
    public void handleSendBtn(ActionEvent event) {
        output.setText(loop(console.getText()));
        console.clear();
        System.out.println(g.getS());
    }

}
