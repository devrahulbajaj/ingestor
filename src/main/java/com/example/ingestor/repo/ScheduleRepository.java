package com.example.ingestor.repo;
 
import java.util.List;

import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

import com.example.ingestor.model.Schedule;;
 
@ViewIndexed(designDoc = "schedule")
public interface ScheduleRepository extends CouchbaseRepository<Schedule, String> {
	
	List<Schedule> findByflightNumber(String number);
}