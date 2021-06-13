package tn.epi.pfa.doa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.epi.pfa.entities.Title;

import java.util.List;

@Repository
public interface ITitleDao extends JpaRepository<Title, Long> {

    List<Title> findAllByLessonId(Long lessonId);
}
