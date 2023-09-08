package ada.grupo5.msnotificacao.enums;

public enum SubjectEnum {
    ACCOUNT(0),
    PURCHASE(1),
    INVOICE(2);

    private final int value;

    private SubjectEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}