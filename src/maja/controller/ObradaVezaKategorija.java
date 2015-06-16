/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maja.controller;

import java.util.ArrayList;
import java.util.List;
import maja.model.Kategorije;
import maja.model.TockaInteresa;
import maja.model.VezaKategorija;

/**
 *
 * @author Maja
 */
public class ObradaVezaKategorija extends Obrada{

    public ObradaVezaKategorija() {
        super();
    }
    
    public List<VezaKategorija> getVezaKategorije (String uvjet){
       List<VezaKategorija> lista = new ArrayList<>();
       
        try {
            izraz=veza.prepareStatement("select a.sifra as sifraTockaInteresa, a.naziv as nazivTockaInteresa, a.adresa as adresa, a.kratakOpis as kratakOpis, a.detaljanOpis as detaljanOpis,\n" +
"b.tockaInteresa as tockaInteresa, b.kategorija as kategorija,\n" +
"c.sifra as sifraKategorije, c.nazivKategorije as nazivKategorije\n" +
"from tockaInteresa a \n" +
"inner join vezakategorija b on a.sifra=b.tockaInteresa\n" +
"inner join kategorija c on c.sifra=b.kategorija\n" +
"where c.nazivKategorije like ?");
            izraz.setString(1, "%" + uvjet + "%");
            rs = izraz.executeQuery();
            VezaKategorija t;
            Kategorije k = null;
            TockaInteresa ti;
            
        while(rs.next()){
               
                t= new VezaKategorija();
                
                ti= new TockaInteresa();
                ti.setSifra(rs.getInt("sifraTockaInteresa"));
                ti.setNaziv(rs.getString("nazivTockaInteresa"));
                ti.setAdresa(rs.getString("adresa"));
                ti.setKratakOpis(rs.getString("kratakOpis"));
                ti.setDetaljanOpis(rs.getString("detaljanOpis"));
                
                t.setTockaInteresa(ti);
                
                k=new Kategorije();
                k.setSifra(rs.getInt("sifraKategorije"));
                k.setNazivKategorije(rs.getString("nazivKategorije"));
                
                t.setKategorije(k);
                
               lista.add(t);
                
                
            }
            rs.close();
            izraz.close();
            
            for (VezaKategorija vezaKategorija : lista) {
            
                List<TockaInteresa> tockaInteresas = new ArrayList<>();
                
                
                //otići u bazu po polaznike
                izraz = veza.prepareStatement("select  a.sifra, a.naziv, a.adresa, a.kratakOpis, a.detaljanOpis, a.putanja\n" +
"from tockainteresa a \n" +
"inner join vezakategorija b on a.sifra=b.tockaInteresa\n" +
"inner join kategorija c on c.sifra=b.kategorija\n" +
"where b.kategorija=?");
               izraz.setInt(1, vezaKategorija.getKategorije().getSifra());
            rs = izraz.executeQuery();
            // System.out.println("1");
            while (rs.next()) {
                ti = new TockaInteresa();
                ti.setSifra(rs.getInt("sifra"));
                ti.setNaziv(rs.getString("naziv"));
                ti.setAdresa(rs.getString("adresa"));
                ti.setKratakOpis(rs.getString("kratakOpis"));
                ti.setDetaljanOpis(rs.getString("detaljanOpis"));
                ti.setPutanja(rs.getString("putanja"));
              tockaInteresas.add(ti);
            }
            rs.close();
            izraz.close();
             
            vezaKategorija.setListaTocke(tockaInteresas);
            }
            
            for (VezaKategorija vezaKategorija : lista) {
            
                List<Kategorije> kategorije = new ArrayList<>();
                
                
                //otići u bazu po polaznike
                izraz = veza.prepareStatement("select  c.nazivKategorije\n" +
"from tockainteresa a \n" +
"inner join vezakategorija b on a.sifra=b.tockaInteresa\n" +
"inner join kategorija c on c.sifra=b.kategorija\n" +
"where b.tockainteresa = ?");
               izraz.setInt(1, vezaKategorija.getTockaInteresa().getSifra());
            rs = izraz.executeQuery();
            // System.out.println("1");
            while (rs.next()) {
                k = new Kategorije();
                k.setNazivKategorije(rs.getString("nazivKategorije"));
                kategorije.add(k);
            }
            rs.close();
            izraz.close();
             
            vezaKategorija.setListaKategorije(kategorije);
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
   
        
    }
    
    
}
    
    
   
