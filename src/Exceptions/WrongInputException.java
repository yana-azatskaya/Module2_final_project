package Exceptions;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;

import java.io.IOException;

public class WrongInputException extends IOException {
    public WrongInputException (String message) {
        super(message);
    }

}
