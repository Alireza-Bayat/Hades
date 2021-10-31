package com.hades.model.enumeration.relational;

/**
 * @author alireza_bayat
 * created on 10/19/21
 */
public enum QueryKeyWords {

    //TODO add other words
    SELECT(" SELECT "), FROM(" FROM "), WHERE(" WHERE "), AND(" AND "), OR(" OR "), IN(" IN "), NOT_IN(" NOT IN "), AS(" AS "),
    JOIN(" JOIN "), LEFT_JOIN(" LEFT JOIN "), RIGHT_JOIN(" RIGHT JOIN "), ON(" ON ");

    private final String keyWord;

    QueryKeyWords(String s) {
        this.keyWord = s;
    }

    public String getKeyWord() {
        return keyWord;
    }
}
