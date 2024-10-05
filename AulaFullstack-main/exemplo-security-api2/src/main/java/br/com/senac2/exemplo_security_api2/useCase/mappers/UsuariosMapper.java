package br.com.senac2.exemplo_security_api2.useCase.mappers;

import br.com.senac2.exemplo_security_api2.entitys.Usuarios;
import br.com.senac2.exemplo_security_api2.useCase.domains.UsuarioRequestDom;
import br.com.senac2.exemplo_security_api2.useCase.domains.UsuariosResponseDom;

public class UsuariosMapper {
    public static Usuarios usuarioRequestDomToUsuarios(UsuarioRequestDom input) {
        Usuarios output = new Usuarios();
        output.setLogin(input.getLogin());
        output.setSenha(input.getSenha());

        return output;
    }
    public static UsuariosResponseDom usuariosToUsuariosResponseDom(Usuarios input) {
        UsuariosResponseDom output = new UsuariosResponseDom();
        output.setId(input.getId());
        output.setLogin(input.getLogin());

        return output;
    }
}
