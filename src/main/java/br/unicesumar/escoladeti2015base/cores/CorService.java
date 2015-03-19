/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicesumar.escoladeti2015base.cores;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Cristiano
 */
@Component
public class CorService {
    
    @Autowired
    private CorRepository repo;
    
    public void save(Cor c) {
        repo.save(c);
    }
    
    public void remove(Cor c) {
        repo.remove(c);
    }

    public Cor findById(String id) {
        return repo.findById(id);
    }

    public List<Cor> findAll() {
        return repo.findAll();
    }

    void remove(String id) {
        repo.remove(repo.findById(id));
    }
}
