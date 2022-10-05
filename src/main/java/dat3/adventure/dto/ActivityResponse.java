package dat3.adventure.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.adventure.entity.Activity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ActivityResponse {
    String activityName;
    int minimumAge;
    int minimumHeight;
    //int duration;
    double pricePerHour;

    public ActivityResponse(Activity ars, boolean includeAll) {
        this.activityName = ars.getActivityName();
        this.minimumAge = ars.getMinimumAge();
        this.minimumHeight = ars.getMinimumHeight();
        this.pricePerHour = ars.getPricePerHour();
    }

}
