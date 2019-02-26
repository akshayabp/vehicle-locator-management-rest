package org.apawaskar.vehiclelocator.repos;

import java.util.List;

import org.apawaskar.vehiclelocator.domain.Driver;
import org.apawaskar.vehiclelocator.domain.Vehicle;

public interface DriverRepository {

	Driver save(Driver driver);
	
	Driver find(long driverId);
	
	List<Driver> findAll();
	
	void delete(long driverId);
	
	Driver update(Driver driver);
}
