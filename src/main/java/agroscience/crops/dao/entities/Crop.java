package agroscience.crops.dao.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "crops")
@NoArgsConstructor
@Getter
@Setter
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "organization_id")
    private Integer organizationId;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "color", length = 6, nullable = false)
    private String color;
}
