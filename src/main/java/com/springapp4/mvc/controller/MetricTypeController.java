
package com.springapp4.mvc.controller;

import com.google.gson.Gson;
import com.springapp4.mvc.model.MetricType;
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
@RequestMapping("/metricType")
public class MetricTypeController {

    private static SessionFactory factory;

    @RequestMapping(method = RequestMethod.GET)
    public String listMetricTypes(ModelMap model) {
        // build Hibernate session
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        Gson gson = new Gson();
        String jsonObj = "not working";

        try{
            tx = session.beginTransaction();
            List<MetricType> metricType = session.createQuery("FROM com.springapp4.mvc.model.MetricType").list();
            jsonObj = gson.toJson(metricType.toArray());
            tx.commit(); // you have to do this for the transaction to close
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }finally {
            session.close();
        }

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