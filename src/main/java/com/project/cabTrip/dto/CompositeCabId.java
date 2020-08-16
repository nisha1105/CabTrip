package com.project.cabTrip.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CompositeCabId implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	String medallion;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	LocalDate pickup_datetime;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	LocalDate dropoff_datetime;

	public CompositeCabId() {
	}

	public CompositeCabId(String medallion, LocalDate pickup_datetime, LocalDate dropoff_datetime) {
		super();
		this.medallion = medallion;
		this.pickup_datetime = pickup_datetime;
		this.dropoff_datetime = dropoff_datetime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dropoff_datetime == null) ? 0 : dropoff_datetime.hashCode());
		result = prime * result + ((medallion == null) ? 0 : medallion.hashCode());
		result = prime * result + ((pickup_datetime == null) ? 0 : pickup_datetime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompositeCabId other = (CompositeCabId) obj;
		if (dropoff_datetime == null) {
			if (other.dropoff_datetime != null)
				return false;
		} else if (!dropoff_datetime.equals(other.dropoff_datetime))
			return false;
		if (medallion == null) {
			if (other.medallion != null)
				return false;
		} else if (!medallion.equals(other.medallion))
			return false;
		if (pickup_datetime == null) {
			if (other.pickup_datetime != null)
				return false;
		} else if (!pickup_datetime.equals(other.pickup_datetime))
			return false;
		return true;
	}

}
