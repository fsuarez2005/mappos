/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.franksuarez.MapPOS.model;

import java.util.function.Consumer;

/**
 *
 * @author franksuarez
 */
public class Command {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        // -----------------------------------
        private Consumer<String> commandCode;

        public Command(String name, Consumer<String> commandCode) {
            this.name = name;
            this.commandCode = commandCode;
        }


        // -----------------------------------
        public void apply(String arg) {
            this.commandCode.accept(arg);
        }
        
    }