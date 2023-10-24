package agroscience.crops.services;

import agroscience.crops.dao.repositories.CropRotationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CropRotationsService {
    private final CropRotationRepository cropRotationRepository;
}
