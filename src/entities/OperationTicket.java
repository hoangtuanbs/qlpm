/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Tuan Vu
 */
@Entity
@Table(name = "operation_ticket")
@NamedQueries({
    @NamedQuery(name = "OperationTicket.findAll", query = "SELECT o FROM OperationTicket o"),
    @NamedQuery(name = "OperationTicket.findByOtId", query = "SELECT o FROM OperationTicket o WHERE o.otId = :otId"),
    @NamedQuery(name = "OperationTicket.findByOperationName", query = "SELECT o FROM OperationTicket o WHERE o.operationName = :operationName"),
    @NamedQuery(name = "OperationTicket.findByOperationTarget", query = "SELECT o FROM OperationTicket o WHERE o.operationTarget = :operationTarget"),
    @NamedQuery(name = "OperationTicket.findByDayCreate", query = "SELECT o FROM OperationTicket o WHERE o.dayCreate = :dayCreate"),
    @NamedQuery(name = "OperationTicket.findByNote", query = "SELECT o FROM OperationTicket o WHERE o.note = :note")})
public class OperationTicket implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ot_id")
    private Integer otId;
    @Basic(optional = false)
    @Column(name = "operation_name")
    private String operationName;
    @Basic(optional = false)
    @Column(name = "operation_target")
    private String operationTarget;
    @Basic(optional = false)
    @Column(name = "day_create")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dayCreate = Calendar.getInstance().getTime();
    @Column(name = "note")
    private String note;
    @JoinColumn(name = "ticket_id", referencedColumnName = "ticket_id")
    @ManyToOne(optional = false)
    private Ticket ticket;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User user;

    public OperationTicket() {
    }

    public OperationTicket(Integer otId) {
        this.otId = otId;
    }

    public OperationTicket(Integer otId, String operationName, String operationTarget, Date dayCreate) {
        this.otId = otId;
        this.operationName = operationName;
        this.operationTarget = operationTarget;
        this.dayCreate = dayCreate;
    }

    public Integer getOtId() {
        return otId;
    }

    public void setOtId(Integer otId) {
        this.otId = otId;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getOperationTarget() {
        return operationTarget;
    }

    public void setOperationTarget(String operationTarget) {
        this.operationTarget = operationTarget;
    }

    public Date getDayCreate() {
        return dayCreate;
    }

    public void setDayCreate(Date dayCreate) {
        this.dayCreate = dayCreate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (otId != null ? otId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OperationTicket)) {
            return false;
        }
        OperationTicket other = (OperationTicket) object;
        if ((this.otId == null && other.otId != null) || (this.otId != null && !this.otId.equals(other.otId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.OperationTicket[otId=" + otId + "]";
    }

}
