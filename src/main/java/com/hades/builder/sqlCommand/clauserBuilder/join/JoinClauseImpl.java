package com.hades.builder.sqlCommand.clauserBuilder.join;

import com.hades.builder.sqlCommand.clauserBuilder.filter.FilterClauseImpl;
import com.hades.model.type.EntityType;

/**
 * @author alireza_bayat
 * created on 10/30/21
 */
public class JoinClauseImpl<E extends EntityType, T extends EntityType> extends JoinElements implements SQLJoinClause<E, T> {

    @Override
    public JoinClauseImpl<E, T> on() {
        return null;
    }

    @Override
    public JoinClauseImpl<E, T> where(FilterClauseImpl<E> filterClause) {
        return null;
    }

    //JOIN table-name2 ON column-name1 = column-name2
    @Override
    public JoinClauseImpl<E, T> join() {
        return null;
    }

    @Override
    public JoinClauseImpl<E, T> leftJoin() {
        return null;
    }

    @Override
    public JoinClauseImpl<E, T> rightJoin() {
        return null;
    }

    @Override
    public JoinClauseImpl<E, T> fullJoin() {
        return null;
    }

    @Override
    public JoinClauseImpl<E, T> selfJoin() {
        return null;
    }
}
