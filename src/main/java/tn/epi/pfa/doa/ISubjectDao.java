package tn.epi.pfa.doa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.epi.pfa.entities.Subject;

@Repository
public interface ISubjectDao extends JpaRepository<Subject, Long> {
}
