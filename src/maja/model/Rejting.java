/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maja.model;


import java.util.Date;
import java.util.List;

/**
 *
 * @author Maja
 */
public class Rejting extends Entiteti{
    
    private TockaInteresa tockaInteresa;
    private Date datum;
    private String komentar;
    private int ocjena;
    private List<TockaInteresa> tockeInteresaRejting;

    public TockaInteresa getTockaInteresa() {
        return tockaInteresa;
    }

    public void setTockaInteresa(TockaInteresa tockaInteresa) {
        this.tockaInteresa = tockaInteresa;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public int getOcjena() {
        return ocjena;
    }

    public void setOcjena(int ocjena) {
        this.ocjena = ocjena;
    }

    public List<TockaInteresa> getTockeInteresaRejting() {
        return tockeInteresaRejting;
    }

    public void setTockeInteresaRejting(List<TockaInteresa> tockeInteresaRejting) {
        this.tockeInteresaRejting = tockeInteresaRejting;
    }

    public Rejting(TockaInteresa tockaInteresa, Date datum, String komentar, int ocjena, List<TockaInteresa> tockeInteresaRejting, int sifra) {
        super(sifra);
        this.tockaInteresa = tockaInteresa;
        this.datum = datum;
        this.komentar = komentar;
        this.ocjena = ocjena;
        this.tockeInteresaRejting = tockeInteresaRejting;
    }

    public Rejting() {
    }

    @Override
    public String toString() {
        return  "" + datum;
    }

   
        
    
}
