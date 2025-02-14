package ServicePackage;
import AnimalActivityController.ReproduceService;
import AnimalActivityController.EatingController.EatService;
import AnimalActivityController.Movement.*;
import java.io.IOException;
public class AnimalLifeProcessRunner implements Runnable{
    public void run() {
        try {
           Movement.move();
            System.out.println("The animals have moved");
           ReproduceService.reproduce();
            System.out.println("The animals have reproduced");
           EatService.eat();
            System.out.println("The animals have eaten");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
