package com.hades.builder.sqlCommand.clauseBuilder.aggregate;

import com.hades.builder.sqlCommand.SQLUtilities;
import com.hades.builder.sqlCommand.clauseBuilder.ClauseElements;
import com.hades.model.type.EntityType;

/**
 * @author alireza_bayat
 * created on 2/26/22
 */
public class AggregateClause<E extends EntityType> extends ClauseElements implements SQLAggregateClause<E> {

    private final SQLUtilities<E> sqlUtils = new SQLUtilities<>();
    private Class<?> clazz;

    /**
     * <p> pass entity class object as param
     */
    public AggregateClause(Class<?> clazz) {
        this.clazz = clazz;
    }

    public AggregateClause() {
    }

    @Override
    public SQLAggregateClause<E> createInstance(E e) {
        clazz = sqlUtils.getClazz(e);
        return this;
    }


    //select listing_type_id, count(*)
    //from listing
    //         left join listing_type lt on listing.listing_type_id = lt.id
    //where listing.listing_date > now() - interval '20 day'
    //group by listing_type_id

    @Override
    public SQLAggregateClause<E> count(E e, String field) {

        super.setClause(super.clause.concat(new StringBuilder().append("asd").append("asda").toString()));
        return this;
    }

    @Override
    public SQLAggregateClause<E> avg(E e, String field) {
        return this;
    }

    @Override
    public SQLAggregateClause<E> sum(E e, String field) {
        return this;
    }

    @Override
    public SQLAggregateClause<E> min(E e, String field) {
        return this;
    }

    @Override
    public SQLAggregateClause<E> max(E e, String field) {
        return this;
    }

    @Override
    public SQLAggregateClause<E> groupBy(String... field) {
        return this;
    }

    @Override
    public SQLAggregateClause<E> having(String field, String filterPhrase) {
        return this;
    }
}
