package com.practicas.services;

import java.util.Comparator;

import com.practicas.model.Car;

public class CarCityMphComparator extends CarComparator implements Comparator<Car> {

	public CarCityMphComparator(boolean desc) {
		super.desc = desc;
	}

	@Override
	public int compare(Car car1, Car car2) {
		Integer valA = car1.getFuelinformation().getCitymph();
		Integer valB = car2.getFuelinformation().getCitymph();

		int mult = -1;
		if (!desc) {
			mult = 1;
		}

		if (valA < valB) {
			return mult * -1;
		} else if (valA > valB) {
			return mult * 1;
		} else {
			return mult * (car1.getIdentification().getMake().compareTo(car2.getIdentification().getMake()));
		}
	}

}
