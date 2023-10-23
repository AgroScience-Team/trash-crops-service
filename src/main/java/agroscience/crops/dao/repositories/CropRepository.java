package agroscience.crops.dao.repositories;

import agroscience.crops.dao.entities.Crop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CropRepository extends JpaRepository<Crop, Long> {
}
