package com.maxkorte;

import java.util.Scanner;

public class App {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Nutzer nutzer = initNutzer();
        System.out.println();
    }

    public static Nutzer initNutzer(){
        System.out.println("Gib einen (deinen) Nutzernamen ein: ");
        String nutzernameIn = sc.next();
        Nutzer nutzer;
        try{
            nutzer = Lieblingslieder.getNutzer(nutzernameIn);
            System.out.println("Angemeldet als '" + nutzer.getNutzername() + "'");
        } catch (IllegalArgumentException e){
            nutzer = Lieblingslieder.addNutzer(nutzernameIn);
            System.out.println("Nutzer '" + nutzer.getNutzername() + "' wurde erstellt");
        }
        return nutzer;
    }
}
