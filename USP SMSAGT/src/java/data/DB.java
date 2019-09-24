/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import beans.Korisnik;
import beans.Traktor;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Stefan
 */
public class DB {

    private static HashMap<String, Korisnik> mapaKorisnika = new HashMap<String, Korisnik>();

    private static HashMap<String, LinkedList<Traktor>> mapaTraktora = new HashMap<String, LinkedList<Traktor>>();

    static {

        mapaKorisnika.put("stefan", new Korisnik("stefan", "stefan123", "Stefan", "Sovilj","stefan@etf.rs", null));
        mapaKorisnika.put("milos", new Korisnik("milos", "milos123", "Milos", "Milosevic","milos@etf.rs", null));

        LinkedList<Traktor> traktori = new LinkedList<>();
        traktori.add(new Traktor("traktor1", "lamburgini", "crvena", "150000h", "radi", "njiva3"));
        traktori.add(new Traktor("traktor2", "audi", "rozi", "15000h", "radi", "njiva5"));

        mapaTraktora.put("stefan", traktori);

    }

    public static Korisnik findKorisnikByUsername(String username) {
        return mapaKorisnika.get(username);
    }

    public static LinkedList<Traktor> getTraktorByUsername(String username) {
        return mapaTraktora.get(username);
    }

    public static boolean isKorisnik(String username, String password) {
        Korisnik k = mapaKorisnika.get(username);
        return (k != null) && k.getPassword().equals(password);
    }

    public static void saveT(String username, LinkedList<Traktor> t) {
        mapaTraktora.replace(username, t);
    }

}
