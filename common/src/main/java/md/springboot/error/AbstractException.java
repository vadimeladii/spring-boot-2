package md.springboot.error;

import lombok.Getter;
import lombok.Setter;
import md.springboot.error.config.MessageException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public abstract class AbstractException extends RuntimeException {

    private MessageException messageException = new MessageException();

    AbstractException() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formatDateTime = now.format(formatter);
        messageException.setDate(formatDateTime);
    }
}
