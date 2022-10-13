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
    String date;
    String startTime;
    String customerEmail;
    String activityName;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    LocalDateTime created;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    LocalDateTime edited;

    //List<ActivityResponse> activities = new ArrayList<>();

    public ReservationResponse(Reservation r) {
        this.reservationId = r.getReservationId();
        this.numberOfParticipants = r.getNumberOfParticipants();
        this.date = r.getDate();
        this.startTime = r.getStartTime();
        this.customerEmail = r.getCustomerEmail();
        this.activityName = r.getActivityName();
    }


    // Convert Reservation Entity to Reservation DTO
    public ReservationResponse(Reservation r, boolean includeDate){
        this.reservationId = r.getReservationId();
        this.numberOfParticipants = r.getNumberOfParticipants();
        this.date = r.getDate();
        this.startTime = r.getStartTime();
        this.activityName = r.getActivityName();
        this.customerEmail = r.getCustomerEmail();
        if(includeDate) {
            this.created = r.getCreated();
            this.edited = r.getEdited();
        }
    }
}
