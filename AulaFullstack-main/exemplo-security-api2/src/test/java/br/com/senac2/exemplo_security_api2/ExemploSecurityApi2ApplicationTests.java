package br.com.senac2.exemplo_security_api2;

import br.com.senac2.exemplo_security_api2.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExemploSecurityApi2ApplicationTests {


	@Autowired
	private EmailService emailService;
	@Test
	public void testeEmail() {
		emailService.enviarEmail( "brunojucoskibr@hotmail.com",
								 "bruno.vaz.juca@gmail.com",
								 "seila",
								  "alguma coisa aqui nada a ver");
	}

}
