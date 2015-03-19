package br.unicesumar.escoladeti2015base.pais;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PaisRepositoryInMemory implements PaisRepository {
    private List<Pais> listaDePaises;

    public PaisRepositoryInMemory() {
        this.listaDePaises = new ArrayList<Pais>();
    }        

    @Override
    public void save(Pais p) {
        if (!listaDePaises.contains(p)) {
            listaDePaises.add(p);
        }
    }

    @Override
    public void remove(Pais p) {
        listaDePaises.remove(p);
    }

    @Override
    public Pais findById(String id) {
        for (Pais pais : listaDePaises) {
            if (pais.getId().equals(id)) {
                return pais;
            }
        }
        return null;
    }

    @Override
    public List<Pais> findAll() {
        return Collections.unmodifiableList(listaDePaises);
    }
    
}
