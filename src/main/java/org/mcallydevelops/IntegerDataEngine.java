package org.mcallydevelops;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;

public class IntegerDataEngine {

    private IntegerDataCollection collection;
    private ObjectMapper objectMapper;

    public IntegerDataEngine() {
       this.collection = new IntegerDataCollection();
        this.objectMapper = new ObjectMapper();
    }

    public Result query(String query) throws JsonProcessingException {
        IntegerQuery queryObject = objectMapper.readValue(query, IntegerQuery.class);
        return queryForItem(queryObject);
    }

    private Result queryForItem(IntegerQuery query) {
        Optional<Item> optionalItem = collection.retrieveElement(query.getKey());
        return new Result(optionalItem);
    }
}
