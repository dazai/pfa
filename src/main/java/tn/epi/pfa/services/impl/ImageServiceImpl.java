package tn.epi.pfa.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.epi.pfa.doa.IImageDao;
import tn.epi.pfa.entities.Image;
import tn.epi.pfa.services.IImageService;

import java.util.List;

@Service
public class ImageServiceImpl implements IImageService {

    @Autowired
    private IImageDao iImageDao;

    @Override
    public void save(Image image) {
        iImageDao.save(image);
    }

    @Override
    public Image findById(Long id) {
        return iImageDao.findById(id).orElse(null);
    }

    @Override
    public List<Image> findAll() {
        return iImageDao.findAll();
    }

    @Override
    public void deleteById(Long id) {
        iImageDao.deleteById(id);
    }
}
