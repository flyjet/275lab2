package edu.sjsu.cmpe275.service;

import edu.sjsu.cmpe275.DAO.ProfileDAO;
import edu.sjsu.cmpe275.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by qi on 3/27/16.
 */

@Service
public class ProfileManagerImpl implements ProfileManager {

    @Autowired
    ProfileDAO dao;

    public List<Profile> getAllProfiles(){

        List<Profile> resultSet = dao.getAllProfiles();
        return resultSet;
    }
}
