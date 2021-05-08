package com.bridgelabz.workshop2.hotelreservationsystem;

public class Hotel {

	private String hotelName;
	private int regularCustomerWeekendRate;
	private int regularCustomerWeekDaysRate;

	public Hotel(String hotelName, int regularCustomerWeekendRate) {
		this.hotelName = hotelName;
		this.regularCustomerWeekendRate = regularCustomerWeekendRate;
	}

	public Hotel(String hotelName, int regularCustomerWeekEndRate, int regularCustomerWeekDaysRate) {
		super();
		this.hotelName = hotelName;
		this.regularCustomerWeekendRate = regularCustomerWeekEndRate;
		this.regularCustomerWeekDaysRate = regularCustomerWeekDaysRate;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getRegularCustomerWeekEndRate() {
		return regularCustomerWeekendRate;
	}

	public void setRegularCustomerWeekEndRate(int regularCustomerWeekendRate) {
		this.regularCustomerWeekendRate = regularCustomerWeekendRate;
	}

	public int getRegularCustomerWeekDaysRate() {
		return regularCustomerWeekDaysRate;
	}

	public void setRegularCustomerWeekDaysRate(int regularCustomerWeekDaysRate) {
		this.regularCustomerWeekDaysRate = regularCustomerWeekDaysRate;
	}

}
