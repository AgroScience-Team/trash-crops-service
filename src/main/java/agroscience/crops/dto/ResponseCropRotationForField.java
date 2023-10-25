package agroscience.crops.dto;

import lombok.Data;

@Data
public class ResponseCropRotationForField {
    Long id;
    String cropName;
    String description;
    String startDate;
    String endDate;
}
