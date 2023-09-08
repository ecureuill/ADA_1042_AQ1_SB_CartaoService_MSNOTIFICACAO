package ada.grupo5.msnotificacao;

import com.sun.jdi.Value;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class ValueObject<TValue, TThis extends ValueObject<TValue, TThis>> {
    private TValue value;

    protected ValueObject() {}

    protected ValueObject(TValue item) {
        value = item;
    }
    protected void validate() {}

    protected boolean tryValidate() {
        return true;
    }

    public static <TValue, TThis extends ValueObject<TValue, TThis>> TThis from(TValue item) {
        try {
            ValueObject<TValue, TThis> vo = new ValueObject<TValue, TThis>();

            @SuppressWarnings("unchecked")
            TThis x = (TThis) vo.getClass()
                    .getConstructor(item.getClass())
                    .newInstance(item);

            x.validate();

            return x;
        } catch (
                InstantiationException |
                IllegalAccessException |
                InvocationTargetException |
                NoSuchMethodException e) {
            final var errorMessage =
                    "There was a error while trying to instantiate";

            throw new RuntimeException(errorMessage, e);
        }
    }

    protected void setValue(TValue value) {
        this.value = value;
    }

    public TValue getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ValueObject<?, ?> that = (ValueObject<?, ?>) obj;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public boolean areEqual(TThis a, TThis b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.equals(b);
    }


}
