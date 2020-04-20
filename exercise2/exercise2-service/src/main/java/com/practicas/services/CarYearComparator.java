package com.practicas.services;

import java.util.Comparator;

import com.practicas.model.Car;

public class CarYearComparator extends CarComparator implements Comparator<Car>{

	public CarYearComparator(boolean asc) {
		super.asc = asc;
	}
	
	@Override
	public int compare(Car car1, Car car2) {
		Integer valA = car1.getIdentification().getYear();
		Integer valB = car2.getIdentification().getYear();


		if (!asc) {
			return valA.compareTo(valB)*-1;
		}else {
			return valA.compareTo(valB);
		}

	}

	
}
