package ada.grupo5.msnotificacao.vo;

import ada.grupo5.msnotificacao.ValueObject;
import ada.grupo5.msnotificacao.enums.ChannelEnum;
import ada.grupo5.msnotificacao.exceptions.ValidationException;

public class CreditCard extends ValueObject<String, CreditCard> {
    private final String regex = "\\d{4}";
    private final String errorMessage = "CreditCard must be a four length numeric sequence.";

    @Override
    protected void validate() {
        if (isValid(this.getValue())) return;
        throw new ValidationException(errorMessage);
    }

    public static boolean isValid(final String input) {
        return input.matches(regex);
    }

}
