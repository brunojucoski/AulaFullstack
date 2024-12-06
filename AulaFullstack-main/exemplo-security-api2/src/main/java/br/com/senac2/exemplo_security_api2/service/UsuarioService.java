package br.com.senac2.exemplo_security_api2.service;

import br.com.senac2.exemplo_security_api2.entitys.Usuario;
import br.com.senac2.exemplo_security_api2.entitys.Usuario;
import br.com.senac2.exemplo_security_api2.jwt.TokenService;
import br.com.senac2.exemplo_security_api2.useCase.domains.UsuarioRequestDom;
import br.com.senac2.exemplo_security_api2.useCase.domains.UsuariosResponseDom;
import br.com.senac2.exemplo_security_api2.useCase.mappers.UsuariosMapper;
import br.com.senac2.exemplo_security_api2.useCase.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService;

    public UsuariosResponseDom criarUsuario(UsuarioRequestDom usuario) {
        Usuario usuariosPersit = UsuariosMapper.usuarioRequestDomToUsuarios(usuario);

        usuariosPersit.setSenha(passwordEncoder.encode(usuario.getSenha()));

        Usuario usuariosResult =
                    usuarioRepository.save(usuariosPersit);

        return UsuariosMapper .usuariosToUsuariosResponseDom(usuariosResult);
    }

    public UsuariosResponseDom loginUsuario(UsuarioRequestDom usuario) throws Exception {
        Optional<Usuario> usuarioResult =
                usuarioRepository.findByLogin(usuario.getLogin());
        if (usuarioResult.isPresent()){
            if(passwordEncoder.matches(
                    usuario.getSenha(),
                    usuarioResult.get().getSenha())) {
                String token = tokenService.gerarToken(usuarioResult.get());

                UsuariosResponseDom usuarioRetorno = UsuariosMapper.usuariosToUsuariosResponseDom(usuarioResult.get());

                usuarioRetorno.setToken(token);

                return usuarioRetorno;

            }
            throw new Exception("Senha invalida");

            }
            throw new Exception("Usuario não encontrado");
        }

}
