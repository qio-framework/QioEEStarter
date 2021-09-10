package dev.web;

import com.google.gson.Gson;
import qio.annotate.HttpHandler;
import qio.annotate.JsonOutput;
import qio.annotate.Property;
import qio.annotate.verbs.Get;
import qio.model.web.ResponseData;

@HttpHandler
public class HelloHandler {

    Gson gson = new Gson();

    @JsonOutput
    @Get("/")
    public String hi(ResponseData data){
        data.put("message", "java is great! thank you sun, " +
                "oracle, mysql, h2 and grails!");
        return gson.toJson(data);
    }

}
