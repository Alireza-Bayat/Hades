package entity;

import com.hades.model.type.EntityType;
import com.hades.model.annotation.entity.Column;
import com.hades.model.annotation.entity.Table;
import com.hades.model.enumeration.entity.ColumnDefinition;

import java.sql.Timestamp;

@Table(name = "sample", alias = "sampleAlias")
public class EntitySample extends EntityType {

    @Column(name = "id", columnDefinition = ColumnDefinition.DECIMAL, nullable = false, updatable = false)
    private int id;
    @Column(name = "name", columnDefinition = ColumnDefinition.VARCHAR)
    private String name;
    @Column(name = "family", columnDefinition = ColumnDefinition.VARCHAR)
    private String family;
    @Column(name = "create_date", columnDefinition = ColumnDefinition.DATETIME)
    private Timestamp createDate;
    @Column(name = "type", columnDefinition = ColumnDefinition.INT)
    private int type;

}
