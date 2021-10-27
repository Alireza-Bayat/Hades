package com.hades.builder.sqlCommand;

import com.hades.builder.sqlCommand.clauserBuilder.ClauseBuilder;
import com.hades.model.type.EntityType;
import com.hades.model.type.Selection;

/**
 * @author alireza_bayat
 */
public interface SQLCommands<E extends EntityType> {

    //<editor-fold defaultstate="collapsed" desc="DQL">
    String findAll(E e);

    String findAll(E e, String... fieldsName);

    String findAll(E e, Selection... selections);

    String findAll(E e, ClauseBuilder<E> clauseBuilder);

    String findAll(E e, ClauseBuilder<E> clauseBuilder, String... fieldsName);
    //</editor-fold>

}
