package dat3.adventure.repository;

import dat3.adventure.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

  List<Reservation> getReservationsByActivityNameAndDate (String activityName, String date);

  List<Reservation> getReservationByCustomerEmail (String customerEmail);

}
