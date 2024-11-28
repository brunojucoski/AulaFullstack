package br.com.senac2.exemplo_security_api2.useCase.repositorys;

import br.com.senac2.exemplo_security_api2.entitys.Produto;
import br.com.senac2.exemplo_security_api2.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository < Produto, Long> {
    Optional<Produto> findByName(String name);

}
