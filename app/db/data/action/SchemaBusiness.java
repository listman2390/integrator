package db.data.action;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import play.db.DB;
import db.data.Schema;
import exception.DBException;

public class SchemaBusiness {

	public static List<Schema> getSchemas(){

		List<Schema> schemas = new ArrayList<>();
		final int SCHEMA_NAME_COLUMN = 1;
		final List<String> excludeSchemas = Arrays.asList(new String[] {"information_schema", "pg_catalog" });

		try (Connection connection = DB.getConnection()) {

			DatabaseMetaData metadata = connection.getMetaData();

			try (ResultSet schemasResult = metadata.getSchemas()) {

				while (schemasResult.next()) {
					String name = schemasResult.getString(SCHEMA_NAME_COLUMN);

					if (!excludeSchemas.contains(name)) {
						schemas.add(new Schema(name));
					}
					
				}
			}
			
		}catch(SQLException e){
			throw new DBException(e);
		}

		return schemas;
	}

}
