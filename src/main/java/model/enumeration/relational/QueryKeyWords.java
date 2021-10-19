package model.enumeration.relational;

/**
 * @author alireza_bayat
 * created on 10/19/21
 */
public enum QueryKeyWords {

    //TODO add other words
    SELECT("SELECT"), FROM("FROM"), WHERE("WHERE"), AND("AND"), OR("OR"), IN("IN"), NOT_IN("NOT IN");

    private String keyWord;

    QueryKeyWords(String s) {
        this.keyWord = s;
    }

    public String getKeyWord() {
        return keyWord;
    }
}
