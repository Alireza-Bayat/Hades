package com.hades.builder.sqlCommand.clauserBuilder.filter;

import com.hades.builder.sqlCommand.SQLUtils;
import com.hades.model.enumeration.relational.QueryKeyOperators;
import com.hades.model.enumeration.relational.QueryKeyWords;
import com.hades.model.type.EntityType;
import com.hades.model.type.Selection;

/**
 * @author alireza_bayat
 * created on 10/19/21
 */
public class FilterClause<E extends EntityType> extends FilterElements implements SQLFilterClause<E> {

    //TODO probably not the best way to use it's function
    // sqlFilterClause extend was tested due to visibility of functions out of library - > ????
    private final SQLUtils<E> sqlUtils = new SQLUtils<E>() {
    };

    @Override
    public FilterClause<E> equal(E e, String field, String filterPhrase) {
        super.setFilterClause(super.filterClause.concat(sqlUtils.getTableAlias(sqlUtils.getTableAnnotation(sqlUtils.getClazz(e))))
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.DOT)).concat(field)
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.EQUAL)).concat(filterPhrase));
        return this;
    }

    @Override
    public FilterClause<E> equal(E e, Selection selection, String filterPhrase) {
        sqlUtils.fieldExistInEntity(e, selection);
        super.setFilterClause(super.filterClause.concat(sqlUtils.getTableAlias(sqlUtils.getTableAnnotation(sqlUtils.getClazz(e))))
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.DOT)).concat(selection.getFieldName())
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.EQUAL)).concat(filterPhrase));
        return this;
    }

    @Override
    public SQLFilterClause<E> notEqual(E e, String field, String filterPhrase) {
        super.setFilterClause(super.filterClause.concat(sqlUtils.getTableAlias(sqlUtils.getTableAnnotation(sqlUtils.getClazz(e))))
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.DOT)).concat(field)
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.NOT_EQUAL)).concat(filterPhrase));
        return this;
    }

    @Override
    public SQLFilterClause<E> notEqual(E e, Selection selection, String filterPhrase) {
        sqlUtils.fieldExistInEntity(e, selection);
        super.setFilterClause(super.filterClause.concat(sqlUtils.getTableAlias(sqlUtils.getTableAnnotation(sqlUtils.getClazz(e))))
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.DOT)).concat(selection.getFieldName())
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.NOT_EQUAL)).concat(filterPhrase));
        return this;
    }

    @Override
    public FilterClause<E> and() {
        super.setFilterClause(super.filterClause.concat(" ").concat(sqlUtils.addQueryKeyWord(QueryKeyWords.AND)).concat(" "));
        return this;
    }

    @Override
    public FilterClause<E> or() {
        super.setFilterClause(super.filterClause.concat(" ").concat(sqlUtils.addQueryKeyWord(QueryKeyWords.OR)).concat(" "));
        return this;
    }

    //TODO refactor
    @Override
    public SQLFilterClause<E> in(E e, String field, String... items) {
        String inBlock = "";
        inBlock = inBlock.concat(" ").concat(sqlUtils.getTableAlias(sqlUtils.getTableAnnotation(sqlUtils.getClazz(e))))
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.DOT))
                .concat(field).concat(sqlUtils.addQueryKeyWord(QueryKeyWords.IN))
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.OPEN_PARENTHESES))
                .concat(getItemsCommaSeparated(items))
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.CLOSE_PARENTHESES));
        super.setFilterClause(filterClause.concat(inBlock));
        return this;
    }

    @Override
    public SQLFilterClause<E> notIn(E e, String field, String... items) {
        String inBlock = "";
        inBlock = inBlock.concat(" ").concat(sqlUtils.getTableAlias(sqlUtils.getTableAnnotation(sqlUtils.getClazz(e))))
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
