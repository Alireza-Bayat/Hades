package com.hades.builder.sqlCommand.impl;

import com.hades.builder.sqlCommand.clauserBuilder.ClauseBuilder;
import com.hades.builder.sqlCommand.clauserBuilder.filter.FilterClause;
import com.hades.builder.sqlCommand.clauserBuilder.join.JoinClause;
import com.hades.builder.sqlCommand.rules.SQL_DQL;
import com.hades.model.enumeration.relational.QueryKeyOperators;
import com.hades.model.enumeration.relational.QueryKeyWords;
import com.hades.model.type.EntityType;
import com.hades.model.type.Selection;

import javax.persistence.Column;
import javax.persistence.Table;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author alireza_bayat
 * created on 10/19/21
 */
public class DQLImpl<E extends EntityType> implements SQL_DQL<E> {

    @Override
    public String selectQuery(E e) {
        Class<?> entity = getClazz(e);
        Table tableAnnotation = getTableAnnotation(entity);
        String tableAlias = getTableName(tableAnnotation);
        StringBuilder query = new StringBuilder();

        addQueryKeyWord(query, QueryKeyWords.SELECT);
        appendSelectColumns(entity.getDeclaredFields(), query, tableAlias);

        appendFromClause(query, tableAnnotation.name(), tableAlias);

        return query.toString();
    }

    //TODO some custom select fields
    @Override
    public String selectQuery(E e, String... fieldsName) {
        Class<?> entity = getClazz(e);
        Table tableAnnotation = getTableAnnotation(entity);
        String tableAlias = getTableName(tableAnnotation);
        StringBuilder query = new StringBuilder();

        addQueryKeyWord(query, QueryKeyWords.SELECT);
        appendSelectColumns(entity.getDeclaredFields(), query, tableAlias, fieldsName);

        appendFromClause(query, tableAnnotation.name(), tableAlias);

        return query.toString();
    }

    @Override
    public String selectQuery(E e, Selection... selections) {
        Class<?> entity = getClazz(e);
        Table tableAnnotation = getTableAnnotation(entity);
        String tableAlias = getTableName(tableAnnotation);
        StringBuilder query = new StringBuilder();

        addQueryKeyWord(query, QueryKeyWords.SELECT);
        appendSelectColumns(entity.getDeclaredFields(), query, tableAlias, selections);

        appendFromClause(query, tableAnnotation.name(), tableAlias);

        return query.toString();
    }

    @Override
    public String selectQuery(E e, ClauseBuilder<E> clauseBuilder) {
        Class<?> entity = getClazz(e);
        Table tableAnnotation = getTableAnnotation(entity);
        String tableAlias = getTableName(tableAnnotation);
        StringBuilder query = new StringBuilder();

        addQueryKeyWord(query, QueryKeyWords.SELECT);
        appendSelectColumns(entity.getDeclaredFields(), query, tableAlias);

        appendFromClause(query, tableAnnotation.name(), tableAlias);

        //TODO JOIN
        JoinClause<E> joinClause = clauseBuilder.getJoinClause();
        query.append(joinClause.getJoinClause());

        //TODO WHERE
        FilterClause<E> filterClause = clauseBuilder.getFilterClause();
        addQueryKeyWord(query, QueryKeyWords.WHERE);
        query.append(filterClause.getFilterClause());

        return query.toString();
    }

    @Override
    public String selectQuery(E e, ClauseBuilder<E> clauseBuilder, String... fieldsName) {
        return null;
    }


    //<editor-fold defaultstate="collapsed" desc="PRIVATE_FUNCTIONS">

    //<editor-fold defaultstate="collapsed" desc="SELECT_COLUMNS">

    /**
     * <p> will generate selected columns according to the  array of fields that given to the functions
     *
     * @param fields     array of fields needed to used in select query
     * @param query      queryBuilder string
     * @param tableAlias entity alias mentioned on entity
     */
    private void appendSelectColumns(Field[] fields, StringBuilder query, String tableAlias) {
        for (Field declaredField : fields) {
            declaredField.setAccessible(true);
            Column columnAnnotation = declaredField.getDeclaredAnnotation(Column.class);
            if (columnAnnotation != null)
                query.append(tableAlias).append(addQueryKeyOperator(QueryKeyOperators.DOT)).append(columnAnnotation.name()).append(",");
        }
        removeLastIndexStringBuilder(query);
    }


    /**
     * <p> will generate selected columns according to the  array of fields that given to the functions
     * and existence of filed name in {@link Selection} varargs
     *
     * @param fields     array of fields needed to used in select query
     * @param query      queryBuilder string
     * @param tableAlias entity alias mentioned on entity
     * @param selections {@link Selection} varargs of fieldNames
     */
    private void appendSelectColumns(Field[] fields, StringBuilder query, String tableAlias, Selection... selections) {
        for (Field declaredField : fields) {
            declaredField.setAccessible(true);
            Column columnAnnotation = declaredField.getDeclaredAnnotation(Column.class);
            if (Arrays.stream(selections).anyMatch(selection -> selection.getFieldName().equalsIgnoreCase(columnAnnotation.name())))
                query.append(tableAlias).append(addQueryKeyOperator(QueryKeyOperators.DOT)).append(columnAnnotation.name()).append(",");
        }
        removeLastIndexStringBuilder(query);
    }


    /**
     * <p> will generate selected columns according to the  array of fields that given to the functions
     * and existence of filed name in String varargs
     *
     * @param fields     array of fields needed to used in select query
     * @param query      queryBuilder string
     * @param tableAlias entity alias mentioned on entity
     * @param fieldsName String varargs of fieldName
     */
    private void appendSelectColumns(Field[] fields, StringBuilder query, String tableAlias, String... fieldsName) {
        for (Field declaredField : fields) {
            declaredField.setAccessible(true);
            Column columnAnnotation = declaredField.getDeclaredAnnotation(Column.class);
            if (Arrays.stream(fieldsName).anyMatch(s -> s.equalsIgnoreCase(columnAnnotation.name())))
                query.append(tableAlias).append(addQueryKeyOperator(QueryKeyOperators.DOT)).append(columnAnnotation.name()).append(",");
        }
        removeLastIndexStringBuilder(query);
    }
    //</editor-fold>

    /**
     * will generate <code>from</code> part of query
     *
     * <pre>
     *     FROM table_name AS table_alias
     * </pre>
     */
    private void appendFromClause(StringBuilder query, String tableName, String tableAlias) {
        addQueryKeyWord(query, QueryKeyWords.FROM);
        query.append(tableName);
        addQueryKeyWord(query, QueryKeyWords.AS);
        query.append(tableAlias);

    }


    //</editor-fold>

}
