package annotation.entity;

import enumeration.entity.ColumnDefinition;

/**
 * <p>specifies columns of table
 *
 * <p>
 * Example :
 * <pre>
 *      &#064;Column(name = "name")
 *      private String name;
 * </pre>
 *
 * @author alireza_bayat
 */
public @interface Column {

    /**
     * defines name of column in table
     */
    String name();

    /**
     * (Optional)
     * defines type of column
     */
    ColumnDefinition columnDefinition() default ColumnDefinition.VARCHAR;

    /**
     * (Optional)
     * specifies that column in table can be update or not
     */
    boolean updatable() default true;

    /**
     * (Optional)
     * defines column can be null or not
     */
    boolean nullable() default true;

}
