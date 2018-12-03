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
import javafx.stage.Stage;
import worldofzuul.gamefunctionality.Game;

/**
 * FXML Controller class
 *
 * @author joakim
 */
public class FXMLStartScreenController implements Initializable {

    @FXML
    private TextField nameSetter;
    @FXML
    private TextField ageSetter;
    @FXML
    private TextField genderSetter;
    @FXML
    private Button playBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    Game g = new Game();
    
    public void setStartName() {
        g.setPlayerName(nameSetter.getText());
    }

    public void setStartAge() {
        g.setAge(ageSetter.getText());
    }

    public void setStartGender() {
        g.setGender(genderSetter.getText());
    }

    @FXML
    private void handlePlayBtn(ActionEvent event) throws IOException {
        setStartName();
        setStartAge();
        setStartGender();
        
       if (g.getAge().equals("")||g.getPlayerName().equals("")||g.getGender().equals("")){
           System.out.println("Please enter whatever");
       } else {
        System.out.println(g.getPlayerName()+"    "+g.getAge()+"     "+g.getGender());
        
        Stage stage = GUI.stage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLMain.fxml"));

        Parent root = loader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    } 
    }
        
}