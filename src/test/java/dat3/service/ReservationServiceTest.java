package dat3.service;

import dat3.adventure.dto.ReservationRequest;
import dat3.adventure.dto.ReservationResponse;
import dat3.adventure.entity.Reservation;
import dat3.adventure.repository.ReservationRepository;
import dat3.adventure.service.ReservationService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ReservationServiceTest {
    public ReservationService reservationService;
    public static ReservationRepository reservationRepository;

    @BeforeAll
    public static void setupReservations(@Autowired ReservationRepository reservationRepository1){
        reservationRepository1.deleteAll();
        reservationRepository = reservationRepository1;
        reservationRepository.save(new Reservation(5, "202020", "2000", 3));
        reservationRepository.save(new Reservation(6,"303030","3000",4));
    }

    @BeforeEach
    void setupEach(){
        reservationService = new ReservationService(reservationRepository);
    }

    @Test
    void getReservationsTest() {
        assertEquals(2, reservationService.getReservations().size());
    }
    @Test
    void findByReservationIdTest() {
        assertEquals(5, reservationService.findByReservationId(1).getNumerOfParticipants());
        assertEquals(6, reservationService.findByReservationId(2).getNumberofParticipants());
    }
    @Test
    void editReservationTest() throws Exception{
        //Change reservation
        ReservationRequest request = new ReservationRequest(new Reservation(7,"909090", "1000", 5));
        reservationService.editReservation(request, 2);
        //Verify the changes
        ReservationResponse response = resevationService.findByReservationId(2);
        assertEquals(7, response.getNumberOfParticipants());
        assertEquals("909090", response.getDate());
        assertEquals("1000", response.getCustomerId());

    }

    @Test
    void deleteReservationByIdTest(){
        reservationRepository.deleteById(1);
        assertEquals(1, reservationRepository.count());
    }

    @Test
    void addReservationTest(){
        Reservation reservation = new Reservation(10, "707070", "2300", 20);
        ReservationRequest request = new ReservationRequest(reservation);
        reservationService.addReservation(request);
        assertEquals(3, reservationRepository.count());
    }
}
