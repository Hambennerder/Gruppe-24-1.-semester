/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import worldofzuul.gamefunctionality.Game;
import worldofzuul.gamefunctionality.PlayerTransporter;

/**
 * FXML Controller class
 *
 * @author joakim
 */
public class FXMLStartScreenController implements Initializable {
    //public String name;
    //private String age;
    //private String gender;
    Game g = new Game();

    
    @FXML
    private TextField nameSetter;
    @FXML
    private TextField ageSetter;
    @FXML
    private TextField genderSetter;
    @FXML
    private Button playBtn;
    
    
    /**
     * Initialises the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void setStartName() {
        //name = nameSetter.getText();
        g.player.setPlayerName(nameSetter.getText());
    }

    public void setStartAge() {
        //age = ageSetter.getText();
        g.player.setAge(ageSetter.getText());
    }

    public void setStartGender() {
        //gender = genderSetter.getText();
        g.player.setGender(genderSetter.getText());
    }
    
    private void nextGUI () throws IOException{
        Stage stage = GUI.stage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLMain.fxml"));
        
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    
    @FXML
    private void nextGUIButton(KeyEvent event) throws IOException{
        if (event.getCode()==KeyCode.ENTER) {
        setStartName();
        setStartAge();
        setStartGender();
       
        
       if (g.player.getPlayerName().equals("")||g.player.getAge().equals("")||g.player.getGender().equals("")){
           System.out.println("Please enter whatever");
       } else {
        PlayerTransporter.setPlayer(g.player);
        nextGUI();
        }
    }
    }
    
    @FXML
    private void handlePlayBtn(ActionEvent event) throws IOException {
        setStartName();
        setStartAge();
        setStartGender();
        
       if (this.age.equals("")||this.name.equals("")||this.gender.equals("")){
           System.out.println("Please enter whatever");
       } else {   
        PlayerTransporter.setPlayer(g.player);
        nextGUI();
    } 
    }
        
}