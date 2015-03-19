
package br.unicesumar.escoladeti2015base.pessoa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PessoaService {
    
    @Autowired
    private PessoaRepository repo;
    
    public void save(Pessoa p){
        this.repo.save(p);
    }
    
    public void remove(Pessoa p){
        this.repo.remove(p);
    }
    
    public Pessoa findById(String id){
        return this.repo.findById(id);
    }
    
    public List<Pessoa> findAll(){
       return this.repo.findAll();
    }
    
    void remove(String id){
        repo.remove(repo.findById(id));
    }
}
