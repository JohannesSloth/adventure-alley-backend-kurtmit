package dat3.adventure.api;

import dat3.adventure.dto.ReservationRequest;
import dat3.adventure.dto.ReservationResponse;
import dat3.adventure.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/reservations")
public class ReservationController {
    ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/{activity}/{date}")
    public List<ReservationResponse> getReservationsByActivityAndDate(@PathVariable String activity, @PathVariable String date){
        return reservationService.getReservationsByActivityAndDate(activity,date);
    }

    @GetMapping
    public List<ReservationResponse> getReservations() {
        return reservationService.getReservations();
    }

    @GetMapping("/{reservationId}")
    public ReservationResponse getReservationById(@PathVariable int reservationId) throws Exception{
        ReservationResponse response = reservationService.findByReservationId(reservationId);
        return response;
    }

    @PostMapping
    public ReservationResponse addReservation (@RequestBody ReservationRequest body){
        return reservationService.addReservation(body);
    }

    @GetMapping("/{customerEmail}")
    public List<ReservationResponse> getReservationsByCustomerEmail(@PathVariable String customerEmail) {
        return reservationService.getReservationsByCustomerEmail(customerEmail);
    }

    @PutMapping("/{reservationId}")
    public ResponseEntity<Boolean> editReservation(@RequestBody ReservationRequest body, @PathVariable int reservationId){
        reservationService.editReservation(body,reservationId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @DeleteMapping("/{reservationId}")
    public void deleteReservationById(@PathVariable int reservationId){
        reservationService.deleteReservationById(reservationId);
    }
}