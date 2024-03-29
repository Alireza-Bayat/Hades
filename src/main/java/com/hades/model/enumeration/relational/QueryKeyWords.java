package com.hades.model.enumeration.relational;

/**
 * @author alireza_bayat
 * created on 10/19/21
 */
public enum QueryKeyWords {

    SELECT(" SELECT "), FROM(" FROM "), WHERE(" WHERE "), AND(" AND "), OR(" OR "), IN(" IN "), NOT_IN(" NOT IN "), AS(" AS "),
    ON(" ON "), ORDER_BY(" ORDER BY "), EXISTS(" EXISTS "), NOT_EXISTS(" NOT EXISTS "), LIKE(" LIKE "), BETWEEN(" BETWEEN "), NOT(" NOT "),
    AVG(" AVG "), SUM(" SUM "), COUNT(" COUNT "), MIN(" MIN "), MAX(" MAX ");

    private final String keyWord;

    QueryKeyWords(String s) {
        this.keyWord = s;
    }

    public String getKeyWord() {
        return keyWord;
    }
}
