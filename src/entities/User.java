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
@Table(name = "user")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId"),
    @NamedQuery(name = "User.findByUserName", query = "SELECT u FROM User u WHERE u.userName = :userName"),
    @NamedQuery(name = "User.findByUserRole", query = "SELECT u FROM User u WHERE u.userRole = :userRole")})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "user_name")
    private String userName;
    @Basic(optional = false)
    @Column(name = "user_role")
    private int userRole;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Payment> paymentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<TicketPrediction> ticketPredictionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<OperationTicket> operationTicketList;

    public User() {
    }

    public User(Integer userId) {
        this.userId = userId;
    }

    public User(Integer userId, String userName, int userRole) {
        this.userId = userId;
        this.userName = userName;
        this.userRole = userRole;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.User[userId=" + userId + "]";
    }

}
