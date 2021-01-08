package org.mcallydevelops;

public class IntegerQuery {

    private Integer key;

    private Operation operation;

    public IntegerQuery() {
    }

    public IntegerQuery(Integer key, Operation operation) {
        this.key = key;
        this.operation = operation;
    }

    public Integer getKey() {
        return key;
    }

    public Operation getOperation() {
        return operation;
    }
}
