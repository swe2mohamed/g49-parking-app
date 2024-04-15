package se.lexicon.data;

import se.lexicon.model.ParkingSpot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ParkingSpotDao {

    ParkingSpot create(ParkingSpot parkingSpot);

    Optional<ParkingSpot> find(int spotNumber);

    boolean remove(int spotNumber);

    Collection<ParkingSpot> findAll();

    List<ParkingSpot> findByAreaCode(int areaCode);

    void occupyParkingSpot(int spotNumber);
    void vacateParkingSpot(int spotNumber);
}
