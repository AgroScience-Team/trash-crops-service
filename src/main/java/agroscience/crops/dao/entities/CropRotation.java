package agroscience.crops.dao.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "crop_rotations")
@NoArgsConstructor
@Getter
@Setter
public class CropRotation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "field_id")
    private Integer fieldId;

    @ManyToOne
    @JoinColumn(name = "crop_id", referencedColumnName = "id")
    private Crop crop;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "description", length = 255)
    private String description;

}
