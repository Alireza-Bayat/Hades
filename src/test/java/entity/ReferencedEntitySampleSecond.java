package entity;

import com.hades.model.annotation.entity.Column;
import com.hades.model.annotation.entity.Table;
import com.hades.model.enumeration.entity.ColumnDefinition;

import java.sql.Timestamp;

/**
 * @author alireza_bayat
 * created on 10/31/21
 */

@Table(name = "property_type", alias = "property_type")
public class ReferencedEntitySampleSecond extends EntitySample {

    @Column(name = "id", columnDefinition = ColumnDefinition.DECIMAL, nullable = false, updatable = false)
    private int id;
    @Column(name = "sample_id", columnDefinition = ColumnDefinition.DECIMAL, nullable = false, updatable = false)
    private int sampleId;
    @Column(name = "sample_id_second", columnDefinition = ColumnDefinition.DECIMAL, nullable = false, updatable = false)
    private int sampleIdSecond;
    @Column(name = "name", columnDefinition = ColumnDefinition.VARCHAR)
    private String name;
    @Column(name = "family", columnDefinition = ColumnDefinition.VARCHAR)
    private String family;
    @Column(name = "create_date", columnDefinition = ColumnDefinition.DATETIME)
    private Timestamp createDate;
    @Column(name = "type", columnDefinition = ColumnDefinition.INT)
    private int type;
}
