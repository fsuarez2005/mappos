/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.franksuarez.MapPOS.client;

import java.io.IOException;
import person.franksuarez.MapPOS.client.ui.MapSwingUI;
import person.franksuarez.MapPOS.client.ui.TextPOS;


enum SubApp {
    TEXTPOS,
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
            case TEXTPOS -> {
                TextPOS tpos = new TextPOS();
                tpos.start();
            }
            case MAPSWINGUI -> {
                MapSwingUI m = new MapSwingUI();
                m.setVisible(true);
            }
            default -> {}
        }
        
        
    }
}
