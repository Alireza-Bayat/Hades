package model.type;

/**
 * @author alireza_bayat
 * created on 10/19/21
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
