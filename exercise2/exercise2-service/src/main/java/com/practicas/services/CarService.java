package com.practicas.services;

import com.practicas.model.Car;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;


public interface CarService {
	
	public List<Car> getCars(int liminferior, int limsuperior);
	
	public List<Car> getCars(int liminferior, int limsuperior, Predicate<Car> p);
	
	public List<Car> getCars(int liminferior, int limsuperior, CarComparator comparator);
	
	public List<Car> getCars(int liminferior, int limsuperior, Predicate<Car> p, CarComparator comparator);
	
	public List<Car> getCars(int liminferior, int limsuperior, Predicate<Car> p, CarComparator comparator, int limit);
	
	public List<Car> getCars(int liminferior, int limsuperior, Predicate<Car> p, int limit);
	
	public List<Car> getCars(int liminferior, int limsuperior, List<Predicate<Car>> ps, CarComparator comparator);
	
	public List<Car> getCarsCompare(int start, int end, List<Predicate<Car>> ps, CarComparator comparator);
	
	public List<Car> getCars(int start, long end, List<Predicate<Car>> ps);
	
	public List<Car> getCars(int start, int end, List<Predicate<Car>> ps);
	
	public long getCarsCount(Predicate<Car> p);
	
	public long getCarsCount(List<Predicate<Car>> ps);
	
	public Optional<Car> getCarByPk(int pk);
	
	public List<String> getCarsFuelTypes();
	
	public List<String> getCarsClassifications();
	
	public List<String> getCarsDrivelines();

	public List<Integer> getCarsNumberOfForwardGears();

	public List<String> getCarsTransmissions();
	
	public List<Integer> getCarsYears();
	
	public List<String> getCarsMakes();
	
	public List<Car> incluyeEnMotor(String caracteres);
	
	public List<Car> consumoCiudad(int cantidad, boolean cantidadmenor, boolean ordendescendente);
	
	public List<Car> cantidadVelocidades(int velocidades);
	
	public List<Car> esHibrido(boolean hibrido);
	
	public List<Car> caracterNumericoEnId(int indice);
	
	public List<Car> cochesPorAnno(int n, int anno, boolean ordendescendente);
	
	public List<Car> tipoFuel(String fuel);
	
	public List<Car> tipoTraccion(String traccion);
	
	public List<Car> tipoClasificacion(String clasificacion);
	
	public List<Car> primerosPotencia(int n, int potencia, boolean mayor);
	
	public long totalCar();

}
