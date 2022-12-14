package dat3.adventure.service;

import dat3.adventure.dto.ReservationRequest;
import dat3.adventure.dto.ReservationResponse;
import dat3.adventure.entity.Reservation;
import dat3.adventure.repository.ActivityRepository;
import dat3.adventure.repository.CustomerRepository;
import dat3.adventure.repository.ReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {

  ReservationRepository reservationRepository;
  CustomerRepository customerRepository;
  ActivityRepository activityRepository;

  public ReservationService(ReservationRepository reservationRepository, CustomerRepository customerRepository, ActivityRepository activityRepository) {
    this.customerRepository = customerRepository;
    this.activityRepository = activityRepository;
    this.reservationRepository = reservationRepository;
  }

  public List<ReservationResponse> getReservationsByActivityAndDate(String activity, String date) {
    List<Reservation> reservations = reservationRepository.getReservationsByActivityNameAndDate(activity, date);
    List<ReservationResponse> response = reservations.stream().map(reservation -> new ReservationResponse(reservation)).collect(Collectors.toList());
    return response;
  }

  public List<ReservationResponse> getReservations() {
    List<Reservation> reservations = reservationRepository.findAll();
    List<ReservationResponse> response = reservations.stream().map(reservation -> new ReservationResponse(reservation)).collect(Collectors.toList());
    return response;
  }

  public ReservationResponse findByReservationId(int reservationId) {

    Reservation found = reservationRepository.findById(reservationId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation with this ID not found"));
    return new ReservationResponse(found, false);
  }

  public List<ReservationResponse> getReservationsByCustomerEmail(String customerEmail){

    List<Reservation> reservations = reservationRepository.getReservationByCustomerEmail(customerEmail);

    List<ReservationResponse> response = reservations.stream().map(reservation -> new ReservationResponse(reservation)).collect(Collectors.toList());

    return response;
  }

  public ReservationResponse addReservation(ReservationRequest reservationRequest) {

    Reservation newReservation = ReservationRequest.getReservationEntity(reservationRequest);
    newReservation = reservationRepository.save(newReservation);

    if (reservationRepository.existsById(newReservation.getReservationId())) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Reservation with this ID already exists");
    }

    return new ReservationResponse(newReservation);
  }

  public void editReservation(ReservationRequest body, int reservationId) {
    Reservation reservation = reservationRepository.findById(reservationId).orElseThrow(
        () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Reservation with this ID already exists"));
        /*if (body.getReservationId() != reservationId) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Can't change reservation");
        }*/
    reservation.setNumberOfParticipants(body.getNumberOfParticipants());
    reservation.setStartTime(body.getStartTime());
    reservation.setDate(body.getDate());
    reservation.setCustomerEmail(body.getCustomerEmail());
    reservation.setActivityName(body.getActivityName());
  }

  public void deleteReservationById(int reservationId) {
    reservationRepository.deleteById(reservationId);
  }


}
