/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.franksuarez.MapPOS.client;

import java.io.IOException;
import person.franksuarez.MapPOS.client.ui.MapSwingUI;



enum SubApp {    
    MAPSWINGUI,
}


/**
 *
 * @author franksuarez
 */
public class App {
    public static void main(String[] args) throws IOException {
        SubApp n = SubApp.MAPSWINGUI;
        
        switch (n) {
            case MAPSWINGUI -> {
                MapSwingUI m = new MapSwingUI();
                m.setVisible(true);
            }
            default -> {}
        }
        
        
    }
}
