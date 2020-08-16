package com.project.cabTrip.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.cabTrip.dto.Cab;

@SpringBootTest()
@WebAppConfiguration
public class CabTripControllerTest {

	private MockMvc mvc;
	@Autowired
	WebApplicationContext webApplicationContext;

	@Autowired
	private CacheManager cacheManager;
	
	@Autowired
	private CabTripController cabcontroller;

	private <T> T mapFromJson(String json, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, clazz);
	}

	@Test
	public void getNoOfTripsList() throws Exception {
		String uri = "http://localhost:8080/cabTrip/noOfTrips?medallion=5455D5FF2BD94D10B304A15D4B7F2735";
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		List<Cab> cabList = mapFromJson(content, List.class);
		assertThat(cabList.size() > 0);
	}

	@Test
	public void getNoOfTripsofCabList() throws Exception {
		String uri = "http://localhost:8080/cabTrip/noOfTripsofCab?medallion=D7D598CD99978BD012A87A76A7C891B7&date=2013-12-01";
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		List<Cab> cabList = mapFromJson(content, List.class);
		assertThat(cabList.size() > 0);
	}

	@Test
	void cacheClearTest() throws Exception {
		String uri = "http://localhost:8080/cabTrip/noOfTripsofCab?medallion=D7D598CD99978BD012A87A76A7C891B7&date=2013-12-01";
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		assertThat(cacheManager.getCacheNames().size() == 1);
		uri = "http://localhost:8080/cabTrip/noOfTrips?medallion=5455D5FF2BD94D10B304A15D4B7F2735";
		mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		assertThat(cacheManager.getCacheNames().size() == 2);
		cabcontroller.clearCache();
		assertThat(cacheManager.getCacheNames().size() == 0);
	}

}
