
package br.unicesumar.escoladeti2015base.pessoa;

import java.io.Serializable;
import java.util.Objects;

public class Pessoa implements Serializable{
    private String id;
    private String nome;
    private String sobreNome;
    private String idade;

    public Pessoa() {
    }

    public Pessoa(String id, String nome, String sobrenome, String idade) {
        this.id = id;
        this.nome = nome;
        this.sobreNome = sobrenome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobrenome) {
        this.sobreNome = sobrenome;
    }

    
    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
     public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", SobreNome=" + sobreNome + ", idade=" + idade + '}';
    }
    
    
}
