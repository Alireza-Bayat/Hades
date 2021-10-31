package com.hades.builder.sqlCommand.rules;


import com.hades.builder.sqlCommand.SQLUtils;
import com.hades.builder.sqlCommand.clauserBuilder.ClauseBuilder;
import com.hades.builder.sqlCommand.clauserBuilder.join.JoinClause;
import com.hades.model.annotation.entity.Column;
import com.hades.model.type.EntityType;
import com.hades.model.type.Selection;

/**
 * <p>Data Query Language queries will be generated by this interface
 *
 * @author alireza_bayat
 */
public interface SQL_DQL<E extends EntityType> extends SQLUtils<E> {

    /**
     * <p> generate select query base on fields that got {@link Column} in given entity
     *
     * @param e entity class
     * @return string of query
     */
    String selectQuery(E e);

    /**
     * first approach is to get fields by  {@link Column#name()}
     *
     * <p> select columns will be generated by String of Varargs.
     * <p>each index of varargs must be present in the given entity as parameters {@link Column#name()}, otherwise that index will not effect the query
     *
     * @param e          entity class
     * @param fieldsName varargs of query columns in response
     * @return string of query
     */
    String selectQuery(E e, String... fieldsName);

    String selectQuery(E e, Selection... selections);

    String selectQuery(E e, ClauseBuilder<E> clauseBuilder);

    String selectQuery(E e, ClauseBuilder<E> clauseBuilder, String... fieldsName);


}
