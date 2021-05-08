package com.bridgelabz.workshop2.hotelreservationsystem;

import java.util.ArrayList;
import java.util.List;

public class HotelReservation {
	private List<Hotel> hotels;

	public HotelReservation() {
		this.hotels = new ArrayList<>();
	}

	public List<Hotel> getHotel() {
		return hotels;
	}

	public void setHotel(List<Hotel> hotel) {
		this.hotels = hotel;
	}
	
	public boolean addHotel(Hotel hotel) {
		return this.hotels.add(hotel);
		
	}

}
