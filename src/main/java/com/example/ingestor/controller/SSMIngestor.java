package com.example.ingestor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ingestor.model.Schedule;
import com.example.ingestor.service.IngestorServiceImpl;

@RestController
public class SSMIngestor {

@Autowired
IngestorServiceImpl service;


	@RequestMapping(value = "/getScheduleInfo", method = RequestMethod.GET)
	@ResponseBody
	public Schedule getSchedule(@RequestParam(value="flightNumber")String flightNumber) throws InterruptedException {

		return service.readScheduleObject(flightNumber);
	}

	@RequestMapping(value = "/ingestScheduleInfo", method = RequestMethod.POST)
	public String saveAndSendScheduleMessage(@RequestBody Schedule schedule) {

		System.out.println("Flight Number is " + schedule.getFlightNumber());
		
		
		service.writeScheduleInfoData(schedule);
		service.produceScheduleMessage(schedule);
		return "Successfully written";
	}
}
