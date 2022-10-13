package com.hades.builder.sqlCommand.clauserBuilder.filter;

import com.hades.model.type.EntityType;
import com.hades.model.type.Selection;

import javax.persistence.Column;

/**
 * <p> operation in where clause will be handled in this interface
 *
 * @author alireza_bayat
 * created on 10/27/21
 */
public interface SQLFilterClause<E extends EntityType> {


    /**
     * <p>create instance {@link Class} of given entity to be used in filter clauses
     * <p> probably not needed in second approach
     *
     * @param e passed entity object
     * @return SQLFilterClause<E> object
     */
    SQLFilterClause<E> createInstance(E e);

    /**
     * <p> equal operand in standard query language
     * main purpose is to set equality operand between given field and filterPhrase
     *
     * @param field        field name which must be present as {@link Column#name()} in entity class
     * @param filterPhrase filtered value in field
     * @return SQLFilterClause<E> object
     */
    SQLFilterClause<E> equal(String field, Object filterPhrase);

    /**
     * <p> equal operand in standard query language
     * main purpose is to set equality operand between given field and filterPhrase
     *
     * @param selection    field name which must be present as {@link Column#name()} in entity class stored in {@link Selection#fieldName}
     * @param filterPhrase filtered value in field
     * @return SQLFilterClause<E> object
     */
    SQLFilterClause<E> equal(Selection selection, Object filterPhrase);

    /**
     * <p> not equal operand in standard query language
     * main purpose is to set not equality operand between given field and filterPhrase
     *
     * @param field        field name which must be present as {@link Column#name()} in entity class
     * @param filterPhrase filtered value in field
     * @return SQLFilterClause<E> object
     */
    SQLFilterClause<E> notEqual(String field, Object filterPhrase);

    /**
     * <p> equal operand in standard query language
     * main purpose is to set equality operand between given field and filterPhrase
     *
     * @param selection    field name which must be present as {@link Column#name()} in entity class stored in {@link Selection#fieldName}
     * @param filterPhrase filtered value in field
     * @return SQLFilterClause<E> object
     */
    SQLFilterClause<E> notEqual(Selection selection, Object filterPhrase);

    /**
     * to append `and` key word in where clause
     */
    SQLFilterClause<E> and();

    /**
     * to append `and` key word and let some filter to be run in parentheses
     */
    SQLFilterClause<E> and(String customQuery);

    /**
     * to append `or` key word in where clause
     */
    SQLFilterClause<E> or();

    /**
     * to append `or` key word and let some filter to be run in parentheses
     */
    SQLFilterClause<E> or(String customQuery);

    /**
     * <p> In operand in standard language
     *
     * @param field field name which must be present as {@link Column#name()} in entity class
     * @param items varargs of all the objects that will appear in final clause
     * @return SQLFilterClause<E> object
     */
    SQLFilterClause<E> in(String field, Object... items);

    /**
     * <p> In operand in standard language
     *
     * @param field field name which must be present as {@link Column#name()} in entity class
     * @param customQuery custom objects that will appear in final clause
     * @return SQLFilterClause<E> object
     */
    SQLFilterClause<E> in(String field, String customQuery);

    /**
     * <p> notIn operand in standard language
     *
     * @param field field name which must be present as {@link Column#name()} in entity class
     * @param items varargs of all the objects that will appear in final clause
     * @return SQLFilterClause<E> object
     */
    SQLFilterClause<E> notIn(String field, Object... items);

    /**
     * <p> notIn operand in standard language
     *
     * @param field field name which must be present as {@link Column#name()} in entity class
     * @param customQuery custom objects that will appear in final clause
     * @return SQLFilterClause<E> object
     */
    SQLFilterClause<E> notIn(String field, String customQuery);

    /**
     * <p> exists operand in standard language
     *
     * @param customQuery exact query will appear in final query
     * @return SQLFilterClause<E> object
     */
    SQLFilterClause<E> exists(String customQuery);

    /**
     * <p> not exists operand in standard language
     *
     * @param customQuery exact query will be appeared in final query
     * @return SQLFilterClause<E> object
     */
    SQLFilterClause<E> notExists(String customQuery);

    /**
     * <p> like operand in standard query language
     * to generate like phrase in between given fields
     *
     * @param selection    field name which must be present as {@link Column#name()} in entity class stored in {@link Selection#fieldName}
     * @param filterPhrase filtered value in field
     * @return SQLFilterClause<E> object
     */
    SQLFilterClause<E> like(Selection selection, String filterPhrase);

    /**
     * <p> like operand in standard query language
     * to generate like phrase in between given fields
     *
     * @param field        field name which must be present as {@link Column#name()} in entity class
     * @param filterPhrase filtered value in field
     * @return SQLFilterClause<E> object
     */
    SQLFilterClause<E> like(String field, String filterPhrase);

    SQLFilterClause<E> innerSelect();

    //TODO between, not, is, null

    /**
     * <p> any customized filter that is not supported by main {@link SQLFilterClause} can be specifies by this function
     *
     * @param customClause any customized filter clause
     * @return SQLFilterClause<E> object
     */
    SQLFilterClause<E> customClause(String customClause);

}
