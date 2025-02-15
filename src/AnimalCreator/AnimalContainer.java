package AnimalCreator;

import Animals.Animal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Map;

@Getter
public class AnimalContainer {
    @JsonProperty("animals")
    public  Map<String, Animal> animalContainer;

    public  Map<String, Animal> getAnimals() {
        return animalContainer;
    }

    public boolean isValid(){
        return animalContainer !=null;
    }
}

