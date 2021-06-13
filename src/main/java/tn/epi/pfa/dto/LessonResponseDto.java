package tn.epi.pfa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.epi.pfa.entities.Bloc;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonResponseDto {

    private String lessonTitle;
    private List<Bloc> blocs;

}
