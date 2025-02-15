package ServicePackage;

import AnimalActivityController.EatingController.EatService;
import AnimalActivityController.Movement.Movement;
import AnimalActivityController.ReproduceService;
import Exceptions.PredatorHasNoChanceToEat;
import Exceptions.WrongInputException;

import java.io.IOException;

public class AnimalLifeProcessRunner implements Runnable {
    public void run() {
        try {
            Movement.move();
            System.out.println("The animals have moved");
            ReproduceService.reproduce();
            System.out.println("The animals have reproduced");
            EatService.eat();
            System.out.println("The animals have eaten");
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
        catch (PredatorHasNoChanceToEat e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

    }
}

