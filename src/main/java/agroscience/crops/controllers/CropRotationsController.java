package agroscience.crops.controllers;

import agroscience.crops.dto.Page;
import agroscience.crops.dto.ResponseCRWithField;
import agroscience.crops.dto.ResponseListCropRotationsForField;
import agroscience.crops.mappers.CropRotationMapper;
import agroscience.crops.services.CropRotationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/crops")
public class CropRotationsController {
    private final CropRotationsService CRService;
    private final CropRotationMapper CRMapper;
    @GetMapping("/crop-rotations/{fieldId}")
    public ResponseListCropRotationsForField getAllCropRotationsByFieldId(@PathVariable Long fieldId, Page p){
        return CRMapper.cropRotationsToList(fieldId, CRMapper.cropRotationToCropRotationResponse(CRService
                .getAllByFieldId(fieldId, PageRequest.of(p.getPage(), p.getSize(), p.getSort().getSortValue()))));
    }

    @GetMapping("/crop-rotations")
    public List<ResponseCRWithField> getAllCropRotations(Page p){
        return CRService.getAll(PageRequest.of(p.getPage(), p.getSize(), p.getSort().getSortValue()));
    }

    @PostMapping(path = "/add-crop-rotation")


}
