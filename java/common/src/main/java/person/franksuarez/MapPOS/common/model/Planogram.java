// TODO: header

package person.franksuarez.MapPOS.common.model;

import java.util.List;

/** Planogram model.
 *
 * Ontology:
 *  * Planograms model a 3D space of non-overlapping Products.
 *  * Products are always inline in depth.
 *  * Products cannot cross boundaries with other Products.
 *  * Some fixtures have shelves.
 *  * Some fixtures have pegs.
 * 
 * 
 * Planograms (POG) are usually a grid, specifying the peg where products are hung.
 * @author franksuarez
 */
public class Planogram {
    // planogram id
    private int id;
    private int fixtureId;
    
    
    private int[] shelves;
    
    
   
    private List<Cell> cells;
    
    
    
    public static class Cell {
        private int height;
        private int width;
        
    
    
    
    }
    
}
