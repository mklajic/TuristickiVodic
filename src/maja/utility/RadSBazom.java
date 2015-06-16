/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maja.utility;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Maja
 */
public class RadSBazom {
    private static RadSBazom instanca;
    private Connection veza;
    
    public RadSBazom(){
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            veza=DriverManager.getConnection(
                    "jdbc:mysql://localhost/turistickiVodic?useUnicode=true&characterEncoding=UTF-8", 
                    "edunova", "edunova");
        } catch (Exception e) {
            e.printStackTrace();
        }
    
}

    public Connection getVeza() {
        return veza;
    }

    public void setVeza(Connection veza) {
        this.veza = veza;
    }
    
    public static RadSBazom dohvatiInstancu(){
        if(instanca==null){
            instanca=new RadSBazom();
        }
        return instanca;
    }
}
