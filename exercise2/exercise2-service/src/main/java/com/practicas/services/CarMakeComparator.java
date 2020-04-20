package com.practicas.services;

import java.util.Comparator;

import com.practicas.model.Car;

public class CarMakeComparator extends CarComparator implements Comparator<Car>{
	
	public CarMakeComparator(boolean asc) {
		super.asc = asc;
	}
	
	@Override
	public int compare(Car car1, Car car2) {

		int mult = 1;
		if (!asc) {
			mult = -1;
		}

		return mult * (car1.getIdentification().getMake().compareTo(car2.getIdentification().getMake()));

	}
	
}
