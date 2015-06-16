/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maja.controller;


import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import maja.model.Rejting;
import maja.model.TockaInteresa;

/**
 *
 * @author Maja
 */
public class ObradaRejting extends Obrada{
    private Rejting r;
    private TockaInteresa t;
   public ObradaRejting(){
       super();
   }
    
   public List<Rejting> getRejting(String uvjet) {
        List<Rejting> lista = new ArrayList<>();
        
        try {
            izraz = veza.prepareStatement(
                    " select a.sifra, a.naziv, a.adresa, a.kratakOpis, a.detaljanOpis, a.putanja,\n" +
                    "b.sifra, b.tockaInteresa, b.datum, b.komentar, b.ocjena\n" +
                    "from tockainteresa a \n" +
                    "inner join rejting b on a.sifra=b.tockaInteresa\n" +
                    "where b.sifra =?");
            izraz.setInt(1, r.getSifra());
            rs = izraz.executeQuery();
           

            while (rs.next()) {
               r= new Rejting();
               t=new TockaInteresa();
               t.setSifra(rs.getInt("sifra"));
               t.setNaziv(rs.getString("naziv"));
               t.setAdresa(rs.getString("adresa"));
               t.setKratakOpis(rs.getString("kratakOpis"));
               t.setDetaljanOpis(rs.getString("detaljanOpis"));
               t.setPutanja(rs.getString("putanja"));
               
               r.setTockaInteresa(t);
      
               r.setSifra(rs.getInt("sifraGrupe"));
               r.setDatum(rs.getDate("datum"));
               r.setKomentar(rs.getString("komentar"));
               r.setOcjena(rs.getInt("ocjena"));
               
               
                lista.add(r);
            }
            rs.close();
            izraz.close();
            
            
            for (Rejting rejting : lista) {
            
                List<TockaInteresa> tockeInteresaRejting = new ArrayList<>();
                
                izraz = veza.prepareStatement(
                    "select a.sifra,a.naziv,a.adresa,a.kratakOpis,a.detaljanOpis,a.putanja\n" +
                    "from tockainteresa a \n" +
                    "inner join rejting b on a.sifra=b.tockaInteresa\n" +
                    "where b.sifra=1");
            izraz.setInt(1, t.getSifra());
         
            rs = izraz.executeQuery();
            
            while (rs.next()) {
               t = new TockaInteresa();
               t.setSifra(rs.getInt("sifra"));
               t.setNaziv(rs.getString("naziv"));
               t.setAdresa(rs.getString("adresa"));
               t.setKratakOpis(rs.getString("kratakOpis"));
               t.setDetaljanOpis(rs.getString("detaljanOpis"));
               t.setPutanja(rs.getString("putanja"));
              
               tockeInteresaRejting.add(t);
            }
            rs.close();
            izraz.close();
             
            rejting.setTockeInteresaRejting(tockeInteresaRejting);
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
    
   public List<Rejting> getOcjene(String uvjet) {
        List<Rejting> lista = new ArrayList<>();
        
        try {
            izraz = veza.prepareStatement(
                    " select b.ocjena\n" +
                    "from tockainteresa a inner join rejting b on a.sifra=b.tockaInteresa\n" +
                    "where a.sifra =?");
            izraz.setInt(1, t.getSifra());
            rs = izraz.executeQuery();
           

            while (rs.next()) {
               r= new Rejting();
               
               r.setOcjena(rs.getInt("ocjena"));
               
               
                lista.add(r);
            }
            rs.close();
            izraz.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
public  Rejting dodaj(Rejting r){
       try {
        
            izraz=veza.prepareStatement("insert into rejting (tockaInteresa,datum,komentar,ocjena) values (?,?,?,?)");
            izraz.setInt(1, r.getTockaInteresa().getSifra());
            izraz.setDate(2, new java.sql.Date(r.getDatum().getTime()));
            izraz.setString(3, r.getKomentar());
            izraz.setInt(4, r.getOcjena());
            
            izraz.executeUpdate();
            rs.close();
    } catch (Exception e) {
    }
    return r;
}
   
}
