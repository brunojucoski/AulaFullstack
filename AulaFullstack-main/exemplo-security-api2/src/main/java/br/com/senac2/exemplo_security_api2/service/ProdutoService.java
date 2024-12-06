package br.com.senac2.exemplo_security_api2.service;


import br.com.senac2.exemplo_security_api2.entitys.Produto;
import br.com.senac2.exemplo_security_api2.useCase.domains.ProdutoRequestDom;
import br.com.senac2.exemplo_security_api2.useCase.domains.ProdutosResponseDom;
import br.com.senac2.exemplo_security_api2.useCase.mappers.ProdutosMapper;
import br.com.senac2.exemplo_security_api2.useCase.repositorys.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static br.com.senac2.exemplo_security_api2.useCase.mappers.ProdutosMapper.produtoRequestDomToProdutos;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtorepository;
    private final ModelMapper modelMapper;



    public ProdutosResponseDom criarProduto(ProdutoRequestDom produto) {
        Produto produtosPersit = produtoRequestDomToProdutos(produto);


        Produto produtosResult =
                produtorepository.save(produtosPersit);

        return ProdutosMapper.produtosToProdutosResponseDom(produtosResult);
    }

    public ProdutosResponseDom BuscaProduto(ProdutoRequestDom produto) throws Exception {
        Optional<Produto> produtoResult =
                produtorepository.findByName(produto.getName());
        if (produtoResult.isPresent()){

                ProdutosResponseDom produtoRetorno = ProdutosMapper.produtosToProdutosResponseDom(produtoResult.get());
                
                return produtoRetorno;
        }
        throw new Exception("Produto não encontrado");
    }

}





