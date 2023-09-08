package ada.grupo5.msnotificacao.adapters.controllers;

import ada.grupo5.msnotificacao.contracts.accounts.AccountNotificationRequest;
import ada.grupo5.msnotificacao.contracts.accounts.AccountNotificationResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController()
public class NotificationController {

    @PostMapping("send/newaccount")
    public Mono<AccountNotificationResponse> newAccount(
            @Valid @RequestBody
            final AccountNotificationRequest req
    ) {
        return Mono.just(req).map(r ->
                new AccountNotificationResponse(
                    req.channel(),
                    req.email(),
                    req.name()
                ));
    }


}
