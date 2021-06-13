package tn.epi.pfa.doa;

import tn.epi.pfa.entities.Paragraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.epi.pfa.entities.Title;

import java.util.List;

@Repository
public interface IParagraphDao extends JpaRepository<Paragraph, Long> {

    List<Paragraph> findAllByLessonId(Long lessonId);
}
