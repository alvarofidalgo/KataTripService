package org.craftedsw.tripservicekata.conf;


import org.craftedsw.tripservicekata.wrappers.ErrorUserSession;
import org.craftedsw.tripservicekata.wrappers.UserSessionWrapper;

public class WrappersConfiguration {

    public static UserSessionWrapper wrapper = new ErrorUserSession();
}
