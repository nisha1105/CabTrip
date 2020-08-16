package com.project.cabTrip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.project.cabTrip.dto.Cab;

@Repository
@Service
public class CabService {

	@Autowired
	private JdbcTemplate jtm;

	public List<Cab> getAllCabsForDate(String medallion, String pickup_date) {
		String sql = "SELECT * FROM CAB_TRIP_DATA WHERE medallion = ? AND pickup_dateTime Like ?";
		return jtm.query(sql, new Object[] { medallion, "%" + pickup_date + "%" },
				new BeanPropertyRowMapper<>(Cab.class));
	}

	public List<Cab> findByMedallion(String medallion) {
		String sql = "SELECT * FROM CAB_TRIP_DATA WHERE medallion = ?";
		return jtm.query(sql, new Object[] { medallion }, new BeanPropertyRowMapper<>(Cab.class));
	}

}
