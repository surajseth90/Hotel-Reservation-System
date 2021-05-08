package com.bridgelabz.workshop2.hotelreservationsystem;

import java.util.Map;

public class Hotel {

	private String hotelName;
	private Map<CustomerType, Rate> rate;

	public Hotel(String hotelName, Map<CustomerType, Rate> rate) {
		this.hotelName = hotelName;
		this.rate = rate;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public Map<CustomerType, Rate> getRate() {
		return rate;
	}

	public void setRate(Map<CustomerType, Rate> rate) {
		this.rate = rate;
	}

}
