package Exceptions;

import java.io.IOException;

public class NoKnownAnimalException extends IOException {
    public NoKnownAnimalException(String message) {
        super(message);
    }

}
