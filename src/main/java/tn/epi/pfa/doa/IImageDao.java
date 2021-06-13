package tn.epi.pfa.doa;

import tn.epi.pfa.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IImageDao extends JpaRepository<Image, Long> {

    List<Image> findAllByLessonId(Long lessonId);
}
