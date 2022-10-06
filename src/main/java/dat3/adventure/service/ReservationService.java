package dat3.adventure.service;

import dat3.adventure.dto.ReservationRequest;
import dat3.adventure.entity.Customer;
import dat3.adventure.entity.Reservation;
import dat3.adventure.repository.ActivityRepository;
import dat3.adventure.repository.CustomerRepository;
import dat3.adventure.repository.EmployeeRepository;
import dat3.adventure.repository.ReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ReservationService {

    ReservationRepository reservationRepository;
    CustomerRepository customerRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation getReservation(int reservationId) {
        return reservationRepository.findById(reservationId).orElseThrow();
    }

    /*public void addReservation(int numberOfParticipants, String date, String time, int customerId) {

        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Customer ID not found"));
        Reservation reservation = reservationRepository.findById(time).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Time slot is already in use"));
    }*/

    public void editReservation(ReservationRequest body, int reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Reservation with this ID already exists"));
        if(body.getReservationId() != reservationId) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Can't change reservation");
        }
        reservation.setNumberOfParticipants(body.getNumberOfParticipants());
        reservation.setDate(body.getDate());
        reservation.setTime(body.getTime());
        reservation.setCustomerId(body.getCustomerId());
    }

    public void deleteReservationById(int reservationId) {
        reservationRepository.deleteById(reservationId);
    }




}
