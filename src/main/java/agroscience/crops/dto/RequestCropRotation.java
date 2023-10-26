package agroscience.crops.dto;

import lombok.Data;

@Data
public class RequestCropRotation {
    private Long fieldId;
    private Long cropId;
    private String startDate;
    private String endDate;
    private String description;
}
