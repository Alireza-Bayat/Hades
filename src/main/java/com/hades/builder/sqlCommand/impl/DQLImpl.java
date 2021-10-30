package com.hades.builder.sqlCommand.impl;

import com.hades.builder.sqlCommand.clauserBuilder.ClauseBuilder;
import com.hades.builder.sqlCommand.clauserBuilder.filter.FilterClauseImpl;
import com.hades.builder.sqlCommand.rules.SQL_DQL;
import com.hades.model.annotation.entity.Column;
import com.hades.model.annotation.entity.Table;
import com.hades.model.enumeration.relational.QueryKeyWords;
import com.hades.model.type.EntityType;
import com.hades.model.type.Selection;

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
        StringBuilder query = new StringBuilder();

        addQueryKeyWord(query, QueryKeyWords.SELECT);
        for (Field declaredField : entity.getDeclaredFields()) {
            declaredField.setAccessible(true);
            Column columnAnnotation = declaredField.getDeclaredAnnotation(Column.class);
            if (columnAnnotation != null)
                query.append(columnAnnotation.name()).append(",");
        }

        removeLastIndexStringBuilder(query);
        addQueryKeyWord(query, QueryKeyWords.FROM);
        query.append(tableAnnotation.name());
        addQueryKeyWord(query, QueryKeyWords.AS);
        query.append(getTableAlias(tableAnnotation));
        return query.toString();
    }

    @Override
    public String selectQuery(E e, String... fieldsName) {
        Class<?> entity = getClazz(e);
        Table tableAnnotation = getTableAnnotation(entity);
        StringBuilder query = new StringBuilder();

        addQueryKeyWord(query, QueryKeyWords.SELECT);
        for (Field declaredField : entity.getDeclaredFields()) {
            declaredField.setAccessible(true);
            Column columnAnnotation = declaredField.getDeclaredAnnotation(Column.class);
            if (Arrays.stream(fieldsName).anyMatch(s -> s.equalsIgnoreCase(columnAnnotation.name())))
                query.append(columnAnnotation.name()).append(",");
        }

        removeLastIndexStringBuilder(query);
        addQueryKeyWord(query, QueryKeyWords.FROM);
        query.append(tableAnnotation.name());
        addQueryKeyWord(query, QueryKeyWords.AS);
        query.append(getTableAlias(tableAnnotation));

        return query.toString();
    }

    @Override
    public String selectQuery(E e, Selection... selections) {
        Class<?> entity = getClazz(e);
        Table tableAnnotation = getTableAnnotation(entity);
        StringBuilder query = new StringBuilder();

        addQueryKeyWord(query, QueryKeyWords.SELECT);
        for (Field declaredField : entity.getDeclaredFields()) {
            declaredField.setAccessible(true);
            Column columnAnnotation = declaredField.getDeclaredAnnotation(Column.class);
            if (Arrays.stream(selections).anyMatch(selection -> selection.getFieldName().equalsIgnoreCase(columnAnnotation.name())))
                query.append(columnAnnotation.name()).append(",");
        }

        removeLastIndexStringBuilder(query);
        addQueryKeyWord(query, QueryKeyWords.FROM);
        query.append(tableAnnotation.name());
        addQueryKeyWord(query, QueryKeyWords.AS);
        query.append(getTableAlias(tableAnnotation));

        return query.toString();
    }

    @Override
    public String selectQuery(E e, ClauseBuilder<E> clauseBuilder) {
        Class<?> entity = getClazz(e);
        Table tableAnnotation = getTableAnnotation(entity);
        StringBuilder query = new StringBuilder();

        addQueryKeyWord(query, QueryKeyWords.SELECT);
        for (Field declaredField : entity.getDeclaredFields()) {
            declaredField.setAccessible(true);
            Column columnAnnotation = declaredField.getDeclaredAnnotation(Column.class);
            if (columnAnnotation != null)
                query.append(columnAnnotation.name()).append(",");
        }

        removeLastIndexStringBuilder(query);
        addQueryKeyWord(query, QueryKeyWords.FROM);
        query.append(tableAnnotation.name());
        addQueryKeyWord(query, QueryKeyWords.AS);
        query.append(getTableAlias(tableAnnotation));

        //TODO WHERE
        FilterClauseImpl<E> filterClauseImpl = clauseBuilder.getFilterClause();
        addQueryKeyWord(query, QueryKeyWords.WHERE);
        query.append(filterClauseImpl.getFilterClause());

        return query.toString();
    }

    @Override
    public String selectQuery(E e, ClauseBuilder<E> clauseBuilder, String... fieldsName) {
        return null;
    }


}
