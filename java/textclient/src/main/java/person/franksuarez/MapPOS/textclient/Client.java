// Purpose: provide the text interface
package person.franksuarez.MapPOS.textclient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author franksuarez
 */
public class Client {

    private Shell shell;
    

    public Client() {
        this.shell = new Shell();
    }
    
    public void startShell() throws IOException {
        this.shell.start();    
    }
    

}
