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

/**
 * FXML Controller class
 *
 * @author joakim
 */
public class FXMLMainController implements Initializable {
    public String text;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setOutput(String text){
        output.setText(text);
    }
    
    public void addLine (String line){
        output.setText(output.getText()+" "+line);
    }

    public void clearOutput(){
        output.clear();
    }
    
    public String getText(){
        return text;
    }
    
    @FXML
    private void handleSendBtn(ActionEvent event) {
        text = console.getText();
        console.clear();
    }
    
}
