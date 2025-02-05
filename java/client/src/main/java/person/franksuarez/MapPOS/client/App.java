// TODO: header

package person.franksuarez.MapPOS.client;

import java.io.IOException;
import person.franksuarez.MapPOS.client.ui.MapSwingUITest;
import person.franksuarez.MapPOS.client.ui.NCRDynakey;
import person.franksuarez.MapPOS.client.ui.SimplePOSGUI;

enum SubApp {    
    MAPSWINGUI,
    NCRDYNAKEY,
    SIMPLEPOSGUI
}

/**
 *
 * @author franksuarez
 */
public class App {
    public static void main(String[] args) throws IOException {
        // TODO: make subapp user selectable
        SubApp n = SubApp.SIMPLEPOSGUI;
        
        switch (n) {
            case MAPSWINGUI -> {
                MapSwingUITest.main(args);
            }
            case NCRDYNAKEY -> {
                NCRDynakey.main(args);
            }
            case SIMPLEPOSGUI -> {
                SimplePOSGUI.main(args);
            }
            default -> {}
        }
        
        
    }
}
