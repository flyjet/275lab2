package edu.sjsu.cmpe275.controller;

/**
 * Created by qi on 3/27/16.
 */


import edu.sjsu.cmpe275.model.Profile;
import edu.sjsu.cmpe275.service.ProfileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping("/")
public class IndexController{
    @Autowired
    private ProfileManager manger;

    @RequestMapping(method = RequestMethod.GET)
    public String listAll (Model model){

        List<Profile> resultSet = manger.getAllProfiles();

        for( Profile p: resultSet){
            System.out.println("--- Profile--");
            System.out.println( "Id  " + p.getId() + "  Name " + p.getFirstname());
        }

        model.addAttribute("profiles", resultSet);


        return "index";
    }
}
