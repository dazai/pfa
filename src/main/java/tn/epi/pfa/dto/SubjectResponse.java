package tn.epi.pfa.dto;

import lombok.Data;
import tn.epi.pfa.entities.Lesson;

import java.util.List;

@Data
public class SubjectResponse {

    private Long id;
    private String subjectName;
    private List<Lesson> lessons;
}
