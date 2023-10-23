package agroscience.crops.dao.repositories;

import agroscience.crops.dao.entities.CropRotation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CropRotationRepository extends JpaRepository<CropRotation, Long> {
}
