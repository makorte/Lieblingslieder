package com.maxkorte;

import java.util.ArrayList;
import java.util.Objects;

public class Nutzer {
    private final String nutzername;
    private final ArrayList<Lied> lieblingslieder;

    Nutzer(String nutzername) {
        this.nutzername = nutzername;
        lieblingslieder = new ArrayList<>();
    }

    void addLied(Lied lied) {
        lieblingslieder.add(lied);
    }

    Lied getLied(int i){
        return lieblingslieder.get(i);
    }

    String getLieder(){
        StringBuilder output = new StringBuilder("nutzername's Lieblingslieder:");
        for(int i = 0; i < lieblingslieder.size(); i++){
            Lied l = lieblingslieder.get(i);
            output.append("\n ").append(i).append(": ").append(l.getInterpret()).append(" - ").append(l.getTitel());
        }
        return output.toString();
    }

    boolean entferneLied(Lied lied){
        try{
            lieblingslieder.remove(lied);
            return true;
        } catch(Exception e){
            return false;
        }
    }

    void entferneLieder(){
        lieblingslieder.clear();
    }

    public String getNutzername() {
        return nutzername;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nutzer nutzer = (Nutzer) o;
        return getNutzername().equals(nutzer.getNutzername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNutzername());
    }

    @Override
    public String toString() {
        return "Nutzer{" +
                "nutzername='" + nutzername + '\'' +
                '}';
    }
}
