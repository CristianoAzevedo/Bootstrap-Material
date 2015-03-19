/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicesumar.escoladeti2015base.cores;
import java.util.List;
/**
 *
 * @author Cristiano
 */
public interface CorRepository {
    void save(Cor c);
    void remove(Cor c);
    Cor findById(String id);
    List<Cor> findAll();
}
