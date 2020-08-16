package com.project.cabTrip.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.cabTrip.dto.Cab;

@SpringBootTest()
public class CabServiceTest {

	@Autowired
	CabService cabService;

	@Test
	public void findByMedallionTest() {
		List<Cab> cabList = cabService.findByMedallion("5455D5FF2BD94D10B304A15D4B7F2735");
		assertThat(cabList.size() > 0);
		Cab cab = cabList.get(0);
		validateCabDto(cab);
		assertThat(cabList.contains(cab));
	}

	@Test
	public void getAllCabsForDateTest() {
		List<Cab> cabList = cabService.getAllCabsForDate("5455D5FF2BD94D10B304A15D4B7F2735", "2013-12-01");
		assertThat(cabList.size() > 0);
		Cab cab = cabList.get(0);
		validateCabDto(cab);
		assertThat(cabList.contains(cab));
	}

	public void validateCabDto(Cab cab) {
		assertThat(cab.getMedallion().equals("D7D598CD99978BD012A87A76A7C891B7"));
		assertThat(cab.getHack_license().equals("82F90D5EFE52FDFD2FDEC3EAD6D5771D"));
		assertThat(cab.getVendor_id().equals("VTS"));
		assertThat(cab.getRate_code().equals("1"));
		assertThat(cab.getStore_and_fwd_flag().equals(""));
		assertThat(cab.getPickup_datetime().compareTo(LocalDate.parse("2013-12-01")));
		assertThat(cab.getDropoff_datetime().compareTo(LocalDate.parse("2013-12-01")));
		assertThat(cab.getPassenger_count() == 1);
		assertThat(cab.getTrip_time_in_secs() == 1080);
		assertThat(cab.getTrip_distance() == 4);
	}
}
