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
@Table(name = "service")
@NamedQueries({
    @NamedQuery(name = "Service.findAll", query = "SELECT s FROM Service s"),
    @NamedQuery(name = "Service.findByServiceId", query = "SELECT s FROM Service s WHERE s.serviceId = :serviceId"),
    @NamedQuery(name = "Service.findByServiceName", query = "SELECT s FROM Service s WHERE s.serviceName = :serviceName"),
    @NamedQuery(name = "Service.findByAlias", query = "SELECT s FROM Service s WHERE s.alias = :alias"),
    @NamedQuery(name = "Service.findByDescription", query = "SELECT s FROM Service s WHERE s.description = :description"),
    @NamedQuery(name = "Service.findByUpperPrice", query = "SELECT s FROM Service s WHERE s.upperPrice = :upperPrice"),
    @NamedQuery(name = "Service.findByLowerPrice", query = "SELECT s FROM Service s WHERE s.lowerPrice = :lowerPrice"),
    @NamedQuery(name = "Service.findByUnit", query = "SELECT s FROM Service s WHERE s.unit = :unit")})
public class Service implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "service_id")
    private Integer serviceId;
    @Basic(optional = false)
    @Column(name = "service_name")
    private String serviceName;
    @Basic(optional = false)
    @Column(name = "alias")
    private String alias;
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "upper_price")
    private double upperPrice;
    @Basic(optional = false)
    @Column(name = "lower_price")
    private double lowerPrice;
    @Basic(optional = false)
    @Column(name = "unit")
    private short unit;
    @OneToMany(mappedBy = "service")
    private List<ServiceTicket> serviceTicketList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "service")
    private List<OperationService> operationServiceList;

    public Service() {
    }

    public Service(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Service(Integer serviceId, String serviceName, String alias, double upperPrice, double lowerPrice, short unit) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.alias = alias;
        this.upperPrice = upperPrice;
        this.lowerPrice = lowerPrice;
        this.unit = unit;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUpperPrice() {
        return upperPrice;
    }

    public void setUpperPrice(double upperPrice) {
        this.upperPrice = upperPrice;
    }

    public double getLowerPrice() {
        return lowerPrice;
    }

    public void setLowerPrice(double lowerPrice) {
        this.lowerPrice = lowerPrice;
    }

    public short getUnit() {
        return unit;
    }

    public void setUnit(short unit) {
        this.unit = unit;
    }

    public List<ServiceTicket> getServiceTicketList() {
        return serviceTicketList;
    }

    public void setServiceTicketList(List<ServiceTicket> serviceTicketList) {
        this.serviceTicketList = serviceTicketList;
    }

    public List<OperationService> getOperationServiceList() {
        return operationServiceList;
    }

    public void setOperationServiceList(List<OperationService> operationServiceList) {
        this.operationServiceList = operationServiceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviceId != null ? serviceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Service)) {
            return false;
        }
        Service other = (Service) object;
        if ((this.serviceId == null && other.serviceId != null) || (this.serviceId != null && !this.serviceId.equals(other.serviceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Service[serviceId=" + serviceId + "]";
    }

}
