package controllers;

import db.data.action.SchemaBusiness;
import play.libs.Json;
import play.mvc.*;


public class SchemaController extends Controller{
	
	public Result all(){
		return ok(Json.toJson(SchemaBusiness.getSchemas()));
	}
	
}
