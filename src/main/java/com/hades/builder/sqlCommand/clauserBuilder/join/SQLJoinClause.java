package com.hades.builder.sqlCommand.clauserBuilder.join;

import com.hades.builder.sqlCommand.clauserBuilder.filter.FilterClauseImpl;
import com.hades.model.type.EntityType;



/**
 * @author alireza_bayat
 * created on 10/30/21
 */
public interface SQLJoinClause<E extends EntityType> {

    SQLJoinClause<E> on();

    SQLJoinClause<E> where(FilterClauseImpl<E> filterClause);

    SQLJoinClause<E> join();

    SQLJoinClause<E> leftJoin();

    SQLJoinClause<E> rightJoin();

    SQLJoinClause<E> fullJoin();

    SQLJoinClause<E> selfJoin();


    // update join

    // delete join

    // union


}
