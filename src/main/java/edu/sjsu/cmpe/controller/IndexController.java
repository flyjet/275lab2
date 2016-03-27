package edu.sjsu.cmpe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by qi on 3/25/16.
 */
@Controller
public class IndexController {

    @RequestMapping("/hello")
    public ModelAndView welcomeMessage(
            @RequestParam(value = "name", required = false) String name) {
        // Name of your jsp file as parameter
        ModelAndView view = new ModelAndView("hello");
        view.addObject("name", name);
        return view;
    }
}