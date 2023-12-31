package agroscience.crops.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "crops")
@Data
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "crops_id_seq")
    @SequenceGenerator(name = "crops_id_seq", sequenceName = "crops_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "description", length = 64)
    private String description;

    @OneToMany(mappedBy = "crop", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true, fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<CropRotation> cropRotation;
}
