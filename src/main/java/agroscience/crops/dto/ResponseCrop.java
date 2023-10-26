package agroscience.crops.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseCrop {
    private Long id;
    private String name;
}
