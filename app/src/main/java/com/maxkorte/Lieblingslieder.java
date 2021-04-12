package com.maxkorte;

import java.util.ArrayList;

public class Lieblingslieder {
    private static final ArrayList<Nutzer> nutzerListe = new ArrayList<>();

    static void addNutzer(String nutzername){
        nutzerListe.add(new Nutzer(nutzername));
    }

    static Nutzer getNutzer(String nutzername){
        for (Nutzer n: nutzerListe){
            if(n.getNutzername().equals(nutzername)) return n;
        }
        throw new IllegalArgumentException("Ein Nutzer mit diesem Nutzername existiert nicht!");
    }

    public static void main(String[] args) {

    }
}
