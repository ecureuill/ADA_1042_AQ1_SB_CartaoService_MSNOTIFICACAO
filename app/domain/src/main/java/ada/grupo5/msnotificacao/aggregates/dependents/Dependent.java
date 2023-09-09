package ada.grupo5.msnotificacao.aggregates.dependents;

import ada.grupo5.msnotificacao.AggregateRoot;
import ada.grupo5.msnotificacao.Identifier;
import ada.grupo5.msnotificacao.aggregates.users.User;
import ada.grupo5.msnotificacao.aggregates.users.UserID;
import ada.grupo5.msnotificacao.utils.InstantUtils;
import ada.grupo5.msnotificacao.vo.CreditCard;
import ada.grupo5.msnotificacao.vo.Document;

import java.time.Instant;
import java.util.UUID;

public class Dependent extends AggregateRoot<UUID, DependentID> {

    private final String name;
    private final Document document;
    private final CreditCard creditCard;
    private final UserID holder;

    private Dependent(
            final DependentID id,
            final String name,
            final Document document,
            final CreditCard creditCard,
            final UserID holder,
            final Instant created,
            final Instant updated) {
        super(id, created, updated);
        this.name = name;
        this.document = document;
        this.creditCard = creditCard;
        this.holder = holder;
    }

    public static Dependent newDependent(
            final UUID uuid,
            final String name,
            final String document,
            final String creditCard,
            final UserID holder
    ) {
        var now = InstantUtils.now();

        return new Dependent(
                (DependentID) DependentID.from(uuid),
                name,
                Document.from(document),
                CreditCard.from(creditCard),
                holder,
                now,
                now
        );
    }

    public String getName() {
        return name;
    }

    public Document getDocument() {
        return document;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public UserID getHolder() {
        return holder;
    }

}
