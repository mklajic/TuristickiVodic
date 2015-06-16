/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maja.controller;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import maja.model.Operater;

/**
 *
 * @author Maja
 */
public class ObradaOperater extends Obrada{
    
    public ObradaOperater(){
        super();
          }
 
    public boolean provjeraKorisnickoImeUnos(String korisnickoIme){
        boolean postoji=false;
        
        try {
            izraz = veza.prepareStatement("select sifra from operater where korisnickoime=?");
            izraz.setString(1, korisnickoIme);
            rs = izraz.executeQuery();
            while (rs.next()) {
                postoji=true;
            }
            rs.close();
            izraz.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return postoji;
    }
    
    
    public boolean provjeraKorisnickoImePromjena(String korisnickoIme, int sifra){
        boolean postoji=false;
        
        try {
            izraz = veza.prepareStatement("select sifra from operater where korisnickoime=? and sifra!=?");
            izraz.setString(1, korisnickoIme);
            izraz.setInt(2, sifra);
            rs = izraz.executeQuery();
            while (rs.next()) {
                postoji=true;
            }
            rs.close();
            izraz.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return postoji;
    }

    public List<Operater> getOperateri(String uvjet) {
        List<Operater> lista = new ArrayList<>();
        try {
            izraz = veza.prepareStatement("select * from operater where ime like ? or prezime like ? or korisnickoime like ?");
            izraz.setString(1, "%" + uvjet + "%");
            izraz.setString(2, "%" + uvjet + "%");
            izraz.setString(3, "%" + uvjet + "%");
            rs = izraz.executeQuery();
            Operater t;
            while (rs.next()) {
                t = new Operater();
                t.setSifra(rs.getInt("sifra"));
                t.setKorisnickoIme(rs.getString("korisnickoIme"));
                t.setIme(rs.getString("ime"));
                t.setPrezime(rs.getString("prezime"));
                t.setLozinka(rs.getString("lozinka"));
                lista.add(t);
            }
            rs.close();
            izraz.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public Operater dodaj(Operater t) {
        try {
            izraz = veza.prepareStatement(
                    "insert into operater (korisnickoime,lozinka,ime,prezime) values (?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            postaviVrijednostiUIzraz(t);
            izraz.executeUpdate();
            rs = izraz.getGeneratedKeys();
            rs.next();
            t.setSifra(rs.getInt(1));
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return t;
    }

    public boolean promjeni(Operater t) {
        try {
            izraz = veza.prepareStatement(
                    "update operater set korisnickoIme=?,lozinka=?,ime=?,prezime=? where sifra=?");
            postaviVrijednostiUIzraz(t);
              izraz.setInt(5, t.getSifra());  
            izraz.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean obrisi(Operater t) {
        try {
            izraz = veza.prepareStatement(
                    "delete from operater where sifra=?");

            izraz.setInt(1, t.getSifra());
            izraz.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
    
    public Operater getOperater(String korisnickoIme, String lozinka){
        Operater t=null; 
        try {
            izraz = veza.prepareStatement("select * from operater where korisnickoIme=? and lozinka=?");
            izraz.setString(1, korisnickoIme);
            izraz.setString(2, lozinka);
            rs = izraz.executeQuery();
            while (rs.next()) {
                t = new Operater();
                t.setSifra(rs.getInt("sifra"));
                t.setKorisnickoIme(rs.getString("korisnickoIme"));
                t.setIme(rs.getString("ime"));
                t.setPrezime(rs.getString("prezime"));
                t.setLozinka(rs.getString("lozinka"));
            }
            rs.close();
            izraz.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
         return t;
    }

    private void postaviVrijednostiUIzraz(Operater t) throws SQLException {

        izraz.setString(1, t.getKorisnickoIme());
        //ta lozinka mora biti u md5 hash
        izraz.setString(2, t.getLozinka());
        izraz.setString(3, t.getIme());
        izraz.setString(4, t.getPrezime());
    }
    
 
}
