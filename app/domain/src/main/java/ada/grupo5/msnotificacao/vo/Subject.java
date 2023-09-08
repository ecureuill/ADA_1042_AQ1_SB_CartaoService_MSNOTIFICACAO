package ada.grupo5.msnotificacao.vo;

import ada.grupo5.msnotificacao.ValueObject;
import ada.grupo5.msnotificacao.enums.SubjectEnum;
import ada.grupo5.msnotificacao.exceptions.ValidationException;

public class Subject extends ValueObject<String, Subject> {
    private final static String errorMessage = "Subject is not a valid one. Must be 'Account', 'Purchase' or 'Invoice'";

    @Override
    protected void validate() {
        var valid = isValid(this.getValue());
        if (valid) return;

        throw new ValidationException(errorMessage);
    }

    public static boolean isValid(String input) {
        input = input.replaceAll("[^a-zA-Z]", "");

        for (SubjectEnum subject : SubjectEnum.values()) {
            if (subject.name().equalsIgnoreCase(input))
                return true;
        }

        return false;
    }
}
