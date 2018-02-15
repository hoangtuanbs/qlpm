/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Tuan Vu
 */
@Entity
@Table(name = "operation")
@NamedQueries({
    @NamedQuery(name = "Operation.findAll", query = "SELECT o FROM Operation o"),
    @NamedQuery(name = "Operation.findByOperationId", query = "SELECT o FROM Operation o WHERE o.operationId = :operationId"),
    @NamedQuery(name = "Operation.findByName", query = "SELECT o FROM Operation o WHERE o.name = :name"),
    @NamedQuery(name = "Operation.findByDayBefore", query = "SELECT o FROM Operation o WHERE o.dayBefore = :dayBefore"),
    @NamedQuery(name = "Operation.findByOrder", query = "SELECT o FROM Operation o WHERE o.order = :order")})
public class Operation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "operation_id")
    private Integer operationId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "day_before")
    private Short dayBefore;
    @Basic(optional = false)
    @Column(name = "order")
    private short order;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "operation")
    private List<OperationService> operationServiceList;

    public Operation() {
    }

    public Operation(Integer operationId) {
        this.operationId = operationId;
    }

    public Operation(Integer operationId, String name, short order) {
        this.operationId = operationId;
        this.name = name;
        this.order = order;
    }

    public Integer getOperationId() {
        return operationId;
    }

    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getDayBefore() {
        return dayBefore;
    }

    public void setDayBefore(Short dayBefore) {
        this.dayBefore = dayBefore;
    }

    public short getOrder() {
        return order;
    }

    public void setOrder(short order) {
        this.order = order;
    }

    public List<OperationService> getOperationServiceList() {
        return operationServiceList;
    }

    public void setOperationServiceList(List<OperationService> operationServiceList) {
        this.operationServiceList = operationServiceList;
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
        if (!(object instanceof Operation)) {
            return false;
        }
        Operation other = (Operation) object;
        if ((this.operationId == null && other.operationId != null) || (this.operationId != null && !this.operationId.equals(other.operationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Operation[operationId=" + operationId + "]";
    }

}
