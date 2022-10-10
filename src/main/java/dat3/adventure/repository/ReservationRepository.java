package dat3.adventure.repository;

import dat3.adventure.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

  Boolean existsByActivity_ActivityNameAndStartTimeBetween(String Activityname, LocalDateTime startTime, LocalDateTime endTime);
  Boolean existsByActivity_ActivityNameAndEndTimeBetween(String Activityname, LocalDateTime startTime, LocalDateTime endTime);

}


