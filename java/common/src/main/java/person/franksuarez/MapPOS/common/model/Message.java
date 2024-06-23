/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.franksuarez.MapPOS.common.model;

/**
 *
 * @author franksuarez
 */
public class Message implements java.io.Serializable {
    public static enum Command {
        TRANSACTION,
        INQUIRY,
        VERSION,
        STATUS,
        DEBUG,
        
    }
    
    public String debugString;
    public Command messageCommand;
    
    
    public Message() {
        
    }
    
    
}
