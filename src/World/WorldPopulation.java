package World;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WorldPopulation {

    @JsonProperty("startWolf")
    int startWolf;
    @JsonProperty("startBear")
    int startBear;
    @JsonProperty("startDeer")
    int startDeer;
    @JsonProperty("startFox")
    int startFox;
    @JsonProperty("startHorse")
    int startHorse;
    @JsonProperty("startSnake")
    int startSnake;
    @JsonProperty("startMouse")
    int startMouse;
    @JsonProperty("startGrass")
    int startGrass;

    public WorldPopulation() {
    }

    public WorldPopulation(int startWolf, int startBear, int startDeer, int startFox, int startHorse, int startSnake) {
        this.startWolf = startWolf;
        this.startBear = startBear;
        this.startDeer = startDeer;
        this.startFox = startFox;
        this.startHorse = startHorse;
        this.startSnake = startSnake;
    }


    public int getStartWolf() {
        return startWolf;
    }

    public int getStartBear() {
        return startBear;
    }

    public int getStartDeer() {
        return startDeer;
    }

    public int getStartFox() {
        return startFox;
    }

    public int getStartHorse() {
        return startHorse;
    }

    public int getStartSnake() {
        return startSnake;
    }

    public int getStartMouse() {
        return startMouse;
    }

    public int getStartGrass() {
        return startGrass;
    }
}
