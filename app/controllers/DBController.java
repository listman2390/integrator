package controllers;

import db.builder.BuilderDB;
import play.libs.Json;
import play.mvc.*;

public class DBController extends Controller{
	
	public Result getDB(){
		BuilderDB builderDB = new BuilderDB();
		return ok(Json.toJson(builderDB.loadDB()));
	}
	
}
