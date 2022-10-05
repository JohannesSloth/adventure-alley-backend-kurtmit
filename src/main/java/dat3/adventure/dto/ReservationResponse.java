package dat3.adventure.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.adventure.entity.Reservation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
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
    String time;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    LocalDateTime created;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    LocalDateTime edited;

    String customerId;
    List<ActivityResponse> activities = new ArrayList<>();

    // Convert Reservation Entity to Reservation DTO
    public ReservationResponse(Reservation r, boolean includeAll){
        for (int i = 0; i < r.getActivities().size(); i++) {
            ActivityResponse act = new ActivityResponse(r.getActivities().get(i));
            activities.add(act);
        }
        this.reservationId = r.getReservationId();
        this.numberOfParticipants = r.getNumberOfParticipants();
        this.date = r.getDate();
        this.time = r.getTime();

        if(includeAll) {
            this.created = r.getCreated();
            this.edited = r.getEdited();
        }
    }
}
