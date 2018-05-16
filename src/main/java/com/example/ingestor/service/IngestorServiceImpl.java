package com.example.ingestor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ingestor.model.EquipmentInformation;
import com.example.ingestor.model.LegInformation;
import com.example.ingestor.model.Schedule;
import com.example.ingestor.repo.ScheduleRepository;
import com.example.ingestor.sender.ScheduleMessageSender;
import com.protobuf.schedule.ScheduleProto;

@Service
public class IngestorServiceImpl {

@Autowired
ScheduleRepository repo;

@Autowired
ScheduleMessageSender sender;

	public void writeScheduleInfoData(Schedule schedule) {
		repo.save(schedule);
	}
	
	public Schedule readScheduleObject(String flightNumber){
		List<Schedule> schedule = repo.findByflightNumber(flightNumber);
		return schedule.get(0);
	}
	
public void produceScheduleMessage(Schedule schedule) {
		
		LegInformation legs = schedule.getLegs().get(0);
		EquipmentInformation equipment = legs.getEquipmentInformation();
		
		ScheduleProto.EquipmentInformation eqInfo = ScheduleProto.EquipmentInformation.newBuilder().setBookingDesignatorText(equipment.getBookingDesignatorText())
				.setEquipmentCode(equipment.getEquipmentCode()).setEquipmentTypeCode(String.valueOf(equipment.getEquipmentTypeCode()))
				.build();
		
		ScheduleProto.LegInformation legInfo = ScheduleProto.LegInformation.newBuilder().setArrivalCityCode(legs.getArrivalCityCode()).setDepartureCityCode(legs.getDepartureCityCode())
				.setDepartureTerminalCode(legs.getDepartureTerminalCode()).setDepartureDateDiscrepancyNumber(legs.getDepartureDateDiscrepancyNumber())
				.setArrivalTerminalCode(legs.getArrivalTerminalCode()).setArrivalDateAdjustmentNumber(legs.getArrivalDateAdjustmentNumber())
				.setOrder(legs.getOrder()).setEquipmentInformation(eqInfo).build(); 
		
		ScheduleProto.Schedule scheduleProto = ScheduleProto.Schedule.newBuilder().setFlightNumber(schedule.getFlightNumber()).setHosted(schedule.isHosted())
		.setVersion(schedule.getVersion()).addLegs(legInfo).build();
		
		sender.sendToKafka(scheduleProto);
	}
}
