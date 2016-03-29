package edu.sjsu.cmpe275.DAO;

import edu.sjsu.cmpe275.model.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by qi on 3/27/16.
 */

@Repository
@Transactional
public class ProfileDAOImpl implements ProfileDAO {

    //An EntityManager will be automatically injected from EntityManagerFactory setup on
    //mvc-dispatcher-servlet.xml
    @PersistenceContext

    private EntityManager manager;
    //EntityTransaction transaction = manager.getTransaction();


    //Since we've setup <tx:annotation-config> and transaction manager on mvc-dispatcher-servlet.xml,
    //any bean method annotated with @Transactional will cause Spring to magically call
    // begin() and commit() at the start/end of the method. If exception occurs it will also
    //call rollback()
    public List<Profile> getAllProfiles(){

        try{
            List<Profile> profiles = manager.createQuery("Select a From Profile a", Profile.class).getResultList();
            return profiles;
        } finally {
            manager.close();
        }
    }

    public Profile getProfileById(String Id){
        try {
            return manager.find(Profile.class, Id);
        } finally {
            manager.close();
        }
    }

    public void deleteById(String Id){

        Profile profile = manager.find(Profile.class, Id);
        manager.remove(profile);

        //TODO transaction does not work, need to fix

        /*
        try {
            transaction.begin();
            Profile profile = manager.find(Profile.class, Id);
            manager.remove(profile);
            transaction.commit();
        }catch (RuntimeException e) {
            transaction.rollback();
            throw e;
        } finally {
            manager.close();
        }*/

    }

    public void addProfile(Profile p){

        manager.merge(p);

        //TODO transaction does not work, need to fix
        /*
        try {
            transaction.begin();
            manager.merge(p);
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw e;
        } finally {
            manager.close();
        }*/

    }

}

