package org.craftedsw.tripservicekata.WrapperDoubles;


import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.wrappers.UserSessionWrapper;

public class UserSessionDouble implements UserSessionWrapper {


    private User user;

    public UserSessionDouble(User user){
      this.user =   user;
    }

    public User getLoggedUser() {
        return user;
    }
}
