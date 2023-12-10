/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

/**
 *
 * @author franksuarez
 */
public class Utility {

    /** 
     * Converts String of digits to byte[]
     * 
     * @param numStr
     * @return 
     */
    public static byte[] convertStringToByteArray(String numStr) { 
        byte[] numBytes = new byte[numStr.length()];
        for(int n = 0; n < numStr.length(); n++) {
            char digitChar = numStr.charAt(n);
            int digit = Character.digit(digitChar, 10);
            numBytes[n] = (byte) digit;            
        }

        return numBytes;
    }
}
