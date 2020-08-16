package com.project.cabTrip.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Table(name = "user")
@Entity
@IdClass(CompositeCabId.class)
public class Cab {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	String medallion;
	
	@Column
	String hack_license;
	
	@Column
	String vendor_id;
	
	@Column
	String rate_code;
	
	@Column
	String store_and_fwd_flag;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	LocalDate pickup_datetime;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	LocalDate dropoff_datetime;
	
	@Column
	int passenger_count;
	
	@Column
	int trip_time_in_secs;
	
	@Column
	int trip_distance;	

	public Cab() {
	}

	public Cab(String medallion, String hack_license, String vendor_id, String rate_code, String store_and_fwd_flag,
			LocalDate pickup_datetime, LocalDate dropoff_datetime, int passenger_count, int trip_time_in_secs,
			int trip_distance) {
		super();
		this.medallion = medallion;
		this.hack_license = hack_license;
		this.vendor_id = vendor_id;
		this.rate_code = rate_code;
		this.store_and_fwd_flag = store_and_fwd_flag;
		this.pickup_datetime = pickup_datetime;
		this.dropoff_datetime = dropoff_datetime;
		this.passenger_count = passenger_count;
		this.trip_time_in_secs = trip_time_in_secs;
		this.trip_distance = trip_distance;
	}

	public String getMedallion() {
		return medallion;
	}

	public void setMedallion(String medallion) {
		this.medallion = medallion;
	}

	public String getHack_license() {
		return hack_license;
	}

	public void setHack_license(String hack_license) {
		this.hack_license = hack_license;
	}

	public String getVendor_id() {
		return vendor_id;
	}

	public void setVendor_id(String vendor_id) {
		this.vendor_id = vendor_id;
	}

	public String getRate_code() {
		return rate_code;
	}

	public void setRate_code(String rate_code) {
		this.rate_code = rate_code;
	}

	public String getStore_and_fwd_flag() {
		return store_and_fwd_flag;
	}

	public void setStore_and_fwd_flag(String store_and_fwd_flag) {
		this.store_and_fwd_flag = store_and_fwd_flag;
	}

	public LocalDate getPickup_datetime() {
		return pickup_datetime;
	}

	public void setPickup_datetime(LocalDate pickup_datetime) {
		this.pickup_datetime = pickup_datetime;
	}

	public LocalDate getDropoff_datetime() {
		return dropoff_datetime;
	}

	public void setDropoff_datetime(LocalDate dropoff_datetime) {
		this.dropoff_datetime = dropoff_datetime;
	}

	public int getPassenger_count() {
		return passenger_count;
	}

	public void setPassenger_count(int passenger_count) {
		this.passenger_count = passenger_count;
	}

	public int getTrip_time_in_secs() {
		return trip_time_in_secs;
	}

	public void setTrip_time_in_secs(int trip_time_in_secs) {
		this.trip_time_in_secs = trip_time_in_secs;
	}

	public int getTrip_distance() {
		return trip_distance;
	}

	public void setTrip_distance(int trip_distance) {
		this.trip_distance = trip_distance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dropoff_datetime == null) ? 0 : dropoff_datetime.hashCode());
		result = prime * result + ((hack_license == null) ? 0 : hack_license.hashCode());
		result = prime * result + ((medallion == null) ? 0 : medallion.hashCode());
		result = prime * result + passenger_count;
		result = prime * result + ((pickup_datetime == null) ? 0 : pickup_datetime.hashCode());
		result = prime * result + ((rate_code == null) ? 0 : rate_code.hashCode());
		result = prime * result + ((store_and_fwd_flag == null) ? 0 : store_and_fwd_flag.hashCode());
		result = prime * result + trip_distance;
		result = prime * result + trip_time_in_secs;
		result = prime * result + ((vendor_id == null) ? 0 : vendor_id.hashCode());
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
		Cab other = (Cab) obj;
		if (dropoff_datetime == null) {
			if (other.dropoff_datetime != null)
				return false;
		} else if (!dropoff_datetime.equals(other.dropoff_datetime))
			return false;
		if (hack_license == null) {
			if (other.hack_license != null)
				return false;
		} else if (!hack_license.equals(other.hack_license))
			return false;
		if (medallion == null) {
			if (other.medallion != null)
				return false;
		} else if (!medallion.equals(other.medallion))
			return false;
		if (passenger_count != other.passenger_count)
			return false;
		if (pickup_datetime == null) {
			if (other.pickup_datetime != null)
				return false;
		} else if (!pickup_datetime.equals(other.pickup_datetime))
			return false;
		if (rate_code == null) {
			if (other.rate_code != null)
				return false;
		} else if (!rate_code.equals(other.rate_code))
			return false;
		if (store_and_fwd_flag == null) {
			if (other.store_and_fwd_flag != null)
				return false;
		} else if (!store_and_fwd_flag.equals(other.store_and_fwd_flag))
			return false;
		if (trip_distance != other.trip_distance)
			return false;
		if (trip_time_in_secs != other.trip_time_in_secs)
			return false;
		if (vendor_id == null) {
			if (other.vendor_id != null)
				return false;
		} else if (!vendor_id.equals(other.vendor_id))
			return false;
		return true;
	}
	

}
