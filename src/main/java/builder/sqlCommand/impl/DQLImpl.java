package builder.sqlCommand.impl;

import builder.sqlCommand.clauserBuilder.ClauseBuilder;
import builder.sqlCommand.rules.SQL_DQL;
import model.annotation.entity.Column;
import model.annotation.entity.Table;
import model.enumeration.relational.QueryKeyWords;
import model.type.EntityType;
import model.type.Selection;

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

        return query.toString();
    }

    @Override
    public String selectQuery(E e, ClauseBuilder clauseBuilder) {
        return null;
    }

    @Override
    public String selectQuery(E e, ClauseBuilder clauseBuilder, String... fieldsName) {
        return null;
    }


}
