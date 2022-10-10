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

  @Column(length= 50, nullable = false)
  LocalDateTime startTime;

  @Column(length= 50)
  LocalDateTime endTime;

  @CreationTimestamp
  LocalDateTime created;

  @UpdateTimestamp
  LocalDateTime edited;

  int customerId;

  @OneToOne
  Activity activity;

  public Reservation(int numberOfParticipants, LocalDateTime startTime) {
    this.numberOfParticipants = numberOfParticipants;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    String startTime1 = startTime.format(formatter);
    this.startTime = LocalDateTime.parse(startTime1,formatter);


    this.endTime = LocalDateTime.parse(this.startTime.getDayOfMonth() + "-" + this.startTime.getMonthValue() + "-" + this.startTime.getYear() +
        " " + (this.startTime.getHour()+1) + ":" + this.startTime.getMinute(),formatter);
  }

  public Reservation(int numberOfParticipants, LocalDateTime startTime, int customerId, Activity activity) {
    this.numberOfParticipants = numberOfParticipants;
    this.startTime = startTime;
    this.customerId = customerId;
    this.activity = activity;
  }

  public Reservation(int reservationId, int numberOfParticipants, LocalDateTime startTime, LocalDateTime created, LocalDateTime edited, int customerId, Activity activity) {
    this.reservationId = reservationId;
    this.numberOfParticipants = numberOfParticipants;
    this.startTime = startTime;
    this.created = created;
    this.edited = edited;
    this.customerId = customerId;
    this.activity = activity;
  }
}