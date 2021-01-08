package org.mcallydevelops;

import java.util.Optional;

public class Result {
    private Optional<Item> item;

    public Result() {

    }
    public Result(Optional<Item> item) {
        this.item = item;
    }

    public Optional<Item> getItem() {
        return item;
    }
}
