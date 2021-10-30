package com.hades.builder.sqlCommand.clauserBuilder.join;

import com.hades.builder.sqlCommand.clauserBuilder.filter.FilterClauseImpl;
import com.hades.model.type.EntityType;

/**
 * @author alireza_bayat
 * created on 10/30/21
 */public class JoinClauseImpl<E extends EntityType> extends JoinElements implements SQLJoinClause<E> {

    @Override
    public JoinClauseImpl<E> on() {
        return null;
    }

    @Override
    public JoinClauseImpl<E> where(FilterClauseImpl<E> filterClause) {
        return null;
    }

    @Override
    public JoinClauseImpl<E> join() {
        return null;
    }

    @Override
    public JoinClauseImpl<E> leftJoin() {
        return null;
    }

    @Override
    public JoinClauseImpl<E> rightJoin() {
        return null;
    }

    @Override
    public JoinClauseImpl<E> fullJoin() {
        return null;
    }

    @Override
    public JoinClauseImpl<E> selfJoin() {
        return null;
    }
}
