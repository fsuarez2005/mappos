/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.franksuarez.MapPOS.common.exception;

/**
 *
 * @author franksuarez
 */
public class InvalidIdentifier extends Exception {

    public InvalidIdentifier() {
    }

    public InvalidIdentifier(String message) {
        super(message);
    }

    public InvalidIdentifier(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidIdentifier(Throwable cause) {
        super(cause);
    }

    public InvalidIdentifier(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
