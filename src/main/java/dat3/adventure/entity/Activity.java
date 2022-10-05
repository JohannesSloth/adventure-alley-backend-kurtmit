package dat3.adventure.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class Activity {


    @Id
    String activityName;

    @Column(length= 50, nullable = false)
    int minimumAge;

    @Column(length= 50, nullable = false)
    int minimumHeight;

    //@Column(length= 50, nullable = false)
    //int duration;

    @Column(length= 50, nullable = false)
    double pricePerHour;

    @OneToMany(mappedBy = "activity", cascade = CascadeType.ALL)
    List<Equipment> equipment = new ArrayList<>();

    @ManyToOne
    Reservation reservation;

    public void addEquipment(Equipment eqp){
        equipment.add(eqp);
        //equipment.setEquipment(this);
    }

    public Activity(String activityName, int minimumAge, int minimumHeight, double pricePerHour) {
        this.activityName = activityName;
        this.minimumAge = minimumAge;
        this.minimumHeight = minimumHeight;
        this.pricePerHour = pricePerHour;
    }
}
