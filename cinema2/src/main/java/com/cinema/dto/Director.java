package com.cinema.dto;

import java.util.Objects;

public class Director {
	private int DIR_ID;
	private String DIR_NAME;
	private String DIR_SURNAME;
	
	public Director(int DIR_ID, String DIR_NAME, String DIR_SURNAME) {
		this.DIR_ID = DIR_ID;
		this.DIR_NAME = DIR_NAME;
		this.DIR_SURNAME = DIR_SURNAME;
	}
	
	public Director() {}

	public String getDIR_NAME() {
		return DIR_NAME;
	}

	public void setDIR_NAME(String dIR_NAME) {
		DIR_NAME = dIR_NAME;
	}

	public String getDIR_SURNAME() {
		return DIR_SURNAME;
	}

	public void setDIR_SURNAME(String dIR_SURNAME) {
		DIR_SURNAME = dIR_SURNAME;
	}

	public int getDIR_ID() {
		return DIR_ID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(DIR_ID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Director other = (Director) obj;
		return DIR_ID == other.DIR_ID;
	}

	@Override
	public String toString() {
		return "Director [DIR_ID=" + DIR_ID + ", DIR_NAME=" + DIR_NAME + ", DIR_SURNAME=" + DIR_SURNAME + "]";
	}
	
}
