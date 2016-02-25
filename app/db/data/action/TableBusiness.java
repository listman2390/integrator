package db.data.action;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import play.db.DB;
import db.data.Schema;
import db.data.Table;
import exception.DBException;

public class TableBusiness {
	
	public static List<Table> getTables(Schema schema){

		final int TABLE_NAME_COLUMN = 3;
		
		try (Connection connection = DB.getConnection()) {

			DatabaseMetaData metadata = connection.getMetaData();

			try (ResultSet tablesResult = metadata.getTables(null, schema.getName(), null, null)) {

				while (tablesResult.next()) {
					String name = tablesResult.getString(TABLE_NAME_COLUMN);
					schema.addTable(new Table(name,schema));
				}
			}
			
		}catch (SQLException e) {
			throw new DBException(e);
		}
		
		return schema.getTables();
	}
}
