/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.franksuarez.MapPOS.common.model;

import java.io.Serializable;

/**
 *
 * @author franksuarez
 */
public class SerialObject implements Serializable {
    private String name;
    
    public SerialObject(String name) {
        this.name = name;
    }
}
