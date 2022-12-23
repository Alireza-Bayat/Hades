package com.hades.builder.sqlCommand;

import java.lang.reflect.InvocationTargetException;

import com.hades.builder.sqlCommand.clauseBuilder.ClauseBuilder;
import com.hades.model.type.EntityType;
import com.hades.model.type.Selection;

/**
 * @author alireza_bayat
 */
public interface SQLCommands<E extends EntityType> {

    //<editor-fold defaultstate="collapsed" desc="DQL">
    String findAllQuery(E e);

    String findAllQuery(E e, String... fieldsName);

    String findAllQuery(E e, Selection... selections);

    String findAllQuery(E e, ClauseBuilder<E> clauseBuilder);

    String findAllQuery(E e, ClauseBuilder<E> clauseBuilder, String... fieldsName);

    String findQuery(E e, ClauseBuilder<E> clauseBuilder);

    String findQuery(E e, ClauseBuilder<E> clauseBuilder, String... fieldsName);
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="DML">
    String insertQuery(E e) throws IllegalAccessException, InvocationTargetException;
    //</editor-fold>

}
