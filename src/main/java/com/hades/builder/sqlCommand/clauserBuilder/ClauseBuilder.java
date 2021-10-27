package com.hades.builder.sqlCommand.clauserBuilder;

import com.hades.builder.sqlCommand.clauserBuilder.filter.FilterClause;
import com.hades.model.type.EntityType;

/**
 * @author alireza_bayat
 * created on 10/19/21
 */
public class ClauseBuilder<E extends EntityType> {

    FilterClause<E> filterClause;

    public ClauseBuilder() {
    }

    public ClauseBuilder(FilterClause<E> filterClause) {
        this.filterClause = filterClause;
    }

    public FilterClause<E> getFilterClause() {
        return filterClause;
    }

    public void setFilterClause(FilterClause<E> filterClause) {
        this.filterClause = filterClause;
    }
}
