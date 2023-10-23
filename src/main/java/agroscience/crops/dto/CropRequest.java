package agroscience.crops.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CropRequest {
    @NotBlank
    @Size(max = 50)
    private String name;
    @Size(max = 64)
    private String description;
}
