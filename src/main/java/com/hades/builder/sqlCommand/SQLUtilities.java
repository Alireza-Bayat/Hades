package com.hades.builder.sqlCommand;

import com.hades.model.type.EntityType;

import java.sql.Timestamp;

/**
 * @author alireza_bayat
 * created on 1/1/22
 */
public class SQLUtilities<E extends EntityType> implements SQLUtils<E> {

    public String getFieldType(Object o) {
        if (o instanceof String)
            return "'" + o + "'";
        else if (o instanceof Number)
            return o + "";//integer
        else if (o instanceof Timestamp)
            return "'" + o + "'";
        else
            return o + "";
    }
}
