package ada.grupo5.msnotificacao.adapters.controllers;

import ada.grupo5.msnotificacao.usecases.accounts.AccountNotificationUseCase;
import ada.grupo5.msnotificacao.usecases.accounts.contracts.AccountNotificationRequest;
import ada.grupo5.msnotificacao.usecases.accounts.contracts.AccountNotificationResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController()
@RequiredArgsConstructor()
public final class NotificationController {

    private final Logger logger = LoggerFactory.getLogger(NotificationController.class);
    private final AccountNotificationUseCase accountNotification;

    @PostMapping("send/newaccount")
    public Mono<AccountNotificationResponse> newAccount(
            @Valid @RequestBody
            final AccountNotificationRequest req
    ) {

        return accountNotification
                .sendNewAccount(Mono.just(req))
                .then(Mono.just(new AccountNotificationResponse(
                        req.channel(),
                        req.email(),
                        req.name()
                )));
    }

}
