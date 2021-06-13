package tn.epi.pfa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageDto {

    private String url;

    private String legend;
    private int orderValue;

    private Long lessonId;
}
