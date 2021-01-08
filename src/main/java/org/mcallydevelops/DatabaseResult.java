package org.mcallydevelops;

import java.util.Optional;

public class DatabaseResult {
    private Optional<Item> item;

    public DatabaseResult() {

    }
    public DatabaseResult(Optional<Item> item) {
        this.item = item;
    }

    public Optional<Item> getItem() {
        return item;
    }
}
