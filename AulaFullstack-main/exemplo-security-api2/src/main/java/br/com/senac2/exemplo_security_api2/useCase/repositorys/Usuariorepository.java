package br.com.senac2.exemplo_security_api2.useCase.repositorys;

import br.com.senac2.exemplo_security_api2.entitys.Usuario;
import br.com.senac2.exemplo_security_api2.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    UserDetails findByLogin(String login);


    Usuario findBylogin(String login);
}
