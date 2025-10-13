// Purpose: provide the text interface
package person.franksuarez.MapPOS.textclient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 *
 * @author franksuarez
 */
public class Client {

    public Shell shell;
    
    // client contains lower level I/O
    // while shell is for parsing
    
    
    private InputStream in;
    private OutputStream out;

    private BufferedReader reader;
    private BufferedWriter writer;
    
    

    public Client() {
        this.in = System.in;
        this.out = System.out;

        this.reader = new BufferedReader(new InputStreamReader(this.in));
        this.writer = new BufferedWriter(new OutputStreamWriter(this.out));

        
        
    }
    
    public void startShell() throws IOException {
        this.shell = new Shell();
        this.shell.setReader(reader);
        this.shell.setWriter(writer);
        
        this.shell.start();    
    }
    

}
