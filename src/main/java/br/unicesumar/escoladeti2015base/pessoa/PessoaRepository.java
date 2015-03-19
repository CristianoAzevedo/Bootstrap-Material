
package br.unicesumar.escoladeti2015base.pessoa;

import java.util.List;

public interface PessoaRepository {
    
    void save(Pessoa pessoa);
    void remove(Pessoa pesssoa);
    Pessoa findById(String id);
    List<Pessoa> findAll();
    
}
