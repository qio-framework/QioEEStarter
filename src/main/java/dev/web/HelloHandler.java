package dev.web;

import com.google.gson.Gson;
import qio.annotate.HttpHandler;
import qio.annotate.JsonOutput;
import qio.annotate.verbs.Get;
import qio.model.web.ResponseData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@HttpHandler
public class HelloHandler {

    Gson gson = new Gson();

    @JsonOutput
    @Get("/")
    public String hi(HttpServletRequest request,
                     HttpServletResponse response,
                     ResponseData data){
        Map<String, String> output = new HashMap<>();
        output.put("say", "hi friend");
        return gson.toJson(output);
    }

}
