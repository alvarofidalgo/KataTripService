package org.craftedsw.tripservicekata.trip;


import org.craftedsw.tripservicekata.WrapperDoubles.ConfiguredSessionWrapperSelector;
import org.craftedsw.tripservicekata.conf.WrappersConfiguration;
import org.craftedsw.tripservicekata.exception.CollaboratorCallException;
import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TripServiceWithAlternativeSessionWrappersTest {

    private User user;
    private TripService service;
    private ConfiguredSessionWrapperSelector configuredWrapperSelector;

    @Before
    public void setUp(){
        user = new User();
        service = new TripService();
        configuredWrapperSelector = new ConfiguredSessionWrapperSelector();
    }

    @After
    public void tearDown(){
        configuredWrapperSelector.reset();
    }

    @Test (expected = UserNotLoggedInException.class)
    public void whenLoggedUserIsNullReturnException(){
        configuredWrapperSelector.changeConfiguredWrapperWith(ConfiguredSessionWrapperSelector.LOGGED_USER_NULL);
        service.getTripsByUser(user);
    }

    @Test
    public void whenLoggedUserIsNotNullButUserIsNotFriendReturnEmptyList(){
        List<Trip> expected = new ArrayList<Trip>();
        configuredWrapperSelector.changeConfiguredWrapperWith(ConfiguredSessionWrapperSelector.LOGGED_USER_NOT_NULL);
        assertThat(service.getTripsByUser(user), is(expected));
    }

    @Test(expected = CollaboratorCallException.class)
    public void whenLoggedUserIsNotNullAndIsFriendAlwaysThrowException(){
        configuredWrapperSelector.changeConfiguredWrapperWith(ConfiguredSessionWrapperSelector.LOGGED_USER_NOT_NULL);
        user.addFriend( WrappersConfiguration.userSessionWrapper.getLoggedUser());
        service.getTripsByUser(user);
    }
}
