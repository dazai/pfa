package tn.epi.pfa.services;

import tn.epi.pfa.entities.Title;

import java.util.List;

public interface ITitleService {

    void save(Title title);

    Title findById(Long id);

    List<Title> findAll();

    void deleteById(Long id);
}
