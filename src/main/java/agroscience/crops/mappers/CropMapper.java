package agroscience.crops.mappers;

import agroscience.crops.dao.entities.Crop;
import agroscience.crops.dto.ResponseCropName;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CropMapper {
    ResponseCropName cropToCropNameResponse(Crop crop);
}
