/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import worldofzuul.Item;
import worldofzuul.gamefunctionality.Command;
import worldofzuul.gamefunctionality.Game;
import worldofzuul.gamefunctionality.PlayerTransporter;

/**
 * FXML Controller class
 *
 * @author joakim
 */
public class FXMLMainController extends FXMLStartScreenController implements Initializable {

    ObservableList<String> showInventory = FXCollections.observableArrayList();
    ObservableList<String> showExits = FXCollections.observableArrayList();

    Game g = new Game();

    @FXML
    private TextArea output;
    @FXML
    private TextField console;
    @FXML
    private Button sendBtn;
    @FXML
    private ListView<String> lvInv;
    @FXML
    private ListView<String> lvEx;
    @FXML
    private TextArea location;
    @FXML
    private Text playerNameHP;
    @FXML
    private Text enemyNameHP;
    @FXML
    private TextArea setPlayerHP;
    @FXML
    private TextArea setEnemyHP;

    private String loop(String s) throws Exception {
        showInventory.clear();
        showExits.clear();
        if (!g.getFinished()) {
            Command command = g.parser.getCommand(s);
            s = g.processCommand(command);
        } else {
            return "Thank you for playing. Good bye.";
        }
        addInventory();
        addExits();

        location.setText(g.currentRoom.getName());
        playerNameHP.setText(g.player.getName());
        setPlayerHP.setText(g.player.getStringHealth());

        if (g.currentRoom.hasEncounter()) {
            enemyNameHP.setText(g.currentRoom.getEncounter().getName());
            //setEnemyHP.setText(g.currentRoom.getEncounter().getHealth());
        }
        return s;
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        g.player = PlayerTransporter.getPlayer();
                output.setText("Welcome "+g.player.getPlayerName()+", to the world of SDUUL.\n\n"
                + "An adventurous text-based rpg game that tackles the life being a new\n"
                + "university student in the most boring of fashion, we will show you the\n"
                + "everchanging day to day life in a comedic way.\n\n"
                + "This game consists of various quests and obstacles, which you as a\n"
                + "player must overcome continue. You might be rewarded, and\n"
                + "ultimately be prepared for how boring studying can be.\n\n"
                + "DISCLAIMER: 9/10 feminists want the creators behind this game in jail."
                + "\n\nType begin to start your adventure!");
        g.play();

        lvInv.setItems(showInventory);
        lvEx.setItems(showExits);
    }

    public void addInventory() {
        for (Item item : g.player.inventory) {
            showInventory.add(item.getName());
        }
    }

    public void addExits() {
        Set<String> keys = g.currentRoom.exits.keySet();
        for (String exit : keys) {
            showExits.add(exit);
        }
    }

    @FXML
    public void handleSendBtn(ActionEvent event) throws Exception {
        output.setText(loop(console.getText()));
        console.clear();
    }

    @FXML
    private void enterButton(KeyEvent event) throws Exception {
        if (event.getCode() == KeyCode.ENTER) {
            output.setText(loop(console.getText()));
            console.clear();
        }
    }

}
