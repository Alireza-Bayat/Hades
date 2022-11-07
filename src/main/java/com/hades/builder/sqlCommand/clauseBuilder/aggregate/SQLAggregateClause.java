package com.hades.builder.sqlCommand.clauseBuilder.aggregate;

import com.hades.model.type.EntityType;

/**
 * <p> all aggregate functions in sql such as SUM,AVG,COUNT,...
 *
 * @author alireza_bayat
 * created on 2/26/22
 */
public interface SQLAggregateClause<E extends EntityType> {

    /**
     * <p>create instance {@link Class} of given entity to be used in Aggregate clauses
     * <p> probably not needed in second approach
     *
     * @param e passed entity object
     * @return SQLAggregateClause<E> object
     */
    SQLAggregateClause<E> createInstance(E e);

    SQLAggregateClause<E> count(E e, String field);

    SQLAggregateClause<E> avg(E e, String field);

    SQLAggregateClause<E> sum(E e, String field);

    SQLAggregateClause<E> min(E e, String field);

    SQLAggregateClause<E> max(E e, String field);

    SQLAggregateClause<E> groupBy(String... field);

    SQLAggregateClause<E> having(String field, String filterPhrase);


}
