package com.hades.services;

import java.lang.reflect.InvocationTargetException;

import com.hades.builder.sqlCommand.SQLCommands;
import com.hades.builder.sqlCommand.clauseBuilder.ClauseBuilder;
import com.hades.builder.sqlCommand.impl.DMLImpl;
import com.hades.builder.sqlCommand.impl.DQLImpl;
import com.hades.model.type.EntityType;
import com.hades.model.type.Selection;

/**
 * @author alireza_bayat
 * created on 10/12/21
 */
public class RelationalServices<E extends EntityType> implements SQLCommands<E> {

    private final DQLImpl<E> dql = new DQLImpl<>();
    private final DMLImpl<E> dml = new DMLImpl<>();

    //<editor-fold defaultstate="collapsed" desc="DQL">
    @Override
    public String findAllQuery(E e) {
        return dql.selectQuery(e);
    }

    @Override
    public String findAllQuery(E e, String... fieldsName) {
        return dql.selectQuery(e, fieldsName);
    }

    @Override
    public String findAllQuery(E e, Selection... selections) {
        return dql.selectQuery(e, selections);
    }

    @Override
    public String findAllQuery(E e, ClauseBuilder<E> clauseBuilder) {
        return dql.selectQuery(e, clauseBuilder);
    }

    @Override
    public String findAllQuery(E e, ClauseBuilder<E> clauseBuilder, String... fieldsName) {
        return dql.selectQuery(e, clauseBuilder, fieldsName);
    }

    @Override
    public String findQuery(E e, ClauseBuilder<E> clauseBuilder) {
        return dql.selectQuery(e, clauseBuilder);
    }

    @Override
    public String findQuery(E e, ClauseBuilder<E> clauseBuilder, String... fieldsName) {
        return dql.selectQuery(e, clauseBuilder, fieldsName);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="DML">

    @Override
    public String insertQuery(E e) throws IllegalAccessException, InvocationTargetException {
        return dml.insert(e);
    }

    //</editor-fold>
}
