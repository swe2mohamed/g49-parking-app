package se.lexicon.data;

import se.lexicon.model.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationDao {
    Reservation create(Reservation reservation);

    Optional<Reservation> find(String id);

    boolean remove(String id);

    Reservation findByCustomerId(int customerId);

    Reservation findByVehicleLicensePlate(String licensePlate);

    Reservation findByParkingSpotNumber(int spotNumber);

    List<Reservation> findAll();
}
