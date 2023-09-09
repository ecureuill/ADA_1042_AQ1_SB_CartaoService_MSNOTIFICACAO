package ada.grupo5.msnotificacao;

import ada.grupo5.msnotificacao.utils.InstantUtils;

import java.time.Instant;
public abstract class AggregateRoot <T, ID extends Identifier<T>> extends Entity<T, ID> {
    protected Instant updatedAt;
    protected Instant createdAt;

    protected AggregateRoot(
            final ID id,
            final Instant created,
            final Instant updated
    ) {
        super(id);
        updatedAt = updated;
        createdAt = created;
    }
}
