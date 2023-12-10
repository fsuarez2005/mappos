/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.franksuarez.MapPOS.model;




/**
 *
 * @author franksuarez
 */
public class UPC {
    private byte[] ASCII;

    // uses less memory than char type
    private byte[] data;
    
    // ---------------------------------------------
    
    public UPC() {
    }

    /**
     * Returns a String representation of UPC digits.
     * @todo
     * @return 
     */
    @Override
    public String toString() {
        
        // TODO
        return "";
        
    }

    public void setDigitAt(int index, byte value) {
        this.data[index] = value;     
    }
    
    public byte getDigitAt(int index) {
        return this.data[index];
    }
    
    /**
     * 
     */
    public void initializeValues() {
        
        // initialize ASCII table
        this.ASCII = new byte[128];
        this.ASCII['0'] = 0;
        this.ASCII['1'] = 1;
        this.ASCII['2'] = 2;
        this.ASCII['3'] = 3;
        this.ASCII['4'] = 4;
        this.ASCII['5'] = 5;
        this.ASCII['6'] = 6;
        this.ASCII['7'] = 7;
        this.ASCII['8'] = 8;
        this.ASCII['9'] = 9;
        
        
        
        
    }
    
    /** converts String of digits to byte[]
     * 
     * @param numStr
     * @return 
     */
    public byte[] convertStringToByteArray(String numStr) { 
        byte[] numBytes = new byte[numStr.length()];
        for(int n = 0; n < numStr.length(); n++) {
            char digitChar = numStr.charAt(n);
            int digit = Character.digit(digitChar, 10);
            numBytes[n] = (byte) digit;
        }
        
        return numBytes;
    }
    
    
    /**
     * 
     * @return 
     */
    public int calculateCheckDigit() {
        
        int checksum = 0;
        
        checksum = 
                this.data[0] +
                this.data[2] +
                this.data[4] +
                this.data[6] +
                this.data[8] +
                this.data[10];
        
        checksum *= 3;
        
        checksum =
                checksum +
                this.data[1] +
                this.data[3] +
                this.data[5] +
                this.data[7] +
                this.data[9];
        
        checksum %= 10;
        
        if (checksum != 0) {
            checksum = 10 - checksum;
        }
        
        return checksum; 
    }
    
    /**
     * 
     * @param upcStr 
     */
    public void setData(String upcStr) {
        this.initializeValues();
        this.data = new byte[upcStr.length()];
        
        for(int n = 0; n < upcStr.length();n++) {
            char c = upcStr.charAt(n);
            
            this.data[n] = this.ASCII[c];
            
            
            //System.out.println("n = "+n+" char = "+(int)c+" value = "+this.data[n]);
        
        }
    }
    
    
    /**
     * 
     * @return 
     */
    // TODO: public void setData(byte[] byteArr) {}
    public byte[] getBytes() {
        return this.data;
    }
    

            
}
