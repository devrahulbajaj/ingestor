package com.example.ingestor.serializer;

import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.protobuf.schedule.ScheduleProto;

public class ScheduleSerializer implements Serializer<ScheduleProto.Schedule>{

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public byte[] serialize(final String topic, final ScheduleProto.Schedule data) {
        return data.toByteArray();
    }

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}


}
