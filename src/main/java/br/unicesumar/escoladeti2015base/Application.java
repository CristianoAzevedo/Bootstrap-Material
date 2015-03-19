package br.unicesumar.escoladeti2015base;


import br.unicesumar.escoladeti2015base.cores.CorRepository;
import br.unicesumar.escoladeti2015base.cores.CorRepositoryInMemory;
import br.unicesumar.escoladeti2015base.pais.PaisRepository;
import br.unicesumar.escoladeti2015base.pais.PaisRepositoryInMemory;
import br.unicesumar.escoladeti2015base.pessoa.PessoaRepository;
import br.unicesumar.escoladeti2015base.pessoa.PessoaRepositoryInMemory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);        
    }
    
    @Bean
    public PaisRepository criarPaisRepository() {
        return new PaisRepositoryInMemory();
    }
    
    @Bean 
    public CorRepository criarCorRepository() {
        return new CorRepositoryInMemory();
    }
    
    @Bean
    public PessoaRepository criarPessoaRepository(){
        return new PessoaRepositoryInMemory();
    }
}
