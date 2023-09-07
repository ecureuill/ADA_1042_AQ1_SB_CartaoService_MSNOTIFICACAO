package ada.grupo5.msnotificacao.enums;

public enum ChannelEnum {
    Email(0),
    SMS(1);

    private final int value;

    private ChannelEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

