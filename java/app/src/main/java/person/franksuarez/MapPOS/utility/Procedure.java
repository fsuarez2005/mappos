/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.franksuarez.MapPOS.utility;

// https://stackoverflow.com/questions/23868733/java-8-functional-interface-with-no-arguments-and-no-return-value

/**
 * Procedure is a Function that accepts nothing and returns nothing.
 * 
 * @author franksuarez
 */

@FunctionalInterface
public interface Procedure {
    void run();

    default Procedure andThen(Procedure after){
        return () -> {
            this.run();
            after.run();
        };
    }

    default Procedure compose(Procedure before){
        return () -> {
            before.run();
            this.run();
        };
    }
}