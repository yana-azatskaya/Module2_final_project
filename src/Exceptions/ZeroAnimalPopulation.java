package Exceptions;

import java.io.IOException;

public class ZeroAnimalPopulation extends IOException {
    public ZeroAnimalPopulation(String message) {
        super(message);
    }

}
