package dat3.adventure.dto;

import dat3.adventure.entity.Activity;
import dat3.adventure.entity.Customer;
import dat3.adventure.entity.Reservation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.asm.Advice;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ReservationRequest {

    int reservationId;
    int numberOfParticipants;

    LocalDateTime startTime;
    int customerId;
    Activity activity;

    @CreationTimestamp
    LocalDateTime created;

    @UpdateTimestamp
    LocalDateTime edited;


    public static Reservation getReservationEntity(ReservationRequest rrq) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String startTime1 = rrq.getStartTime().format(formatter);
        LocalDateTime startTime = LocalDateTime.parse(startTime1,formatter);

        return new Reservation(rrq.getReservationId(), rrq.getNumberOfParticipants(), startTime,
            rrq.getCreated(), rrq.getEdited(),rrq.getCustomerId(),rrq.getActivity());
    }

    public ReservationRequest (Reservation r) {
        this.reservationId = r.getReservationId();
        this.numberOfParticipants = r.getNumberOfParticipants();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String startTime1 = r.getStartTime().format(formatter);
        this.startTime = LocalDateTime.parse(startTime1,formatter);

        this.created = r.getCreated();
        this.edited = r.getEdited();
        this.customerId = r.getCustomerId();
        this.activity = r.getActivity();
    }
}
