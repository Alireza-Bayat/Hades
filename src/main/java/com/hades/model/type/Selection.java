package com.hades.model.type;

import javax.persistence.Table;

/**
 * @author alireza_bayat
 * created on 10/19/21
 *
 * <p> developer can access any columns from joined table by specifiying alias of the table
 * <p> alias must be exact value of {@link Table#name()}
 * <p>
 * e.g.
 * <pre>
 *     student.name
 *     teacher.name
 * </pre>
 */
public class Selection {

    private String fieldName;

    public Selection(String fieldName) {
        setFieldName(fieldName);
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}
