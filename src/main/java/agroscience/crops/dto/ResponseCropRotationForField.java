package agroscience.crops.dto;

import lombok.Data;

@Data
public class ResponseCropRotationForField {
    private Long id;
    private ResponseCrop crop;
    private String description;
    private String startDate;
    private String endDate;
}
