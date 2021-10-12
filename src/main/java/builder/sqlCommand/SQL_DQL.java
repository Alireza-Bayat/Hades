package builder.sqlCommand;


import exceptions.AnnotationNotPresentException;
import model.annotation.entity.Column;
import model.annotation.entity.Table;

import java.lang.reflect.Field;

/**
 * <p>Data Query Language queries will be generated by this interface
 *
 * @author alireza_bayat
 */
public interface SQL_DQL<E> {

    //TODO SELECT
    default String selectQuery(E e) {
        Class<?> entity = e.getClass();
        Table tableAnnotation = getTableAnnotation(entity);
        StringBuilder query = new StringBuilder();

        query.append(" SELECT ");
        for (Field declaredField : entity.getDeclaredFields()) {
            declaredField.setAccessible(true);
            Column columnAnnotation = declaredField.getDeclaredAnnotation(Column.class);
            if (columnAnnotation != null)
                query.append(columnAnnotation.name()).append(",");
        }

        query.delete(query.length() - 1, query.length());
        query.append(" FROM ").append(tableAnnotation.name());
        return query.toString();
    }

    default String selectQuery(E e, Field... parameter) {
        Class<?> entity = e.getClass();
        Table tableAnnotation = getTableAnnotation(entity);
        StringBuilder query = new StringBuilder();

        //TODO parameters ????

        return "";

    }

    default Table getTableAnnotation(Class<?> entity) {
        if (entity.isAnnotationPresent(Table.class)) {
            return entity.getDeclaredAnnotation(Table.class);
        } else
            throw new AnnotationNotPresentException("Table annotation is not present on -> " + entity.getName());
    }

}
