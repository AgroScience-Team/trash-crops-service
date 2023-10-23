package agroscience.crops.dao.repositories;

import agroscience.crops.dao.entities.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CropsRepository extends JpaRepository<Crop, Long> {
    @Query("SELECT c FROM Crop c " +
            "WHERE c.id = (SELECT cr.crop.id FROM CropRotation cr " +
            "WHERE cr.fieldId = :fieldId " +
            "ORDER BY cr.startDate DESC " +
            "LIMIT 1)")
    Crop findLatestCrop(Long fieldId);
}
