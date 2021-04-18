package com.maxkorte;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class NutzerTest {
    private static Nutzer nutzer;
    private static Lied[] lieder = {new Lied("Haus am See", "Peter Fox"),
            new Lied("Bochum", "Herbert Groenemeyer")};

    private static void addLieder() {
        for(Lied l:lieder) nutzer.lieblingslieder.add(l);
    }

    @BeforeAll
    static void beforeAll() {
        nutzer = new Nutzer("maxkorte");
    }

    @Test
    void testNutzer() {
        Assertions.assertEquals("maxkorte", nutzer.getNutzername());
        Assertions.assertEquals(new ArrayList<Lied>(), nutzer.lieblingslieder);

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Nutzer(null));
    }

    @BeforeEach
    void setUp() {
        if(nutzer != null) nutzer.lieblingslieder.clear();
    }

    @Test
    void testAddLied() {
        nutzer.addLied(lieder[0]);
        Assertions.assertEquals(lieder[0], nutzer.lieblingslieder.get(nutzer.lieblingslieder.size() -1));

        Assertions.assertThrows(IllegalArgumentException.class, () -> nutzer.addLied(null));
    }

    @Test
    void testGetLieder() {
        Assertions.assertEquals("", nutzer.getLieder());

        addLieder();

        Assertions.assertEquals("1: " + lieder[0] + "\n" + "2: " + lieder[1] + "\n",
                nutzer.getLieder());
    }

    @Test
    void testGetLied() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> nutzer.getLied(0));

        addLieder();
        Assertions.assertEquals(lieder[1], nutzer.getLied(1));
    }

    @Test
    void testEntferneLied() {
        addLieder();

        Assertions.assertDoesNotThrow(() -> nutzer.entferneLied(1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> nutzer.lieblingslieder.get(1));
    }

    @Test
    void testEntferneLieder() {
        addLieder();

        Assertions.assertDoesNotThrow(() -> nutzer.lieblingslieder.get(1));
        Assertions.assertDoesNotThrow(() -> nutzer.entferneLieder());
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> nutzer.lieblingslieder.get(1));
    }
}
