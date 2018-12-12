
package worldofzuul.gamefunctionality;

import worldofzuul.Player;

public class PlayerTransporter {
    
    private static Player player;
    
    public static void setPlayer(Player player) {
        PlayerTransporter.player = player;        
    }
    
    public static Player getPlayer() {
        return player;
    }
}
