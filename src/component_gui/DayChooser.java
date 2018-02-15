/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DayChooser.java
 *
 * Created on Jan 7, 2011, 11:39:09 AM
 */

package component_gui;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Tuan Vu
 */
public class DayChooser extends javax.swing.JPanel {
    private Date date;
    int maxFeb = 28;
    int maxday [] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


    /** Creates new form DayChooser */
    public DayChooser() {
        initComponents();

        cbxMonth.removeAllItems();
        cbxYear.removeAllItems();
        cbxDay.removeAllItems();

        for (int i = 1; i <=12; i ++) {
            cbxMonth.addItem(i);
        }
        for (int i = 1900; i <=Calendar.getInstance().get(Calendar.YEAR); i ++) {
            cbxYear.addItem(i);

        }
        cbxYear.setSelectedItem(Calendar.getInstance().get(Calendar.YEAR));
        cbxMonth.setSelectedItem(Calendar.getInstance().get(Calendar.MONTH));
        initDay();
        cbxDay.setSelectedItem(Calendar.getInstance().get(Calendar.DATE));
    }

    public void initDay() {
         if ((((Integer)cbxYear.getSelectedIndex()) == -1 )||
                ((Integer)cbxMonth.getSelectedIndex() == -1)) return;
        Integer year = (Integer) cbxYear.getSelectedItem();

        Integer month =  (Integer) cbxMonth.getSelectedItem();


        int max = maxday[month];
        if (max == 28 && (year %4==0) &&(year%100!=0) ) {
            max = 29;
        }
        if (max != cbxDay.getItemCount()) {
            cbxDay.removeAllItems();
                for (int i =1 ; i <=max; i ++) {
                cbxDay.addItem(i);
            }
        }

    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbxDay = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cbxMonth = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cbxYear = new javax.swing.JComboBox();

        setMaximumSize(new java.awt.Dimension(300, 30));
        setMinimumSize(new java.awt.Dimension(200, 30));
        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(qlpm.QLPMApp.class).getContext().getResourceMap(DayChooser.class);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        cbxDay.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxDay.setName("cbxDay"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        cbxMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxMonth.setName("cbxMonth"); // NOI18N
        cbxMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMonthActionPerformed(evt);
            }
        });

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        cbxYear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxYear.setName("cbxYear"); // NOI18N
        cbxYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxYearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cbxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cbxYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbxYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxYearActionPerformed
        // TODO add your handling code here:
        initDay();
    }//GEN-LAST:event_cbxYearActionPerformed

    private void cbxMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMonthActionPerformed
        // TODO add your handling code here:
        initDay();
    }//GEN-LAST:event_cbxMonthActionPerformed

    public Date getDate() {
        Calendar c = Calendar.getInstance();
        Integer y = (Integer) cbxYear.getSelectedItem();
        Integer m = (Integer) cbxMonth.getSelectedItem();
        Integer d = (Integer) cbxDay.getSelectedItem();
        if ( y == null || m == null || d == null) return null;
        c.set(y, m-1, d,0, 0, 1);

        date =c.getTime();

        return c.getTime();
    }

    public void setDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        Integer year = c.get(Calendar.YEAR) ;
        cbxYear.setSelectedItem(year);
        Integer month = c.get(Calendar.MONTH ) +1;
        cbxMonth.setSelectedItem(month);
        initDay();
        Integer day = c.get(Calendar.DATE);
        cbxDay.setSelectedItem(day);

        this.date = date;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbxDay;
    private javax.swing.JComboBox cbxMonth;
    private javax.swing.JComboBox cbxYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

}
