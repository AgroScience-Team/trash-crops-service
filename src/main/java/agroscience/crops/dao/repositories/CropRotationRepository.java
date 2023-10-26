package agroscience.crops.dao.repositories;

import agroscience.crops.dao.entities.Crop;
import agroscience.crops.dao.entities.CropRotation;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CropRotationRepository extends JpaRepository<CropRotation, Long> {

    Slice<CropRotation> findAllByFieldId(Long fieldId, Pageable pageable);
    @Query("SELECT c FROM CropRotation c")
    Slice<CropRotation> findAllAsSlice(Pageable pageable);
}
