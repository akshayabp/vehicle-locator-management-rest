package org.apawaskar.vehiclelocator.repos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apawaskar.vehiclelocator.domain.Vehicle;
import org.springframework.stereotype.Repository;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Vehicle save(Vehicle vehicle) {
		entityManager.persist(vehicle);
		return vehicle;
	}

	@Override
	public Vehicle find(long vehicleId) {
		return entityManager.find(Vehicle.class, vehicleId);
	}

	@Override
	public List<Vehicle> findAll() {
		return (List<Vehicle>) entityManager.createQuery("select v from Vehicle v").getResultList();
	}

	@Override
	public void delete(long vehicleId) {
		Vehicle vehicle = entityManager.find(Vehicle.class, vehicleId);
		entityManager.remove(vehicle);
	}

	@Override
	public Vehicle update(Vehicle vehicle) {
		return entityManager.merge(vehicle);
	}

}
