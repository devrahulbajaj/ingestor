package com.example.ingestor.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.example.ingestor.model.Schedule;

@Component
public class ScheduleMessageSender {

//	@Autowired
//	private KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
	private KafkaTemplate<String, Schedule> scheduleMesssageKafkaTemplate;

	@Value(value = "${message.topic.name}")
	private String topicName;

//	public void produceScheduleEvent(String msg) {
//
//		kafkaTemplate.send(topicName, 0, "", msg);
//
//	}

	public void produceScheduleMessage(Schedule schMsg) {

		scheduleMesssageKafkaTemplate.send(topicName, 1, "key-1", schMsg);

	}

}
