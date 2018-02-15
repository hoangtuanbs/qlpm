/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package converter;

import entities.Prediction;
import entities.Service;
import entities.User;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Tuan Vu
 */
public class GlobalProperty {
    private static GlobalProperty gp = null;
    private org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(qlpm.QLPMApp.class).getContext().getResourceMap(GlobalProperty.class);
    private EntityManager entityManager ;//= java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory(resourceMap.getString("entityManager.persistenceUnit")).createEntityManager(); // NOI18N
    private Query               pQquery ;//= java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT p FROM Prediction p"); // NOI18N
    private List<Prediction>   predictionList ;//=  (java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(pQquery.getResultList()));
    private Query               sQuery  ;//= java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT s FROM Service s");
    private List<Service>       serviceList;// = (java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(sQuery.getResultList()));

    private Query                uQuery ;
    private List<User>           userList;

    //private static Query                sQuery;
    //private static List<Service>
    private GlobalProperty() {
        entityManager   =  java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("QLPMPU").createEntityManager();
        pQquery         = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT p FROM Prediction p"); // NOI18N
        predictionList  =  (java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(pQquery.getResultList()));
        sQuery          = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT s FROM Service s");
        serviceList     = (java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(sQuery.getResultList()));
        uQuery          = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT s FROM User s");
        userList     = (java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(uQuery.getResultList()));
    }

    public static GlobalProperty getInstance() {
        if ( gp==null) {
            gp = new GlobalProperty();
        }
        return gp;
    }

    private static class GlobalPropertyHolder {
        private static final GlobalProperty INSTANCE = new GlobalProperty();
    }

    public List<Prediction> getPredictionList () {
        return predictionList;
    }

    public List<Service> getServiceList () {
        return serviceList;
    }

    public List<User> getUserList () {
        return userList;
    }

 }
