package com.maxkorte;

import java.util.Scanner;

public class App {
    private static final Scanner sc = new Scanner(System.in);
    private static Nutzer nutzer;

    public static void main(String[] args) {
        nutzer = initNutzer();
        printLieder();
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

    public static void printLieder(){
        String lieder = nutzer.getLieder();
        if(lieder.equals("")) System.out.println("Du hast aktuell keine Lieder");
        else System.out.println("Deine Lieblingslieder:\n" + nutzer.getLieder());
    }
}
