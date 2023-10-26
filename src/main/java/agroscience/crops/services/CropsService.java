package agroscience.crops.services;

import agroscience.crops.dao.entities.Crop;
import agroscience.crops.dao.repositories.CropRotationRepository;
import agroscience.crops.dao.repositories.CropsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CropsService {
    private final CropsRepository cropsRepository;
    private final CropRotationRepository CRRepository;

    public Crop getCurrentCrop(Long fieldId) {
        return cropsRepository.findLatestCrop(fieldId);
    }
    public Crop createCrop(Crop crop){
        return cropsRepository.save(crop);
    }

    public Crop updateCrop(Long id, Crop newCrop){
        var crop = cropsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Crop not found with id: " + id));
        crop.setName(newCrop.getName());
        return cropsRepository.save(crop);
    }

    public void deleteCropById(Long id) {
        Crop crop = cropsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Crop not found with id: " + id));

        cropsRepository.delete(crop);
    }

    public Crop getCrop(Long cropId) {
        return cropsRepository.findById(cropId).orElseThrow(() -> new EntityNotFoundException("Crop not found with id: " + cropId));
    }
}
