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
@Table(name = "prediction")
@NamedQueries({
    @NamedQuery(name = "Prediction.findAll", query = "SELECT p FROM Prediction p"),
    @NamedQuery(name = "Prediction.findByPredictionId", query = "SELECT p FROM Prediction p WHERE p.predictionId = :predictionId"),
    @NamedQuery(name = "Prediction.findByAlias", query = "SELECT p FROM Prediction p WHERE p.alias = :alias")})
public class Prediction implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "prediction_id")
    private Integer predictionId;
    @Basic(optional = false)
    @Column(name = "alias")
    private String alias;
    @Basic(optional = false)
    @Lob
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "prediction")
    private List<TicketPrediction> ticketPredictionList;

    public Prediction() {
    }

    public Prediction(Integer predictionId) {
        this.predictionId = predictionId;
    }

    public Prediction(Integer predictionId, String alias, String name) {
        this.predictionId = predictionId;
        this.alias = alias;
        this.name = name;
    }

    public Integer getPredictionId() {
        return predictionId;
    }

    public void setPredictionId(Integer predictionId) {
        this.predictionId = predictionId;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TicketPrediction> getTicketPredictionList() {
        return ticketPredictionList;
    }

    public void setTicketPredictionList(List<TicketPrediction> ticketPredictionList) {
        this.ticketPredictionList = ticketPredictionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (predictionId != null ? predictionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prediction)) {
            return false;
        }
        Prediction other = (Prediction) object;
        if ((this.predictionId == null && other.predictionId != null) || (this.predictionId != null && !this.predictionId.equals(other.predictionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Prediction[predictionId=" + predictionId + "]";
    }

}
