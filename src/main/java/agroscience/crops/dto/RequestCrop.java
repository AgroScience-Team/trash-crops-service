package agroscience.crops.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestCrop {
    @NotBlank
    @Size(max = 50)
    private String name;
    @Size(max = 64)
    private String description;
}
