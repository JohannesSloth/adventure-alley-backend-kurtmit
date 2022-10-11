package dat3.adventure.entity;

import lombok.*;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

  String date;

  String startTime;

  @CreationTimestamp
  LocalDateTime created;

  @UpdateTimestamp
  LocalDateTime edited;

  int customerId;

  @OneToOne
  Activity activity;

  public Reservation(int numberOfParticipants, String date, String startTime) {
    this.numberOfParticipants = numberOfParticipants;
    this.date = date;
    this.startTime = startTime;
  }

  public Reservation(int numberOfParticipants, String date, String startTime, int customerId, Activity activity) {
    this.numberOfParticipants = numberOfParticipants;
    this.date = date;
    this.startTime = startTime;
    this.customerId = customerId;
    this.activity = activity;
  }

}