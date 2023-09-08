package ada.grupo5.msnotificacao.contracts.accounts;

import ada.grupo5.msnotificacao.enums.ChannelEnum;

public record AccountNotificationResponse(
        String subject,
        String result,
        ChannelEnum channel,
        String recipient,
        String name
) {
    public AccountNotificationResponse(
            ChannelEnum channel,
            String recipient,
            String name
    ) {
        this(
                "Account creation",
                "Message was sent with success",
                channel,
                recipient,
                name);
    }
}
