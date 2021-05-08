package com.bridgelabz.workshop2.hotelreservationsystem;

public class Rate {
	private int weekDaysRate;
	private int weekEndDaysRate;

	public Rate(int weekDaysRate, int weekEndDaysRate) {

		this.weekDaysRate = weekDaysRate;
		this.weekEndDaysRate = weekEndDaysRate;
	}

	public int getWeekDaysRate() {
		return weekDaysRate;
	}

	public void setWeekDaysRate(int weekDaysRate) {
		this.weekDaysRate = weekDaysRate;
	}

	public int getWeekEndDaysRate() {
		return weekEndDaysRate;
	}

	public void setWeekEndDaysRate(int weekEndDaysRate) {
		this.weekEndDaysRate = weekEndDaysRate;
	}

}
