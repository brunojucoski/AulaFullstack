package br.com.senac2.exemplo_security_api2.useCase.mappers;

import br.com.senac2.exemplo_security_api2.entitys.Produtos;
import br.com.senac2.exemplo_security_api2.entitys.Usuarios;
import br.com.senac2.exemplo_security_api2.useCase.domains.ProdutoRequestDom;
import br.com.senac2.exemplo_security_api2.useCase.domains.ProdutosResponseDom;
import br.com.senac2.exemplo_security_api2.useCase.domains.UsuarioRequestDom;
import br.com.senac2.exemplo_security_api2.useCase.domains.UsuariosResponseDom;

public class ProdutosMapper {
    public static Produtos produtoRequestDomToProdutos(ProdutoRequestDom input) {
        Produtos output = new Produtos();
        output.setName(input.getName());
        output.setPreco(input.getPreco());
        output.setDescricao(input.getDescricao());

        return output;
}
    public static ProdutosResponseDom produtosToProdutosResponseDom(Produtos input) {
        ProdutosResponseDom output = new ProdutosResponseDom();
        output.setId(input.getId());
        output.setName(input.getName());

        return output;
    }
}