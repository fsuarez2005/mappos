/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.franksuarez.MapPOS.common;

import java.nio.file.Paths;
import java.sql.SQLException;
import java.sql.Statement;
import person.franksuarez.MapPOS.common.model.SQLiteDatabase;

/**
 *
 * @author franksuarez
 */
public class App {
    public void test1() throws SQLException {
        SQLiteDatabase db = new SQLiteDatabase(
                Paths.get("/tmp/mappos_test_sqlite.db")
        );
        
        db.initialize();
        Statement stmt = db.getConnection().createStatement();
        
        
    }
    
    
    
    public static void main(String[] args) throws SQLException {
        System.out.println("common.App");
        
        App a = new App();
        a.test1();
        
        
    }
}
