package com.practicas.model;

import java.util.List;
import java.util.Map;

public class PaginaCompleta {

	private int draw;
	private long recordsTotal;
	private long recordsFiltered;
	private List<Car> cars;
	private Map<String, List<?>> filters;

	public PaginaCompleta() {

	}

	public PaginaCompleta(int draw, long recordstotal, long recordsfiltered, List<Car> cars, Map<String, List<?>> filters) {
		this.draw = draw;
		this.recordsTotal = recordstotal;
		this.recordsFiltered = recordsfiltered;
		this.cars = cars;
		this.filters = filters;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
	public long getRecordsTotal() {
		return recordsTotal;
	}
	
	public void setRecordsTotal(long recordstotal) {
		this.recordsTotal = recordstotal;
	}
	
	public long getRecordsFiltered() {
		return recordsFiltered;
	}
	
	public void setRecordsFiltered(long recordsfiltered) {
		this.recordsFiltered = recordsfiltered;
	}
	
	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}
	
	public Map<String, List<?>> getFilters() {
		return filters;
	}
	
	public void setFilters(Map<String, List<?>> filters) {
		this.filters = filters;
	}	

}
