package com.hades.builder.sqlCommand.clauseBuilder.order;

import com.hades.model.enumeration.relational.OrderArrange;
import com.hades.model.type.EntityType;
import com.hades.model.type.Selection;

import javax.persistence.Column;

/**
 * @author alireza_bayat
 * created on 11/1/21
 */
public interface SQLOrderClause<E extends EntityType> {

    /**
     * <p>create instance {@link Class} of given entity to be used in Order clauses
     *
     * @param e passed entity object
     * @return SQLOrderClause<E> object
     */
    SQLOrderClause<E> createInstance(E e);

    /**
     * <p> create and order clause for given field name with with given {@link OrderArrange}.
     * <p>{@link OrderArrange} can be null in case of multi field in order clause
     *
     * @param fieldName    string of field name {@link Column#name()}
     * @param orderArrange {@link OrderArrange} ASC|DESC
     */
    SQLOrderClause<E> order(String fieldName, OrderArrange orderArrange);


    /**
     * <p> create and order clause for given field name with with given {@link OrderArrange}.
     * <p>{@link OrderArrange} can be null in case of multi field in order clause
     * <p>existence of field will be tested in {@link Selection}
     *
     * @param fieldName    {@link Selection} of field name {@link Column#name()}
     * @param orderArrange {@link OrderArrange} ASC|DESC
     */
    SQLOrderClause<E> order(Selection fieldName, OrderArrange orderArrange);
}
