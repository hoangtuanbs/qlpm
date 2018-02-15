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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Tuan Vu
 */
@Entity
@Table(name = "operation_type")
@NamedQueries({
    @NamedQuery(name = "OperationType.findAll", query = "SELECT o FROM OperationType o"),
    @NamedQuery(name = "OperationType.findByOperationId", query = "SELECT o FROM OperationType o WHERE o.operationId = :operationId"),
    @NamedQuery(name = "OperationType.findByOperationName", query = "SELECT o FROM OperationType o WHERE o.operationName = :operationName")})
public class OperationType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "operation_id")
    private Integer operationId;
    @Basic(optional = false)
    @Column(name = "operation_name")
    private String operationName;

    public OperationType() {
    }

    public OperationType(Integer operationId) {
        this.operationId = operationId;
    }

    public OperationType(Integer operationId, String operationName) {
        this.operationId = operationId;
        this.operationName = operationName;
    }

    public Integer getOperationId() {
        return operationId;
    }

    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (operationId != null ? operationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OperationType)) {
            return false;
        }
        OperationType other = (OperationType) object;
        if ((this.operationId == null && other.operationId != null) || (this.operationId != null && !this.operationId.equals(other.operationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.OperationType[operationId=" + operationId + "]";
    }

}
