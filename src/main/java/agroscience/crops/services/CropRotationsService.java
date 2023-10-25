package agroscience.crops.services;

import agroscience.crops.dao.entities.CropRotation;
import agroscience.crops.dao.repositories.CropRotationRepository;
import agroscience.crops.dto.ResponseCRWithField;
import agroscience.crops.dto.ResponseFieldName;
import agroscience.crops.mappers.CropRotationMapper;
import agroscience.crops.utilities.DifficultMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CropRotationsService {
    private final CropRotationRepository cropRotationRepository;
    private final WebClient webClient;
    private final CropRotationMapper CRMapper;

    public List<CropRotation> getAllByFieldId(Long fieldId, PageRequest request) {
        return cropRotationRepository.findAllByFieldId(fieldId, request).toList();
    }

    public List<ResponseCRWithField> getAll(PageRequest request) {
        List<CropRotation> cropRotations = cropRotationRepository.findAllAsSlice(request).toList();

        List<ResponseFieldName> fieldNames = webClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/getNamesByIds")
                        .queryParam("id", cropRotations.stream()
                                .map(CropRotation::getFieldId).toList())
                        .build())
                .retrieve()
                .bodyToFlux(ResponseFieldName.class)
                .collectList()
                .block();

        return DifficultMapping.listResponseCRWithFieldList(cropRotations, fieldNames);
    }
}
