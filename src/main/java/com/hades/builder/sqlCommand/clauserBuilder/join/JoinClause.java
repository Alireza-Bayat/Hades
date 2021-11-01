package com.hades.builder.sqlCommand.clauserBuilder.join;

import com.hades.builder.sqlCommand.SQLUtils;
import com.hades.builder.sqlCommand.clauserBuilder.ClauseElements;
import com.hades.builder.sqlCommand.clauserBuilder.filter.SQLFilterClause;
import com.hades.model.enumeration.relational.JoinTypes;
import com.hades.model.enumeration.relational.QueryKeyOperators;
import com.hades.model.enumeration.relational.QueryKeyWords;
import com.hades.model.type.EntityType;

import javax.persistence.Table;

/**
 * @author alireza_bayat
 * created on 10/30/21
 */
public class JoinClause<E extends EntityType> extends ClauseElements implements SQLJoinClause<E> {

    private Class<?> clazz;
    //TODO probably not the best way to use it's function
    // sqlFilterClause extend was tested due to visibility of functions out of library - > ????
    private final SQLUtils<E> sqlUtils = new SQLUtils<E>() {
    };

    public JoinClause(Class<?> clazz) {
        this.clazz = clazz;
    }

    public JoinClause() {
    }

    @Override
    public SQLJoinClause<E> createInstance(E e) {
        this.clazz = sqlUtils.getClazz(e);
        return this;
    }

    @Override
    public JoinClause<E> on() {
        return this;
    }

    @Override
    public JoinClause<E> join(Class<? extends EntityType> referencedClass, String entityKey, String referencedKey, JoinTypes joinTypes) {
        Table table = sqlUtils.getTableAnnotation(clazz);
        Table referencedTable = sqlUtils.getTableAnnotation(referencedClass);
        super.setClause(super.clause.concat(sqlUtils.addJoinType(joinTypes)).concat(sqlUtils.getTableName(referencedTable))
                .concat(sqlUtils.addQueryKeyWord(QueryKeyWords.AS)).concat(sqlUtils.getTableName(referencedTable))
                .concat(sqlUtils.addQueryKeyWord(QueryKeyWords.ON)).concat(sqlUtils.getTableName(table)).concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.DOT))
                .concat(entityKey).concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.EQUAL)).concat(sqlUtils.getTableName(referencedTable))
                .concat(sqlUtils.addQueryKeyOperator(QueryKeyOperators.DOT)).concat(referencedKey));
        return this;
    }

    @Override
    public SQLJoinClause<E> join(Class<? extends EntityType> referencedClass, String entityKey, String referencedKey, JoinTypes joinTypes, SQLFilterClause<E> filterClause) {
        return null;
    }

    @Override
    public SQLJoinClause<E> customJoin(String customJoin) {
        super.setClause(super.clause.concat(" ").concat(customJoin));
        return this;
    }
}
