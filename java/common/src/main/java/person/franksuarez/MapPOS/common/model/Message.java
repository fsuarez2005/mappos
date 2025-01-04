// TODO: header

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
    
    public String description;
    public String debugString;
    public Command messageCommand;
    
    public Message() {}
    public Message(Command messageCommand) {
        this.messageCommand = messageCommand;
    }
    
    
}
