package com.springapp4.mvc.tools;

import com.google.gson.JsonElement;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;

import static com.springapp4.mvc.model.Constants.*;

/**
 * Created by josh on 12/22/13.
 */
public class HttpRequestTool {
    public static String rawRequestToString(HttpServletRequest request) throws IOException{
        InputStream body = request.getInputStream();
        Writer writer = new StringWriter();
        IOUtils.copy(body, writer);
        return writer.toString();
    }

    public static JSON_TYPE getJsonRequestType(HttpServletRequest request) throws IOException {
        String json = rawRequestToString(request);
        com.google.gson.JsonParser parser = new com.google.gson.JsonParser();
        JsonElement element = parser.parse(json);
        if(element.isJsonArray()){
            return JSON_TYPE.ARRAY;
        }else if(element.isJsonObject()){
            return JSON_TYPE.OBJECT;
        }else if(element.isJsonPrimitive()){
            return JSON_TYPE.PRIMITIVE;
        }else if(element.isJsonNull()){
            return JSON_TYPE.NULL;
        }else{
            return JSON_TYPE.INVALID;
        }
    }
}
