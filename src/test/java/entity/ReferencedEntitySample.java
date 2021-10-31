package entity;

import com.hades.model.annotation.entity.Column;
import com.hades.model.annotation.entity.Table;
import com.hades.model.enumeration.entity.ColumnDefinition;
import com.hades.model.type.EntityType;

import java.sql.Timestamp;

/**
 * @author alireza_bayat
 * created on 10/31/21
 */

@Table(name = "listing_type", alias = "listing_type")
public class ReferencedEntitySample extends EntityType {

    @Column(name = "id", columnDefinition = ColumnDefinition.DECIMAL, nullable = false, updatable = false)
    private int id;
    @Column(name = "sample_id", columnDefinition = ColumnDefinition.DECIMAL, nullable = false, updatable = false)
    private int sampleId;
    @Column(name = "name", columnDefinition = ColumnDefinition.VARCHAR)
    private String name;
    @Column(name = "family", columnDefinition = ColumnDefinition.VARCHAR)
    private String family;
    @Column(name = "create_date", columnDefinition = ColumnDefinition.DATETIME)
    private Timestamp createDate;
    @Column(name = "type", columnDefinition = ColumnDefinition.INT)
    private int type;
}
