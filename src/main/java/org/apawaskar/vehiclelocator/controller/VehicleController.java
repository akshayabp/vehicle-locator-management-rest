package org.apawaskar.vehiclelocator.controller;

import java.util.List;

import org.apawaskar.vehiclelocator.domain.Vehicle;
import org.apawaskar.vehiclelocator.repos.VehicleRepository;
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
public class VehicleController {

	@Autowired
	private VehicleRepository vehicleRepo;
	
	@RequestMapping("/vehicle/{id}")
	public Vehicle getVehicle(@PathVariable("id") long id){			
		Vehicle vehicle =vehicleRepo.find(id);		
		return vehicle;
	}
	
	@RequestMapping(value="/vehicle/{id}",  method=RequestMethod.DELETE)
	public void deleteVehicle(@PathVariable("id") long id){			
		vehicleRepo.delete(id);		
		
	}
	
	@RequestMapping(value="/vehicle",  method=RequestMethod.POST, consumes="application/json")
	public Vehicle createVehicle(@RequestBody Vehicle vehicle){	
		System.out.println(vehicle);
		Vehicle createdVehicle = vehicleRepo.save(vehicle);		
		return createdVehicle;
	}
	
	@RequestMapping(value="/vehicle",  method=RequestMethod.PUT, consumes="application/json")
	public Vehicle updateVehicle(@RequestBody Vehicle vehicle){	
		System.out.println(vehicle);
		Vehicle createdVehicle = vehicleRepo.update(vehicle);		
		return createdVehicle;
	}

	@RequestMapping("/vehicles")
	public List<Vehicle> getAllVehicles(){
		
		List<Vehicle> vehicles = vehicleRepo.findAll();
		return vehicles;
	}
	
}
