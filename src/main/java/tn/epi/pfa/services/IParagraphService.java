package tn.epi.pfa.services;

import tn.epi.pfa.entities.Paragraph;

import java.util.List;

public interface IParagraphService {

    void save(Paragraph paragraph);

    Paragraph findById(Long id);

    List<Paragraph> findAll();

    void deleteById(Long id);
}
