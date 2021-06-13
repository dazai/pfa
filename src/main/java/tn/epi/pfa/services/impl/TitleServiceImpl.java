package tn.epi.pfa.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.epi.pfa.doa.ITitleDao;
import tn.epi.pfa.entities.Title;
import tn.epi.pfa.services.ITitleService;

import java.util.List;

@Service
public class TitleServiceImpl implements ITitleService {

    @Autowired
    private ITitleDao iTitleDao;

    @Override
    public void save(Title title) {
        iTitleDao.save(title);
    }

    @Override
    public Title findById(Long id) {
        return iTitleDao.findById(id).orElse(null);
    }

    @Override
    public List<Title> findAll() {
        return iTitleDao.findAll();
    }

    @Override
    public void deleteById(Long id) {
        iTitleDao.deleteById(id);
    }
}
