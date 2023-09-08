package ada.grupo5.msnotificacao.contracts.accounts;

import ada.grupo5.msnotificacao.enums.ChannelEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.util.UUID;


public record AccountNotificationRequest(
        UUID id,
        @CPF String document,
        @Email String email,
        ChannelEnum channel,
        @Pattern(regexp = "^[0-9]{6}$") String code,
        @NotBlank String name,
        @Pattern(regexp = "^[0-9]{4}$") String creditCard,
        @Valid DependentRequestDto[] dependents
)
{}

