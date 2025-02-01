// TODO: header

package person.franksuarez.MapPOS.common.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 *
 * @author franksuarez
 */
public class PLUList {
    private Map<Integer,String> plu_s = new HashMap<>();
    
    public void put(int pluNumber, String pluName) {
        this.plu_s.put(pluNumber, pluName);
    }
    
    public void remove(int pluNumber) {
        this.plu_s.remove(pluNumber);
    }
    
    public int size() {
        return this.plu_s.size();
    }
    
    
    public Set<Integer> keySet() {
        return this.plu_s.keySet();
    }
    
    
    public void loadFromCSVResource(String resName) throws IOException {
        String separator = "\t";
        
        
        InputStreamReader isr;
        BufferedReader br;
        
        
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(resName);
        
        isr = new InputStreamReader(is);
        br = new BufferedReader(isr);
        
        
        String line;
        
        while ((line = br.readLine()) != null) {
            String[] entry = line.split(separator);
            this.put(Integer.parseInt(entry[1]), entry[0]);
        }
    }
    
    public String get(int pluNumber) {
        return this.plu_s.get(pluNumber);
    }
    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        for (int n: this.plu_s.keySet()) {
            sb.append(String.format("(%d,%s),",n,this.plu_s.get(n) ));
        }
        
        return sb.toString();
    }
    
}
