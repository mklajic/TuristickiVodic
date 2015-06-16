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
public class Operater {
    
    private int sifra;
    private String korisnickoIme;
    private String lozinka;
    private String ime;
    private String prezime;

    public Operater(int sifra, String korisnickoIma, String lozinka, String ime, String prezime) {
        this.sifra = sifra;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
    }

    public Operater() {
    }

    public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
    public String getImePrezime(){
        return this.ime + " " + this.prezime;
    }

    @Override
    public String toString() {
        return this.ime + " " + this.prezime + " " + this.korisnickoIme ;
    }
    
    
    
}
