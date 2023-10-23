package agroscience.crops.mappers;

import agroscience.crops.dao.entities.Crop;
import agroscience.crops.dto.CropNameResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CropMapper {
    CropNameResponse cropToCropNameResponse(Crop crop);
}
