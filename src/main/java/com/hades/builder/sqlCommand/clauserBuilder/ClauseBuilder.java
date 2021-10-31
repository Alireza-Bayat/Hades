package com.hades.builder.sqlCommand.clauserBuilder;

import com.hades.builder.sqlCommand.clauserBuilder.filter.FilterClause;
import com.hades.builder.sqlCommand.clauserBuilder.join.JoinClause;
import com.hades.model.type.EntityType;

/**
 * @author alireza_bayat
 * created on 10/19/21
 */
public class ClauseBuilder<E extends EntityType> {

    FilterClause<E> filterClause;
    JoinClause<E> joinClause;

    public ClauseBuilder() {
    }

    public ClauseBuilder(FilterClause<E> filterClause) {
        this.filterClause = filterClause;
    }

    public ClauseBuilder(JoinClause<E> joinClause) {
        this.joinClause = joinClause;
    }

    public ClauseBuilder(FilterClause<E> filterClause, JoinClause<E> joinClause) {
        this.filterClause = filterClause;
        this.joinClause = joinClause;
    }

    public FilterClause<E> getFilterClause() {
        return filterClause;
    }

    public void setFilterClause(FilterClause<E> filterClause) {
        this.filterClause = filterClause;
    }

    public JoinClause<E> getJoinClause() {
        return joinClause;
    }

    public void setJoinClause(JoinClause<E> joinClause) {
        this.joinClause = joinClause;
    }
}
