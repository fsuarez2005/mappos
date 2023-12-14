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
    private boolean[][][] barcodePatterns; 
    
    private int[] data;
    
    public UPC() {}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
         
        for(int d: data) {
            sb.append(d);
        }
        System.out.printf("%s", sb.toString());
        return sb.toString();
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
        if (! isFormattedCorrectly(upcStr) ) {
            System.err.println("UPC not formatted correctly.");
            
        }
        
        this.data = new int[upcStr.length()];
        
        for(int n = 0; n < upcStr.length();n++) {
            char c = upcStr.charAt(n);
            this.data[n] = Character.digit(c,10);
        }
    }

    
    public int[] toIntArray() {
        return this.data;
        
    }
    
    public boolean hasValidCheckDigit() {
        // todo
        int checkDigit = calculateCheckDigit();
        return (this.data[11] == checkDigit);
    }
    
    public static boolean isFormattedCorrectly(String dataStr) {
        int dataStrLen = dataStr.length();

        // has 12 digits
        boolean correctLength = 12 == dataStrLen;
    
        // only has digits
        boolean onlyHasDigits = true;
        for (int n = 0; n < dataStrLen; n++) {
            if( ! Character.isDigit(dataStr.charAt(n)) ) {
                onlyHasDigits = false;
                break;
            }
        }
        return (correctLength && onlyHasDigits);
    }  
    
    
    public void generateBarcode() {
        
        // bar patterns for beginning, middle and end
        boolean[] startPattern = new boolean[] {true, false, true};
        boolean[] middlePattern = new boolean[] {true, false, true, false, true};
        boolean[] endPattern = new boolean[] {true, false, true};
        
        // bar patterns for each digit
        // top array is 0 for left and 1 for right
        boolean[][][] patterns = new boolean[2][10][7];
        
        // TODO: combine patterns into an initializer
        patterns[0][0] = new boolean[] {false,false,false,true,true,false,true};
        patterns[0][1] = new boolean[] {false,false,true,true,false,false,true};
        patterns[0][2] = new boolean[] {false,false,true,false,false,true,true};
        patterns[0][3] = new boolean[] {false,true,true,true,true,false,true};
        patterns[0][4] = new boolean[] {false,true,false,false,false,true,true};
        patterns[0][5] = new boolean[] {false,true,true,false,false,false,true};
        patterns[0][6] = new boolean[] {false,true,false,true,true,true,true};
        patterns[0][7] = new boolean[] {false,true,true,true,false,true,true};
        patterns[0][8] = new boolean[] {false,true,true,false,true,true,true};
        patterns[0][9] = new boolean[] {false,false,false,true,false,true,true};

        patterns[1][0] = new boolean[] {true,true,true,false,false,true,false};
        patterns[1][1] = new boolean[] {true,true,false,false,true,true,false};
        patterns[1][2] = new boolean[] {true,true,false,true,true,false,false};
        patterns[1][3] = new boolean[] {true,false,false,false,false,true,false};
        patterns[1][4] = new boolean[] {true,false,true,true,true,false,false};
        patterns[1][5] = new boolean[] {true,false,false,true,true,true,false};
        patterns[1][6] = new boolean[] {true,false,true,false,false,false,false};
        patterns[1][7] = new boolean[] {true,false,false,false,true,false,false};
        patterns[1][8] = new boolean[] {true,false,false,true,false,false,false};
        patterns[1][9] = new boolean[] {true,true,true,false,true,false,false};
        
        
        // array indicies for each digit
        // 0 to 11
        int[] barcodeIndex = {
            // start
            0,
            // left
            3, 10, 17, 24, 31, 38,
            // middle
            45,
            //right
            50,57,64,71,78,85,
            //end
            92
        };
        
        // barcode 
        boolean[] barcode = new boolean[95];
        
        // start
        for(int n = 0; n < 3; n++) {
            
            
        }
        // middle
        
        
        
        // end
        
        // 3 + 7*6 + 5 + 7*6 + 3
        // 2*3 + 12*7 + 5
        
        
        
        // beginning 101
        
        
        
        
        
        // left 
        
        // middle 10101
        
        // right
        
        // ending 101
        
        
        /*
        Start "101"
        End "101"
        Middle "10101"
        
        Left
        0 "0001101"
        1 "0011001"
        2 "0010011"
        3 "0111101"
        4 "0100011"
        5 "0110001"
        6 "0101111"
        7 "0111011"
        8 "0110111"
        9 "0001011"
        
        Right
        
        patterns[0][0] = new boolean[] {false,false,false,true,true,false,true};
        patterns[0][1] = new boolean[] {false,false,true,true,false,false,true};
        patterns[0][2] = new boolean[] {false,false,true,false,false,true,true};
        patterns[0][3] = new boolean[] {false,true,true,true,true,false,true};
        patterns[0][4] = new boolean[] {false,true,false,false,false,true,true};
        patterns[0][5] = new boolean[] {false,true,true,false,false,false,true};
        patterns[0][6] = new boolean[] {false,true,false,true,true,true,true};
        patterns[0][7] = new boolean[] {false,true,true,true,false,true,true};
        patterns[0][8] = new boolean[] {false,true,true,false,true,true,true};
        patterns[0][9] = new boolean[] {false,false,false,true,false,true,true};

        */
        
        
        
    }

    public void tempGenerateCode() {
        boolean[][][] patterns = new boolean[2][10][7];
        
        String[] codes = new String[] {
            "0001101",
            "0011001",
            "0010011",
            "0111101",
            "0100011",
            "0110001",
            "0101111",
            "0111011",
            "0110111",
            "0001011"
        };
        
        boolean isLeftSide = false;
        for(int n = 0; n < codes.length; n++) {
            int side;
            
            if (isLeftSide) {
                side = 0;
            } else {
                side = 1;
            }
            
            
            System.out.printf("patterns[%d][%d] = new boolean[] {",side,n);
            for(int m = 0; m < codes[n].length();m++) {
                char codeChar = codes[n].charAt(m);
                
                if (! isLeftSide) {
                    if (codeChar == '0') {
                        codeChar = '1';
                    } else {
                        codeChar = '0';
                    }
                }
                
                
                if (codeChar == '0') {
                    System.out.print("false");
                    
                } else {
                    System.out.print("true");
                }
                    
                if (m < codes[n].length() - 1) {
                    System.out.print(",");
                    
                    
                }
            }
            
            System.out.println("};");
            
            
        }
        
        
    }
    
    
    
    
    
}


