package edu.sjsu.cmpe275.controller;

/**
 * Created by qi on 3/27/16.
 */


import edu.sjsu.cmpe275.model.Profile;
import edu.sjsu.cmpe275.service.ProfileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/*

@Controller
public class IndexController {
    @RequestMapping(value = "/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("/index");

        String msg = "Running IndexController.index() method";

        mav.addObject("msg", msg);
        return mav;
    }
} */

@Controller
@RequestMapping("/Profile")
public class ProfileController {
    @Autowired
    private ProfileManager manger;

    //Method will be called in initial page load at GET /Profile
    @RequestMapping(method = RequestMethod.GET)
    public String listAll (Model model){

        List<Profile> resultSet = manger.getAllProfiles();
        /*
        for( Profile p: resultSet){
            System.out.println("--- Profile--");
            System.out.println( "Id  " + p.getId() + "  Name " + p.getFirstname());
        }*/
        model.addAttribute("profiles", resultSet);
        return "listAll";
    }

    //Method will be called page load at GET /Profile/userId
    @RequestMapping(value ="/{userId}",method = RequestMethod.GET)
    public String listById (@PathVariable("userId") String Id,  Model model){

        Profile result = manger.getProfileById(Id);

        if(result == null){
            //TODO
        }
        model.addAttribute("profile", result);

        return "listById";
    }


    //Method will be called on submitting add profile form POST /Profile
    @RequestMapping(method = RequestMethod.POST )
    public String addProfile(@ModelAttribute("profile") Profile profile,
                             BindingResult result, SessionStatus status){

        //TODO Validation the input data

        if(result.hasErrors()){
            //TODO error message
        }
        manger.addProfile(profile);

        //Mark Session Complete and redirect to URL so that page refresh do not re-submit the form
        status.setComplete();
        return "listById";
    }

    //Method will be called on delete /Profile/UserId
    @RequestMapping(value ="/{userId}", method = RequestMethod.DELETE)
    public String deleteProfile(@PathVariable("userId") String Id){

        //TODO Validation the input data

        manger.deleteById(Id);
        return "listAll";
    }



}
