package com.practicas.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.practicas.services.CarService;

@RestController
@RequestMapping("maestros")
public class MaestrosRest {
	
	@Autowired
	private CarService carService;
	
	@GetMapping(value="/makes", produces = "application/json")
	public @ResponseBody List<String> getMakes(){
		return carService.getCarsMakes();
	}
	
	@GetMapping(value="/years", produces = "application/json")
	public @ResponseBody List<Integer> getYears(){
		return carService.getCarsYears();
	}
	
	@GetMapping(value="/classifications", produces = "application/json")
	public @ResponseBody List<String> getClassifications(){
		return carService.getCarsClassifications();
	}
	
	@GetMapping(value="/fuelTypes", produces = "application/json")
	public @ResponseBody List<String> getFuelTypes(){
		return carService.getCarsFuelTypes();
	}	
	
}
