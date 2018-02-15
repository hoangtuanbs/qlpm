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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Tuan Vu
 */
@Entity
@Table(name = "service_ticket")
@NamedQueries({
    @NamedQuery(name = "ServiceTicket.findAll", query = "SELECT s FROM ServiceTicket s"),
    @NamedQuery(name = "ServiceTicket.findByStId", query = "SELECT s FROM ServiceTicket s WHERE s.stId = :stId"),
    @NamedQuery(name = "ServiceTicket.findByPrice", query = "SELECT s FROM ServiceTicket s WHERE s.price = :price")})
public class ServiceTicket implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "st_id")
    private Integer stId;
    @Column(name = "price")
    private Double price;
    @Lob
    @Column(name = "service_log")
    private String serviceLog;
    @Lob
    @Column(name = "target_log")
    private String targetLog;
    @Lob
    @Column(name = "note")
    private String note;
    @JoinColumn(name = "target_id", referencedColumnName = "target_id")
    @ManyToOne
    private Target target;
    @JoinColumn(name = "ticket_id", referencedColumnName = "ticket_id")
    @ManyToOne(optional = false)
    private Ticket ticket;
    @JoinColumn(name = "service_id", referencedColumnName = "service_id")
    @ManyToOne
    private Service service;

    public ServiceTicket() {
    }

    public ServiceTicket(Integer stId) {
        this.stId = stId;
    }

    public Integer getStId() {
        return stId;
    }

    public void setStId(Integer stId) {
        this.stId = stId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getServiceLog() {
        return serviceLog;
    }

    public void setServiceLog(String serviceLog) {
        this.serviceLog = serviceLog;
    }

    public String getTargetLog() {
        return targetLog;
    }

    public void setTargetLog(String targetLog) {
        this.targetLog = targetLog;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stId != null ? stId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiceTicket)) {
            return false;
        }
        ServiceTicket other = (ServiceTicket) object;
        if ((this.stId == null && other.stId != null) || (this.stId != null && !this.stId.equals(other.stId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ServiceTicket[stId=" + stId + "]";
    }

}
