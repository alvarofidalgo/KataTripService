package org.craftedsw.tripservicekata.wrappers;


import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;


public class ErrorUserSession implements UserSessionWrapper {


    public User getLoggedUser() {
        return UserSession.getInstance().getLoggedUser();
    }
}
