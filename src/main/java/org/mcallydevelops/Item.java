package org.mcallydevelops;

import java.util.Map;

public class Item {
    private Integer id;
    private Object value;

    public Item(Integer id, Object value) {
        this.id = id;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public Object getValue() {
        return value;
    }
}
