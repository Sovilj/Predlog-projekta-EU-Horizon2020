/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Stefan
 */
public class Traktor {
    
    private String naziv;
    private String marka;
    private String boja;
    private String rs;
    private String status;
    private String lokacija;

    public Traktor(String naziv, String marka, String boja, String rs, String status, String lokacija) {
        this.naziv = naziv;
        this.marka = marka;
        this.boja = boja;
        this.rs = rs;
        this.status = status;
        this.lokacija = lokacija;
    }

    public Traktor() {
    }

    
    
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getBoja() {
        return boja;
    }

    public void setBoja(String boja) {
        this.boja = boja;
    }

    public String getRs() {
        return rs;
    }

    public void setRs(String rs) {
        this.rs = rs;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }
    
    
    
}
