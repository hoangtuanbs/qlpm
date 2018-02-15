/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Tuan Vu
 */
@Entity
@Table(name = "operation_service")
@NamedQueries({
    @NamedQuery(name = "OperationService.findAll", query = "SELECT o FROM OperationService o"),
    @NamedQuery(name = "OperationService.findByOsId", query = "SELECT o FROM OperationService o WHERE o.osId = :osId")})
public class OperationService implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "os_id")
    private Integer osId;
    @JoinColumn(name = "service_id", referencedColumnName = "service_id")
    @ManyToOne(optional = false)
    private Service service;
    @JoinColumn(name = "operation_id", referencedColumnName = "operation_id")
    @ManyToOne(optional = false)
    private Operation operation;

    public OperationService() {
    }

    public OperationService(Integer osId) {
        this.osId = osId;
    }

    public Integer getOsId() {
        return osId;
    }

    public void setOsId(Integer osId) {
        this.osId = osId;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (osId != null ? osId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OperationService)) {
            return false;
        }
        OperationService other = (OperationService) object;
        if ((this.osId == null && other.osId != null) || (this.osId != null && !this.osId.equals(other.osId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.OperationService[osId=" + osId + "]";
    }

}
