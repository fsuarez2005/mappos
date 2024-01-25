/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.franksuarez.MapPOS.model;

/**
 *
 * @author franksuarez
 */
public abstract class UPC {
    protected int[] data;
    protected int formatLength = 0;
    
    public int getFormatLength() {
        return this.formatLength;
    }
    
    /**
     * 
     * @return The UPC as a list of the digits.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
         
        for(int d: data) {
            sb.append(d);
        }
        System.out.printf("%s", sb.toString());
        return sb.toString();
    }
    
}
