package dat3.adventure.service;

import dat3.adventure.dto.ReservationRequest;
import dat3.adventure.dto.ReservationResponse;
import dat3.adventure.entity.Activity;
import dat3.adventure.entity.Customer;
import dat3.adventure.entity.Reservation;
import dat3.adventure.repository.ActivityRepository;
import dat3.adventure.repository.CustomerRepository;
import dat3.adventure.repository.ReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
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

    public List<ReservationResponse> getReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        List<ReservationResponse> response = reservations.stream().map(reservation -> new ReservationResponse(reservation)).collect(Collectors.toList());
        return response;
    }

    public ReservationResponse findByReservationId(int reservationId) {

        Reservation found = reservationRepository.findById(reservationId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation with this ID not found"));
        return new ReservationResponse(found, false);
    }

    public ReservationResponse addReservation(ReservationRequest reservationRequest) {

        //boolean exists = reservationRepository.existsByActivity_ActivityNameAndRentalDateAndTime(reservationRequest.getActivity().getActivityName(),reservationRequest.getRentalDate(), reservationRequest.getTime());

        //if (exists) {
        //    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Denne aktivitet er allerede booket på denne");
        //}

        if (reservationRepository.existsById(reservationRequest.getReservationId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Reservation with this ID already exists");
        }


        Reservation newReservation = ReservationRequest.getReservationEntity(reservationRequest);
        newReservation = reservationRepository.save(newReservation);

        return new ReservationResponse(newReservation);
    }

    public void editReservation(ReservationRequest body, int reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Reservation with this ID already exists"));
        /*if (body.getReservationId() != reservationId) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Can't change reservation");
        }*/
        reservation.setNumberOfParticipants(body.getNumberOfParticipants());
        reservation.setRentalDate(body.getRentalDate());
        reservation.setTime(body.getTime());
        reservation.setCustomer(body.getCustomer());
        reservation.setActivity(body.getActivity());
    }

    public void deleteReservationById(int reservationId) {
        reservationRepository.deleteById(reservationId);
    }


}
