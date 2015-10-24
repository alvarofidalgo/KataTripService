package org.craftedsw.tripservicekata.WrapperDoubles;

import org.craftedsw.tripservicekata.conf.WrappersConfiguration;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.wrappers.UserSessionWrapper;

import java.util.HashMap;
import java.util.Map;

public class ConfiguredSessionWrapperSelector {

    public static final String LOGGED_USER_NULL= "LOGGED_USER_NULL";
    public static final String LOGGED_USER_NOT_NULL = "LOGGED_USER_NOT_NULL";


    private Map<String,UserSessionWrapper> wrappers = new HashMap<String, UserSessionWrapper>();
    private UserSessionWrapper configuredWrapper = WrappersConfiguration.userSessionWrapper;

    public ConfiguredSessionWrapperSelector(){
        wrappers.put(LOGGED_USER_NULL,new UserSessionDouble(null));
        wrappers.put(LOGGED_USER_NOT_NULL,new UserSessionDouble(new User()));
    }

    public void changeConfiguredWrapperWith(String typeUser){
        WrappersConfiguration.userSessionWrapper = wrappers.get(typeUser);
    }

    public void reset(){
        WrappersConfiguration.userSessionWrapper = configuredWrapper;
    }


}
