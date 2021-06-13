package tn.epi.pfa.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.epi.pfa.doa.IParagraphDao;
import tn.epi.pfa.entities.Paragraph;
import tn.epi.pfa.services.IParagraphService;

import java.util.List;

@Service
public class ParagraphServiceImpl implements IParagraphService {

    @Autowired
    private IParagraphDao iParagraphDao;

    @Override
    public void save(Paragraph paragraph) {
        iParagraphDao.save(paragraph);
    }

    @Override
    public Paragraph findById(Long id) {
        return iParagraphDao.findById(id).orElse(null);
    }

    @Override
    public List<Paragraph> findAll() {
        return iParagraphDao.findAll();
    }

    @Override
    public void deleteById(Long id) {
        iParagraphDao.deleteById(id);
    }
}
