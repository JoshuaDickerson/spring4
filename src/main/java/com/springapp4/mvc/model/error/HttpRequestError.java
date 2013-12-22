package com.springapp4.mvc.model.error;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.Serializable;

/**
 * Created by josh on 12/22/13.
 */
public class HttpRequestError implements Serializable{
    private final String requestUrl;
    private final String details;
    private final String method;
    private Exception exception;


    public HttpRequestError(String url, RequestMethod method, String details){
        this.requestUrl = url;
        this.details = details;
        this.method = getMethodString(method);
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public String getDetails() {
        return details;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    private String getMethodString(RequestMethod method){
        switch (method){
            case POST:
                return "POST";
            case GET:
                return "GET";
            case PUT:
                return "PUT";
            case DELETE:
                return "DELETE";
            case PATCH:
                return "PATCH";
            default:
                return "UNKNOWN";
        }
    }
}
