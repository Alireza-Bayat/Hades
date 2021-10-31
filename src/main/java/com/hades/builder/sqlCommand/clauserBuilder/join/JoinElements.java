package com.hades.builder.sqlCommand.clauserBuilder.join;

/**
 * @author alireza_bayat
 * created on 10/30/21
 */
public class JoinElements {

    protected String joinClause = "";

    public JoinElements() {
    }

    public String getJoinClause() {
        return joinClause;
    }

    public void setJoinClause(String joinClause) {
        this.joinClause = joinClause;
    }
}
