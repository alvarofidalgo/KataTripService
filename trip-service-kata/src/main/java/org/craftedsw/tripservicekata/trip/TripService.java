package org.craftedsw.tripservicekata.trip;


import java.util.List;

import org.craftedsw.tripservicekata.conf.WrappersConfiguration;
import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.TripUser;
import org.craftedsw.tripservicekata.user.User;

public class TripService {

	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
		TripUser tripUser = new TripUser(user);
		tripUser.setIfIsFriendOf(getLoggedUser());
		return tripUser.tripList();
	}

	private User getLoggedUser(){
		User loggedUser = WrappersConfiguration.userSessionWrapper.getLoggedUser();
		if (loggedUser == null)
			throw new UserNotLoggedInException();
		return loggedUser;
	}
}
