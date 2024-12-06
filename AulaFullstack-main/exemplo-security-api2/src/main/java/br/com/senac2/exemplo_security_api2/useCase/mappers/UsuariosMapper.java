package br.com.senac2.exemplo_security_api2.useCase.mappers;

import br.com.senac2.exemplo_security_api2.entitys.Usuario;
import br.com.senac2.exemplo_security_api2.useCase.domains.UsuarioRequestDom;
import br.com.senac2.exemplo_security_api2.useCase.domains.UsuariosResponseDom;

public class UsuariosMapper {
    public static Usuario usuarioRequestDomToUsuarios(UsuarioRequestDom input) {
        Usuario output = new Usuario();
        output.setLogin(input.getLogin());
        output.setSenha(input.getSenha());

        return output;
    }
    public static UsuariosResponseDom usuariosToUsuariosResponseDom(Usuario input) {
        UsuariosResponseDom output = new UsuariosResponseDom();
        output.setId(input.getId());
        output.setLogin(input.getLogin());

        return output;
    }
}
