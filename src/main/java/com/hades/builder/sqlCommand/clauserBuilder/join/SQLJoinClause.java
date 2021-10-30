package com.hades.builder.sqlCommand.clauserBuilder.join;

import com.hades.builder.sqlCommand.clauserBuilder.filter.FilterClauseImpl;
import com.hades.model.type.EntityType;


/**
 * @author alireza_bayat
 * created on 10/30/21
 */
public interface SQLJoinClause<E extends EntityType, T extends EntityType> {

    SQLJoinClause<E, T> on();

    SQLJoinClause<E, T> where(FilterClauseImpl<E> filterClause);

    SQLJoinClause<E, T> join();

    SQLJoinClause<E, T> leftJoin();

    SQLJoinClause<E, T> rightJoin();

    SQLJoinClause<E, T> fullJoin();

    SQLJoinClause<E, T> selfJoin();


    // update join

    // delete join

    // union


}
