package com.hades.services;

import com.hades.builder.sqlCommand.SQLCommands;

/**
 * @author alireza_bayat
 * created on 10/12/21
 */
public class RelationalServices<E> implements SQLCommands<E> {

    @Override
    public String getQuery(E e) {
        return selectQuery(e);
    }
}
