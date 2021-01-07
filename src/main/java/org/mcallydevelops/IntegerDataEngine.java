package org.mcallydevelops;

import java.util.Optional;

public class IntegerDataEngine {

    private IntegerDataCollection collection;
    private IntegerQueryParser queryParser;

    public IntegerDataEngine() {
       this.collection = new IntegerDataCollection();
       this.queryParser = new IntegerQueryParser();
    }

    public Result queryForItem(IntegerQuery query) {
        Optional<Item> optionalItem = collection.retrieveElement(query.getKey());
        return new Result(optionalItem);
    }
}
