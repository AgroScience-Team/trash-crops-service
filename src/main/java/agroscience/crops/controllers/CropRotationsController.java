package agroscience.crops.controllers;

import agroscience.crops.dto.Page;
import agroscience.crops.dto.RequestCropRotation;
import agroscience.crops.dto.ResponseCRWithField;
import agroscience.crops.dto.ResponseListCropRotationsForField;
import agroscience.crops.mappers.CropRotationMapper;
import agroscience.crops.services.CropRotationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/crops")
public class CropRotationsController {
    private final CropRotationsService CRService;
    private final CropRotationMapper CRMapper;
    @GetMapping("/crop-rotations/field/{fieldId}")
    public ResponseListCropRotationsForField getAllCropRotationsByFieldId(@PathVariable Long fieldId, Page p){
        return CRMapper.cropRotationsToList(fieldId, CRMapper.cropRotationToCropRotationResponse(CRService
                .getAllByFieldId(fieldId, PageRequest.of(p.getPage(), p.getSize(), p.getSort().getSortValue()))));
    }

    @GetMapping("/crop-rotations")
    public List<ResponseCRWithField> getAllCropRotations(Page p){
        return CRService.getAll(PageRequest.of(p.getPage(), p.getSize(), p.getSort().getSortValue()));
    }

    @GetMapping(path = "crop-rotation/{id}")
    public ResponseCRWithField getCR(@PathVariable Long id){
        return CRService.getCR(id);
    }

    @PostMapping(path = "/crop-rotation")
    public ResponseCRWithField createCR(RequestCropRotation request){
        return CRService.createCR(CRMapper.CropRotatopnRequestToCropRotation(request), request.getCropId());
    }

    @PutMapping(path = "/crop-rotation/{id}")
    public ResponseCRWithField updateCR(@PathVariable Long id, RequestCropRotation request){
        return CRService.updateCR(id, CRMapper.CropRotatopnRequestToCropRotation(request), request.getCropId());
    }

    @DeleteMapping(path = "/crop-rotation/{id}")
    public ResponseEntity<Void> deleteCR(@PathVariable Long id){
        CRService.deleteCR(id);
        return ResponseEntity.noContent().build();
    }




}
