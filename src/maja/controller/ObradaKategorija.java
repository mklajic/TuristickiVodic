/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maja.controller;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import maja.model.Kategorije;


/**
 *
 * @author Maja
 */
public class ObradaKategorija extends Obrada {

    public ObradaKategorija() {
    super();
    }
    
    public boolean provjeraNazivKategorije(String nazivKategorije){
        boolean postoji=false;
        
        try {
            izraz = veza.prepareStatement("select sifra from kategorija where nazivKategorije=?");
            izraz.setString(1, nazivKategorije);
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
    
     public boolean provjeraNazivKategorijePromjena(String nazivKategorije, int sifra){
        boolean postoji=false;
        
        try {
            izraz = veza.prepareStatement("select sifra from kategorija where nazivKategorije=? and sifra!=?");
            izraz.setString(1, nazivKategorije);
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
    
    
    public List<Kategorije> getKategorije(String uvjet){
        List<Kategorije> lista= new ArrayList<>();
        try {
            izraz=veza.prepareStatement("select * from kategorija where nazivKategorije like ?");
            izraz.setString(1, "%" + uvjet + "%");
            rs=izraz.executeQuery();
          Kategorije k;
            while(rs.next()){
                k = new Kategorije();
                k.setSifra(rs.getInt("sifra"));
                k.setNazivKategorije(rs.getString("nazivKategorije"));
                lista.add(k);
            }
            rs.close();
            izraz.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Kategorije dodaj(Kategorije t) {
        try {
            izraz = veza.prepareStatement(
                    
"insert into kategorija(nazivKategorije) values (?)",
                    Statement.RETURN_GENERATED_KEYS);
            izraz.setString(1, t.getNazivKategorije());
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

    public boolean promjeni(Kategorije t) {
        try {
            izraz = veza.prepareStatement(
                    "update kategorija set nazivKategorije=? where sifra=?");
            izraz.setString(1, t.getNazivKategorije());
              izraz.setInt(2, t.getSifra());  
            izraz.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean obrisi(Kategorije t) {
        try {
            izraz = veza.prepareStatement(
                    "delete from kategorija where sifra=?");

            izraz.setInt(1, t.getSifra());
            izraz.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
      
}
