package com.bridgelabz.workshop2.hotelreservationsystem;

public class Hotel {

	private String hotelName;
	private int regularCustomerWeekendRate;
	private int regularCustomerWeekDaysRate;
	private int ratingOfHotel;
	private int rewardedCustomerWeekendRate;
	private int rewardedCustomerWeekDaysRate;

	public int getRatingOfHotel() {
		return ratingOfHotel;
	}

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

	public Hotel(String hotelName, int regularCustomerWeekendRate, int regularCustomerWeekDaysRate, int ratingOfHotel) {
		super();
		this.hotelName = hotelName;
		this.regularCustomerWeekendRate = regularCustomerWeekendRate;
		this.regularCustomerWeekDaysRate = regularCustomerWeekDaysRate;
		this.ratingOfHotel = ratingOfHotel;
	}

	public Hotel(String hotelName, int regularCustomerWeekendRate, int regularCustomerWeekDaysRate, int ratingOfHotel,
			int rewardedCustomerWeekendRate, int rewardedCustomerWeekDaysRate) {
		super();
		this.hotelName = hotelName;
		this.regularCustomerWeekendRate = regularCustomerWeekendRate;
		this.regularCustomerWeekDaysRate = regularCustomerWeekDaysRate;
		this.ratingOfHotel = ratingOfHotel;
		this.rewardedCustomerWeekendRate = rewardedCustomerWeekendRate;
		this.rewardedCustomerWeekDaysRate = rewardedCustomerWeekDaysRate;
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

	public void setRatingOfHotel(int ratingOfHotel) {
		this.ratingOfHotel = ratingOfHotel;
	}

	public int getRewardedCustomerWeekendRate() {
		return rewardedCustomerWeekendRate;
	}

	public void setRewardedCustomerWeekendRate(int rewardedCustomerWeekendRate) {
		this.rewardedCustomerWeekendRate = rewardedCustomerWeekendRate;
	}

	public int getRewardedCustomerWeekDaysRate() {
		return rewardedCustomerWeekDaysRate;
	}

	public void setRewardedCustomerWeekDaysRate(int rewardedCustomerWeekDaysRate) {
		this.rewardedCustomerWeekDaysRate = rewardedCustomerWeekDaysRate;
	}

}
