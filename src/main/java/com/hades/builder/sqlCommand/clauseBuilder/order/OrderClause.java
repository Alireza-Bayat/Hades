package com.hades.builder.sqlCommand.clauseBuilder.order;

import com.hades.builder.sqlCommand.SQLUtilities;
import com.hades.builder.sqlCommand.clauseBuilder.ClauseElements;
import com.hades.model.enumeration.relational.OrderArrange;
import com.hades.model.enumeration.relational.QueryKeyOperators;
import com.hades.model.type.EntityType;
import com.hades.model.type.Selection;

/**
 * @author alireza_bayat
 * created on 11/1/21
 */
public class OrderClause<E extends EntityType> extends ClauseElements implements SQLOrderClause<E> {

    private Class<?> clazz;
    private final SQLUtilities<E> sqlUtils = new SQLUtilities<E>();

    public OrderClause(Class<?> clazz) {
        this.clazz = clazz;
    }

    public OrderClause() {
    }

    @Override
    public OrderClause<E> createInstance(E e) {
        this.clazz = e.getClass();
        return this;
    }

    @Override
    public OrderClause<E> order(String fieldName, OrderArrange orderArrange) {
        super.setClause(clause.concat(sqlUtils.getTableName(sqlUtils.getTableAnnotation(clazz))).concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.DOT)).concat(fieldName).concat(sqlUtils.nullValidation(orderArrange)).concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.COMMA)));
        return this;
    }

    @Override
    public OrderClause<E> order(Selection fieldName, OrderArrange orderArrange) {
        sqlUtils.fieldExistInEntity(clazz, fieldName);
        super.setClause(clause.concat(fieldName.getFieldName()).concat(sqlUtils.nullValidation(orderArrange)).concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.COMMA)));
        return this;
    }
}
