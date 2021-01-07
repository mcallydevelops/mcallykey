package org.mcallydevelops;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class IntegerDataCollection {

    private Map<Integer, Item> collection;

    public IntegerDataCollection() {
        this.collection = new ConcurrentHashMap<>();
        loadCollection();

    }

    private void loadCollection() {
        for(int i = 0; i < 1000000; ++i) {
            collection.put(i, new Item(i, String.valueOf(i)));
        }
    }

    public Optional<Item> retrieveElement(Integer key) {
        Item item = collection.get(key);
        if(item == null) {
            return Optional.empty();
        }
        return Optional.of(item);
    }





}
