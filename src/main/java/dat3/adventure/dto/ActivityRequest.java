package dat3.adventure.dto;

import dat3.adventure.entity.Activity;
import dat3.adventure.entity.Equipment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

public class ActivityRequest {
    String activityName;
    int minimumAge;
    int minimumHeight;
    //int duration;
    double pricePerHour;
    List<Equipment> equipment = new ArrayList<>();

    public static Activity getActivityEntity(ActivityRequest arq) {
        return new Activity(arq.getMinimumAge(), arq.getMinimumHeight(), arq.getPricePerHour());
    }

    public ActivityRequest(Activity a) {
        this.activityName = a.getActivityName();
        this.minimumAge = a.getMinimumAge();
        this.minimumHeight = a.getMinimumHeight();
        this.pricePerHour = a.getPricePerHour();
    }

    public ActivityRequest(String activityName, int minimumAge, int minimumHeight, double pricePerHour) {
        this.activityName = activityName;
        this.minimumAge = minimumAge;
        this.minimumHeight = minimumHeight;
        this.pricePerHour = pricePerHour;
    }
}
