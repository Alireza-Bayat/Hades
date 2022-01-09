package entity;

import com.hades.model.type.EntityType;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Table(name = "listing")
public class EntitySample extends EntityType {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private int id;

    @Column(name = "listing_type_id", nullable = false, updatable = false)
    private int sampleId;

    @Column(name = "property_type_id", nullable = false, updatable = false)
    private int sampleIdSecond;

    @Column(name = "name")
    private String name;
    @Column(name = "family")
    private String family;
    @Column(name = "create_date")
    private Timestamp createDate;
    @Column(name = "type")
    private int type;

}
