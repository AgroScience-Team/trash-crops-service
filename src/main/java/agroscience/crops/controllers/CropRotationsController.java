package agroscience.crops.controllers;

import agroscience.crops.dao.repositories.CropRotationRepository;
import agroscience.crops.services.CropRotationsService;
import agroscience.crops.services.CropsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/crops")
public class CropRotationsController {
    private final CropRotationsService cropRotationsService;
}
