package edu.sjsu.cmpe275.controller;

/**
 * Created by qi on 3/27/16.
 */


import edu.sjsu.cmpe275.model.Profile;
import edu.sjsu.cmpe275.service.ProfileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

    //Method will be called in initial page load at GET /Profile
    @RequestMapping(value ="/{userId}",method = RequestMethod.GET)
    public String listById (@PathVariable("userId") String Id,  Model model){

        Profile result = manger.getProfileById(Id);

        if(result == null){
            //TODO
        }
        model.addAttribute("profile", result);
        return "listById";
    }



    @RequestMapping(value = "/addPerson", method = RequestMethod.POST )
    public String addProfile(@ModelAttribute Profile profile){
        manger.addProfile(profile);
        return "redirect:/";
    }

}
