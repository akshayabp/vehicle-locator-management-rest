package org.apawaskar.vehiclelocator.repos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apawaskar.vehiclelocator.domain.Driver;
import org.apawaskar.vehiclelocator.domain.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DriverRepositoryImpl implements DriverRepository {

	
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Driver save(Driver driver) {
		entityManager.persist(driver);
		return driver;
	}

	@Override
	public Driver find(long driverId) {
		return entityManager.find(Driver.class, driverId);
	}

	@Override
	public List<Driver> findAll() {
		return (List<Driver>) entityManager.createQuery("select d from Driver d").getResultList();
	}

	@Override
	public void delete(long driverId) {
		Driver driver = entityManager.find(Driver.class, driverId);
		entityManager.remove(driver);		
	}

	@Override
	public Driver update(Driver driver) {
		return entityManager.merge(driver);
	}
	
	

}
