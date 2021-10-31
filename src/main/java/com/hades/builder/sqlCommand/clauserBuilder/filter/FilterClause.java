package com.hades.builder.sqlCommand.clauserBuilder.filter;

import com.hades.builder.sqlCommand.SQLUtils;
import com.hades.model.enumeration.relational.QueryKeyOperators;
import com.hades.model.enumeration.relational.QueryKeyWords;
import com.hades.model.type.EntityType;
import com.hades.model.type.Selection;

/**
 * <p>
 * there is 2 way to create an object of {@link FilterClause}
 * <ol>
 *     <li> create object with constructor -> {@link #FilterClause(Class)} in which developer must pass {@link Class} object of entity type</li>
 *     <li> create Object with constructor -> {@link #FilterClauseImpl()} in which developer must create {@link Class} instance by calling {@link #createInstance(EntityType)}</li>
 * </ol>
 *
 * @author alireza_bayat
 * created on 10/19/21
 */
public class FilterClause<E extends EntityType> extends FilterElements implements SQLFilterClause<E> {

    //TODO probably not the best way to use it's function
    // sqlFilterClause extend was tested due to visibility of functions out of library - > ????
    private final SQLUtils<E> sqlUtils = new SQLUtils<E>() {
    };
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
    public FilterClause<E> equal(String field, String filterPhrase) {
        super.setFilterClause(super.filterClause.concat(sqlUtils.getTableName(sqlUtils.getTableAnnotation(clazz)))
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.DOT)).concat(field)
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.EQUAL)).concat(filterPhrase));
        return this;
    }

    @Override
    public FilterClause<E> equal(Selection selection, String filterPhrase) {
        sqlUtils.fieldExistInEntity(clazz, selection);
        super.setFilterClause(super.filterClause.concat(sqlUtils.getTableName(sqlUtils.getTableAnnotation(clazz)))
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.DOT)).concat(selection.getFieldName())
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.EQUAL)).concat(filterPhrase));
        return this;
    }

    @Override
    public SQLFilterClause<E> notEqual(String field, String filterPhrase) {
        super.setFilterClause(super.filterClause.concat(sqlUtils.getTableName(sqlUtils.getTableAnnotation(clazz)))
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.DOT)).concat(field)
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.NOT_EQUAL)).concat(filterPhrase));
        return this;
    }

    @Override
    public SQLFilterClause<E> notEqual(Selection selection, String filterPhrase) {
        sqlUtils.fieldExistInEntity(clazz, selection);
        super.setFilterClause(super.filterClause.concat(sqlUtils.getTableName(sqlUtils.getTableAnnotation(clazz)))
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.DOT)).concat(selection.getFieldName())
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.NOT_EQUAL)).concat(filterPhrase));
        return this;
    }

    @Override
    public FilterClause<E> and() {
        super.setFilterClause(super.filterClause.concat(sqlUtils.addQueryKeyWord(QueryKeyWords.AND)));
        return this;
    }

    @Override
    public FilterClause<E> or() {
        super.setFilterClause(super.filterClause.concat(sqlUtils.addQueryKeyWord(QueryKeyWords.OR)));
        return this;
    }

    //TODO refactor
    @Override
    public SQLFilterClause<E> in(String field, String... items) {
        String inBlock = "";
        inBlock = inBlock.concat(" ").concat(sqlUtils.getTableName(sqlUtils.getTableAnnotation(clazz)))
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.DOT))
                .concat(field).concat(sqlUtils.addQueryKeyWord(QueryKeyWords.IN))
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.OPEN_PARENTHESES))
                .concat(getItemsCommaSeparated(items))
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.CLOSE_PARENTHESES));
        super.setFilterClause(filterClause.concat(inBlock));
        return this;
    }

    @Override
    public SQLFilterClause<E> notIn(String field, String... items) {
        String inBlock = "";
        inBlock = inBlock.concat(" ").concat(sqlUtils.getTableName(sqlUtils.getTableAnnotation(clazz)))
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.DOT))
                .concat(field).concat(sqlUtils.addQueryKeyWord(QueryKeyWords.NOT_IN))
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.OPEN_PARENTHESES))
                .concat(getItemsCommaSeparated(items))
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.CLOSE_PARENTHESES));
        super.setFilterClause(filterClause.concat(inBlock));
        return this;
    }

    @Override
    public SQLFilterClause<E> customClause(String customClause) {
        super.setFilterClause(filterClause.concat(" ").concat(customClause).concat(" "));
        return this;
    }

    //general functions
    private String getItemsCommaSeparated(String... items) {
        String commaSeparated = "";
        for (String item : items)
            commaSeparated = commaSeparated.concat(item).concat(",");
        commaSeparated = sqlUtils.removeLastIndexStringBuilder(commaSeparated);
        return commaSeparated;
    }
}
