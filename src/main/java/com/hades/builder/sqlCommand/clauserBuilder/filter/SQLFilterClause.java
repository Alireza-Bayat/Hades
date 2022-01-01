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

    //TODO AND multi ()
    SQLFilterClause<E> and();

    //TODO OR multi()
    SQLFilterClause<E> or();

    SQLFilterClause<E> in(String field, Object... items);

    SQLFilterClause<E> in(String field);

    //TODO not in with inner select
    SQLFilterClause<E> notIn(String field, Object... items);

    SQLFilterClause<E> innerSelect();

    //TODO like,exists, between, not, is, null

    /**
     * <p> any customized filter that is not supported by main {@link SQLFilterClause} can be specifies by this function
     *
     * @param customClause any customized filter clause
     * @return SQLFilterClause<E> object
     */
    SQLFilterClause<E> customClause(String customClause);

}
