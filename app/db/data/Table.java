package db.data;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import db.data.action.TableBusiness;

public class Table {
	
	private String name;
	@JsonBackReference private Schema schema;
	private List<Column> columns;
	private List<Column> primaryKeys;
	private List<Column> foreignKeys;
	public static TableBusiness action = new TableBusiness();
	
	public Table(String name, Schema schema) {
		super();
		this.name = name;
		this.schema = schema;
		this.columns = new ArrayList<>();
		this.primaryKeys =new ArrayList<>();
		this.foreignKeys =new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}

	public List<Column> getPrimaryKeys() {
		return primaryKeys;
	}

	public void setPrimaryKeys(List<Column> primaryKeys) {
		this.primaryKeys = primaryKeys;
	}

	public List<Column> getForeignKeys() {
		return foreignKeys;
	}

	public void setForeignKeys(List<Column> foreignKeys) {
		this.foreignKeys = foreignKeys;
	}

	public Schema getSchema() {
		return schema;
	}

	public void setSchema(Schema schema) {
		this.schema = schema;
	}
	
	public boolean addCoulmn(Column column){
		return this.columns.add(column);
	}
	
	public boolean addPrimaryKey(Column columnPK){
		return this.columns.add(columnPK);
	}
	
	public boolean addForeignKey(Column columnFK){
		return this.columns.add(columnFK);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((schema == null) ? 0 : schema.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Table other = (Table) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (schema == null) {
			if (other.schema != null)
				return false;
		} else if (!schema.equals(other.schema))
			return false;
		return true;
	}
	
}
