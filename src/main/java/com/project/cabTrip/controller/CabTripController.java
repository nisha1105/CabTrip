package com.project.cabTrip.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.cabTrip.dto.Cab;
import com.project.cabTrip.service.CabService;

@RestController
@RequestMapping(path = "/cabTrip")
public class CabTripController {

	@Autowired
	private CabService cabservice;

	@Autowired
	private CacheManager cacheManager;

	@RequestMapping(path = "/noOfTrips", produces = "application/json")
	@Cacheable(cacheNames = "cablist", condition = "!#noCache")
	public ArrayList<Cab> noOfTrips(@RequestParam(name = "medallion") String medallion,
			@RequestParam(required = false) boolean noCache) {
		return (ArrayList<Cab>) cabservice.findByMedallion(medallion);
	}

	@RequestMapping(path = "/noOfTripsofCab", produces = "application/json")
	@Cacheable(cacheNames = "cablistperDate", condition = "!#noCache")
	public ArrayList<Cab> noOfTripsofCab(@RequestParam(name = "medallion") String medallion,
			@RequestParam(name = "date") String date, @RequestParam(required = false) boolean noCache) {
		return (ArrayList<Cab>) cabservice.getAllCabsForDate(medallion, date);
	}

	@RequestMapping(path = "/clearCache")
	public void clearCache() {
		cacheManager.getCacheNames().stream().map(cacheManager::getCache).forEach(Cache::clear);
	}

}
