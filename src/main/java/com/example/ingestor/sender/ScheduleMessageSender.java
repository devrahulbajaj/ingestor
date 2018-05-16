package com.example.ingestor.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.protobuf.schedule.ScheduleProto;;

@Component
public class ScheduleMessageSender {

	@Autowired
	private KafkaTemplate<String, ScheduleProto.Schedule> scheduleMesssageKafkaTemplate;

	@Value(value = "${message.topic.name}")
	private String topicName;

	public void sendToKafka(ScheduleProto.Schedule schedule) {		
		scheduleMesssageKafkaTemplate.send(topicName,schedule);

	}

}
