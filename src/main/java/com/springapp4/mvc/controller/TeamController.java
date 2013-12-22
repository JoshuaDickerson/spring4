
package com.springapp4.mvc.controller;

import com.google.gson.Gson;
import com.springapp4.mvc.model.*;
import com.springapp4.mvc.model.error.HttpRequestError;
import com.springapp4.mvc.tools.HttpRequestMapper;
import com.springapp4.mvc.tools.HttpRequestTool;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

import static com.springapp4.mvc.model.Constants.*;

@Controller
@RequestMapping("/team")
public class TeamController {

    private static SessionFactory factory;
    private Logger log = LoggerFactory.getLogger(TeamController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String listTeams(HttpServletRequest request, ModelMap model) {

        System.err.println("Making factory.");
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        Gson gson = new Gson();
        String jsonObj = "not working";

        try{
            tx = session.beginTransaction();
            List<Team> teams = session.createQuery("FROM Team").list();
            jsonObj = gson.toJson(teams.toArray());
            tx.commit(); // you have to do this for the transaction to close"
        }catch (Exception ex) {
            log.error("Failed to create sessionFactory object." + ex);
            HttpRequestError error = new HttpRequestError(request.getRequestURI(), RequestMethod.GET, "Failed to create sessionFactory object." + ex);
            jsonObj = error.toJson();
        }finally {
            session.close();
        }

        model.addAttribute("json", jsonObj);
        return "json";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addUser(final HttpServletRequest request, ModelMap model) {
        HttpRequestMapper mapper = new HttpRequestMapper(request);
        try{
            JSON_TYPE type = HttpRequestTool.getJsonRequestType(request);
            if(type == JSON_TYPE.ARRAY){
                List<Team> teams = mapper.mapRequestStringToTeamList();
            }

            if(true){
                String json = HttpRequestTool.rawRequestToString(request);
                log.error("Unable to cast as Team - JSON_TYPE: "+json);
                HttpRequestError error = new HttpRequestError(request.getRequestURI(), RequestMethod.POST, "Unable to cast as Team - JSON_TYPE: "+json);
                model.addAttribute("json", error.toJson());
            }

        }catch (IOException e){
            log.error("Unable to read input stream");
        }catch (Exception e){
            log.error("Unable to cast as Team - Exception: "+e);
            HttpRequestError error = new HttpRequestError(request.getRequestURI(), RequestMethod.POST, "Unable to cast as Team - Exception: "+e);
            model.addAttribute("json", error.toJson());
        }
        return "json";
    }
}