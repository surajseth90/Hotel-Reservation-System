package com.bridgelabz.workshop2.hotelreservationsystemtest;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bridgelabz.workshop2.hotelreservationsystem.CustomerType;
import com.bridgelabz.workshop2.hotelreservationsystem.Hotel;
import com.bridgelabz.workshop2.hotelreservationsystem.HotelReservation;
import com.bridgelabz.workshop2.hotelreservationsystem.Rate;

public class HotelReservationTest {

	private Hotel lakewood;
	private Hotel bridgewood;
	private Hotel ridgewood;
	HotelReservation hotelReservation = new HotelReservation();

	@Before
	public void setHotel() {

		HashMap<CustomerType, Rate> customerTypeRate = new HashMap<>();

		customerTypeRate.put(CustomerType.regular, new Rate(110, 90));
		customerTypeRate.put(CustomerType.rewarded, new Rate(80, 80));
		lakewood = new Hotel("Lakewood", customerTypeRate);

		customerTypeRate.put(CustomerType.regular, new Rate(160, 40));
		customerTypeRate.put(CustomerType.rewarded, new Rate(110, 50));
		bridgewood = new Hotel("Bridgewood", customerTypeRate);

		customerTypeRate.put(CustomerType.regular, new Rate(220, 150));
		customerTypeRate.put(CustomerType.rewarded, new Rate(100, 40));
		ridgewood = new Hotel("Ridgewood", customerTypeRate);

		hotelReservation.addHotel(lakewood);
		hotelReservation.addHotel(bridgewood);
		hotelReservation.addHotel(ridgewood);

	}

	@Test
	public void givenHotel_WhenAdded_ShouldReturnTrue() {
		Assert.assertTrue(hotelReservation.addHotel(lakewood));
		Assert.assertTrue(hotelReservation.addHotel(bridgewood));
		Assert.assertTrue(hotelReservation.addHotel(ridgewood));
	}
}
