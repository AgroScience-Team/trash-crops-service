package agroscience.crops.dao.repositories;

import agroscience.crops.dao.entities.Crop;
import agroscience.crops.dao.entities.CropRotation;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CropRotationRepository extends JpaRepository<CropRotation, Long> {
    @Query("SELECT cr FROM CropRotation cr " +
            "WHERE cr.fieldId = :fieldId " +
            "ORDER BY cr.startDate DESC")
    public List<CropRotation> findLatestCrop(Long fieldId, Pageable pageable);
}
