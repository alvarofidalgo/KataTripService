package org.craftedsw.tripservicekata.conf;


import org.craftedsw.tripservicekata.wrappers.ErrorTripDao;
import org.craftedsw.tripservicekata.wrappers.ErrorUserSession;
import org.craftedsw.tripservicekata.wrappers.TripDaoWrapper;
import org.craftedsw.tripservicekata.wrappers.UserSessionWrapper;

public class WrappersConfiguration {

    public static UserSessionWrapper userSessionWrapper = new ErrorUserSession();
    public static TripDaoWrapper tripDaoWrapper = new ErrorTripDao();

}
