package com.hades.builder.sqlCommand.clauserBuilder;

import com.hades.builder.sqlCommand.clauserBuilder.filter.FilterClauseImpl;
import com.hades.builder.sqlCommand.clauserBuilder.join.JoinClauseImpl;
import com.hades.model.type.EntityType;

/**
 * @author alireza_bayat
 * created on 10/19/21
 */
public class ClauseBuilder<E extends EntityType> {

    FilterClauseImpl<E> filterClause;
    JoinClauseImpl<E> joinClause;

    public ClauseBuilder() {
    }

    public ClauseBuilder(FilterClauseImpl<E> filterClauseImpl) {
        this.filterClause = filterClauseImpl;
    }

    public ClauseBuilder(JoinClauseImpl<E> joinClause) {
        this.joinClause = joinClause;
    }

    public ClauseBuilder(FilterClauseImpl<E> filterClause, JoinClauseImpl<E> joinClause) {
        this.filterClause = filterClause;
        this.joinClause = joinClause;
    }

    public FilterClauseImpl<E> getFilterClause() {
        return filterClause;
    }

    public void setFilterClause(FilterClauseImpl<E> filterClause) {
        this.filterClause = filterClause;
    }

    public JoinClauseImpl<E> getJoinClause() {
        return joinClause;
    }

    public void setJoinClause(JoinClauseImpl<E> joinClause) {
        this.joinClause = joinClause;
    }
}
