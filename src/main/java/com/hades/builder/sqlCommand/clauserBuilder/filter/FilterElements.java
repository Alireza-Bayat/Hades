package com.hades.builder.sqlCommand.clauserBuilder.filter;

/**
 * @author alireza_bayat
 * created on 10/19/21
 */
public class FilterElements {

    protected String filterClause = "";

    public FilterElements() {
    }

    public String getFilterClause() {
        return filterClause;
    }

    public void setFilterClause(String filterClause) {
        this.filterClause = filterClause;
    }
}
