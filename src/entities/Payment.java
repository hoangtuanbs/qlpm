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
@Table(name = "payment")
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p"),
    @NamedQuery(name = "Payment.findByPaymentId", query = "SELECT p FROM Payment p WHERE p.paymentId = :paymentId"),
    @NamedQuery(name = "Payment.findByAmount", query = "SELECT p FROM Payment p WHERE p.amount = :amount"),
    @NamedQuery(name = "Payment.findByDateCreate", query = "SELECT p FROM Payment p WHERE p.dateCreate = :dateCreate"),
    @NamedQuery(name = "Payment.findByLastModified", query = "SELECT p FROM Payment p WHERE p.lastModified = :lastModified"),
    @NamedQuery(name = "Payment.findByNote", query = "SELECT p FROM Payment p WHERE p.note = :note")})
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "payment_id")
    private Integer paymentId;
    @Basic(optional = false)
    @Column(name = "amount")
    private double amount;
    @Basic(optional = false)
    @Column(name = "date_create")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate = Calendar.getInstance().getTime();
    @Basic(optional = false)
    @Column(name = "last_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified = Calendar.getInstance().getTime();
    @Column(name = "note")
    private String note;
    @JoinColumn(name = "ticket_id", referencedColumnName = "ticket_id")
    @ManyToOne(optional = false)
    private Ticket ticket;
    @JoinColumn(name = "user_charge", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User user;

    public Payment() {
    }

    public Payment(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Payment(Integer paymentId, double amount, Date dateCreate, Date lastModified) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.dateCreate = dateCreate;
        this.lastModified = lastModified;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
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
        hash += (paymentId != null ? paymentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.paymentId == null && other.paymentId != null) || (this.paymentId != null && !this.paymentId.equals(other.paymentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Payment[paymentId=" + paymentId + "]";
    }

}
