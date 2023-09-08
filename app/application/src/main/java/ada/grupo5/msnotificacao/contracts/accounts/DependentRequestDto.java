package ada.grupo5.msnotificacao.contracts.accounts;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;

public record DependentRequestDto(
        @NotBlank String name,
        @CPF String document,
        @Pattern(regexp = "^[0-9]{4}$") String creditCard
        )
{ }
