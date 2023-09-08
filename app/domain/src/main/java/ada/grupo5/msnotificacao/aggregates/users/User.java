package ada.grupo5.msnotificacao.aggregates.users;

import ada.grupo5.msnotificacao.AggregateRoot;
import ada.grupo5.msnotificacao.Identifier;
import ada.grupo5.msnotificacao.ValueObject;
import ada.grupo5.msnotificacao.exceptions.ValidationException;
import ada.grupo5.msnotificacao.vo.CreditCard;
import ada.grupo5.msnotificacao.vo.Document;
import ada.grupo5.msnotificacao.vo.EmailAddress;
import ada.grupo5.msnotificacao.vo.PhoneNumber;

import java.util.Set;
import java.util.UUID;

public class User extends AggregateRoot<UUID> {
    private final String name;
    private final Document document;
    private final EmailAddress address;
    private final PhoneNumber phoneNumber;
    private final CreditCard creditCard;

    private User(
            final Identifier<UUID> uuid,
            final String name,
            final Document document,
            final EmailAddress address,
            final PhoneNumber phoneNumber,
            final CreditCard creditCard) {
        super(uuid);
        this.name = name;
        this.document = document;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.creditCard = creditCard;
    }

    public static User newUser(
           final UUID id,
           final String name,
           final String document,
           final String email,
           final String phoneNumber,
           final String creditCard
    ) {
        return new User(
                    Identifier.from(id),
                    name,
                    Document.from(document),
                    EmailAddress.from(email),
                    PhoneNumber.from(phoneNumber),
                    CreditCard.from(creditCard)
            );
    }
}
