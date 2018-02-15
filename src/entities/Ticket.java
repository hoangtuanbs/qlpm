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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Tuan Vu
 */
@Entity
@Table(name = "ticket")
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t"),
    @NamedQuery(name = "Ticket.findByTicketId", query = "SELECT t FROM Ticket t WHERE t.ticketId = :ticketId"),
    @NamedQuery(name = "Ticket.findByDateStart", query = "SELECT t FROM Ticket t WHERE t.dateStart = :dateStart"),
    @NamedQuery(name = "Ticket.findByLastAccess", query = "SELECT t FROM Ticket t WHERE t.lastAccess = :lastAccess"),
    @NamedQuery(name = "Ticket.findByTotalPayment", query = "SELECT t FROM Ticket t WHERE t.totalPayment = :totalPayment")})
public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ticket_id")
    private Integer ticketId;
    @Basic(optional = false)
    @Column(name = "date_start")
    private int dateStart = TimeProcessor.getInstance().getIntegerFromCurrentDate();
    @Basic(optional = false)
    @Column(name = "last_access")
    private int lastAccess = TimeProcessor.getInstance().getIntegerFromCurrentDate();
    @Lob
    @Column(name = "notice")
    private String notice;
    @Column(name = "total_payment")
    private Double totalPayment = 0.0;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticket")
    private List<Payment> paymentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticket")
    private List<TicketPrediction> ticketPredictionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticket")
    private List<OperationTicket> operationTicketList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticket")
    private List<ServiceTicket> serviceTicketList;
    @JoinColumn(name = "ticket_user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private Customer customer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticket")
    private List<BookingTicket> bookingTicketList;

    public Ticket() {
    }

    public Ticket(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Ticket(Integer ticketId, int dateStart, int lastAccess) {
        this.ticketId = ticketId;
        this.dateStart = dateStart;
        this.lastAccess = lastAccess;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public int getDateStart() {
        return dateStart;
    }

    public void setDateStart(int dateStart) {
        this.dateStart = dateStart;
    }

    public int getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(int lastAccess) {
        this.lastAccess = lastAccess;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public Double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(Double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public List<TicketPrediction> getTicketPredictionList() {
        return ticketPredictionList;
    }

    public void setTicketPredictionList(List<TicketPrediction> ticketPredictionList) {
        this.ticketPredictionList = ticketPredictionList;
    }

    public List<OperationTicket> getOperationTicketList() {
        return operationTicketList;
    }

    public void setOperationTicketList(List<OperationTicket> operationTicketList) {
        this.operationTicketList = operationTicketList;
    }

    public List<ServiceTicket> getServiceTicketList() {
        return serviceTicketList;
    }

    public void setServiceTicketList(List<ServiceTicket> serviceTicketList) {
        this.serviceTicketList = serviceTicketList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<BookingTicket> getBookingTicketList() {
        return bookingTicketList;
    }

    public void setBookingTicketList(List<BookingTicket> bookingTicketList) {
        this.bookingTicketList = bookingTicketList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ticketId != null ? ticketId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.ticketId == null && other.ticketId != null) || (this.ticketId != null && !this.ticketId.equals(other.ticketId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Ticket[ticketId=" + ticketId + "]";
    }

}
