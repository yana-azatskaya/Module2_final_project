package AnimalActivityController.EatingController;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

public class EatingChanceContainer {
    @JsonProperty("eatingChance")
    private Map <String, Map<String, Integer>> eatingChance;

    public Map<String, Map<String, Integer>> getEatingChance() {
        return eatingChance;
    }

    public void setEatingChance(Map<String, Map<String, Integer>> eatingChance) {
        this.eatingChance = eatingChance;
    }
}
