package com.example.ingestor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ingestor.model.Schedule;
import com.example.ingestor.sender.ScheduleMessageSender;
import com.example.ingestor.service.IngestorServiceImpl;

@RestController
public class SSMIngestor {

@Autowired
IngestorServiceImpl service;

@Autowired
ScheduleMessageSender sender;
//	@RequestMapping("/ingestEqInfot", , method = RequestMethod.POST)
//	public void produceMessage() throws InterruptedException {
//
//		System.out.println("In Controller");
//		kafkaProduce.produceScheduleEvent("Hello Sabre");
//
//		new KafkaMsgConsumeImpl().latch.await(10, TimeUnit.SECONDS);
//
//	}

	@RequestMapping(value = "/ingestEqInfo", method = RequestMethod.POST)
	public String saveAndSendScheduleMessage(@RequestBody Schedule schedule) {

		System.out.println("Flight Number is " + schedule.getFlightNumber());
		service.writeEqInfoData(schedule);
		sender.produceScheduleMessage(schedule);
		return "Successfully written";
	}
}
