package com.hades.builder.sqlCommand.impl;

import com.hades.builder.sqlCommand.clauseBuilder.ClauseBuilder;
import com.hades.builder.sqlCommand.clauseBuilder.filter.FilterClause;
import com.hades.builder.sqlCommand.clauseBuilder.join.JoinClause;
import com.hades.builder.sqlCommand.clauseBuilder.order.OrderClause;
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

        appendClauseBuilders(clauseBuilder, query);

        return query.toString();
    }

    @Override
    public String selectQuery(E e, ClauseBuilder<E> clauseBuilder, String... fieldsName) {
        Class<?> entity = getClazz(e);
        Table tableAnnotation = getTableAnnotation(entity);
        String tableAlias = getTableName(tableAnnotation);
        StringBuilder query = new StringBuilder();

        addQueryKeyWord(query, QueryKeyWords.SELECT);
        appendSelectColumns(entity.getDeclaredFields(), query, tableAlias, fieldsName);

        appendFromClause(query, tableAnnotation.name(), tableAlias);

        appendClauseBuilders(clauseBuilder, query);

        return query.toString();
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
                query.append(tableAlias).append(addQueryKeyOperator(QueryKeyOperators.DOT)).append(columnAnnotation.name()).append(addQueryKeyOperator(QueryKeyOperators.COMMA));
        }
        removeLastIndexStringBuilder(query);
    }


    /**
     * <p> will generate selected columns according to the  array of fields that given to the functions
     * and existence of filed name in {@link Selection} varargs
     * <p> in case field name contains '.' which is equivalence for specifying alias no validation occurs on field.
     *
     * @param fields     array of fields needed to used in select query
     * @param query      queryBuilder string
     * @param tableAlias entity alias mentioned on entity
     * @param selections {@link Selection} varargs of fieldNames
     */
    private void appendSelectColumns(Field[] fields, StringBuilder query, String tableAlias, Selection... selections) {
        for (Selection s : selections) {
            if (s.getFieldName().contains(".")) {
                query.append(s).append(addQueryKeyOperator(QueryKeyOperators.COMMA));
                continue;
            }
            Arrays.stream(fields).forEach(field -> {
                field.setAccessible(true);
                Column columnAnnotation = field.getDeclaredAnnotation(Column.class);
                if (columnAnnotation.name().equalsIgnoreCase(s.getFieldName()))
                    query.append(tableAlias).append(addQueryKeyOperator(QueryKeyOperators.DOT)).append(columnAnnotation.name()).append(addQueryKeyOperator(QueryKeyOperators.COMMA));
            });
        }
        removeLastIndexStringBuilder(query);
    }


    /**
     * <p> will generate selected columns according to the  array of fields that given to the functions
     * and existence of filed name in String varargs
     * <p> in case field name contains '.' which is equivalence for specifying alias no validation occurs on field.
     *
     * @param fields     array of fields needed to used in select query
     * @param query      queryBuilder string
     * @param tableAlias entity alias mentioned on entity
     * @param fieldsName String varargs of fieldName
     */
    private void appendSelectColumns(Field[] fields, StringBuilder query, String tableAlias, String... fieldsName) {
        for (String s : fieldsName) {
            if (s.contains(".")) {
                query.append(s).append(addQueryKeyOperator(QueryKeyOperators.COMMA));
                continue;
            }
            Arrays.stream(fields).forEach(field -> {
                field.setAccessible(true);
                Column columnAnnotation = field.getDeclaredAnnotation(Column.class);
                if (columnAnnotation.name().equalsIgnoreCase(s))
                    query.append(tableAlias).append(addQueryKeyOperator(QueryKeyOperators.DOT)).append(columnAnnotation.name()).append(addQueryKeyOperator(QueryKeyOperators.COMMA));
            });
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

    //<editor-fold defaultstate="collapsed" desc="CLAUSE_BUILDERS">
    private void appendClauseBuilders(ClauseBuilder<E> clauseBuilder, StringBuilder query) {
        appendJoinClause((JoinClause<E>) clauseBuilder.getJoinClause(), query);
        appendFilterClause((FilterClause<E>) clauseBuilder.getFilterClause(), query);
        appendOrderClause((OrderClause<E>) clauseBuilder.getOrderClause(), query);
    }

    private void appendJoinClause(JoinClause<E> joinClause, StringBuilder query) {
        if (joinClause != null && joinClause.getClause() != null)
            query.append(joinClause.getClause());
    }

    private void appendFilterClause(FilterClause<E> filterClause, StringBuilder query) {
        if (filterClause != null && filterClause.getClause() != null) {
            addQueryKeyWord(query, QueryKeyWords.WHERE);
            query.append(filterClause.getClause());
        }
    }

    private void appendOrderClause(OrderClause<E> orderClause, StringBuilder query) {
        if (orderClause != null && orderClause.getClause() != null) {
            addQueryKeyWord(query, QueryKeyWords.ORDER_BY);
            query.append(removeLastIndexStringBuilder(orderClause.getClause()));
        }
    }
    //</editor-fold>


    //</editor-fold>

}
