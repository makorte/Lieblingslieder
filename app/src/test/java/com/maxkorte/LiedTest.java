package com.maxkorte;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LiedTest {
    private static Lied lied;

    @BeforeAll
    static void beforeAll() {
        lied = new Lied("Haus am See", "Peter Fox");
    }

    @Test
    void testLied() {
        Assertions.assertEquals("Haus am See", lied.getTitel());
        Assertions.assertEquals("Peter Fox", lied.getInterpret());
    }

    @Test
    void testEquals() {
        Lied gleichesLied = new Lied("Haus am See", "Peter Fox");
        Lied anderesLied = new Lied("Bochum", "Herbert Groenemeyer");

        Assertions.assertEquals(lied, lied);
        Assertions.assertEquals(lied, gleichesLied);
        Assertions.assertNotEquals(lied, anderesLied);
    }

    @Test
    void testToString() {
        Assertions.assertEquals("Peter Fox - Haus am See", lied.toString());
    }

    @AfterAll
    static void afterAll() {
        lied = null;
    }
}
