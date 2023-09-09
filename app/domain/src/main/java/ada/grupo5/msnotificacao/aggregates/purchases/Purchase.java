package ada.grupo5.msnotificacao.aggregates.purchases;

import ada.grupo5.msnotificacao.AggregateRoot;
import ada.grupo5.msnotificacao.Identifier;
import ada.grupo5.msnotificacao.aggregates.dependents.Dependent;
import ada.grupo5.msnotificacao.aggregates.users.UserID;
import ada.grupo5.msnotificacao.utils.InstantUtils;
import ada.grupo5.msnotificacao.vo.CreditCard;
import ada.grupo5.msnotificacao.vo.Document;
import ada.grupo5.msnotificacao.vo.EmailAddress;
import ada.grupo5.msnotificacao.vo.PhoneNumber;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;

public class Purchase extends AggregateRoot<UUID, PurchaseID> {

    public final Document holderDocument;
    public final UserID holderId;
    public final Document buyerDocument;
    public final Identifier<UUID> buyerId;
    public final CreditCard buyerCard;
    public final String seller;
    public final BigDecimal value;
    public final Instant purchaseTime;

    private Purchase(
            final PurchaseID id,
            final Document holderDocument,
            final UserID holderId,
            final Document buyerDocument,
            final Identifier<UUID> buyerId,
            final CreditCard buyerCard,
            final String seller,
            final BigDecimal value,
            final Instant purchaseTime,
            final Instant created,
            final Instant updated) {
        super(id, created, updated);
        this.holderDocument = holderDocument;
        this.holderId = holderId;
        this.buyerDocument = buyerDocument;
        this.buyerId = buyerId;
        this.buyerCard = buyerCard;
        this.seller = seller;
        this.value = value;
        this.purchaseTime = purchaseTime;
    }

    public static Purchase newPurchase(
            final UUID id,
            final Document holderDocument,
            final UserID holderId,
            final Document buyerDocument,
            final Identifier<UUID> buyerId,
            final CreditCard buyerCard,
            final String seller,
            final BigDecimal value,
            final Instant purchaseTime,
            final Instant created,
            final Instant updated
    ) {
        var now = InstantUtils.now();

        return new Purchase(
                (PurchaseID) PurchaseID.from(id),
                holderDocument,
                holderId,
                buyerDocument,
                buyerId,
                buyerCard,
                seller,
                value,
                purchaseTime,
                created,
                updated
        );
    }
}
