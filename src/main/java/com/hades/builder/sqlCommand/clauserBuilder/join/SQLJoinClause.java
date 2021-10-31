package com.hades.builder.sqlCommand.clauserBuilder.join;

import com.hades.builder.sqlCommand.clauserBuilder.filter.FilterClause;
import com.hades.model.enumeration.relational.JoinTypes;
import com.hades.model.type.EntityType;


/**
 * @author alireza_bayat
 * created on 10/30/21
 */
public interface SQLJoinClause<E extends EntityType> {

    SQLJoinClause<E> createInstance(E e);

    SQLJoinClause<E> on();

    SQLJoinClause<E> where(FilterClause<E> filterClause);

    SQLJoinClause<E> join(Class<?> referencedClass, String entityKey, String referencedKey, JoinTypes joinTypes);

    SQLJoinClause<E> selfJoin();

    SQLJoinClause<E> customJoin(String customJoin);


    // update join

    // delete join

    // union


}
