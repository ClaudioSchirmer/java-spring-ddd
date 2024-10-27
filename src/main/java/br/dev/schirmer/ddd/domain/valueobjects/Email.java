package br.dev.schirmer.ddd.domain.valueobjects;

import br.dev.schirmer.ddd.domain.exceptions.Notification;

import java.util.List;
import java.util.regex.Pattern;

public record Email(String value) implements ValueObject<String> {
    private static final String EMAIL_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    private static final Pattern PATTERN = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);

    @Override
    public void validate(Boolean required, String fieldName, List<Notification> notifications) {
        if (required && value == null) {
            notifications.add(
                    new Notification(
                            fieldName,
                            fieldName + " is required."
                    )
            );
            return;
        }
        if (!PATTERN.matcher(value).matches()) {
            notifications.add(
                    new Notification(
                            fieldName,
                            "Invalid value."
                    )
            );
        }
    }
}
