package ada.grupo5.msnotificacao;

import ada.grupo5.msnotificacao.utils.InstantUtils;

import java.time.Instant;
public abstract class AggregateRoot<ID> extends Entity<ID> {
    protected Instant updatedAt;
    protected Instant createdAt;

    protected AggregateRoot(final Identifier<ID> id) {
        super(id);
        var now = InstantUtils.now();
        updatedAt = now;
        createdAt = now;
    }
}
