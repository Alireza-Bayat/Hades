package services;

import builder.sqlCommand.SQLCommands;
import builder.sqlCommand.clauserBuilder.ClauseBuilder;
import builder.sqlCommand.impl.DQLImpl;
import model.type.EntityType;
import model.type.Selection;

/**
 * @author alireza_bayat
 * created on 10/12/21
 */
public class RelationalServices<E extends EntityType> implements SQLCommands<E> {

    private final DQLImpl<E> dql = new DQLImpl<>();

    @Override
    public String findAll(E e) {
        return dql.selectQuery(e);
    }

    @Override
    public String findAll(E e, String... fieldsName) {
        return dql.selectQuery(e, fieldsName);
    }

    @Override
    public String findAll(E e, Selection... selections) {
        return dql.selectQuery(e, selections);
    }

    @Override
    public String findAll(E e, ClauseBuilder clauseBuilder) {
        return dql.selectQuery(e, clauseBuilder);
    }

    @Override
    public String findAll(E e, ClauseBuilder clauseBuilder, String... fieldsName) {
        return dql.selectQuery(e, clauseBuilder, fieldsName);
    }
}
