package com.maxkorte;

import java.util.Objects;

public class Lied {
    private final String titel;
    private final String interpret;

    Lied(String titel, String interpret) {
        this.titel = titel;
        this.interpret = interpret;
    }

    String getTitel() {
        return titel;
    }

    String getInterpret() {
        return interpret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lied lied = (Lied) o;
        return getTitel().equals(lied.getTitel()) && getInterpret().equals(lied.getInterpret());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitel(), getInterpret());
    }

    @Override
    public String toString() {
        return  interpret +  " - " + titel;
    }
}
