package org.craftedsw.tripservicekata.wrappers;


import org.craftedsw.tripservicekata.trip.Trip;
import org.craftedsw.tripservicekata.user.User;

import java.util.List;

public interface TripDaoWrapper {

    List<Trip> findTripsByUser(User user);
}
