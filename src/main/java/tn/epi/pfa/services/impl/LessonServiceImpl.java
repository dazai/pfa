package tn.epi.pfa.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.epi.pfa.doa.IImageDao;
import tn.epi.pfa.doa.ILessonDao;
import tn.epi.pfa.doa.IParagraphDao;
import tn.epi.pfa.doa.ITitleDao;
import tn.epi.pfa.dto.LessonResponse;
import tn.epi.pfa.entities.Lesson;
import tn.epi.pfa.services.ILessonService;

import java.util.List;

@Service
public class LessonServiceImpl implements ILessonService {

    @Autowired
    private ILessonDao iLessonDao;
    @Autowired
    private ITitleDao titleDao;
    @Autowired
    private IImageDao imageDao;
    @Autowired
    private IParagraphDao paragraphDao;


    @Override
    public void save(Lesson lesson) {
        iLessonDao.save(lesson);
    }

    @Override
    public LessonResponse findById(Long id) {
        LessonResponse response = new LessonResponse();
        Lesson lesson = iLessonDao.findById(id).orElse(null);
        if (lesson != null) {
            response.setId(lesson.getId());
            response.setLessonTitle(lesson.getLessonTitle());
            response.setImages(imageDao.findAllByLessonId(id));
            response.setTitles(titleDao.findAllByLessonId(id));
            response.setParagraphs(paragraphDao.findAllByLessonId(id));
        }
        return response;
    }

    @Override
    public List<Lesson> findAll() {
        return iLessonDao.findAll();
    }

    @Override
    public void deleteById(Long id) {
        iLessonDao.deleteById(id);
    }
}
