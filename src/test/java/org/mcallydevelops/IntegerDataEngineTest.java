package org.mcallydevelops;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IntegerDataEngineTest {

    IntegerDataEngine dataEngine;

    @BeforeEach
    void setUp() {
        this.dataEngine = new IntegerDataEngine();
    }

    @Test
    void findExistingElement() {
        IntegerQuery query = new IntegerQuery(500000);
        Result result = dataEngine.queryForItem(query);
        assertTrue(result.getItem().isPresent());
        assertEquals(500000, result.getItem().get().getId());
    }

    @Test
    void findMissingElement() {
        IntegerQuery query = new IntegerQuery(-1);
        Result result = dataEngine.queryForItem(query);
        assertTrue(result.getItem().isEmpty());
    }
}