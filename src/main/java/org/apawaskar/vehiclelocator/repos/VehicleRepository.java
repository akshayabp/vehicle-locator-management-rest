package org.apawaskar.vehiclelocator.repos;

import java.util.List;

import org.apawaskar.vehiclelocator.domain.Vehicle;

public interface VehicleRepository {

	Vehicle save(Vehicle vehicle);
	
	Vehicle find(long vehicleId);
	
	void delete(long vehicleId);
	
	Vehicle update(Vehicle vehicle);
	
	List<Vehicle> findAll();
	
}
