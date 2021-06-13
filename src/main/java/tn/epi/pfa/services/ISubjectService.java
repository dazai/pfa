package tn.epi.pfa.services;



import tn.epi.pfa.dto.SubjectResponse;
import tn.epi.pfa.entities.Subject;

import java.util.List;

public interface ISubjectService {

    void save(Subject subject);

    SubjectResponse findById(Long id);

    List<Subject> findAll();

    void deleteById(Long id);
}
