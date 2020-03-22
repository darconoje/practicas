package com.practicas.services;

import java.util.Comparator;

import com.practicas.model.Car;

public class CarFuelTypeComparator extends CarComparator implements Comparator<Car> {

	public CarFuelTypeComparator(boolean desc) {

		super.desc = desc;
	}

	@Override
	public int compare(Car o1, Car o2) {

		return 0;
	}

}
