package edu.sjsu.cmpe275.service;

import edu.sjsu.cmpe275.model.Profile;

import java.util.List;

/**
 * Created by qi on 3/27/16.
 */
public interface ProfileManager {

    List<Profile> getAllProfiles();
    Profile getProfileById(String Id);
    void deleteById(String Id);
    void addProfile(Profile p);
}
