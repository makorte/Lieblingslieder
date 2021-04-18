package com.maxkorte;

import java.util.ArrayList;
import java.util.Objects;

public class Nutzer {
    private final String nutzername;
    protected final ArrayList<Lied> lieblingslieder;

    Nutzer(String nutzername) {
        if(nutzername == null) throw new IllegalArgumentException("Argumente dürfen nicht null sein!");

        this.nutzername = nutzername;
        lieblingslieder = new ArrayList<>();
    }

    void addLied(Lied lied) {
        if(lied == null) throw new IllegalArgumentException("Argumente dürfen nicht null sein!");

        lieblingslieder.add(lied);
    }

    String getLieder(){
        StringBuilder output = new StringBuilder();

        for(int i = 0; i < lieblingslieder.size(); i++){
            Lied l = lieblingslieder.get(i);
            output.append(i + 1).append(": ").append(l).append("\n");
        }

        return output.toString();
    }

    Lied getLied(int i){
        return lieblingslieder.get(i);
    }

    boolean entferneLied(int i){
        try{
            Lied lied = getLied(i);
            lieblingslieder.remove(lied);
            return true;
        } catch(IndexOutOfBoundsException e){
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
