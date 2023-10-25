package agroscience.crops.services;

import agroscience.crops.dao.entities.Crop;
import agroscience.crops.dao.repositories.CropRotationRepository;
import agroscience.crops.dao.repositories.CropsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CropsService {
    private final CropsRepository cropsRepository;

    public Crop getCurrentCrop(Long fieldId) {
        return cropsRepository.findLatestCrop(fieldId);
    }

}
