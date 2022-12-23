package entity;

import com.hades.model.type.EntityType;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Table(name = "listing")
public class EntitySample extends EntityType {

    public EntitySample(){}

    public EntitySample(Integer id, Integer sampleId, Integer sampleIdSecond, String name, String family, Timestamp createDate, Integer type) {
        this.id = id;
        this.sampleId = sampleId;
        this.sampleIdSecond = sampleIdSecond;
        this.name = name;
        this.family = family;
        this.createDate = createDate;
        this.type = type;
    }

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "listing_type_id", nullable = false, updatable = false)
    private Integer sampleId;

    @Column(name = "property_type_id", nullable = false, updatable = false)
    private Integer sampleIdSecond;

    @Column(name = "name")
    private String name;
    @Column(name = "family")
    private String family;
    @Column(name = "create_date")
    private Timestamp createDate;
    @Column(name = "type")
    private Integer type;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSampleId() {
        return sampleId;
    }

    public void setSampleId(Integer sampleId) {
        this.sampleId = sampleId;
    }

    public Integer getSampleIdSecond() {
        return sampleIdSecond;
    }

    public void setSampleIdSecond(Integer sampleIdSecond) {
        this.sampleIdSecond = sampleIdSecond;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
