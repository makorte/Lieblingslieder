package com.maxkorte;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LieblingsliederTest {
    Nutzer testNutzer = new Nutzer("maxkorte");

    @Test
    void testAddNutzer() {
        Assertions.assertEquals(testNutzer, Lieblingslieder.addNutzer(testNutzer.getNutzername()));
        Assertions.assertEquals(testNutzer, Lieblingslieder.nutzerListe.get(0));

        Assertions.assertThrows(IllegalArgumentException.class, () -> Lieblingslieder.addNutzer(null));
    }

    @Test
    void testGetNutzer() {
        Assertions.assertEquals(testNutzer, Lieblingslieder.getNutzer(testNutzer.getNutzername()));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Lieblingslieder.getNutzer("hansmaier"));
    }
}
