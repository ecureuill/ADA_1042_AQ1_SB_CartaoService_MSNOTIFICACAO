package ada.grupo5.msnotificacao;

import java.util.Objects;

public abstract class Entity<ID> {
    protected final Identifier<ID> id;

    protected Entity(final Identifier<ID> id) {
        Objects.requireNonNull(id, "id should not be null");
        this.id = id;
    }
    public ID getId() {
        return id.getValue();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Entity<?> entity = (Entity<?>) o;
        return getId().equals(entity.getId());
    }
}
