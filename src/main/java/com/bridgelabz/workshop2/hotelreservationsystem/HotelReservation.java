package com.bridgelabz.workshop2.hotelreservationsystem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;

public class HotelReservation {
	private static Map<String, Hotel> hotelMap;

	public HotelReservation() {
		this.hotelMap = new HashMap<>();
	}

	public boolean addHotel(String name, int regularCustomerWeekendRate) {
		Hotel hotel = new Hotel(name, regularCustomerWeekendRate);
		hotelMap.put(name, hotel);
		return true;
	}

	public String findCheapestHotel(String fromDate, String toDate) {
		Map<Integer, ArrayList<Hotel>> rateMap = createRateMap(fromDate, toDate);
		int minimumRate = Integer.MAX_VALUE;
		for (Map.Entry<Integer, ArrayList<Hotel>> entry : rateMap.entrySet()) {
			if (entry.getKey() < minimumRate)
				minimumRate = entry.getKey();
		}

		System.out.println(rateMap.get(minimumRate).get(0).getHotelName());
		System.out.println("Total Rate : " + minimumRate);
		return rateMap.get(minimumRate).get(0).getHotelName();
	}

	public static Map<Integer, ArrayList<Hotel>> createRateMap(String fromDate, String toDate) {
		HashMap<Integer, ArrayList<Hotel>> rateMap = new HashMap<>();
		int numOfDays = numberOfDays(fromDate, toDate);
		for (Map.Entry<String, Hotel> entry : hotelMap.entrySet()) {
			int rent = entry.getValue().getRegularCustomerWeekendRate() * numOfDays;
			rateMap.computeIfAbsent(rent, k -> new ArrayList<>()).add(entry.getValue());
		}
		return rateMap;
	}

	public static int numberOfDays(String startDate, String endDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyy");
		LocalDate from = LocalDate.parse(startDate, formatter);
		LocalDate to = LocalDate.parse(endDate, formatter);
		int numOfDays = 0;
		for (LocalDate date = from; date.isBefore(to); date = date.plusDays(1)) {
			numOfDays++;
		}

		return numOfDays;
	}

	public static boolean isWeekend(String startDate, int numOfDays) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyy");
		LocalDate from = LocalDate.parse(startDate, formatter);
		DayOfWeek day1_OfWeek = DayOfWeek.of(from.get(ChronoField.DAY_OF_WEEK));
		switch (day1_OfWeek) {
		case SATURDAY:
		case SUNDAY:
			return true;
		default:
			return false;

		}
	}
}
