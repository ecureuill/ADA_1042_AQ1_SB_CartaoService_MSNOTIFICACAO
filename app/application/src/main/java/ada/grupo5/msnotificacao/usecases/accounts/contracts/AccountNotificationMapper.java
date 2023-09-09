package ada.grupo5.msnotificacao.usecases.accounts.contracts;

import ada.grupo5.msnotificacao.aggregates.dependents.Dependent;
import ada.grupo5.msnotificacao.aggregates.users.User;
import ada.grupo5.msnotificacao.aggregates.users.UserID;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AccountNotificationMapper {
    public Mono<User> fromRequestToMonoUser(
            final AccountNotificationRequest req
    ) {
        return Mono.just(req).flatMap(r -> {
            return fromRequestToDependentSet(Flux.fromArray(r.dependents()), r.id())
                    .collect(Collectors.toSet())
                    .map(dependentSet -> User.newUser(
                            r.id(),
                            r.name(),
                            r.document(),
                            r.email(),
                            r.phoneNumber(),
                            r.creditCard(),
                            dependentSet
                    ));
        });
    }

    public Flux<Dependent> fromRequestToDependentSet(
            final Flux<DependentRequestDto> deps,
            final UUID userId
    ) {
        return deps.map(d -> Dependent.newDependent(
                d.id(),
                d.name(),
                d.document(),
                d.creditCard(),
                (UserID) UserID.from(userId)
        ));
    }
}
