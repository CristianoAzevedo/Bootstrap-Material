
package br.unicesumar.escoladeti2015base.pessoa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/pessoas")
public class PessoaController {
    
    @Autowired
    private PessoaService service;
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Pessoa getPessoa(@PathVariable String id){
        return service.findById(id);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Pessoa> getPessoas(){
        return service.findAll();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void criaPessoa(@RequestBody Pessoa p){
        service.save(p);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void excluirPessoa(@PathVariable String id){
        service.remove(id);
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public void atualizarPessoa(@PathVariable String id, @RequestBody Pessoa p){
        service.remove(p);
        service.save(p);
    }
}
