package se.lexicon.data.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.data.VehicleDao;
import se.lexicon.model.Vehicle;
import se.lexicon.model.VehicleType;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleDaoImplTest {
    // 1. testCreate
    // 2. testCreateExistingVehicle
    // 3. testFindExistingVehicle
    // 4. testFindNonExistingVehicle
    // 5. testRemoveExistingVehicle
    // 6. testRemoveNonExistingVehicle
    private VehicleDaoImpl vehicleDao;

    @BeforeEach
    public void setUp(){
        vehicleDao = new VehicleDaoImpl();
    }

    // 1. testCreate
    @Test
    public void testCreate(){
        Vehicle vehicle = new Vehicle("ABC123", VehicleType.CAR);
        Vehicle actualValue = vehicleDao.create(vehicle);
        Vehicle expectedValue = vehicle;

        assertEquals(expectedValue,actualValue);
        assertTrue(vehicleDao.find("ABC123").isPresent());

    }

    // 2. testCreateExistingVehicle
    @Test
    public void testCreateExistingVehicle(){
        Vehicle vehicle = new Vehicle("ABC123",VehicleType.CAR);
        vehicleDao.create(vehicle);
        assertThrows(IllegalArgumentException.class, () -> vehicleDao.create(vehicle));
    }

    // 3. testFindExistingVehicle
    @Test
    public void testFindExistingVehicle(){
        Vehicle vehicle = new Vehicle("ABC123", VehicleType.CAR);
        vehicleDao.create(vehicle);

        Optional<Vehicle> foundVehicle = vehicleDao.find("ABC123");;
        assertTrue(foundVehicle.isPresent());
        assertEquals(vehicle,foundVehicle.get());
    }

    // 4. testFindNonExistingVehicle
    @Test
    public void testFindNonExistingVehicle(){
        Optional<Vehicle> foundNonExisting = vehicleDao.find("ABC123");
        assertFalse(foundNonExisting.isPresent());
    }

    // 5. testRemoveExistingVehicle
    @Test
    public void testRemoveExistingVehicle(){
        Vehicle vehicle = new Vehicle("ABC123", VehicleType.CAR);
        vehicleDao.create(vehicle);
        assertTrue(vehicleDao.remove("ABC123"));
        assertFalse(vehicleDao.find("ABC123").isPresent());

    }

    // 6. testRemoveNonExistingVehicle
    @Test
    public void testRemoveNonExistingVehicle(){
        assertFalse(vehicleDao.remove("ABC123"));
    }
}
