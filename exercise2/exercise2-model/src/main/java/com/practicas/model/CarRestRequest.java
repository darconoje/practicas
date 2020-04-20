package com.practicas.model;

public class CarRestRequest {

	private String makeFilter;
	private int yearFilter;
	private String classificationFilter;
	private String fuelTypeFilter;
	private boolean hybridFilter;
	private String search;
	private int page;
	private int recordsPerPage;
	private String sortPk;
	private String sortMake;
	private String sortYear;

	public CarRestRequest(String makeFilter, int yearFilter, String classificationFilter, String fuelTypeFilter,
			boolean hybridFilter, String search, int page, int recordsPerPage, String sortPk, String sortMake,
			String sortYear) {
		this.makeFilter = makeFilter;
		this.yearFilter = yearFilter;
		this.classificationFilter = classificationFilter;
		this.fuelTypeFilter = fuelTypeFilter;
		this.hybridFilter = hybridFilter;
		this.search = search;
		this.page = page;
		this.recordsPerPage = recordsPerPage;
		this.sortPk = sortPk;
		this.sortMake = sortMake;
		this.sortYear = sortYear;
	}

	public String getMakeFilter() {
		return makeFilter;
	}

	public void setMakeFilter(String makeFilter) {
		this.makeFilter = makeFilter;
	}

	public int getYearFilter() {
		return yearFilter;
	}

	public void setYearFilter(int yearFilter) {
		this.yearFilter = yearFilter;
	}

	public String getClassificationFilter() {
		return classificationFilter;
	}

	public void setClassificationFilter(String classificationFilter) {
		this.classificationFilter = classificationFilter;
	}

	public String getFuelTypeFilter() {
		return fuelTypeFilter;
	}

	public void setFuelTypeFilter(String fuelTypeFilter) {
		this.fuelTypeFilter = fuelTypeFilter;
	}

	public boolean isHybridFilter() {
		return hybridFilter;
	}

	public void setHybridFilter(boolean hybridFilter) {
		this.hybridFilter = hybridFilter;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public String getSortPk() {
		return sortPk;
	}

	public void setSortPk(String sortPk) {
		this.sortPk = sortPk;
	}

	public String getSortMake() {
		return sortMake;
	}

	public void setSortMake(String sortMake) {
		this.sortMake = sortMake;
	}

	public String getSortYear() {
		return sortYear;
	}

	public void setSortYear(String sortYear) {
		this.sortYear = sortYear;
	}

	
	
}
