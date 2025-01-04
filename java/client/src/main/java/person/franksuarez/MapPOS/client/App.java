/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.franksuarez.MapPOS.client;

import java.io.IOException;
import person.franksuarez.MapPOS.client.ui.MapSwingUI;
import person.franksuarez.MapPOS.client.ui.NCRDynakey;



enum SubApp {    
    MAPSWINGUI,
    NCRDYNAKEY,
}


/**
 *
 * @author franksuarez
 */
public class App {
    public static void main(String[] args) throws IOException {
        SubApp n = SubApp.NCRDYNAKEY;
        
        switch (n) {
            case MAPSWINGUI -> {
                MapSwingUI.main(args);
            }
            case NCRDYNAKEY -> {
                NCRDynakey.main(args);
            }
            default -> {}
        }
        
        
    }
}
