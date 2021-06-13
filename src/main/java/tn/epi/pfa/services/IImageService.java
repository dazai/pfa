package tn.epi.pfa.services;

import tn.epi.pfa.entities.Image;

import java.util.List;

public interface IImageService {

    void save(Image image);

    Image findById(Long id);

    List<Image> findAll();

    void deleteById(Long id);
}
