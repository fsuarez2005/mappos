/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.franksuarez.MapPOS.model;

import java.util.function.Predicate;
import person.franksuarez.MapPOS.exception.InvalidFormat;

/**
 *
 * @author franksuarez
 */
public class UPC {

    public static int charToInt(char c) throws InvalidFormat {
        int intDigit = 0;
        switch (c) {
            case '0' -> {
                intDigit = 0;
            }
            case '1' -> {
                intDigit = 1;
            }
            case '2' -> {
                intDigit = 2;
            }
            case '3' -> {
                intDigit = 3;
            }
            case '4' -> {
                intDigit = 4;
            }
            case '5' -> {
                intDigit = 5;
            }
            case '6' -> {
                intDigit = 6;
            }
            case '7' -> {
                intDigit = 7;
            }
            case '8' -> {
                intDigit = 8;
            }
            case '9' -> {
                intDigit = 9;
            }
            default -> {
                throw new InvalidFormat();
            }
        }
        return intDigit;
    }

    protected char[] charData; // some UPCs have non-numeral characters

    protected int[] data; // many UPCs have only numeral characters

    protected int formatLength = 0;

    
    protected Predicate<Character> isCharValid; // returns true if char is valid for this UPC

    private boolean isValid = false;

    public UPC() {
        this.isCharValid = (Character c) -> true;
    }

    public void setData(int[] data) {
        this.data = data;
    }
    
    public int[] getData() {
        return this.data;
    }

    public char[] getCharData() {
        return charData;
    }

    public void setCharData(char[] charData) {
        this.charData = charData;
    }

    public Predicate<Character> getIsCharValid() {
        return isCharValid;
    }

    public void setIsCharValid(Predicate<Character> isCharValid) {
        this.isCharValid = isCharValid;
    }

    public boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }
    
    public void fromString(String dataString) {
        this.charData = dataString.toCharArray();
    }

    public void generateDigitOnlyData() throws InvalidFormat {
        this.data = new int[this.charData.length];

        if (this.charData == null) {
            throw new NullPointerException();
        }
        for (int n = 0; n < this.charData.length; n++) {
            //int intDigit = UPC.charToInt(c);
            int intDigit = UPC.charToInt(this.charData[n]);
            this.data[n] = intDigit;
        }
    }

    

    /** Checks each Char of charData to see if it passes isCharValid(char).
     *
     *
     * @return 
     */
    public boolean areAllCharsValid() {
        boolean allValid = true;
        
        for (char c : charData) {
            if (!isCharValid.test(c)) {
                return false;
            }
        }
        
        return allValid;
    }


    public void setFormatLength(int formatLength) {
        this.formatLength = formatLength;
    }

    public int getFormatLength() {
        return this.formatLength;
    }

    /**
     *
     * @return The UPC as a list of the digits.
     */
    @Override
    public String toString() {
        return String.valueOf(this.charData);
    }

}
