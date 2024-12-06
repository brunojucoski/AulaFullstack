package br.com.senac2.exemplo_security_api2.useCase.mappers;

import br.com.senac2.exemplo_security_api2.entitys.Produto;
import br.com.senac2.exemplo_security_api2.entitys.Usuario;
import br.com.senac2.exemplo_security_api2.useCase.domains.ProdutoRequestDom;
import br.com.senac2.exemplo_security_api2.useCase.domains.ProdutosResponseDom;
import br.com.senac2.exemplo_security_api2.useCase.domains.UsuarioRequestDom;
import br.com.senac2.exemplo_security_api2.useCase.domains.UsuariosResponseDom;

public class ProdutosMapper {
    public static Produto produtoRequestDomToProdutos(ProdutoRequestDom input) {
        Produto output = new Produto();
        output.setName(input.getName());
        output.setPreco(input.getPreco());
        output.setDescricao(input.getDescricao());

        return output;
}
    public static ProdutosResponseDom produtosToProdutosResponseDom(Produto input) {
        ProdutosResponseDom output = new ProdutosResponseDom();
        output.setId(input.getId());
        output.setName(input.getName());

        return output;
    }
}