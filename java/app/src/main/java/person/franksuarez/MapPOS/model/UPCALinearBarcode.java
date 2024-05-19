/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.franksuarez.MapPOS.model;

/**
 *
 * @author franksuarez
 */
public class UPCALinearBarcode {
    
    // STATIC DATA
    public static int totalModules = 95;
    
    public static boolean[] startPattern;
    public static boolean[] middlePattern;
    public static boolean[] endPattern;
    
    
    public static int digitPatternLength = 7;
    // store patterns for left side
    // invert for right side
    public static boolean[][] barcodePatterns;
    
    // array indicies for each digit
    // 0 to 11
    public static int[] barcodeIndex = {
                                    // start
                                    0,
                                    // left
                                    3, 10, 17, 24, 31, 38,
                                    // middle
                                    45,
                                    //right
                                    50, 57, 64, 71, 78, 85,
                                    //end
                                    92
                                };
    
    // ==================================================
    
    
    public static String startPatternString = "101";
    public static String endPatternString = "101";
    public static String middlePatternString = "10101";
    
    public static String[] barcodePatternsString = {
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
    
    
    
    
    static {
        initializeStaticProperties();
    }
    
    public static void initializeStaticProperties() {
        // convert String patterns to boolean patterns
        try {
            startPattern = createBooleanPattern(startPatternString,false);
            endPattern = createBooleanPattern(endPatternString,false);
            middlePattern = createBooleanPattern(middlePatternString,false);
        
            barcodePatterns = new boolean[10][];
            for(int n = 0; n < barcodePatterns.length; n++) {
                barcodePatterns[n] = createBooleanPattern(barcodePatternsString[n], false);
            }
            
            
        } catch (Exception ex) {
            System.err.printf("Invalid Pattern\n");
            System.exit(-1);
            
        }
        
        
    }

    // ==================================================
    // INSTANCE DATA
    private boolean[] barcodeData;
    
    
    
    public UPCALinearBarcode() {
        initializeBarcodeData();
    
    }
    
    
    public final void initializeBarcodeData() {
        barcodeData = new boolean[totalModules];
    }
    
    
    private static boolean xor(boolean a, boolean b) {
        // https://www.baeldung.com/java-xor-operator
        return (a && !b)||(!a && b);
    }
    
    public void setStartPattern() {}
    public void setMiddlePattern() {}
    public void setEndPattern() {}
    
    
    public void setDigit(int index, int value) {
        // indexes of barcodeIndex[] that point to digits
        int[] digitIndex = {
            1,2,3,4,5,6,
            8,9,10,11,12,13
        };
        
        // get offset using index
        int offset = barcodeIndex[digitIndex[index]];
        
        
        // TODO: use System.arraycopy
        // need to copy only a small portion
        
        /*
        for(int n = 0; n < digitPatternLength; n++) {
        barcodeData[offset+n] = barcodePatterns[value][n];
        }
        */
        
        System.arraycopy(barcodePatterns[value], 0, barcodeData, offset, digitPatternLength);
        
        
    }
    
    
    public static boolean[] createBooleanPattern(String patternStr, boolean inverted) throws Exception{
        boolean[] pattern = new boolean[patternStr.length()];
        
        for(int n = 0; n < patternStr.length();n++) {
            char c = patternStr.charAt(n);
            switch(c) {
                case '0':
                    pattern[n] = xor(inverted,false);
                    break;
                case '1':
                    pattern[n] = xor(inverted,true);
                    break;
                default:
                    // TODO throw exception
                    // patternStr must only have 0 or 1
                    throw new Exception("Char "+String.valueOf(c)+" is not accepted in a pattern.");
                    
                    //break;
            }
        }
        return pattern;
    }
    
    public void printBarcodeData() {
        System.out.printf("%s\n",java.util.Arrays.toString(barcodeData) );
        
        
    }
    
    
    public static void getAllPatterns() {
        // print all the patterns for debugging
        System.out.printf("%s\n",java.util.Arrays.toString(startPattern));
        System.out.printf("%s\n",java.util.Arrays.toString(endPattern));
    }
    
    
    
    
    private void invertPattern(boolean[] pattern) {
        // TODO: invertPattern
        throw new UnsupportedOperationException();
    }
    
    private void generateBarcode() {
        // TODO: generateBarcode()
        throw new UnsupportedOperationException();
    }
    
}
