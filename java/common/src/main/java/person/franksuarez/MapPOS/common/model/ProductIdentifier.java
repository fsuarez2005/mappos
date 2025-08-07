/** ProductIdentifier.
 *
 *
 *
 *
 */
package person.franksuarez.MapPOS.common.model;

import person.franksuarez.MapPOS.common.exception.InvalidFormat;

/** ProductIdentifier contains useful utility functions.
 *
 * @author franksuarez
 */
public abstract class ProductIdentifier {

    // cache the validation test
    private boolean validated;

    private boolean hasCheckDigit;

    // should be a very generic type
    private char[] data;

    private int formatLength;

    private int checkDigitIndex;

    public ProductIdentifier() {
    }

    public ProductIdentifier(char[] data, int formatLength, boolean hasCheckDigit, boolean validated, int checkDigitIndex) {
        this.validated = validated;
        this.hasCheckDigit = hasCheckDigit;
        this.data = data;
        this.formatLength = formatLength;
        this.checkDigitIndex = checkDigitIndex;
    }

    protected abstract boolean isCharValid(char c);

    public final boolean getHasCheckDigit() {
        return hasCheckDigit;
    }

    public final void setHasCheckDigit(boolean hasCheckDigit) {
        this.hasCheckDigit = hasCheckDigit;
    }

    public final char[] getData() {
        return data;
    }

    public final void setData(char[] data) {
        this.data = data;
    }

    public final int getFormatLength() {
        return formatLength;
    }

    public final void setFormatLength(int formatLength) throws IllegalArgumentException {
        if (formatLength < 0) {
            throw new IllegalArgumentException("Format Length cannot be negative.");
        }
        this.formatLength = formatLength;
    }
    
    public final int getCheckDigitIndex() {
        return checkDigitIndex;
    }

    public final void setCheckDigitIndex(int checkDigitIndex) {
        if (checkDigitIndex < 0) {
            throw new IndexOutOfBoundsException(checkDigitIndex);
        }

        this.checkDigitIndex = checkDigitIndex;
    }

    /**
     * Checks each Char of charData to see if it passes isCharValidOld(char).
     *
     *
     * @return
     */
    public boolean areAllCharsValid() {
        if (this.validated) {
            return true;
            
        }

        boolean allValid = true;

        for (char c : this.data) {

            if (!isCharValid(c)) {
                return false;
            }
        }

        this.validated = true;

        return allValid;
    }

    public void invalidate() {
        this.validated = false;
    }

    public boolean isValid() {
        return isCorrectFormatLength() && areAllCharsValid();
    }

    public boolean isCorrectFormatLength() {
        return (getData().length == getFormatLength());
    }

    public void fromString(String dataStr) {
        setData(dataStr.toCharArray());
    }

    public int[] toIntArray() throws InvalidFormat, NullPointerException {
        if (getData() == null) {
            throw new NullPointerException();
        }

        int[] intData = new int[this.data.length];

        for (int n = 0; n < getData().length; n++) {
            int intDigit = Character.getNumericValue(getData()[n]);

            if (intDigit == -1) {
                // Character.getNumericValue returns -1 on unaccepted char
                throw new InvalidFormat();
            }

            intData[n] = intDigit;
        }
        return intData;
    }

    /**
     *
     * @return The UPC as a list of the digits.
     */
    @Override
    public String toString() {
        return String.valueOf(getData());
    }

}
