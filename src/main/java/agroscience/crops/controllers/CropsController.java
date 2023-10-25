package agroscience.crops.controllers;

import agroscience.crops.dto.ResponseCropName;
import agroscience.crops.services.CropsService;
import agroscience.crops.mappers.CropMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/crops")
public class CropsController {
    private final CropsService cropsService;
    private final CropMapper cropMapper;

    @GetMapping("/currentcrop/{fieldId}")
    public ResponseCropName getCurrentCropName(@PathVariable Long fieldId){
        return cropMapper.cropToCropNameResponse(cropsService.getCurrentCrop(fieldId));
    }


}
