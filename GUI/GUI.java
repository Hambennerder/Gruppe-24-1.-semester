/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author joakim
 */
public class GUI extends Application {
    
    public static Stage stage;
    
    public Stage getStage(){
        return stage;
    }
    
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLStartScreen.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        this.stage = stage;
    }
}
