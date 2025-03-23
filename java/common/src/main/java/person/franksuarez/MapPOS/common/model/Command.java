// TODO: header
package person.franksuarez.MapPOS.common.model;

import java.util.function.Consumer;

/** TODO: class description
 *
 * @author franksuarez
 */
public class Command {

    private String name;
    private String shortDescription;
    private String usage;

    public String getShortDescription() {
        return (shortDescription != null ? shortDescription : "TODO");
    }

    public Command setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
        return this;
    }

    public String getUsage() {
        return (usage != null ? usage : "TODO");
    }

    public Command setUsage(String usage) {
        this.usage = usage;
        return this;
    }
    
    
    private Consumer<String> commandCode;

    public Command() {
        
    }
    
    public Command(String name) {
        this();
        this.name = name;
    }
    
    public Command(String name, Consumer<String> commandCode) {
        this(name);
        this.commandCode = commandCode;
    }

    public String getName() {
        return name;
    }

    public Command setName(String name) {
        this.name = name;
        return this;
    }

    public Command setCommand(Consumer<String> commandCode) {
        this.commandCode = commandCode;
        return this;
    }

    public Consumer<String> getCommand() {
        return this.commandCode;
    }

    public void accept(String arg) {
        this.commandCode.accept(arg);
    }

}
