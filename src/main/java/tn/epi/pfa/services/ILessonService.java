package tn.epi.pfa.services;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.epi.pfa.dto.LessonResponse;
import tn.epi.pfa.entities.Lesson;

import java.util.List;

public interface ILessonService {

    void save(Lesson lesson);

    LessonResponse findById(Long id);

    List<Lesson> findAll();

    void deleteById(Long id);


}
