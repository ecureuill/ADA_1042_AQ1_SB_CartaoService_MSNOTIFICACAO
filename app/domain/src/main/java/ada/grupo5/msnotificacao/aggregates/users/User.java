package ada.grupo5.msnotificacao.aggregates.users;

import ada.grupo5.msnotificacao.AggregateRoot;
import ada.grupo5.msnotificacao.Identifier;
import ada.grupo5.msnotificacao.ValueObject;
import ada.grupo5.msnotificacao.aggregates.dependents.Dependent;
import ada.grupo5.msnotificacao.exceptions.ValidationException;
import ada.grupo5.msnotificacao.utils.InstantUtils;
import ada.grupo5.msnotificacao.vo.CreditCard;
import ada.grupo5.msnotificacao.vo.Document;
import ada.grupo5.msnotificacao.vo.EmailAddress;
import ada.grupo5.msnotificacao.vo.PhoneNumber;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

public class User extends AggregateRoot<UUID, UserID> {

    private final String name;
    private final Document document;
    private final EmailAddress emailAddress;
    private final PhoneNumber phoneNumber;
    private final CreditCard creditCard;
    private final Set<Dependent> dependents;

    private User(
            final UserID uuid,
            final String name,
            final Document document,
            final EmailAddress emailAddress,
            final PhoneNumber phoneNumber,
            final CreditCard creditCard,
            final Set<Dependent> dependents,
            final Instant createdAt,
            final Instant updatedAt
    ) {
        super(uuid, createdAt, updatedAt);
        this.name = name;
        this.document = document;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.creditCard = creditCard;
        this.dependents = dependents;
    }

    public static User newUser(
           final UUID id,
           final String name,
           final String document,
           final String email,
           final String phoneNumber,
           final String creditCard,
           final Set<Dependent> dependents
    ) {
        var now = InstantUtils.now();

        return new User(
                (UserID) UserID.from(id),
                name,
                Document.from(document),
                EmailAddress.from(email),
                PhoneNumber.from(phoneNumber),
                CreditCard.from(creditCard),
                dependents,
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

    public EmailAddress getEmailAddress() {
        return emailAddress;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public Set<Dependent> getDependents() {
        return dependents;
    }
}
