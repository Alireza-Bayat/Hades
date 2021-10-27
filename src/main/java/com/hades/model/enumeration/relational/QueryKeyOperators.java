package com.hades.model.enumeration.relational;

/**
 * @author alireza_bayat
 * created on 10/27/21
 */
public enum QueryKeyOperators {

    EQUAL(" = "), NOT_EQUAL(" != "), OPEN_PARENTHESES(" ("), CLOSE_PARENTHESES(") "), DOT(".");

    private final String operator;

    QueryKeyOperators(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }
}
