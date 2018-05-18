package com.example.ingestor.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import com.couchbase.client.java.repository.annotation.Field;


/**
 * Objects of this class represents Schedules. The main objective of this class have actual schedules data.
 *
 */
@Document
public class Schedule implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8737622339112459927L;

	@Id
	@Field
	private int id;
	
	@Field
    private Long version;

	@Field
	private String flightNumber;
	
	@Field
	private       List<LegInformation> legs;

    private   boolean   hosted;                //NOTE: Schedule-based, not carrier-based

    public Schedule(){}
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
    public long getVersion() {
        return version == null ? -1 : version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }

    //**************************************************************************************************
    // Getters and Setters
    //**************************************************************************************************

    public String getFlightNumber() {
        return flightNumber;
    }
    
    public List<LegInformation> getLegs() {
        return Collections.unmodifiableList(this.legs);
    }

    public void setLegs(List<LegInformation> legs) {
		this.legs = Collections.unmodifiableList(legs);
	}
    
    public boolean isHosted()
    {
        return hosted;
    }

    /**
     * Return the leg with given city pair.
     * @param boardPoint
     * @param offPoint
     * @return the matching LegInformation, or null
     */
   }
