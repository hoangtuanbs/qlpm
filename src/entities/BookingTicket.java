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
@Table(name = "booking_ticket")
@NamedQueries({
    @NamedQuery(name = "BookingTicket.findAll", query = "SELECT b FROM BookingTicket b"),
    @NamedQuery(name = "BookingTicket.findByBookingId", query = "SELECT b FROM BookingTicket b WHERE b.bookingId = :bookingId"),
    @NamedQuery(name = "BookingTicket.findByBookingDate", query = "SELECT b FROM BookingTicket b WHERE b.bookingDate = :bookingDate"),
    @NamedQuery(name = "BookingTicket.findByBookingStatus", query = "SELECT b FROM BookingTicket b WHERE b.bookingStatus = :bookingStatus"),
    @NamedQuery(name = "BookingTicket.findByNote", query = "SELECT b FROM BookingTicket b WHERE b.note = :note")})
public class BookingTicket implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "booking_id")
    private Integer bookingId;
    @Basic(optional = false)
    @Column(name = "booking_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bookingDate = Calendar.getInstance().getTime();
    @Basic(optional = false)
    @Column(name = "booking_status")
    private int bookingStatus;
    @Column(name = "note")
    private String note;
    @JoinColumn(name = "ticket_id", referencedColumnName = "ticket_id")
    @ManyToOne(optional = false)
    private Ticket ticket;

    public BookingTicket() {
    }

    public BookingTicket(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public BookingTicket(Integer bookingId, Date bookingDate, int bookingStatus) {
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.bookingStatus = bookingStatus;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(int bookingStatus) {
        this.bookingStatus = bookingStatus;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingId != null ? bookingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookingTicket)) {
            return false;
        }
        BookingTicket other = (BookingTicket) object;
        if ((this.bookingId == null && other.bookingId != null) || (this.bookingId != null && !this.bookingId.equals(other.bookingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.BookingTicket[bookingId=" + bookingId + "]";
    }

}
