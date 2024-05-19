



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.junit.jupiter.api.Test;


/**
 *
 * @author franksuarez
 */
public class TestCSVData {
    
    @Test
    public void testGetResource() throws IOException {
        String resName = "plu.csv";
        
        
        InputStream r = this.getClass().getClassLoader().getResourceAsStream(resName);
        
        if (r == null) {
            throw new IllegalArgumentException(resName+" not found.");
        }
        
        
        try (
                InputStreamReader isr = new InputStreamReader(r);
                BufferedReader br = new BufferedReader(isr);
                ) {
            
            String line;
            while ((line = br.readLine()) != null) {
                String[] entry = line.split("\t");
                //System.out.println(line);
                System.out.printf("%-50s %s%n",entry[0],entry[1]);
            }
            r.close();
            
        }
        
        
    }
}
