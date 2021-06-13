package tn.epi.pfa.dto;

import lombok.Data;
import tn.epi.pfa.entities.Image;
import tn.epi.pfa.entities.Paragraph;
import tn.epi.pfa.entities.Title;

import java.util.List;

@Data
public class LessonResponse {

    private Long id;
    private String lessonTitle;
    private List<Paragraph> paragraphs;
    private List<Image> images;
    private List<Title> titles;
}
