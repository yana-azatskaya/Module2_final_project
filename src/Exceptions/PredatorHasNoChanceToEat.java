package Exceptions;

import java.io.IOException;

public class PredatorHasNoChanceToEat extends IOException {
    public PredatorHasNoChanceToEat(String message) {
        super(message);
    }

}
