package dat3.service;

import dat3.adventure.dto.ActivityRequest;
import dat3.adventure.dto.ActivityResponse;
import dat3.adventure.entity.Activity;
import dat3.adventure.entity.Reservation;
import dat3.adventure.repository.ActivityRepository;
import dat3.adventure.repository.ReservationRepository;
import dat3.adventure.service.ActivityService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*@DataJpaTest
public class ReservationRepositoryTest {

  public static ReservationRepository reservationRepository;


  @BeforeAll
  public static void setupActivity(@Autowired ReservationRepository reservationRepository1){
    reservationRepository = reservationRepository1;
    reservationRepository.save(new Reservation(1, "10102022","09",1,"sumo"));
    reservationRepository.save(new Reservation(2, "11102022","10",2,"gokart"));
    reservationRepository.save(new Reservation(1, "12102022","09",1,"sumo"));
  }

  @Test
  public void testFindRes(){
    assertEquals(reservationRepository.getReservationsByActivityNameAndDate("sumo","10102022").size(), 2);
  }

}
*/