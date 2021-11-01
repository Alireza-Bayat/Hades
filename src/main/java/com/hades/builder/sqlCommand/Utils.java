package com.hades.builder.sqlCommand;

import com.hades.model.enumeration.relational.OrderArrange;
import com.hades.model.type.EntityType;

/**
 * @author alireza_bayat
 * created on 11/1/21
 */
public interface Utils<E extends EntityType> {

    default String nullValidation(String s) {
        return s == null ? "" : s;
    }

    default String nullValidation(OrderArrange orderArrange) {
        return orderArrange == null ? "" : orderArrange.getOrderArrange();
    }


    /**
     * <p> get class object of given entity
     */
    default Class<?> getClazz(E e) {
        return e.getClass();
    }


}
