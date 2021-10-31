package entity;

import com.hades.model.type.EntityType;

import javax.persistence.Column;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * @author alireza_bayat
 * created on 10/31/21
 */

@Table(name = "listing_type")
public class ReferencedEntitySample extends EntityType {

    @Column(name = "id", nullable = false, updatable = false)
    private int id;
    @Column(name = "sample_id", nullable = false, updatable = false)
    private int sampleId;
    @Column(name = "name")
    private String name;
    @Column(name = "family")
    private String family;
    @Column(name = "create_date")
    private Timestamp createDate;
    @Column(name = "type")
    private int type;
}
