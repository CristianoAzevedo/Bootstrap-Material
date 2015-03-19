
package br.unicesumar.escoladeti2015base.pessoa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PessoaRepositoryInMemory implements PessoaRepository{
    private final List<Pessoa> listaPessoa;

    public PessoaRepositoryInMemory() {
        this.listaPessoa = new ArrayList<Pessoa>();
    }

    
    @Override
    public void save(Pessoa p) {
        if (!listaPessoa.contains(p)){
           listaPessoa.add(p);
        }
    }

    @Override
    public void remove(Pessoa p) {
        this.listaPessoa.remove(p);
    }

    @Override
    public Pessoa findById(String id) {
        for (Pessoa p : listaPessoa) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Pessoa> findAll() {
        return Collections.unmodifiableList(listaPessoa);
    }
}
