package org.craftedsw.tripservicekata.trip;


import org.craftedsw.tripservicekata.WrapperDoubles.ConfiguredSessionWrapperSelector;
import org.craftedsw.tripservicekata.WrapperDoubles.TripDaoWithResults;
import org.craftedsw.tripservicekata.conf.WrappersConfiguration;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.wrappers.TripDaoWrapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class TripServiceWithAlternativeTripDao {

    private User user;
    private TripService service;
    private ConfiguredSessionWrapperSelector configuredWrapperSelector;
    private TripDaoWrapper configuredDaoWrapper = WrappersConfiguration.tripDaoWrapper;

    @Before
    public void setUp(){
        user = new User();
        service = new TripService();
        configuredWrapperSelector = new ConfiguredSessionWrapperSelector();
    }

    @After
    public void tearDown(){
        configuredWrapperSelector.reset();
        WrappersConfiguration.tripDaoWrapper = configuredDaoWrapper;
    }

    @Test
    public void whenLoggedUserIsNotNullAndIsFriendAndDaoIsCorrectReturnDaoResult(){
        configuredWrapperSelector.changeConfiguredWrapperWith(ConfiguredSessionWrapperSelector.LOGGED_USER_NOT_NULL);
        WrappersConfiguration.tripDaoWrapper  = new TripDaoWithResults();
        user.addFriend(WrappersConfiguration.userSessionWrapper.getLoggedUser());
        assertThat(service.getTripsByUser(user).size(), is(WrappersConfiguration.tripDaoWrapper.findTripsByUser(user).size()));
        assertThat(service.getTripsByUser(user).get(0),is(WrappersConfiguration.tripDaoWrapper.findTripsByUser(user).get(0)));
    }
}
