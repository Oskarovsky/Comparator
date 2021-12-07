package com.oskarro.comparator.model;

public enum ComparisonOperator {

    LT("<"), GT(">"), EQ("=="), LE("<="), GE("=<");

    private final String mark;

    ComparisonOperator(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }
}
