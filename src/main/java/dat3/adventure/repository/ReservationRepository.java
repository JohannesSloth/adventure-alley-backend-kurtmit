package dat3.adventure.repository;

import dat3.adventure.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

  //Boolean existsByActivity_ActivityNameAndRentalDateAndTime(String Activityname, String rentalDate, String time);
  //Skal fikses med et tidsinterval
}