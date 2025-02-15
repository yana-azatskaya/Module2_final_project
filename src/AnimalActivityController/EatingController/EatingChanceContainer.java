package AnimalActivityController.EatingController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;
import java.util.Map;

@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EatingChanceContainer {
    @JsonProperty("eatingChance")
    private Map<String, Map<String, Integer>> eatingChance;

    public Map<String, Map<String, Integer>> getEatingChance() {
        return eatingChance;
    }

}
