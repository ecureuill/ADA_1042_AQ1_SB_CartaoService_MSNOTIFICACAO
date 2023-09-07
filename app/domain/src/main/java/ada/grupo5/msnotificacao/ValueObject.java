package ada.grupo5.msnotificacao;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Classe base para objetos de valor imutáveis.
 *
 * @param <TValue> O tipo de valor do objeto.
 * @param <TThis>  O próprio tipo (subclasse).
 */
public class ValueObject<TValue, TThis extends ValueObject<TValue, TThis>> {
    private TValue value;
    public static final Supplier<? extends ValueObject<?, ?>> FACTORY;

    static {
        try {
            FACTORY = newInstance();
        } catch (
                IllegalAccessException |
                InstantiationException |
                NoSuchMethodException |
                InvocationTargetException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    protected void validate() {
        // Deve ser sobrescrito pelas subclasses.
    }

    protected boolean tryValidate() {
        return true;
    }

    public static <TValue, TThis extends ValueObject<TValue, TThis>> TThis from(Class<TThis> valueType, TValue item) {
        TThis x = valueType.cast(FACTORY.get());
        x.setValue(item);
        x.validate();
        return x;
    }

    public static <TValue, TThis extends ValueObject<TValue, TThis>> boolean tryFrom(Class<TThis> valueType, TValue item, ValueObject<TValue, TThis>[] result) {
        TThis x = valueType.cast(FACTORY.get());
        x.setValue(item);
        if (x.tryValidate()) {
            result[0] = x;
            return true;
        }
        return false;
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

    public static <TValue, TThis extends ValueObject<TValue, TThis>> boolean areEqual(TThis a, TThis b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.equals(b);
    }

    @SuppressWarnings("unchecked")
    protected static <TValue, TThis extends ValueObject<TValue, TThis>> TThis newInstance()
            throws IllegalAccessException,
            InstantiationException,
            NoSuchMethodException,
            InvocationTargetException {
       return (TThis) ValueObject.class.getDeclaredConstructor().newInstance();
    }

}
