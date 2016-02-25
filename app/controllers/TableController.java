package controllers;

import db.data.Schema;
import db.data.action.TableBusiness;
import play.libs.Json;
import play.mvc.*;

public class TableController extends Controller {
	
	public Result get(String schemaName){
		
		Schema schema = new Schema(schemaName);	
	
		return ok(Json.toJson(TableBusiness.getTables(schema)));
	}
}
