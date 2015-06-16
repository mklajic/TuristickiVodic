/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maja.model;

/**
 *
 * @author Maja
 */
public class Kategorije extends Entiteti {
    
    private String nazivKategorije;

    public String getNazivKategorije() {
        return nazivKategorije;
    }

    public void setNazivKategorije(String nazivKategorije) {
        this.nazivKategorije = nazivKategorije;
    }

    public Kategorije(String nazivKategorije, int sifra) {
        super(sifra);
        this.nazivKategorije = nazivKategorije;
    }

    public Kategorije() {
    }

    @Override
    public String toString() {
        return this.nazivKategorije;
    }

        
    
    
}
