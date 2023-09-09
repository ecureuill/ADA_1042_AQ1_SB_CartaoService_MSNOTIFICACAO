package ada.grupo5.msnotificacao.usecases.accounts;

import ada.grupo5.msnotificacao.aggregates.users.User;
import ada.grupo5.msnotificacao.mailer.EmailService;
import ada.grupo5.msnotificacao.usecases.accounts.contracts.AccountNotificationMapper;
import ada.grupo5.msnotificacao.usecases.accounts.contracts.AccountNotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public final class AccountNotificationUseCase {

    private final EmailService emailService;
    private final AccountNotificationMapper mapper;

    public Mono<Void> sendNewAccount(final Mono<AccountNotificationRequest> req) {
        return req
                .flatMap(r -> Mono.fromRunnable(
                        () -> emailService.sendAccountCreation(r)
                ));
    }
}
