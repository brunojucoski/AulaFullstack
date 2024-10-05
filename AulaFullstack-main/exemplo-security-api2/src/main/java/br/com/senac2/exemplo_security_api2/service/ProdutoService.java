package br.com.senac2.exemplo_security_api2.service;


import br.com.senac2.exemplo_security_api2.entitys.Produtos;
import br.com.senac2.exemplo_security_api2.useCase.domains.ProdutoRequestDom;
import br.com.senac2.exemplo_security_api2.useCase.domains.ProdutosResponseDom;
import br.com.senac2.exemplo_security_api2.useCase.mappers.ProdutosMapper;
import br.com.senac2.exemplo_security_api2.useCase.repositorys.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtorepository;



    public ProdutosResponseDom criarProduto(ProdutoRequestDom produto) {
        Produtos produtosPersit = ProdutosMapper.produtoRequestDomToProdutos(produto);


        Produtos produtosResult =
                produtorepository.save(produtosPersit);

        return ProdutosMapper.produtosToProdutosResponseDom(produtosResult);
    }

    public ProdutosResponseDom BuscaProduto(ProdutoRequestDom produto) throws Exception {
        Optional<Produtos> produtoResult =
                produtorepository.findByName(produto.getName());
        if (produtoResult.isPresent()){

                ProdutosResponseDom produtoRetorno = ProdutosMapper.produtosToProdutosResponseDom(produtoResult.get());
                
                return produtoRetorno;
        }
        throw new Exception("Produto não encontrado");
    }

}





