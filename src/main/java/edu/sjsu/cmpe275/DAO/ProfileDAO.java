package edu.sjsu.cmpe275.DAO;

import edu.sjsu.cmpe275.model.Profile;

import java.util.List;

/**
 * Created by qi on 3/27/16.
 */
public interface ProfileDAO {
    List<Profile> getAllProfiles();
    Profile getProfileById(String Id);
    void deleteById(String Id);
    void addProfile(Profile p);

}
