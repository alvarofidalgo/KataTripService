package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.CollaboratorCallException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.Test;

public class TripServiceWithOutAlternativesWrapperTest {



    @Test(expected = CollaboratorCallException.class)
    public void whenCallGetTripByUserAlwaysThrowException(){
        User user = new User();
        new TripService().getTripsByUser(user);
    }
}
