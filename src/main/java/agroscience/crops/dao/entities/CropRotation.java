package agroscience.crops.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "crop_rotations")
@Data
public class CropRotation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "crop_rotations_id_seq")
    @SequenceGenerator(name = "crop_rotations_id_seq", sequenceName = "crop_rotations_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "field_id", nullable = false)
    private Integer fieldId;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "crop_id", referencedColumnName = "id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Crop crop;

    @Column(name = "start_date",nullable = false)
    private Date startDate;

    @Column(name = "end_date",nullable = false)
    private Date endDate;

    @Column(name = "description", length = 256, nullable = false)
    private String description;

}
