package com.maxkorte;

import java.util.Scanner;

public class App {
    private static final Scanner sc = new Scanner(System.in);
    private static Nutzer nutzer;

    public static void main(String[] args) {
        nutzer = initNutzer();
        
        boolean running = true;
        while(running){ // TODO: 16.04.21 maybe change while loop (to be tested) 
            printLieder();
            
            int userAction = getUserAction();
            switch (userAction){
                case 1: addLied(); break;
                case 2: removeLied(); break; 
                case 3: removeAll(); break;
                case 9: {
                    running = false;
                    exit();
                }
                default: System.out.println("Fehler");
            }
        }
    }

    public static void addLied(){
        System.out.print("Gib den Titel des Liedes ein: ");
        String titel = sc.next();
        System.out.print("Gib den Interpret des Liedes ein: ");
        String interpret = sc.next();

        Lied hinzugefuegtesLied = new Lied(titel, interpret);

        nutzer.addLied(hinzugefuegtesLied);

        System.out.println(hinzugefuegtesLied + " wurde hinzugefügt!\n");
    }

    public static void removeLied(){
        if (nutzer.getLieder().equals("")){
            System.out.println("Keine Lieder vorhanden\n");
            return;
        }

        boolean running = true;
        while(running){
            nutzer.getLieder();
            System.out.print("Gib die Nummer des zu Löschenden Lieds an: ");
            try{
                int userInput = (sc.nextInt() - 1);
                Lied entferntesLied = nutzer.getLied(userInput);
                nutzer.entferneLied(userInput);
                System.out.println(entferntesLied + " wurde gelöscht!\n");
                running = false;
            } catch (Exception e){
                System.out.println("Falsche Eingabe!\n");
            }
        }
    }

    public static void removeAll(){
        System.out.println("Es werden alle Lieblingslieder gelöscht...\n");
        nutzer.entferneLieder();
    }

    public static void exit(){
        System.out.println("Das Programm wird beendet...");
        System.exit(0);
    }

    public static int getUserAction(){
        int input = 0;

        boolean running = true;
        while (running) {
            System.out.print("1: Lied hinzufügen, 2: Lied entfernen, 3: alle Lieder entfernen, 9: Beenden: ");
            try {
                input = sc.nextInt();
                if (input < 1 || (input > 3 && input < 9) || input > 9) throw new Exception();
                running = false;
            } catch (Exception e) {
                System.out.println("Falsche Eingabe!\n");
            }
        }

        return input;
    }

    public static Nutzer initNutzer(){
        System.out.print("Gib einen (deinen) Nutzernamen ein: ");
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
