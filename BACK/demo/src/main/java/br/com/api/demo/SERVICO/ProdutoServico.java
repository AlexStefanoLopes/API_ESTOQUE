package br.com.api.demo.SERVICO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.demo.MODELO.ProdutoModelo;
import br.com.api.demo.MODELO.RespostaModelo;
import br.com.api.demo.REPOSITORIO.ProdutoRepositório;

@Service
public class ProdutoServico {

    @Autowired
    private ProdutoRepositório pr;

    // Método para listas todos os produtos
    public Iterable<ProdutoModelo> listar(){
        return pr.findAll();
    }

    @Autowired
    private RespostaModelo rm;

    // Método para cadastrar produtos
    public ResponseEntity<?> cadastrarAlterar(ProdutoModelo pm, String acao){

        if(pm.getNome().equals("")){
            rm.setMensagem("O nome do produto é obrigatório");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }
        else if(pm.getMarca().equals("")){
            rm.setMensagem("O nome da marca é obrigatório");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }
        else{
            if(acao.equals("cadastrar")){
                return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.CREATED);
            }
            else{
                return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.OK);
            }
            }
        }

        // Método para remover produtos
        public ResponseEntity<RespostaModelo> remover(Long codigo){
            pr.deleteById(codigo);

            rm.setMensagem("O produto foi removido com sucesso!");
            return new ResponseEntity<RespostaModelo> (rm, HttpStatus.OK);       
        }

    }





