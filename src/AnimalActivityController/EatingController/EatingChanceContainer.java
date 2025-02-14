package AnimalActivityController.EatingController;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;

import java.util.Map;

@Setter
public class EatingChanceContainer {
    @JsonProperty("eatingChance")
    private Map<String, Map<String, Integer>> eatingChance;

    public Map<String, Map<String, Integer>> getEatingChance() {
        return eatingChance;
    }

}
