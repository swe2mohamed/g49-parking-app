package se.lexicon.data.impl;

import se.lexicon.data.VehicleDao;
import se.lexicon.model.Vehicle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class VehicleDaoImpl implements VehicleDao {
    private List<Vehicle> storage = new ArrayList<>();
    @Override
    public Vehicle create(Vehicle vehicle) {
        if (vehicle == null) throw new IllegalArgumentException("Vehicle Data is null.");
        Optional<Vehicle> vehicleOptional = find(vehicle.getLicensePlate());
        if (vehicleOptional.isPresent()) throw new IllegalArgumentException("License plate is duplicate.");
        storage.add(vehicle);
        return vehicle;
    }

    @Override
    public Optional<Vehicle> find(String licensePlate) {
        for (Vehicle vehicle : storage){
            if (vehicle.getLicensePlate().equals(licensePlate)) return Optional.of(vehicle);
        }
        return Optional.empty();
    }

    @Override
    public boolean remove(String licensePlate) {
        Optional<Vehicle> vehicleOptional = find(licensePlate);
        if(!vehicleOptional.isPresent()) return false;
        else {
            storage.remove(vehicleOptional.get());
        }
        return true;
    }

    @Override
    public Collection<Vehicle> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public void update(Vehicle vehicle) {
        if (vehicle  == null) throw new IllegalArgumentException("Vehicle Data is null.");
        Optional <Vehicle> existingVehicleOptional = find(vehicle.getLicensePlate());
        if (!existingVehicleOptional.isPresent()) throw new IllegalArgumentException("License Plate not found");
        Vehicle existingVehicle = existingVehicleOptional.get();
        int index = storage.indexOf(existingVehicle);
        storage.set(index, vehicle);
        }
    }


