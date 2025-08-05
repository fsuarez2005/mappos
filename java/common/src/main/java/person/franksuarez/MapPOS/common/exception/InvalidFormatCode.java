/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.franksuarez.MapPOS.common.exception;

/**
 *
 * @author franksuarez
 */
public class InvalidFormatCode extends Exception {

    public InvalidFormatCode() {
    }

    public InvalidFormatCode(String message) {
        super(message);
    }

    public InvalidFormatCode(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidFormatCode(Throwable cause) {
        super(cause);
    }

    public InvalidFormatCode(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    
}
