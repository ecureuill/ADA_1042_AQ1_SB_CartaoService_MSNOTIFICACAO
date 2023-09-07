package ada.grupo5.msnotificacao.vo;

import ada.grupo5.msnotificacao.ValueObject;
import ada.grupo5.msnotificacao.enums.ChannelEnum;
import ada.grupo5.msnotificacao.exceptions.ValidationException;

public class Channel extends ValueObject<String, Channel> {
    private final String errorMessage = "Channel is not a valid one. Must be 'Email' or 'Sms'";

    @Override
    protected void validate() {
        var valid = isValid(this.getValue());
        if (valid) return;

        throw new ValidationException(errorMessage);
    }

    public static boolean isValid(String input) {
        input = input.replaceAll("[^a-zA-Z]", "");

        for (ChannelEnum channel : ChannelEnum.values()) {
            if (channel.name().equalsIgnoreCase(input))
                return true;
        }

        return false;
    }


}
