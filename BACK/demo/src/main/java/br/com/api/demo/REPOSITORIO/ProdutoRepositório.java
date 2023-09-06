package br.com.api.demo.REPOSITORIO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import br.com.api.demo.MODELO.ProdutoModelo;

@Repository
public interface ProdutoRepositório extends CrudRepository<ProdutoModelo, Long>{
    
}
