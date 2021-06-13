package tn.epi.pfa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParagraphDto {

    private Long lessonId;

    private int orderValue;

    private String paragraphContent;
}
