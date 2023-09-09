package ada.grupo5.msnotificacao.usecases.accounts.contracts;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;

import java.util.UUID;

public record DependentRequestDto(
        UUID id,
        @NotBlank String name,
        @CPF String document,
        @Pattern(regexp = "^[0-9]{4}$") String creditCard
        )
{ }
