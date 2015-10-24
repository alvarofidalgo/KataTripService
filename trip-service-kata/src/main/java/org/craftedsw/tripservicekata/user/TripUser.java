package org.craftedsw.tripservicekata.user;


import org.craftedsw.tripservicekata.conf.WrappersConfiguration;
import org.craftedsw.tripservicekata.trip.Trip;

import java.util.ArrayList;
import java.util.List;

public class TripUser {

    private User user;
    private boolean isFriend = false;

    public TripUser(User user){
        this.user = user;
    }

    public void setIfIsFriendOf(User loggedUser){
        List<User> friends = user.getFriends();
        for (int index=0;index<friends.size() && !isFriend;index++){
            User friend = friends.get(index);
            isFriend =  friend.equals(loggedUser);
        }
    }

    public  List<Trip> tripList(){
        List<Trip> tripList = new ArrayList<Trip>();
        if (isFriend) {
            tripList = new ArrayList<Trip>(WrappersConfiguration.tripDaoWrapper.findTripsByUser(user));
        }
        return tripList;
    }
}
