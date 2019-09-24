/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import beans.Korisnik;
import beans.Traktor;
import data.DB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author Stefan
 */
@Named(value = "controlerBean")
@SessionScoped
public class ControlerBean implements Serializable {

    private String username;
    private String password;
    private Korisnik korisnik;
    private String poruka;

    private String nazivT;
    private String markaT;
    private String bojaT;
    private String rsT;

    private String nazivTL;
    private String lokacijaTL;

    private String nazivTS;
    private String statusTS;

    LinkedList<Traktor> lista = null;

    public LinkedList<Traktor> getLista() {
        return lista;
    }

    public void setLista(LinkedList<Traktor> lista) {
        this.lista = lista;
    }

    public String getNazivTS() {
        return nazivTS;
    }

    public void setNazivTS(String nazivTS) {
        this.nazivTS = nazivTS;
    }

    public String getStatusTS() {
        return statusTS;
    }

    public void setStatusTS(String statusTS) {
        this.statusTS = statusTS;
    }

    public String getNazivTL() {
        return nazivTL;
    }

    public void setNazivTL(String nazivTL) {
        this.nazivTL = nazivTL;
    }

    public String getLokacijaTL() {
        return lokacijaTL;
    }

    public void setLokacijaTL(String lokacijaTL) {
        this.lokacijaTL = lokacijaTL;
    }

    public String getNazivT() {
        return nazivT;
    }

    public void setNazivT(String nazivT) {
        this.nazivT = nazivT;
    }

    public String getMarkaT() {
        return markaT;
    }

    public void setMarkaT(String markaT) {
        this.markaT = markaT;
    }

    public String getBojaT() {
        return bojaT;
    }

    public void setBojaT(String bojaT) {
        this.bojaT = bojaT;
    }

    public String getRsT() {
        return rsT;
    }

    public void setRsT(String rsT) {
        this.rsT = rsT;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public ControlerBean() {
    }

    public String login() {
        String sledecaStranica = null;
        if (DB.isKorisnik(username, password)) {
            korisnik = DB.findKorisnikByUsername(username);

            sledecaStranica = "user";
            poruka = "";
        } else {
            poruka = "Ne postoji traženi korisnik u sistemu!";
        }
        return sledecaStranica;
    }

    public void dodajT() {
        if (!nazivT.isEmpty() && !markaT.isEmpty() && !bojaT.isEmpty() && !rsT.isEmpty()) {

            Traktor t = new Traktor(nazivT, markaT, bojaT, rsT, null, null);
            LinkedList<Traktor> l = DB.getTraktorByUsername(username);
            l.add(t);
            DB.saveT(username, l);

            poruka = "Uspesno dodat traktor";

        } else {
            poruka = "Popunite sva polja";
        }
    }

    public String prikazi() {
        lista = DB.getTraktorByUsername(username);
        return "prikaz";
    }

    public void dodajTL() {
        lista = DB.getTraktorByUsername(username);

        int i = 0;
        boolean b = false;
        while (i < lista.size()) {

            if (lista.get(i).getNaziv().equals(nazivTL)) {
                lista.get(i).setLokacija(lokacijaTL);
                b = true;

                break;

            }
            i++;
        }
        if (!b) {
            poruka = "Pogresno ime traktora";
        } else {
            DB.saveT(username, lista);
            poruka = "Uspesno izmenjen traktor";
        }

    }

    public void dodajTS() {
        lista = DB.getTraktorByUsername(username);

        int i = 0;
        boolean b = false;
        while (i < lista.size()) {

            if (lista.get(i).getNaziv().equals(nazivTL)) {
                lista.get(i).setStatus(statusTS);
                b = true;

                break;

            }
            i++;
        }
        if (!b) {
            poruka = "Pogresno ime traktora";
        } else {
            DB.saveT(username, lista);
            poruka = "Uspesno izmenjen traktor";
        }

    }
}
