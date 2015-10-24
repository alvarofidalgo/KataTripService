package org.craftedsw.tripservicekata.trip;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TripServiceWithAlternativeSessionWrappersTest.class,
        TripServiceWithAlternativeTripDao.class,
        TripServiceWithOutAlternativesWrapperTest.class
})
public class TripServiceTest {
}
