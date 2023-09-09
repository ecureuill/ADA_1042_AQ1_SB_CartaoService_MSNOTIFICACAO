package ada.grupo5.msnotificacao;

import java.util.Objects;

public abstract class Entity<T, ID extends Identifier<T>> {
    protected final ID id;

    protected Entity(final ID id) {
        Objects.requireNonNull(id, "id should not be null");
        this.id = id;
    }

    public T getId() {
        return id.getValue();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Entity<?,?> entity = (Entity<?,?>) o;
        return getId().equals(entity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
