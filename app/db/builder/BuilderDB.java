package db.builder;

import java.util.List;

import db.data.Schema;
import db.data.action.ColumnBusiness;
import db.data.action.SchemaBusiness;
import db.data.action.TableBusiness;


public class BuilderDB {
	
	public List<Schema> loadDB(){
		
		List<Schema> schemas = SchemaBusiness.getSchemas();
		
		schemas.forEach(schema -> {
			
			TableBusiness.getTables(schema).parallelStream().forEach(table -> {
				ColumnBusiness.getColumns(table);
				ColumnBusiness.getForeignKeys(table);
				ColumnBusiness.getPrimaryKeys(table);
			});
			
		});
		
		return schemas;
	}

}
