package agroscience.crops.dto;

import lombok.Data;

@Data
public class Page {
    private Integer size;
    private Integer page;
    private CropRotationSort sort;
}
