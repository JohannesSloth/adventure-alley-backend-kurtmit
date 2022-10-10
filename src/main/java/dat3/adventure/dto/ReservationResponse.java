package dat3.adventure.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.adventure.entity.Activity;
import dat3.adventure.entity.Customer;
import dat3.adventure.entity.Reservation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationResponse {

    int reservationId;
    int numberOfParticipants;
    LocalDateTime startTime;
    int customerId;
    Activity activity;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    LocalDateTime created;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    LocalDateTime edited;

    //List<ActivityResponse> activities = new ArrayList<>();

    public ReservationResponse(Reservation r) {
        this.reservationId = r.getReservationId();
        this.numberOfParticipants = r.getNumberOfParticipants();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String startTime1 = r.getStartTime().format(formatter);
        this.startTime = LocalDateTime.parse(startTime1,formatter);

        this.customerId = r.getCustomerId();
        this.activity = r.getActivity();
    }


    // Convert Reservation Entity to Reservation DTO
    public ReservationResponse(Reservation r, boolean includeDate){
        this.reservationId = r.getReservationId();
        this.numberOfParticipants = r.getNumberOfParticipants();

        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

        this.startTime = LocalDateTime.parse(r.getStartTime().format(formatter),formatter);

        this.activity = r.getActivity();
        this.customerId = getCustomerId();
        if(includeDate) {
            this.created = r.getCreated();
            this.edited = r.getEdited();
        }
    }
}
