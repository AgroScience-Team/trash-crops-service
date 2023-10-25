package agroscience.crops.mappers;

import agroscience.crops.dao.entities.Crop;
import agroscience.crops.dao.entities.CropRotation;
import agroscience.crops.dto.ResponseCRWithField;
import agroscience.crops.dto.ResponseCropRotationForField;
import agroscience.crops.dto.ResponseFieldName;
import agroscience.crops.dto.ResponseListCropRotationsForField;
import agroscience.crops.utilities.LocalDateConverting;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CropRotationMapper {
    @Mapping(target = "startDate", source = "startDate", qualifiedByName = "localDateToString")
    @Mapping(target = "endDate", source = "endDate", qualifiedByName = "localDateToString")
    @Mapping(target = "cropName", source = "crop", qualifiedByName = "cropName")
    ResponseCropRotationForField cropRotationToCropRotationResponse(CropRotation cropRotation);

    @Mapping(target = "startDate", source = "startDate", qualifiedByName = "localDateToString")
    @Mapping(target = "endDate", source = "endDate", qualifiedByName = "localDateToString")
    @Mapping(target = "cropName", source = "crop", qualifiedByName = "cropName")
    List<ResponseCropRotationForField> cropRotationToCropRotationResponse(List<CropRotation> cropRotations);
    @Mapping(target = "cropRotations", source = "cropRotationResponses")
    ResponseListCropRotationsForField cropRotationsToList(Long fieldId,
                                                          List<ResponseCropRotationForField> cropRotationResponses);

    @Mapping(target = "startDate", source = "cropRotations.startDate", qualifiedByName = "localDateToString")
    @Mapping(target = "endDate", source = "cropRotations.endDate", qualifiedByName = "localDateToString")
    @Mapping(target = "cropName", source = "cropRotations.crop", qualifiedByName = "cropName")
    @Mapping(target = "id", source = "cropRotations.id")
    ResponseCRWithField responseCRWithField(CropRotation cropRotations, ResponseFieldName field);
    @Named("localDateToString")
    default String localDateToString(LocalDate date){
        return LocalDateConverting.localDateTimeToString(date);
    }
    @Named("cropName")
    default String cropName(Crop crop){
        return crop.getName();
    }
}
