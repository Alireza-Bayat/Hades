package com.hades.builder.sqlCommand.clauseBuilder;

import com.hades.builder.sqlCommand.clauseBuilder.filter.SQLFilterClause;
import com.hades.builder.sqlCommand.clauseBuilder.join.SQLJoinClause;
import com.hades.builder.sqlCommand.clauseBuilder.order.SQLOrderClause;
import com.hades.model.type.EntityType;

/**
 * @author alireza_bayat
 * created on 10/19/21
 */
public class ClauseBuilder<E extends EntityType> {

    SQLFilterClause<E> filterClause;
    SQLJoinClause<E> joinClause;
    SQLOrderClause<E> orderClause;

    public ClauseBuilder() {
    }

    public ClauseBuilder(SQLFilterClause<E> filterClause, SQLJoinClause<E> joinClause, SQLOrderClause<E> orderClause) {
        this.filterClause = filterClause;
        this.joinClause = joinClause;
        this.orderClause = orderClause;
    }

    public SQLFilterClause<E> getFilterClause() {
        return filterClause;
    }

    public void setFilterClause(SQLFilterClause<E> filterClause) {
        this.filterClause = filterClause;
    }

    public SQLJoinClause<E> getJoinClause() {
        return joinClause;
    }

    public void setJoinClause(SQLJoinClause<E> joinClause) {
        this.joinClause = joinClause;
    }

    public SQLOrderClause<E> getOrderClause() {
        return orderClause;
    }

    public void setOrderClause(SQLOrderClause<E> orderClause) {
        this.orderClause = orderClause;
    }
}
