package com.hades.builder.sqlCommand.clauserBuilder.filter;

import com.hades.builder.sqlCommand.SQLUtilities;
import com.hades.builder.sqlCommand.SQLUtils;
import com.hades.builder.sqlCommand.clauserBuilder.ClauseElements;
import com.hades.model.enumeration.relational.QueryKeyOperators;
import com.hades.model.enumeration.relational.QueryKeyWords;
import com.hades.model.type.EntityType;
import com.hades.model.type.Selection;

/**
 * <p>
 * there is 2 way to create an object of {@link FilterClause}
 * <ol>
 *     <li> create object with constructor -> {@link #FilterClause(Class)} in which developer must pass {@link Class} object of entity type</li>
 *     <li> create Object with constructor -> {@link #FilterClause()} ()} in which developer must create {@link Class} instance by calling {@link #createInstance(EntityType)}</li>
 * </ol>
 *
 * @author alireza_bayat
 * created on 10/19/21
 * @see ClauseElements
 * @see SQLFilterClause
 */
public class FilterClause<E extends EntityType> extends ClauseElements implements SQLFilterClause<E> {

    private final SQLUtilities<E> sqlUtils = new SQLUtilities<>();
    private Class<?> clazz;

    /**
     * <p> pass entity class object as param
     */
    public FilterClause(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Override
    public FilterClause<E> createInstance(E e) {
        clazz = sqlUtils.getClazz(e);
        return this;
    }

    @Override
    public FilterClause<E> equal(String field, Object filterPhrase) {
        super.setClause(super.clause.concat(sqlUtils.getTableName(sqlUtils.getTableAnnotation(clazz)))
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.DOT)).concat(field)
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.EQUAL)).concat(sqlUtils.getFieldType(filterPhrase)));
        return this;
    }

    @Override
    public FilterClause<E> equal(Selection selection, Object filterPhrase) {
        sqlUtils.fieldExistInEntity(clazz, selection);
        super.setClause(super.clause.concat(sqlUtils.getTableName(sqlUtils.getTableAnnotation(clazz)))
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.DOT)).concat(selection.getFieldName())
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.EQUAL)).concat(sqlUtils.getFieldType(filterPhrase)));
        return this;
    }

    @Override
    public SQLFilterClause<E> notEqual(String field, Object filterPhrase) {
        super.setClause(super.clause.concat(sqlUtils.getTableName(sqlUtils.getTableAnnotation(clazz)))
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.DOT)).concat(field)
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.NOT_EQUAL)).concat(sqlUtils.getFieldType(filterPhrase)));
        return this;
    }

    @Override
    public SQLFilterClause<E> notEqual(Selection selection, Object filterPhrase) {
        sqlUtils.fieldExistInEntity(clazz, selection);
        super.setClause(super.clause.concat(sqlUtils.getTableName(sqlUtils.getTableAnnotation(clazz)))
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.DOT)).concat(selection.getFieldName())
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.NOT_EQUAL)).concat(sqlUtils.getFieldType(filterPhrase)));
        return this;
    }

    @Override
    public FilterClause<E> and() {
        super.setClause(super.clause.concat(sqlUtils.addQueryKeyWord(QueryKeyWords.AND)));
        return this;
    }

    @Override
    public SQLFilterClause<E> and(String customQuery) {
        super.setClause(super.clause.concat(sqlUtils.addQueryKeyWord(QueryKeyWords.AND))
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.OPEN_PARENTHESES))
                .concat(customQuery)
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.CLOSE_PARENTHESES)));
        return this;
    }

    @Override
    public FilterClause<E> or() {
        super.setClause(super.clause.concat(sqlUtils.addQueryKeyWord(QueryKeyWords.OR)));
        return this;
    }

    @Override
    public SQLFilterClause<E> or(String customQuery) {
        super.setClause(super.clause.concat(sqlUtils.addQueryKeyWord(QueryKeyWords.OR))
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.OPEN_PARENTHESES))
                .concat(customQuery)
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.CLOSE_PARENTHESES)));
        return this;
    }

    @Override
    public SQLFilterClause<E> in(String field, Object... items) {
        String inBlock = "";
        inBlock = inBlock.concat(" ").concat(sqlUtils.getTableName(sqlUtils.getTableAnnotation(clazz)))
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.DOT))
                .concat(field).concat(sqlUtils.addQueryKeyWord(QueryKeyWords.IN))
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.OPEN_PARENTHESES))
                .concat(getItemsCommaSeparated(items))
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.CLOSE_PARENTHESES));
        super.setClause(clause.concat(inBlock));
        return this;
    }

    @Override
    public SQLFilterClause<E> in(String field, String customQuery) {
        super.setClause(clause.concat(" ").concat(sqlUtils.getTableName(sqlUtils.getTableAnnotation(clazz))
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.DOT))
                .concat(field).concat(sqlUtils.addQueryKeyWord(QueryKeyWords.IN))
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.OPEN_PARENTHESES))
                .concat(customQuery).concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.CLOSE_PARENTHESES))));
        return this;
    }

    @Override
    public SQLFilterClause<E> notIn(String field, Object... items) {
        String inBlock = "";
        inBlock = inBlock.concat(" ").concat(sqlUtils.getTableName(sqlUtils.getTableAnnotation(clazz)))
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.DOT))
                .concat(field).concat(sqlUtils.addQueryKeyWord(QueryKeyWords.NOT_IN))
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.OPEN_PARENTHESES))
                .concat(getItemsCommaSeparated(items))
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.CLOSE_PARENTHESES));
        super.setClause(clause.concat(inBlock));
        return this;
    }

    @Override
    public SQLFilterClause<E> notIn(String field, String customQuery) {
        super.setClause(clause.concat(" ").concat(sqlUtils.getTableName(sqlUtils.getTableAnnotation(clazz))
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.DOT))
                .concat(field).concat(sqlUtils.addQueryKeyWord(QueryKeyWords.NOT_IN))
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.OPEN_PARENTHESES))
                .concat(customQuery).concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.CLOSE_PARENTHESES))));
        return this;
    }

    @Override
    public SQLFilterClause<E> exists(String customQuery) {
        super.setClause(clause.concat(sqlUtils.addQueryKeyWord(QueryKeyWords.EXISTS))
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.OPEN_PARENTHESES))
                .concat(customQuery).concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.CLOSE_PARENTHESES)));
        return this;
    }

    @Override
    public SQLFilterClause<E> notExists(String customQuery) {
        super.setClause(clause.concat(sqlUtils.addQueryKeyWord(QueryKeyWords.NOT_EXISTS))
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.OPEN_PARENTHESES))
                .concat(customQuery).concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.CLOSE_PARENTHESES)));
        return this;
    }

    @Override
    public SQLFilterClause<E> innerSelect() {
        return null;
    }

    @Override
    public SQLFilterClause<E> customClause(String customClause) {
        super.setClause(clause.concat(" ").concat(customClause).concat(" "));
        return this;
    }

    private String getItemsCommaSeparated(Object... items) {
        String commaSeparated = "";
        for (Object item : items)
            commaSeparated = commaSeparated.concat(sqlUtils.getFieldType(item)).concat(",");
        commaSeparated = sqlUtils.removeLastIndexStringBuilder(commaSeparated);
        return commaSeparated;
    }


}
