package br.unicesumar.escoladeti2015base.pais;

import java.util.List;

public interface PaisRepository {
    
    void save(Pais p);
    void remove(Pais p);
    Pais findById(String id);
    List<Pais> findAll();
    
}
