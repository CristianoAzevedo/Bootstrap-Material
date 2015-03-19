package br.unicesumar.escoladeti2015base.pais;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/paises")
public class PaisController {

    @Autowired
    private PaisService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Pais getPais(@PathVariable String id) {
        return service.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Pais> getPaises() {
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void criarPais(@RequestBody Pais pais) {
        service.save(pais);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void excluirPais(@PathVariable String id) {
        service.remove(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void atualizarPais(@PathVariable String id, @RequestBody Pais pais) {
        service.remove(id);
        service.save(pais);
    }
}
