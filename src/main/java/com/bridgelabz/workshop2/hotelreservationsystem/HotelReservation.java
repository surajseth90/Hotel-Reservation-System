package com.bridgelabz.workshop2.hotelreservationsystem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Date;
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

	public boolean addHotel(String name, int regularCustomerWeekDaysRate, int regularCustomerWeekEndRate) {
		Hotel hotel = new Hotel(name, regularCustomerWeekDaysRate, regularCustomerWeekEndRate);
		hotelMap.put(name, hotel);
		return true;
	}

	public boolean addHotel(String name, int regularCustomerWeekDaysRate, int regularCustomerWeekEndRate,
			int ratingOfHotel) {
		Hotel hotel = new Hotel(name, regularCustomerWeekDaysRate, regularCustomerWeekEndRate, ratingOfHotel);
		hotelMap.put(name, hotel);
		return true;
	}

	public boolean addHotel(String name, int regularCustomerWeekDaysRate, int regularCustomerWeekEndRate,
			int hotelRating, int rewardedCustomerWeekDaysRate, int rewardedCustomerWeekEndRate) {
		Hotel hotelObject = new Hotel(name, regularCustomerWeekDaysRate, regularCustomerWeekEndRate, hotelRating,
				rewardedCustomerWeekDaysRate, rewardedCustomerWeekEndRate);
		hotelMap.put(name, hotelObject);
		return true;
	}

	public boolean findCheapestHotel(String fromDate, String toDate) {
		Map<Integer, ArrayList<Hotel>> rateMap = createRateMap(fromDate, toDate);
		int minimumRate = Integer.MAX_VALUE;
		for (Map.Entry<Integer, ArrayList<Hotel>> entry : rateMap.entrySet()) {
			if (entry.getKey() < minimumRate)
				minimumRate = entry.getKey();
		}
		System.out.println("Cheapest Hotel for you is: ");
		for (Hotel hotel : rateMap.get(minimumRate)) {
			System.out.print(hotel.getHotelName() + "  ");
		}
		System.out.println("\nTotal Rent : " + minimumRate);
		return true;
	}

	public boolean cheapestBestRatedHotel(String fromDate, String toDate) {
		Map<Integer, ArrayList<Hotel>> rentMap = createRateMap(fromDate, toDate);
		int minimumRent = Integer.MAX_VALUE;
		for (Map.Entry<Integer, ArrayList<Hotel>> entry : rentMap.entrySet()) {
			if (entry.getKey() < minimumRent)
				minimumRent = entry.getKey();
		}
		ArrayList<Hotel> cheapestHotels = rentMap.get(minimumRent);
		String bestRatedCheapestHotel = "";
		int rating = 0;
		for (Hotel hotel : cheapestHotels) {
			if (hotel.getRatingOfHotel() > rating) {
				bestRatedCheapestHotel = hotel.getHotelName();
				rating = hotel.getRatingOfHotel();
			}
		}
		System.out.println("Cheapest Hotel is " + bestRatedCheapestHotel + " with Rating " + rating + " Total Rent : "
				+ minimumRent + "\n");
		return true;
	}

	public boolean findBestRatedHotelForGivenDates(String fromDate, String toDate) {
		int rating = 0;
		int rate = 0;
		String bestRatedHotel = "";
		for (Map.Entry<String, Hotel> entry : hotelMap.entrySet()) {
			if (entry.getValue().getRatingOfHotel() > rating) {
				rating = entry.getValue().getRatingOfHotel();
				bestRatedHotel = entry.getKey();
				rate = calculateRent(fromDate, toDate, entry.getValue().getRegularCustomerWeekDaysRate(),
						entry.getValue().getRegularCustomerWeekEndRate());
			}
		}
		System.out.println("Best Rated Hotel : " + bestRatedHotel + ", Rent : " + rate);
		return true;
	}

	public static int calculateRent(String fromDate, String toDate, int weekDayRate, int weekEndRate) {
		int[] numOfDays = numberOfDays(fromDate, toDate);
		int weekDayRent = weekDayRate * numOfDays[0];
		int weekEndRent = weekEndRate * numOfDays[1];
		int totalRent = weekDayRent + weekEndRent;
		return totalRent;
	}

	public static Map<Integer, ArrayList<Hotel>> createRateMap(String fromDate, String toDate) {
		HashMap<Integer, ArrayList<Hotel>> rateMap = new HashMap<>();
		int days[] = numberOfDays(fromDate, toDate);

		for (Map.Entry<String, Hotel> entry : hotelMap.entrySet()) {
			int weekDaysRate = entry.getValue().getRegularCustomerWeekDaysRate() * days[0];
			int weekEndDaysRate = entry.getValue().getRegularCustomerWeekEndRate() * days[1];
			int finalRate = weekDaysRate + weekEndDaysRate;
			rateMap.computeIfAbsent(finalRate, k -> new ArrayList<>()).add(entry.getValue());
		}
		return rateMap;
	}

	public static int[] numberOfDays(String startDate, String endDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyy");
		LocalDate from = LocalDate.parse(startDate, formatter);
		LocalDate to = LocalDate.parse(endDate, formatter);
		int numOfWeekDays = 0;
		int numOfWeekEndDays = 0;
		for (LocalDate date = from; date.isBefore(to); date = date.plusDays(1)) {
			if (isWeekend(date))
				numOfWeekDays++;
			else
				numOfWeekEndDays++;
		}
		int days[] = new int[2];
		days[0] = numOfWeekDays;
		days[1] = numOfWeekEndDays;
		return days;
	}

	public static boolean isWeekend(LocalDate date) {
		DayOfWeek day1_OfWeek = DayOfWeek.of(((TemporalAccessor) date).get(ChronoField.DAY_OF_WEEK));
		switch (day1_OfWeek) {
		case SATURDAY:
		case SUNDAY:
			return true;
		default:
			return false;
		}
	}

	public void printHotels() {
		for (Map.Entry<String, Hotel> entry : hotelMap.entrySet()) {
			System.out.println("Hotel Name : " + entry.getKey());
			System.out.println(
					"Rate on Weekdays for Regular Customers : " + entry.getValue().getRegularCustomerWeekDaysRate());
			System.out.println(
					"Rate on Weekends for Regular Customers : " + entry.getValue().getRegularCustomerWeekEndRate());
			System.out.println("Rating of Hotel : " + entry.getValue().getRatingOfHotel());
			System.out.println(
					"Rate on weekdays for reward customers : " + entry.getValue().getRewardedCustomerWeekDaysRate());
			System.out.println(
					"Rate on weekend days for reward customers : " + entry.getValue().getRewardedCustomerWeekendRate());

			System.out.println();
		}

	}

	public static void main(String[] args) {
	}
}
