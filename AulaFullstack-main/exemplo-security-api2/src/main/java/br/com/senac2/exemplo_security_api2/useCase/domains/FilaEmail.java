package br.com.senac2.exemplo_security_api2.useCase.domains;

        import br.com.senac2.exemplo_security_api2.entitys.EntityID;
        import jakarta.persistence.Entity;
        import lombok.AllArgsConstructor;
        import lombok.Getter;
        import lombok.NoArgsConstructor;
        import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FilaEmail extends EntityID {
    private String email;
    private Boolean enviado;
}
