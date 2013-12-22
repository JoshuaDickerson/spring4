package com.springapp4.mvc.tools;

import com.google.gson.Gson;
import com.springapp4.mvc.model.Constants;
import com.springapp4.mvc.model.Team;
import com.springapp4.mvc.model.error.InvalidJSONException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

import static com.springapp4.mvc.model.Constants.JSON_TYPE;

/**
 * Created by josh on 12/22/13.
 * Maps Requests to their model objects
 */

public class HttpRequestMapper {
    private final HttpServletRequest request;

    public HttpRequestMapper(HttpServletRequest request){
        this.request = request;
    }

    public Team mapRequestToTeam() throws IOException {
        if(HttpRequestTool.getJsonRequestType(request) != Constants.JSON_TYPE.OBJECT){
            throw new InvalidJSONException("Request does not contain a json OBJECT.");
        }else{

        }

        return null;
    }

    public List<Team> mapRequestStringToTeamList() throws InvalidJSONException, IOException {
        Gson gson = new Gson();
        Object[] objArray = gson.fromJson(HttpRequestTool.rawRequestToString(request), Object[].class);
        System.out.println("working");
        return null;
    }
}
