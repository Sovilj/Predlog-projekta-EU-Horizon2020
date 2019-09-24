/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Stefan
 */
public class Korisnik {

    private String username;
    private String password;
    private String ime;
    private String prezime;
    private String email;
    private List<Traktor> traktori;

    public Korisnik() {
    }

    public Korisnik(String username, String password, String ime, String prezime, String email, List<Traktor> traktori) {
        this.username = username;
        this.password = password;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.traktori = traktori;
    }

    public String getEmail() {
        return email;
    }

    public List<Traktor> getTraktori() {
        return traktori;
    }

   

    public void setTraktori(List<Traktor> traktori) {
        this.traktori = traktori;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
