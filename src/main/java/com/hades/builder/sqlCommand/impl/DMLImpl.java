package com.hades.builder.sqlCommand.impl;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.persistence.Column;
import javax.persistence.Table;

import com.hades.builder.sqlCommand.rules.SQL_DML;
import com.hades.model.type.EntityType;

public class DMLImpl<E extends EntityType> implements SQL_DML<E> {

    @Override
    public String insert(E e) throws IllegalAccessException, InvocationTargetException {
        Class<?> entity = getClazz(e);
        Table tableAnnotation = getTableAnnotation(entity);
        String tableAlias = getTableName(tableAnnotation);
        StringBuilder query = new StringBuilder();
        generateFieldsForInsert(entity, e);
        return null;
    }

    @Override
    public String update(E e) {
        return null;
    }

    @Override
    public String delete(E e) {
        return null;
    }

    private String generateFieldsForInsert(Class<?> entity, E e) throws IllegalAccessException, InvocationTargetException {
        for (Field declaredField : entity.getDeclaredFields()) {
            declaredField.setAccessible(true);
            if (declaredField.isAnnotationPresent(Column.class)) {
                Column column = declaredField.getAnnotation(Column.class);
                //todo get column name and values to create the query
//                String name = column.name();
//                Class<?> type = declaredField.getType();
//                Object o = runGetter(declaredField, entity, e);
            }
        }
        return "";
    }

    public Object runGetter(Field field, Class<?> entity, E e) throws InvocationTargetException, IllegalAccessException {
        for (Method method : entity.getMethods())
            if ((method.getName().startsWith("get")) && (method.getName().length() == (field.getName().length() + 3)))
                if (method.getName().toLowerCase().endsWith(field.getName().toLowerCase()))
                    return method.invoke(e);

        return null;
    }
}
