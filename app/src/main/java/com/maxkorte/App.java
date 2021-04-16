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
            switch (userAction){    // TODO: 16.04.21 implement in while loop 
                case 1: addLied();
                case 2: removeLied();
                case 3: removeAll();
                case 9: {
                    running = false;
                    exit();
                }
                default: System.out.println("Fehler");
            }
        }
    }

    public static void addLied(){
        if (nutzer.getLieder().equals("")){
            System.out.println("Keine Lieder vorhanden");
        }
        
        // TODO: 16.04.21 implement 
    }

    public static void removeLied(){
        // TODO: 16.04.21 implement 
    }

    public static void removeAll(){
        System.out.println("Es werden alle Lieblingslieder gelöscht...");
        nutzer.entferneLieder();
        return true;
    }

    public static void exit(){
        System.out.println("Das Programm wird beendet...");
        System.exit(0);
    }

    public static int getUserAction(){
        int input = 0;

        boolean running;
        do {
            System.out.println("1: Lied hinzufügen, 2: Lied entfernen, 3: alle Lieder entfernen, 9: Beenden");
            try{
                input = sc.nextInt();
                if(input < 1 || (input > 3 && input < 9) || input > 9) throw new Exception();
                running = false;
            } catch (Exception e){
                System.out.println("Falsche Eingabe!");
                running = true;
            }
        } while (running);

        return input;
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
