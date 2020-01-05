package org.apawaskar.vehiclelocator.controller;

import java.util.List;

import org.apawaskar.vehiclelocator.domain.Driver;
import org.apawaskar.vehiclelocator.repos.DriverRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Transactional
public class DriverController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DriverController.class);
	
	@Autowired
	private DriverRepository driverRepo;
	
	@RequestMapping("/driver/{id}")
	public Driver getDriver(@PathVariable("id") long id){			
		Driver driver =driverRepo.find(id);	
		LOGGER.info("Driver for {} : {}", id, driver);
		return driver;
	}
	
	@RequestMapping(value="/driver",  method=RequestMethod.POST, consumes="application/json")
	public Driver createDriver(@RequestBody Driver driver){
		Driver createdDriver = driverRepo.save(driver);
		LOGGER.info("Driver created for {}: {}", createdDriver.getId(), createdDriver);		
		return createdDriver;
	}

	@RequestMapping("/drivers")
	public List<Driver> getAllDrivers(){		
		List<Driver> drivers = driverRepo.findAll();		
		return drivers;
	}
	
	@RequestMapping(value="/driver",  method=RequestMethod.PUT, consumes="application/json")
	public Driver updateDriver(@RequestBody Driver driver){
		Driver createdDriver = driverRepo.update(driver);
		return createdDriver;
	}
	
	@RequestMapping(value="/driver/{id}",  method=RequestMethod.DELETE)
	public void deleteVehicle(@PathVariable("id") long id){			
		driverRepo.delete(id);		
	}
}
