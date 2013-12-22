
package com.springapp4.mvc.controller;

import com.google.gson.Gson;
import com.springapp4.mvc.model.Api;
import com.springapp4.mvc.model.Person;
import com.springapp4.mvc.model.Player;
import com.springapp4.mvc.model.Team;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class ApiController {

    private static SessionFactory factory;

    @RequestMapping(method = RequestMethod.GET)
    public String listApi(ModelMap model) {
        Gson gson = new Gson();
        String jsonObj = "not working";
        Api api = new Api();
        api.setVersion("0.0.1");
        api.setCredits("Team 7");
        jsonObj = gson.toJson(api);

        model.addAttribute("json", jsonObj);
        return "json";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") Person person, BindingResult result) {



        return "redirect:/";
    }

    @RequestMapping("/delete/{userId}")
    public String deleteUser(@PathVariable("userId") Long userId) {



        return "redirect:/";
    }
}