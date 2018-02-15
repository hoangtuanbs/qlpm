/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "target")
@NamedQueries({
    @NamedQuery(name = "Target.findAll", query = "SELECT t FROM Target t"),
    @NamedQuery(name = "Target.findByTargetId", query = "SELECT t FROM Target t WHERE t.targetId = :targetId"),
    @NamedQuery(name = "Target.findByTargeName", query = "SELECT t FROM Target t WHERE t.targeName = :targeName")})
public class Target implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "target_id")
    private Integer targetId;
    @Basic(optional = false)
    @Column(name = "targe_name")
    private String targeName;
    @OneToMany(mappedBy = "target")
    private List<TicketPrediction> ticketPredictionList;
    @OneToMany(mappedBy = "target")
    private List<ServiceTicket> serviceTicketList;

    public Target() {
    }

    public Target(Integer targetId) {
        this.targetId = targetId;
    }

    public Target(Integer targetId, String targeName) {
        this.targetId = targetId;
        this.targeName = targeName;
    }

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public String getTargeName() {
        return targeName;
    }

    public void setTargeName(String targeName) {
        this.targeName = targeName;
    }

    public List<TicketPrediction> getTicketPredictionList() {
        return ticketPredictionList;
    }

    public void setTicketPredictionList(List<TicketPrediction> ticketPredictionList) {
        this.ticketPredictionList = ticketPredictionList;
    }

    public List<ServiceTicket> getServiceTicketList() {
        return serviceTicketList;
    }

    public void setServiceTicketList(List<ServiceTicket> serviceTicketList) {
        this.serviceTicketList = serviceTicketList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (targetId != null ? targetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Target)) {
            return false;
        }
        Target other = (Target) object;
        if ((this.targetId == null && other.targetId != null) || (this.targetId != null && !this.targetId.equals(other.targetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Target[targetId=" + targetId + "]";
    }

}
