package com.bridgelabz.workshop2.hotelreservationsystemtest;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.workshop2.hotelreservationsystem.HotelReservation;

public class HotelReservationTest {

	@Test
	public void whenNewHotelAdded_shouldReturnTrue() {

		HotelReservation hotelReservationObject = new HotelReservation();
		Assert.assertTrue(hotelReservationObject.addHotel("Lakewood", 110));
		Assert.assertTrue(hotelReservationObject.addHotel("Bridgewood", 160));
		Assert.assertTrue(hotelReservationObject.addHotel("Ridgewood", 220));

	}

	@Test
	public void whenFindCheapestHotelMethodCalled_shouldReturn_nameOfHotel() {
		HotelReservation hotelReservation = new HotelReservation();
		Assert.assertTrue(hotelReservation.addHotel("Lakewood", 110));
		Assert.assertTrue(hotelReservation.addHotel("Bridgewood", 160));
		Assert.assertTrue(hotelReservation.addHotel("Ridgewood", 220));
		Assert.assertEquals("Lakewood", hotelReservation.findCheapestHotel("10Sep2020", "11Sep2020"));
	}
}
