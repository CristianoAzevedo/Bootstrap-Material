package br.unicesumar.escoladeti2015base.pais;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaisService {
    
    @Autowired
    private PaisRepository repo;
    
    public void save(Pais p) {
        repo.save(p);
    }
    
    public void remove(Pais p) {
        repo.remove(p);
    }

    public Pais findById(String id) {
        return repo.findById(id);
    }

    public List<Pais> findAll() {
        return repo.findAll();
    }

    void remove(String id) {
        repo.remove(repo.findById(id));
    }
    
    
}
