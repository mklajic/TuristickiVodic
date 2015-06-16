package maja.controller;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import maja.model.Kategorije;
import maja.model.Rejting;
import maja.model.TockaInteresa;
import maja.utility.RadSBazom;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maja
 */
public class ObradaTockaInteresa extends Obrada{
    
   public ObradaTockaInteresa(){
       super();
   }
    
     public boolean provjeraNazivaUnos(String naziv){
        boolean postoji=false;
        
        try {
            izraz = veza.prepareStatement("select * from tockaInteresa where naziv=?");
            izraz.setString(1, naziv);
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
   
    public List<TockaInteresa> getTockaInteresa(String uvjet){
        List<TockaInteresa> lista= new ArrayList<>();
        try {
            izraz=veza.prepareStatement("select * from tockaInteresa where naziv like ?");
            izraz.setString(1, "%" + uvjet + "%");
            rs=izraz.executeQuery();
           TockaInteresa t;
           Kategorije k;
           Rejting r;
            while(rs.next()){
                t= new TockaInteresa();
                t.setSifra(rs.getInt("sifra"));
                t.setNaziv(rs.getString("naziv"));
                t.setAdresa(rs.getString("adresa"));
                t.setKratakOpis(rs.getString("kratakOpis"));
                t.setDetaljanOpis(rs.getString("detaljanOpis"));
                t.setPutanja(rs.getString("putanja"));
                lista.add(t);
            }
                rs.close();
                izraz.close();
                
                for (TockaInteresa tockaInteresa : lista) {
                List<Kategorije> kategorije = new ArrayList<>();
                
                izraz=veza.prepareStatement(
                        " select c.sifra, c.nazivKategorije\n" +
                        "from tockainteresa a \n" +
                        "inner join vezakategorija b on a.sifra=b.tockaInteresa\n" +
                        "inner join kategorija c on c.sifra=b.kategorija\n" +
                        "where a.sifra=?");
                izraz.setInt(1, tockaInteresa.getSifra());
                rs=izraz.executeQuery();
                while(rs.next()){
                    
                    k=new Kategorije();
                    k.setSifra(rs.getInt("sifra"));
                    k.setNazivKategorije(rs.getString("nazivKategorije"));
                    kategorije.add(k);
                }
                rs.close();
                izraz.close();
                tockaInteresa.setKategorije(kategorije);
                    
            }
                
                 for (TockaInteresa tockaInteresa : lista) {
                List<Rejting> rejting = new ArrayList<>();
                izraz=veza.prepareStatement(
                        "select \n" +
                        "b.sifra, b.datum, b.komentar, b.ocjena\n" +
                        "from tockainteresa a \n" +
                        "inner join rejting b on a.sifra=b.tockaInteresa\n" +
                        "where a.sifra=? ");
                izraz.setInt(1, tockaInteresa.getSifra());
                rs=izraz.executeQuery();
                while(rs.next()){

                    r= new Rejting();
                    r.setSifra(rs.getInt("sifra"));
                    r.setDatum(rs.getDate("datum"));
                    r.setKomentar(rs.getString("komentar"));
                    r.setOcjena(rs.getInt("ocjena"));
                    rejting.add(r);
                }
                rs.close();
                izraz.close();
                tockaInteresa.setRejting(rejting);
                    
            }
                
        } catch (Exception e) {
        e.printStackTrace();
        }
        return lista;
    }
    
        public TockaInteresa dodaj(TockaInteresa t) {
        try {
            veza.setAutoCommit(false);
            izraz = veza.prepareStatement(
                    "insert into tockaInteresa (naziv,adresa,kratakOpis,detaljanOpis, putanja) values (?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            postaviVrijednostiUIzraz(t);
            izraz.executeUpdate();
            rs = izraz.getGeneratedKeys();
            rs.next();
            t.setSifra(rs.getInt(1));
            rs.close();
            
            izraz = veza.prepareStatement(
                    "insert into vezaKategorija (tockaInteresa,kategorija) values (?,?)");
            
            izraz.setInt(1, t.getSifra());
            for (Kategorije k : t.getKategorije()) {
            izraz.setInt(2, k.getSifra());
            izraz.executeUpdate();
            }
            
//            veza.commit();
            veza.setAutoCommit(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return t;
    }

    public boolean promjeni(TockaInteresa t) {
        try {
            veza.setAutoCommit(false);
            izraz = veza.prepareStatement(
                    "update tockaInteresa set naziv=?,adresa=?,kratakOpis=?,detaljanOpis=?, putanja=? where sifra=?");
            postaviVrijednostiUIzraz(t);
            izraz.setInt(6, t.getSifra());  
            izraz.executeUpdate();
            
            izraz = veza.prepareStatement(
                    "delete from vezaKategorija where tockaInteresa=?");
            izraz.setInt(1, t.getSifra());
            izraz.executeUpdate();
            izraz = veza.prepareStatement(
                    "insert into vezaKategorija (tockaInteresa,kategorija) values (?,?)");
            
            izraz.setInt(1, t.getSifra());
            for (Kategorije k : t.getKategorije()) {
            izraz.setInt(2, k.getSifra());
            izraz.executeUpdate();
            }
            
           veza.commit();
            veza.setAutoCommit(true);
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean obrisi(TockaInteresa t) {
        
         try {
            veza.setAutoCommit(false);
            izraz = veza.prepareStatement(
                    "delete from vezaKategorija where tockaInteresa=?");

            izraz.setInt(1, t.getSifra());
            izraz.executeUpdate();
            izraz = veza.prepareStatement(
                    "delete from tockaInteresa where sifra=?");

            izraz.setInt(1, t.getSifra());
            izraz.executeUpdate();
            
            veza.commit();
            veza.setAutoCommit(true);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
//        try {
//            izraz = veza.prepareStatement(
//                    "delete from tockaInteresa where sifra=?");
//            izraz.setInt(1, t.getSifra());
//            izraz.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//
//        return true;
    }
    
    

    private void postaviVrijednostiUIzraz(TockaInteresa t) throws SQLException {

        izraz.setString(1, t.getNaziv());
        //ta lozinka mora biti u md5 hash
        izraz.setString(2, t.getAdresa());
        izraz.setString(3, t.getKratakOpis());
        izraz.setString(4, t.getDetaljanOpis());
        izraz.setString(5, t.getPutanja());
       
    }
    
    
}
