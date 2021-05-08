package com.bridgelabz.workshop2.hotelreservationsystem;


public class Hotel {

	private String hotelName;
	private int regularCustomerWeekendRate;

	public Hotel(String hotelName, int regularCustomerWeekendRate) {
		this.hotelName = hotelName;
		this.regularCustomerWeekendRate = regularCustomerWeekendRate;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getRegularCustomerWeekendRate() {
		return regularCustomerWeekendRate;
	}

	public void setRegularCustomerWeekendRate(int regularCustomerWeekendRate) {
		this.regularCustomerWeekendRate = regularCustomerWeekendRate;
	}

}
