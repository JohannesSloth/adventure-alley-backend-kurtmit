package dat3.adventure.entity;

import lombok.*;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString


@Entity
public class Reservation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int reservationId;

  int numberOfParticipants;

  @Column(length= 50, nullable = false)
  String date;

  @Column(length= 50, nullable = false)
  String time;

  @CreationTimestamp
  LocalDateTime created;

  @UpdateTimestamp
  LocalDateTime edited;

  /*@OneToMany(mappedBy = "reservations", cascade = CascadeType.ALL)
  List<Activity> activities = new ArrayList<>();*/

  int customerId;

  /*public void addActivity(Activity act){
    activities.add(act);
    //activities.setActivity(this);
  }*/

  public Reservation(int numberOfParticipants, String date, String time, int customerId) {
    this.numberOfParticipants = numberOfParticipants;
    this.date = date;
    this.time = time;
    this.customerId = customerId;
  }
}
