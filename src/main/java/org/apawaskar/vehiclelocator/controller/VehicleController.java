package org.apawaskar.vehiclelocator.controller;

import java.util.List;

import org.apawaskar.vehiclelocator.domain.Vehicle;
import org.apawaskar.vehiclelocator.repos.VehicleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Transactional
public class VehicleController {

	private static final Logger LOGGER = LoggerFactory.getLogger(VehicleController.class);
	
	@Autowired
	private VehicleRepository vehicleRepo;
	
	@RequestMapping("/vehicle/{id}" )
	public Vehicle getVehicle(@PathVariable("id") long id){	
		Vehicle vehicle =vehicleRepo.find(id);		
		LOGGER.info("Vehicle for {} : {}", id, vehicle);
		return vehicle;
	}
	
	@RequestMapping(value="/vehicle/{id}",  method=RequestMethod.DELETE)
	public void deleteVehicle(@PathVariable("id") long id){			
		vehicleRepo.delete(id);		
		
	}
	
	@RequestMapping(value="/vehicle",  method=RequestMethod.POST, consumes="application/json")
	public Vehicle createVehicle(@RequestBody Vehicle vehicle){			
		Vehicle createdVehicle = vehicleRepo.save(vehicle);		
		LOGGER.info("Vehicle created for {} : {}", createdVehicle.getId(), createdVehicle);
		return createdVehicle;
	}
	
	@RequestMapping(value="/vehicle",  method=RequestMethod.PUT, consumes="application/json")
	public Vehicle updateVehicle(@RequestBody Vehicle vehicle){	
		LOGGER.info("Vehicle updated for {} : {}", vehicle.getId(), vehicle);
		Vehicle updatedVehicle = vehicleRepo.update(vehicle);		
		return updatedVehicle;
	}

	@RequestMapping(value="/vehicles", produces="application/json")
	@ResponseBody
	public List<Vehicle> getAllVehicles(){
		LOGGER.info("Retrieving all vehicles");
		List<Vehicle> vehicles = vehicleRepo.findAll();
		return vehicles;
	}
	
}
