package org.mcallydevelops;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IntegerDataEngineTest {

    IntegerDataEngine dataEngine;
    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        this.dataEngine = new IntegerDataEngine();
        this.objectMapper = new ObjectMapper();
    }

    @Test
    void findExistingElement() throws Exception {
        IntegerQuery queryObject = new IntegerQuery(500000, Operation.RETRIEVE);
        String query = objectMapper.writeValueAsString(queryObject);
        Result result = dataEngine.query(query);
        assertTrue(result.getItem().isPresent());
        assertEquals(500000, result.getItem().get().getId());
    }

    @Test
    void findMissingElement() throws Exception {
        IntegerQuery queryObject = new IntegerQuery(-1, Operation.RETRIEVE);
        String query = objectMapper.writeValueAsString(queryObject);
        Result result = dataEngine.query(query);
        assertTrue(result.getItem().isEmpty());
    }
}