package com.example.ingestor.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;


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

	//**************************************************************************************************
    // Instance variables
    //**************************************************************************************************

	@Id
	@NotNull
	private int id;
	
    private Long version;               //TODO: Who uses this?
    private String flightNumber;
//    private final DatePeriod operationalDates;
    private       List<LegInformation> legs;

	//  private       List<DEIInformation> segments;
    private   boolean   hosted;                //NOTE: Schedule-based, not carrier-based

    public Schedule(){}
    
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

    //**************************************************************************************************
    // Output formatters
    //**************************************************************************************************

//    @Override
//    public String toString() {
//
//        StringBuilder result = new StringBuilder().append(String.format("%s %s ", flightDesignator, operationalDates));
//
//        String lastArrivalAirport = null;
//        for (LegInformation leg : legs) {
//
//            if (lastArrivalAirport != null && !lastArrivalAirport.equals(leg.getDepartureCityCode()))
//                result.append("<" + lastArrivalAirport + ">");
//
//            result.append(leg.getDepartureCityCode());
//            switch (leg.getDepartureDateDiscrepancyNumber()) {
//                case 0:
//                    result.append('.');
//                    break;
//                case 1:
//                    result.append('+');
//                    break;
//                case -1:
//                    result.append('-');
//                    break;
//                default:
//                    result.append(leg.getDepartureDateDiscrepancyNumber());
//            }
//
//            lastArrivalAirport = leg.getArrivalCityCode();
//        }
//
//        result.append(lastArrivalAirport);
//        return result.toString();
//    }

    //**************************************************************************************************
    // Principal methods
    //**************************************************************************************************

    /**
     * Return the leg with given city pair.
     * @param boardPoint
     * @param offPoint
     * @return the matching LegInformation, or null
     */
//    public LegInformation findLeg(String boardPoint, String offPoint)
//    {
//        for (LegInformation leg : legs)
//        {
//            if (!leg.getDepartureCityCode().equals(boardPoint)) continue;
//            if (!leg.getArrivalCityCode().equals(offPoint)) continue;
//            return leg;
//        }
//
//        return null;
//    }
//
//    /**
//     * Return the leg with given boardPoint.
//     * @param boardPoint
//     * @return the matching LegInformation, or null
//     */
//    public LegInformation findLeg(String boardPoint)
//    {
//        for (LegInformation leg : legs)
//        {
//            if (!leg.getDepartureCityCode().equals(boardPoint)) continue;
//            return leg;
//        }
//
//        return null;
//    }
   }
