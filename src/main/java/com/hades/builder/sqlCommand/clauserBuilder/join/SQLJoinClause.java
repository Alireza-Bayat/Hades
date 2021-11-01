package com.hades.builder.sqlCommand.clauserBuilder.join;

import com.hades.builder.sqlCommand.clauserBuilder.filter.SQLFilterClause;
import com.hades.model.enumeration.relational.JoinTypes;
import com.hades.model.type.EntityType;


/**
 * @author alireza_bayat
 * created on 10/30/21
 * @see JoinTypes
 */
public interface SQLJoinClause<E extends EntityType> {

    /**
     * <p>create instance {@link Class} of given entity to be used in Join clauses
     *
     * @param e passed entity object
     * @return SQLJoinClause<E> object
     */
    SQLJoinClause<E> createInstance(E e);

    SQLJoinClause<E> on();

    /**
     * <p> create join clause with passed referenced class.
     * <p> entityKey and referencedKey will be used as foreign key to join to tables.
     * <p> type of join must be passed to the function from {@link JoinTypes}
     *
     * <p>sample output:
     * <br>
     * <code> LEFT JOIN listing_type AS listing_type ON listing.listing_type_id = listing_type.id </code>
     *
     * @param referencedClass entity table class referenced
     * @param entityKey       E key to be used in join
     * @param referencedKey   referenced class key to be used in join
     * @param joinTypes       {@link JoinTypes}
     * @return SQLJoinClause
     */
    SQLJoinClause<E> join(Class<? extends EntityType> referencedClass, String entityKey, String referencedKey, JoinTypes joinTypes);


    /**
     * <p> create join clause with passed referenced class.
     * <p> entityKey and referencedKey will be used as foreign key to join to tables.
     * <p> type of join must be passed to the function from {@link JoinTypes}
     * <p>
     *
     * <p>sample output:
     * <br>
     * <code> LEFT JOIN listing_type AS listing_type ON listing.listing_type_id = listing_type.id AND listing.id != 1000000 </code>
     *
     * @param referencedClass entity table class referenced
     * @param entityKey       E key to be used in join
     * @param referencedKey   referenced class key to be used in join
     * @param joinTypes       {@link JoinTypes}
     * @param filterClause    manage where clause of join
     * @return SQLJoinClause
     * @see SQLFilterClause
     */
    SQLJoinClause<E> join(Class<? extends EntityType> referencedClass, String entityKey, String referencedKey, JoinTypes joinTypes, SQLFilterClause<E> filterClause);

    SQLJoinClause<E> customJoin(String customJoin);

    // update join

    // delete join

    // union


}
