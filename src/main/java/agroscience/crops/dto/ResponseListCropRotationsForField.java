package agroscience.crops.dto;

import lombok.Data;

import java.util.List;
@Data
public class ResponseListCropRotationsForField {
    private Integer fieldId;
    List<ResponseCropRotationForField> cropRotations;
}
