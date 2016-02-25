package db.data.action;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import play.db.DB;
import db.data.Column;
import db.data.Table;
import exception.DBException;

public class ColumnBusiness {

	public static List<Column> getColumns(Table table) {

		final int COLUMN_NAME = 4;
		final int COLUMN_TYPE = 6;

		try (Connection connection = DB.getConnection()) {

			DatabaseMetaData metadata = connection.getMetaData();

			try (ResultSet columnsResult = metadata.getColumns(null, table.getSchema().getName(), table.getName(), null)) {

				while (columnsResult.next()) {
					
					String name = columnsResult.getString(COLUMN_NAME);
					String type = columnsResult.getString(COLUMN_TYPE);
					table.addCoulmn(new Column(name, type, table));
					
				}

			}

		} catch (SQLException e) {
			throw new DBException(e);
		}

		return table.getColumns();
	}

	public static List<Column> getPrimaryKeys(Table table) {

		final int COLUMN_NAME = 4;
		final int COLUMN_TYPE = 6;

		try (Connection connection = DB.getConnection()) {

			DatabaseMetaData metadata = connection.getMetaData();
			try (ResultSet columnsResult = metadata.getPrimaryKeys(null, table.getSchema().getName(), table.getName())) {

				while (columnsResult.next()) {
					String name = columnsResult.getString(COLUMN_NAME);
					String type = columnsResult.getString(COLUMN_TYPE);
					table.addPrimaryKey(new Column(name, type, table));

				}
			}
		} catch (SQLException e) {
			throw new DBException(e);
		}

		return table.getColumns();
	}

	public static List<Column> getForeignKeys(Table table) {

		final int COLUMN_NAME = 4;
		final int COLUMN_TYPE = 6;

		try (Connection connection = DB.getConnection()) {

			DatabaseMetaData metadata = connection.getMetaData();

			try (ResultSet columnsResult = metadata.getImportedKeys(null, table.getSchema().getName(), table.getName())) {

				while (columnsResult.next()) {
					String name = columnsResult.getString(COLUMN_NAME);
					String type = columnsResult.getString(COLUMN_TYPE);
					table.addForeignKey(new Column(name, type, table));
				}

			}

		} catch (SQLException e) {
			throw new DBException(e);
		}

		return table.getColumns();
	}

}
