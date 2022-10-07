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
  String rentalDate;

  @Column(length= 50, nullable = false)
  String time;

  @CreationTimestamp
  LocalDateTime created;

  @UpdateTimestamp
  LocalDateTime edited;

  @ManyToOne
  Customer customer;

  @OneToOne(mappedBy = "reservation", cascade = CascadeType.ALL)
  private Activity activity;

  /*public void addActivity(Activity act){
    activities.add(act);
    //activities.setActivity(this);
  }*/

  public Reservation(int numberOfParticipants, String rentalDate, String time) {
    this.numberOfParticipants = numberOfParticipants;
    this.rentalDate = rentalDate;
    this.time = time;
  }

  public Reservation(int numberOfParticipants, String rentalDate, String time, int customerId, Customer customer, Activity activity) {
    this.numberOfParticipants = numberOfParticipants;
    this.rentalDate = rentalDate;
    this.time = time;
    this.customer = customer;
    this.activity = activity;
  }
}
