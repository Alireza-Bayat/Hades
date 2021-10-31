package com.hades.builder.sqlCommand;


import com.hades.exceptions.AnnotationNotPresentException;
import com.hades.model.annotation.entity.Table;
import com.hades.model.enumeration.relational.QueryKeyOperators;
import com.hades.model.enumeration.relational.QueryKeyWords;
import com.hades.model.type.EntityType;

/**
 * <p> utilities of relational databases
 *
 * @author alireza_bayat
 * created on 10/19/21
 */
public interface SQLUtils<E extends EntityType> extends SQLValidationUtils<E> {

    /**
     * <p> extract {@link Table} of entity if present
     *
     * @param entity entity class
     * @return Table
     * @throws AnnotationNotPresentException in case annotation is not present on the class
     */
    default Table getTableAnnotation(Class<?> entity) {
        if (entity.isAnnotationPresent(Table.class)) {
            return entity.getDeclaredAnnotation(Table.class);
        } else
            throw new AnnotationNotPresentException("Table annotation is not present on -> " + entity.getName());
    }


    /**
     * <p> get class object of given entity
     */
    default Class<?> getClazz(E e) {
        return e.getClass();
    }

    /**
     * <p> remove last index of string builder
     */
    default void removeLastIndexStringBuilder(StringBuilder s) {
        s.delete(s.length() - 1, s.length());
    }

    /**
     * <p> remove last index of string
     */
    default String removeLastIndexStringBuilder(String s) {
        return s.substring(0, s.length() - 1);
    }

    /**
     * @return alias name for given table in case {@link Table#alias()} is not filed then {@link Table#name()} will be used as alias
     */
    default String getTableAlias(Table table) {
        return table.alias().equalsIgnoreCase("") ? table.name() : table.alias();
    }

    default String getTableName(Table table) {
        return table.name();
    }

    default void addQueryKeyWord(StringBuilder s, QueryKeyWords queryKeyWords) {
        s.append(queryKeyWords.getKeyWord());
    }

    default String addQueryKeyWord(QueryKeyWords queryKeyWords) {
        return queryKeyWords.getKeyWord();
    }

    default String addQueryKeyOperator(QueryKeyOperators queryKeyOperators) {
        return queryKeyOperators.getOperator();
    }


}
