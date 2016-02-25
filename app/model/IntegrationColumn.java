package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "integration_column")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IntegrationColumn.findAll", query = "SELECT i FROM IntegrationColumn i"),
    @NamedQuery(name = "IntegrationColumn.findById", query = "SELECT i FROM IntegrationColumn i WHERE i.id = :id"),
    @NamedQuery(name = "IntegrationColumn.findByNumberColumn", query = "SELECT i FROM IntegrationColumn i WHERE i.numberColumn = :numberColumn"),
    @NamedQuery(name = "IntegrationColumn.findByDbTable", query = "SELECT i FROM IntegrationColumn i WHERE i.dbTable = :dbTable"),
    @NamedQuery(name = "IntegrationColumn.findByDbField", query = "SELECT i FROM IntegrationColumn i WHERE i.dbField = :dbField"),
    @NamedQuery(name = "IntegrationColumn.findByCreateDependency", query = "SELECT i FROM IntegrationColumn i WHERE i.createDependency = :createDependency"),
    @NamedQuery(name = "IntegrationColumn.findByDependencyBdTable", query = "SELECT i FROM IntegrationColumn i WHERE i.dependencyBdTable = :dependencyBdTable"),
    @NamedQuery(name = "IntegrationColumn.findByDependencyBdField", query = "SELECT i FROM IntegrationColumn i WHERE i.dependencyBdField = :dependencyBdField")})

public class IntegrationColumn implements Serializable {
	
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "number_column")
    private int numberColumn;
    @Basic(optional = false)
    @Column(name = "db_table")
    private String dbTable;
    @Basic(optional = false)
    @Column(name = "db_field")
    private String dbField;
    @Basic(optional = false)
    @Column(name = "create_dependency")
    private boolean createDependency;
    @Basic(optional = false)
    @Column(name = "dependency_bd_table")
    private String dependencyBdTable;
    @Basic(optional = false)
    @Column(name = "dependency_bd_field")
    private String dependencyBdField;
    @JoinColumn(name = "id_integration_file", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private IntegrationFile idIntegrationFile;

    public IntegrationColumn() {
    }

    public IntegrationColumn(Integer id) {
        this.id = id;
    }

    public IntegrationColumn(Integer id, int numberColumn, String dbTable, String dbField, boolean createDependency, String dependencyBdTable, String dependencyBdField) {
        this.id = id;
        this.numberColumn = numberColumn;
        this.dbTable = dbTable;
        this.dbField = dbField;
        this.createDependency = createDependency;
        this.dependencyBdTable = dependencyBdTable;
        this.dependencyBdField = dependencyBdField;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumberColumn() {
        return numberColumn;
    }

    public void setNumberColumn(int numberColumn) {
        this.numberColumn = numberColumn;
    }

    public String getDbTable() {
        return dbTable;
    }

    public void setDbTable(String dbTable) {
        this.dbTable = dbTable;
    }

    public String getDbField() {
        return dbField;
    }

    public void setDbField(String dbField) {
        this.dbField = dbField;
    }

    public boolean getCreateDependency() {
        return createDependency;
    }

    public void setCreateDependency(boolean createDependency) {
        this.createDependency = createDependency;
    }

    public String getDependencyBdTable() {
        return dependencyBdTable;
    }

    public void setDependencyBdTable(String dependencyBdTable) {
        this.dependencyBdTable = dependencyBdTable;
    }

    public String getDependencyBdField() {
        return dependencyBdField;
    }

    public void setDependencyBdField(String dependencyBdField) {
        this.dependencyBdField = dependencyBdField;
    }

    public IntegrationFile getIdIntegrationFile() {
        return idIntegrationFile;
    }

    public void setIdIntegrationFile(IntegrationFile idIntegrationFile) {
        this.idIntegrationFile = idIntegrationFile;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof IntegrationColumn)) {
            return false;
        }
        IntegrationColumn other = (IntegrationColumn) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.IntegrationColumn[ id=" + id + " ]";
    }
    
}
