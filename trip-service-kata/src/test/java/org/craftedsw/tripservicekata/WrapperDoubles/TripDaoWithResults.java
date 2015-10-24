package org.craftedsw.tripservicekata.WrapperDoubles;


import org.craftedsw.tripservicekata.trip.Trip;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.wrappers.TripDaoWrapper;

import java.util.ArrayList;
import java.util.List;

public class TripDaoWithResults implements TripDaoWrapper {


    private List<Trip> trips = new ArrayList<Trip>();


    public TripDaoWithResults(){
        trips.add(new Trip());
    }
    public List<Trip> findTripsByUser(User user) {
        return trips;
    }
}
