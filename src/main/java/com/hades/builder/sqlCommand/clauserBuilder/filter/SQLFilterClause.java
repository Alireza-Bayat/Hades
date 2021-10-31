package com.hades.builder.sqlCommand.clauserBuilder.filter;

import com.hades.model.annotation.entity.Column;
import com.hades.model.type.EntityType;
import com.hades.model.type.Selection;

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
    SQLFilterClause<E> equal(String field, String filterPhrase);

    /**
     * <p> equal operand in standard query language
     * main purpose is to set equality operand between given field and filterPhrase
     *
     * @param selection    field name which must be present as {@link Column#name()} in entity class stored in {@link Selection#fieldName}
     * @param filterPhrase filtered value in field
     * @return SQLFilterClause<E> object
     */
    SQLFilterClause<E> equal(Selection selection, String filterPhrase);

    /**
     * <p> not equal operand in standard query language
     * main purpose is to set not equality operand between given field and filterPhrase
     *
     * @param field        field name which must be present as {@link Column#name()} in entity class
     * @param filterPhrase filtered value in field
     * @return SQLFilterClause<E> object
     */
    SQLFilterClause<E> notEqual(String field, String filterPhrase);

    /**
     * <p> equal operand in standard query language
     * main purpose is to set equality operand between given field and filterPhrase
     *
     * @param selection    field name which must be present as {@link Column#name()} in entity class stored in {@link Selection#fieldName}
     * @param filterPhrase filtered value in field
     * @return SQLFilterClause<E> object
     */
    SQLFilterClause<E> notEqual(Selection selection, String filterPhrase);

    //TODO AND multi ()
    SQLFilterClause<E> and();

    //TODO OR multi()
    SQLFilterClause<E> or();

    //TODO in with inner select
    SQLFilterClause<E> in(String field, String... items);

    //TODO not in with inner select
    SQLFilterClause<E> notIn(String field, String... items);

    //TODO like,exists, between, not, is, null

    SQLFilterClause<E> customClause(String customClause);

}
