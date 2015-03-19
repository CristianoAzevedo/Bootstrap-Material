/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicesumar.escoladeti2015base.cores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Cristiano
 */
public class CorRepositoryInMemory implements CorRepository{
    
    private final List<Cor> listaDeCores;

    public CorRepositoryInMemory() {
        this.listaDeCores = new ArrayList<Cor>();
    }        

    @Override
    public void save(Cor c) {
        if (!listaDeCores.contains(c)) {
            listaDeCores.add(c);
        }
    }

    @Override
    public void remove(Cor c) {
        listaDeCores.remove(c);
    }

    @Override
    public Cor findById(String id) {
        for (Cor Cor : listaDeCores) {
            if (Cor.getId().equals(id)) {
                return Cor;
            }
        }
        return null;
    }

    @Override
    public List<Cor> findAll() {
        return Collections.unmodifiableList(listaDeCores);
    }
   
}
