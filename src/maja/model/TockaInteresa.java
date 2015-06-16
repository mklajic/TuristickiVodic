/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maja.model;

import java.util.List;

/**
 *
 * @author Maja
 */
public class TockaInteresa  extends Entiteti{
    
    private String naziv;
    private String adresa;
    private String kratakOpis;
    private String detaljanOpis;
    private String putanja;
    private List<Kategorije> kategorije;
    private List<Rejting> rejting;

    public List<Rejting> getRejting() {
        return rejting;
    }

    public void setRejting(List<Rejting> rejting) {
        this.rejting = rejting;
    }
    
    

    public List<Kategorije> getKategorije() {
        return kategorije;
    }

    public void setKategorije(List<Kategorije> kategorije) {
        this.kategorije = kategorije;
    }

        
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getKratakOpis() {
        return kratakOpis;
    }

    public void setKratakOpis(String kratakOpis) {
        this.kratakOpis = kratakOpis;
    }

    public String getDetaljanOpis() {
        return detaljanOpis;
    }

    public void setDetaljanOpis(String detaljanOpis) {
        this.detaljanOpis = detaljanOpis;
    }

    public String getPutanja() {
        return putanja;
    }

    public void setPutanja(String putanja) {
        this.putanja = putanja;
    }

    public TockaInteresa(String naziv, String adresa, String kratakOpis, String detaljanOpis, String putanja, List<Kategorije> kategorije, List<Rejting> rejting, int sifra) {
        super(sifra);
        this.naziv = naziv;
        this.adresa = adresa;
        this.kratakOpis = kratakOpis;
        this.detaljanOpis = detaljanOpis;
        this.putanja = putanja;
        this.kategorije = kategorije;
        this.rejting = rejting;
    }


    public TockaInteresa() {
    }

    

    @Override
    public String toString() {
        return this.naziv;
    }
    
    
    
}
