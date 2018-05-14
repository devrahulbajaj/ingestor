package com.example.ingestor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ingestor.model.Schedule;
import com.example.ingestor.repo.ScheduleRepository;

@Service
public class IngestorServiceImpl {

@Autowired
ScheduleRepository repo;

	public void writeEqInfoData(Schedule schedule) {
		repo.save(schedule);
	}
}
