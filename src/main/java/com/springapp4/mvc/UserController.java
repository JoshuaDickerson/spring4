
package com.springapp4.mvc;

import com.google.gson.Gson;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Property;
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
public class UserController {

    private static SessionFactory factory;

    @RequestMapping(method = RequestMethod.GET)
    public String listUsers(ModelMap model) {

        System.err.println("Making factory.");
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        Gson gson = new Gson();
        String jsonObj = "not working";


        try{
            tx = session.beginTransaction();

            // this is a super nested set of objects
            // a team has players, and players have a person
            List<Team> teams = session.createQuery("FROM Team").list();

            List<Player> players = session.createQuery("FROM Player").list();

            // get all the Persons from the person table
//            List<Person> users = session.createQuery("FROM Person").list();

            // get all the Persons with an id greater than 47
//            Property age = Property.forName("id");
//            List<Person> persons = session.createCriteria(Person.class).add(age.gt(new Long(47))).list();
//            jsonObj = gson.toJson(persons.toArray());

            jsonObj = gson.toJson(players.toArray());



            tx.commit(); // you have to do this for the transaction to close"
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