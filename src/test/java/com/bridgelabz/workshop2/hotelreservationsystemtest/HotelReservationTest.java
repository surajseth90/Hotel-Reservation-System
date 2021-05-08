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
		hotelReservation.printHotels();
	}

	@Test
	public void whenNewHotelAddedWithWeekend_shouldReturnTrue() {

		HotelReservation hotelReservation = new HotelReservation();
		Assert.assertTrue(hotelReservation.addHotel("Lakewood", 110, 90));
		Assert.assertTrue(hotelReservation.addHotel("Bridgewood", 160, 60));
		Assert.assertTrue(hotelReservation.addHotel("Ridgewood", 110, 150));

		hotelReservation.printHotels();
	}

	@Test
	public void whenFindCheapestHotelIsCalled_shouldReturn_nameOfHotelWithCheapestRent() {
		HotelReservation hotelReservation = new HotelReservation();
		Assert.assertTrue(hotelReservation.addHotel("Lakewood", 110, 90));
		Assert.assertTrue(hotelReservation.addHotel("Bridgewood", 160, 60));
		Assert.assertTrue(hotelReservation.addHotel("Ridgewood", 220, 150));
		Assert.assertEquals("Lakewood", hotelReservation.findCheapestHotel("10Sep2020", "11Sep2020"));
	}

	@Test
	public void whenNewHotelAddedWithRating_shouldReturnTrue() {

		HotelReservation hotelReservation = new HotelReservation();
		Assert.assertTrue(hotelReservation.addHotel("Lakewood", 110, 90, 3));
		Assert.assertTrue(hotelReservation.addHotel("Bridgewood", 160, 60, 4));
		Assert.assertTrue(hotelReservation.addHotel("Ridgewood", 220, 150, 5));

		hotelReservation.printHotels();

	}

	@Test
	public void whenCheapestBestRatedCalled_shouldReturn_bestRatedHotel() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 110, 90, 3);
		hotelReservation.addHotel("Bridgewood", 150, 50, 4);
		hotelReservation.addHotel("Ridgewood", 220, 150, 5);
		Assert.assertTrue(hotelReservation.cheapestBestRatedHotel("11Sep2020", "12Sep2020"));
	}

	@Test
	public void whenFindBestRatedMethodCalled_shouldReturn_bestRatedHotel() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 110, 90, 3);
		hotelReservation.addHotel("Bridgewood", 150, 50, 4);
		hotelReservation.addHotel("Ridgewood", 220, 150, 5);
		Assert.assertTrue(hotelReservation.findBestRatedHotelForGivenDates("11Sep2020", "12Sep2020"));
	}

	@Test
	public void whenAddedRatesForRewardCustomers_shouldAdd_hotelWithAllRates() {
		HotelReservation hotelReservationObject = new HotelReservation();
		hotelReservationObject.addHotel("Lakewood", 110, 90, 3, 80, 80);
		hotelReservationObject.addHotel("Bridgewood", 150, 50, 4, 110, 50);
		hotelReservationObject.addHotel("Ridgewood", 220, 150, 5, 100, 40);
		hotelReservationObject.printHotels();
	}
}
