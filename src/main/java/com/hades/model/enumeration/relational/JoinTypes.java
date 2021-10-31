package com.hades.model.enumeration.relational;

/**
 * @author alireza_bayat
 * created on 10/31/21
 */
public enum JoinTypes {
    JOIN(" JOIN "), LEFT_JOIN(" LEFT JOIN "), RIGHT_JOIN(" RIGHT JOIN "), FULL_OUTER_JOIN(" FULL OUTER JOIN ");

    private final String joinType;

    JoinTypes(String joinType) {
        this.joinType = joinType;
    }

    public String getJoinType() {
        return joinType;
    }
}
