package com.hades.model.annotation.entity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * <p> specifies tables of data base
 *
 * <p>
 * Example :
 * <pre>
 *      &#064;Table(name="STUDENTS", alias="STD")
 *      public class Student { ... }
 * </pre>
 *
 * @author alireza_bayat
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Table {

    /**
     * defines name of table
     */
    String name();

    /**
     * defines alias name for table
     */
    String alias() default "";
}
