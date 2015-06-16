/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maja.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import maja.utility.RadSBazom;

/**
 *
 * @author Maja
 */
public abstract class Obrada {
    protected Connection veza;
    protected PreparedStatement izraz;
    protected ResultSet rs;

    public Obrada() {
    veza=RadSBazom.dohvatiInstancu().getVeza();
    }
}
