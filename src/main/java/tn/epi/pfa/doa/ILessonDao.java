package tn.epi.pfa.doa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.epi.pfa.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILessonDao extends JpaRepository<Lesson, Long> {

    List<Lesson> findAllBySubjectId(Long subjectId);
}
