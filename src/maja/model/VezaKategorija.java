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
public class VezaKategorija {
    
   private TockaInteresa tockaInteresa;
   private Kategorije kategorije;
   private List<TockaInteresa> listaTocke;
   private List<Kategorije> listaKategorije;

    public List<Kategorije> getListaKategorije() {
        return listaKategorije;
    }

    public void setListaKategorije(List<Kategorije> listaKategorije) {
        this.listaKategorije = listaKategorije;
    }
   

    public List<TockaInteresa> getListaTocke() {
        return listaTocke;
    }

    public void setListaTocke(List<TockaInteresa> listaTocke) {
        this.listaTocke = listaTocke;
    }

   
    public TockaInteresa getTockaInteresa() {
        return tockaInteresa;
    }

    public void setTockaInteresa(TockaInteresa tockaInteresa) {
        this.tockaInteresa = tockaInteresa;
    }

    public Kategorije getKategorije() {
        return kategorije;
    }

    public void setKategorije(Kategorije kategorije) {
        this.kategorije = kategorije;
    }

    public VezaKategorija(TockaInteresa tockaInteresa, Kategorije kategorije, List<TockaInteresa> listaTocke, List<Kategorije> listaKategorije) {
        this.tockaInteresa = tockaInteresa;
        this.kategorije = kategorije;
        this.listaTocke = listaTocke;
        this.listaKategorije = listaKategorije;
    }

  
    

    public VezaKategorija() {
    }

    @Override
    public String toString() {
        return "" + kategorije ;
    }
   
    
   
    
   
    
}
