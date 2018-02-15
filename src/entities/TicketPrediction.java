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
@Table(name = "ticket_prediction")
@NamedQueries({
    @NamedQuery(name = "TicketPrediction.findAll", query = "SELECT t FROM TicketPrediction t"),
    @NamedQuery(name = "TicketPrediction.findByTpId", query = "SELECT t FROM TicketPrediction t WHERE t.tpId = :tpId"),
    @NamedQuery(name = "TicketPrediction.findByDateCreate", query = "SELECT t FROM TicketPrediction t WHERE t.dateCreate = :dateCreate")})
public class TicketPrediction implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tp_id")
    private Integer tpId;
    @Basic(optional = false)
    @Column(name = "date_create")
    private int dateCreate = TimeProcessor.getInstance().getIntegerFromCurrentDate();
    @Lob
    @Column(name = "target_log")
    private String targetLog;
    @Lob
    @Column(name = "prediction_log")
    private String predictionLog;
    @JoinColumn(name = "target_id", referencedColumnName = "target_id")
    @ManyToOne
    private Target target;
    @JoinColumn(name = "prediction_id", referencedColumnName = "prediction_id")
    @ManyToOne
    private Prediction prediction;
    @JoinColumn(name = "ticket_id", referencedColumnName = "ticket_id")
    @ManyToOne(optional = false)
    private Ticket ticket;
    @JoinColumn(name = "user_create", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User user;

    public TicketPrediction() {
    }

    public TicketPrediction(Integer tpId) {
        this.tpId = tpId;
    }

    public TicketPrediction(Integer tpId, int dateCreate) {
        this.tpId = tpId;
        this.dateCreate = dateCreate;
    }

    public Integer getTpId() {
        return tpId;
    }

    public void setTpId(Integer tpId) {
        this.tpId = tpId;
    }

    public int getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(int dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getTargetLog() {
        return targetLog;
    }

    public void setTargetLog(String targetLog) {
        this.targetLog = targetLog;
    }

    public String getPredictionLog() {
        return predictionLog;
    }

    public void setPredictionLog(String predictionLog) {
        this.predictionLog = predictionLog;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public Prediction getPrediction() {
        return prediction;
    }

    public void setPrediction(Prediction prediction) {
        this.prediction = prediction;
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
        hash += (tpId != null ? tpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TicketPrediction)) {
            return false;
        }
        TicketPrediction other = (TicketPrediction) object;
        if ((this.tpId == null && other.tpId != null) || (this.tpId != null && !this.tpId.equals(other.tpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TicketPrediction[tpId=" + tpId + "]";
    }

}
