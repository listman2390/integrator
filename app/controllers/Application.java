package controllers;

import javax.inject.Inject;

import com.fasterxml.jackson.databind.JsonNode;

import db.builder.BuilderDB;
import model.IntegrationFile;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {


    public Result index() {
    	//Json.toJson(builderDB.loadDB())
        return ok(main.render());
    }

    @Transactional
    public Result test (){
    	
    	JsonNode input = request().body().asJson();
    	IntegrationFile file =new  IntegrationFile(Integer.parseInt(input.findValue("name").asText()));
    	JPA.em().persist(file);
    	
    	return ok(Json.toJson(file));
    }
}
