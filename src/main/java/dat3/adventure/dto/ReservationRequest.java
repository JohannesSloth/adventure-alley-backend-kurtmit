package dat3.adventure.dto;

import dat3.adventure.entity.Activity;
import dat3.adventure.entity.Customer;
import dat3.adventure.entity.Reservation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ReservationRequest {

    int reservationId;
    int numberOfParticipants;
    String date;
    String time;
    Customer customer;
    Activity activity;

    @CreationTimestamp
    LocalDateTime created;

    @UpdateTimestamp
    LocalDateTime edited;




    /*public static Reservation getReservationEntity(ReservationRequest rrq) {
        return new Reservation(rrq.getReservationId(), rrq.getNumberOfParticipants(), rrq.getDate(), rrq.getTime(), rrq.getCreated(), rrq.getEdited(), rrq.getCustomerId());
    }

    public ReservationRequest (Reservation r) {
        this.reservationId = r.getReservationId();
        this.numberOfParticipants = r.getNumberOfParticipants();
        this.date = r.getDate();
        this.time = r.getTime();
        this.created = r.getCreated();
        this.edited = r.getEdited();
        this.customerId = r.getCustomerId();
    }*/
}
