package tn.epi.pfa.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.epi.pfa.doa.ILessonDao;
import tn.epi.pfa.doa.ISubjectDao;
import tn.epi.pfa.dto.SubjectResponse;
import tn.epi.pfa.entities.Lesson;
import tn.epi.pfa.entities.Subject;
import tn.epi.pfa.services.ISubjectService;

import java.util.List;

@Service
public class SubjectServiceImpl implements ISubjectService {

    @Autowired
    private ISubjectDao iSubjectDao;
    @Autowired
    private ILessonDao lessonDao;


    @Override
    public void save(Subject subject) {
        iSubjectDao.save(subject);
    }

    @Override
    public SubjectResponse findById(Long id) {
        SubjectResponse response = new SubjectResponse();
        Subject subject = iSubjectDao.findById(id).orElse(null);
        List<Lesson> lessons = lessonDao.findAllBySubjectId(id);
        if (subject != null) {
            response.setId(subject.getId());
            response.setSubjectName(subject.getSubjectName());
            response.setLessons(lessons);
        }
        return response;
    }

    @Override
    public List<Subject> findAll() {
        return iSubjectDao.findAll();
    }

    @Override
    public void deleteById(Long id) {
        iSubjectDao.deleteById(id);
    }
}
