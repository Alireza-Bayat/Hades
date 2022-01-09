package com.hades.builder.sqlCommand;

import com.hades.exceptions.QueryGeneratorException;
import com.hades.model.type.EntityType;
import com.hades.model.type.Selection;

import javax.persistence.Column;
import java.lang.reflect.Field;

/**
 * @author alireza_bayat
 * created on 10/27/21
 */
public interface SQLValidationUtils<E extends EntityType> {

    default boolean fieldExistInEntity(Class<?> clazz, Selection selection) {
        for (Field declaredField : clazz.getDeclaredFields()) {
            declaredField.setAccessible(true);
            if (selection.getFieldName().equalsIgnoreCase(declaredField.getDeclaredAnnotation(Column.class).name()))
                return true;
        }
        throw new QueryGeneratorException(" field -> " + selection.getFieldName() + " is not present in -> " + clazz.getName());
    }

    default void extractObjectType(Object filterPhrase) {

        //TODO !??!!?!?!?!
    }
}
