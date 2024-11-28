package br.com.senac2.exemplo_security_api2.useCase.repositorys;

import br.com.senac2.exemplo_security_api2.useCase.domains.FilaEmail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FilaEmailRepository extends JpaRepository<FilaEmail, UUID> {
    List<FilaEmail> findByEnviado(boolean enviado);
}
