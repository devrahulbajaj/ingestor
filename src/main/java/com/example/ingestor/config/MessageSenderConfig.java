package com.example.ingestor.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.example.ingestor.serializer.ScheduleSerializer;
import com.protobuf.schedule.ScheduleProto;

@Configuration
public class MessageSenderConfig {

	@Value(value = "${kafka.bootstrap-servers}")
	private String bootstrapAddress;

	@Bean
	public ProducerFactory<String, ScheduleProto.Schedule> scheduleMessageProducerFactory() {
		Map<String, Object> configProps = new HashMap<>();
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ScheduleSerializer.class);
		return new DefaultKafkaProducerFactory<>(configProps);
	}

	@Bean
	public KafkaTemplate<String, ScheduleProto.Schedule> scheduleMesssageKafkaTemplate() {
		return new KafkaTemplate<>(scheduleMessageProducerFactory());
	}
	
	public MessageSenderConfig(){
		
	}

}
