package entity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * @author alireza_bayat
 * created on 10/31/21
 */

@Table(name = "property_type")
public class ReferencedEntitySampleSecond extends EntitySample {

    @Column(name = "id", nullable = false, updatable = false)
    private int id;
    @Column(name = "sample_id", nullable = false, updatable = false)
    private int sampleId;
    @Column(name = "sample_id_second", nullable = false, updatable = false)
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
