package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "integration_file")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IntegrationFile.findAll", query = "SELECT i FROM IntegrationFile i"),
    @NamedQuery(name = "IntegrationFile.findById", query = "SELECT i FROM IntegrationFile i WHERE i.id = :id"),
    @NamedQuery(name = "IntegrationFile.findByName", query = "SELECT i FROM IntegrationFile i WHERE i.name = :name"),
    @NamedQuery(name = "IntegrationFile.findBySignature", query = "SELECT i FROM IntegrationFile i WHERE i.signature = :signature"),
    @NamedQuery(name = "IntegrationFile.findBySeparator", query = "SELECT i FROM IntegrationFile i WHERE i.separator = :separator"),
    @NamedQuery(name = "IntegrationFile.findByAtomic", query = "SELECT i FROM IntegrationFile i WHERE i.atomic = :atomic")})

public class IntegrationFile implements Serializable {
	
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "signature")
    private String signature;
    @Basic(optional = false)
    @Column(name = "separator")
    private String separator;
    @Basic(optional = false)
    @Column(name = "atomic")
    private boolean atomic;
    @OneToMany(mappedBy = "idIntegrationFile", fetch = FetchType.LAZY)
    private List<IntegrationColumn> integrationColumnList;

    public IntegrationFile() {
    }

    public IntegrationFile(Integer id) {
        this.id = id;
    }

    public IntegrationFile(Integer id, String name, String signature, String separator, boolean atomic) {
        this.id = id;
        this.name = name;
        this.signature = signature;
        this.separator = separator;
        this.atomic = atomic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public boolean getAtomic() {
        return atomic;
    }

    public void setAtomic(boolean atomic) {
        this.atomic = atomic;
    }

    @XmlTransient
    public List<IntegrationColumn> getIntegrationColumnList() {
        return integrationColumnList;
    }

    public void setIntegrationColumnList(List<IntegrationColumn> integrationColumnList) {
        this.integrationColumnList = integrationColumnList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IntegrationFile)) {
            return false;
        }
        IntegrationFile other = (IntegrationFile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "model.IntegrationFile[ id=" + id + " ]";
    }
    
}
