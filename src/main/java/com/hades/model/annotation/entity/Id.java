package com.hades.model.annotation.entity;

import com.hades.model.enumeration.entity.ColumnDefinition;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * <p> specifies primary key of the table
 * <p> each table in RDB must have one
 *
 * <p>
 * Example :
 * <pre>
 *      &#064;Id(name = "Column Name", columnDefinition = {@link ColumnDefinition})
 *      private Long id;
 * </pre>
 *
 * @author alireza_bayat
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Id {

    /**
     * defines name of column
     */
    String name();

    /**
     * (Optional)
     * defines type of column
     */
    ColumnDefinition columnDefinition() default ColumnDefinition.VARCHAR;


}

