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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Tuan Vu
 */
@Entity
@Table(name = "customer")
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByUserId", query = "SELECT c FROM Customer c WHERE c.userId = :userId"),
    @NamedQuery(name = "Customer.findByFullname", query = "SELECT c FROM Customer c WHERE c.fullname = :fullname"),
    @NamedQuery(name = "Customer.findByAge", query = "SELECT c FROM Customer c WHERE c.age = :age"),
    @NamedQuery(name = "Customer.findByAddress", query = "SELECT c FROM Customer c WHERE c.address = :address"),
    @NamedQuery(name = "Customer.findByPhone", query = "SELECT c FROM Customer c WHERE c.phone = :phone"),
    @NamedQuery(name = "Customer.findByIdentity", query = "SELECT c FROM Customer c WHERE c.identity = :identity"),
    @NamedQuery(name = "Customer.findByBirthday", query = "SELECT c FROM Customer c WHERE c.birthday = :birthday"),
    @NamedQuery(name = "Customer.findByGender", query = "SELECT c FROM Customer c WHERE c.gender = :gender"),
    @NamedQuery(name = "Customer.findByDateCreate", query = "SELECT c FROM Customer c WHERE c.dateCreate = :dateCreate")})
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "age")
    private Integer age;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;
    @Column(name = "identity")
    private String identity;
    @Basic(optional = false)
    @Column(name = "birthday")
    private short birthday = 1987;
    @Basic(optional = false)
    @Column(name = "gender")
    private short gender = 0;
    @Lob
    @Column(name = "note")
    private String note;
    @Basic(optional = false)
    @Column(name = "date_create")
    private int dateCreate = TimeProcessor.getInstance().getIntegerFromCurrentDate();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Ticket> ticketList;

    public Customer() {
    }

    public Customer(Integer userId) {
        this.userId = userId;
    }

    public Customer(Integer userId, String fullname, short birthday, short gender, int dateCreate) {
        this.userId = userId;
        this.fullname = fullname;
        this.birthday = birthday;
        this.gender = gender;
        this.dateCreate = dateCreate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public short getBirthday() {
        return birthday;
    }

    public void setBirthday(short birthday) {
        this.birthday = birthday;
    }

    public short getGender() {
        return gender;
    }

    public void setGender(short gender) {
        this.gender = gender;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(int dateCreate) {
        this.dateCreate = dateCreate;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
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
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Customer[userId=" + userId + "]";
    }

}
