package com.hades.model.enumeration.relational;

/**
 * @author alireza_bayat
 * created on 11/1/21
 */
public enum OrderArrange {
    ASC(" ASC"), DESC(" DESC");

    private final String orderArrange;

    OrderArrange(String orderArrange) {
        this.orderArrange = orderArrange;
    }

    public String getOrderArrange() {
        return orderArrange;
    }
}
