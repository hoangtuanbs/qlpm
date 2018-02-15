/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CustomerView.java
 *
 * Created on Dec 28, 2010, 5:43:50 AM
 */

package gui;
import ViewInterface.INewCustomer;
import entities.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import org.jdesktop.application.Action;
import org.jdesktop.application.Task;
/**
 *
 * @author Tuan Vu
 */
public class CustomerView extends javax.swing.JFrame implements WindowListener, INewCustomer {

    /** Creates new form CustomerView */
    public CustomerView() {
        initComponents();
    }

    public String getQuery(){
        String s = "SELECT c FROM Customer c";
        if (tfName!=null&&tfPhone!=null&&tfTicket!=null) {
            if ((!tfName.getText().isEmpty())||(!tfPhone.getText().isEmpty())||(!tfTicket.getText().isEmpty())){
                s+= " WHERE ";
                if (!tfName.getText().isEmpty()) {
                    s += "LOWER(c.fullname) LIKE \'%" +tfName.getText().toLowerCase()+"%\'";
                    if (!tfPhone.getText().isEmpty()) {
                        s += " AND ";
                    }
                }
                if (!tfPhone.getText().isEmpty()) {
                    s += " c.phone LIKE \'%"+tfPhone.getText()+"%\'";
                }
            }
        }

        return s;
    }

    @Action
    public Task refreshMasterTable () {
        customerQuery = java.beans.Beans.isDesignTime() ? null : QLPMPUEntityManager.createQuery(getQuery());
        return new RefreshTask(qlpm.QLPMApp.getApplication());
    }

    @Action
    public void newAccount () {
        NewCustomerDialog newCustomerDialog = new NewCustomerDialog(this, true);
        newCustomerDialog.setCallBack(this);
        newCustomerDialog.setVisible(true);
    }

    @Action
    public void openCustomerView () {
        Customer c = customerList.get( masterTable.getSelectedRow());
        CustomerDetailView view = new CustomerDetailView(this, true, c);
        view.setVisible(true);

    }

    public void addNewAccount(Customer c) {
        customerList.add(c);

    }


    public void windowOpened(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void windowClosing(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void refreshWithoutTask () {

    }
    public void windowClosed(WindowEvent e) {
        //Task t = refreshMasterTable();
        //t.execute();
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void windowIconified(WindowEvent e) {
       // throw new UnsupportedOperationException("Not supported yet.");
    }

    public void windowDeiconified(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void windowActivated(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void windowDeactivated(WindowEvent e) {
       // throw new UnsupportedOperationException("Not supported yet.");
    }

    public void newCustomerCreated(Customer c) {
        QLPMPUEntityManager.persist(c);
        customerList.add(c);
        int row = customerList.size()-1;
        masterTable.setRowSelectionInterval(row, row);
        //masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    private class RefreshTask extends Task {
        RefreshTask(org.jdesktop.application.Application app) {
            super(app);
        }
        @SuppressWarnings("unchecked")
        @Override protected Void doInBackground() {
            try {
                setProgress(0, 0, 4);
                setMessage("Rolling back the current changes...");
                setProgress(1, 0, 4);
                QLPMPUEntityManager.getTransaction().rollback();
                //Thread.sleep(1000L); // remove for real app
                setProgress(2, 0, 4);
            }
            catch (java.lang.IllegalStateException e) {

            }
            setMessage("Starting a new transaction...");
            QLPMPUEntityManager.getTransaction().begin();
            //Thread.sleep(500L); // remove for real app
            setProgress(3, 0, 4);

            setMessage("Fetching new data...");
            java.util.Collection data = customerQuery.getResultList();
            for (Object entity : data) {
                QLPMPUEntityManager.refresh(entity);
            }
            //Thread.sleep(1300L); // remove for real app
            setProgress(4, 0, 4);

            //Thread.sleep(150L); // remove for real app
            customerList.clear();
            customerList.addAll(data);
            masterTable.updateUI();
            return null;
        }
        @Override protected void finished() {
            setMessage("Done.");
            //setSaveNeeded(false);
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        QLPMPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("QLPMPU").createEntityManager();
        customerQuery = java.beans.Beans.isDesignTime() ? null : QLPMPUEntityManager.createQuery(getQuery());
        customerList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : customerQuery.getResultList();
        mainPanel = new javax.swing.JPanel();
        noteLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taNote = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        deleteButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        tfPhone = new javax.swing.JTextField();
        tfTicket = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnNewAccount = new javax.swing.JButton();
        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        btnNext = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        mainPanel.setName("mainPanel"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(qlpm.QLPMApp.class).getContext().getResourceMap(CustomerView.class);
        noteLabel.setText(resourceMap.getString("noteLabel.text")); // NOI18N
        noteLabel.setName("noteLabel"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        taNote.setFont(resourceMap.getFont("taNote.font")); // NOI18N
        taNote.setLineWrap(true);
        taNote.setRows(5);
        taNote.setMaximumSize(new java.awt.Dimension(600, 2147483647));
        taNote.setName("taNote"); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.note}"), taNote, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jScrollPane1.setViewportView(taNote);

        jPanel1.setName("jPanel1"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(qlpm.QLPMApp.class).getContext().getActionMap(CustomerView.class, this);
        deleteButton.setAction(actionMap.get("deleteRecord")); // NOI18N
        deleteButton.setText(resourceMap.getString("deleteButton.text")); // NOI18N
        deleteButton.setName("deleteButton"); // NOI18N

        saveButton.setAction(actionMap.get("save")); // NOI18N
        saveButton.setText(resourceMap.getString("saveButton.text")); // NOI18N
        saveButton.setName("saveButton"); // NOI18N

        newButton.setAction(actionMap.get("newRecord")); // NOI18N
        newButton.setText(resourceMap.getString("newButton.text")); // NOI18N
        newButton.setName("newButton"); // NOI18N

        jButton1.setAction(actionMap.get("openCustomerView")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(deleteButton)
                    .addComponent(newButton)
                    .addComponent(jButton1))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(noteLabel)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(noteLabel)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 564, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusMessageLabel)
                    .addComponent(statusAnimationLabel)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        jPanel2.setName("jPanel2"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        tfName.setName("tfName"); // NOI18N

        tfPhone.setName("tfPhone"); // NOI18N

        tfTicket.setName("tfTicket"); // NOI18N

        btnSearch.setAction(actionMap.get("refreshMasterTable")); // NOI18N
        btnSearch.setText(resourceMap.getString("btnSearch.text")); // NOI18N
        btnSearch.setName("btnSearch"); // NOI18N

        btnNewAccount.setAction(actionMap.get("newAccount")); // NOI18N
        btnNewAccount.setText(resourceMap.getString("btnNewAccount.text")); // NOI18N
        btnNewAccount.setName("btnNewAccount"); // NOI18N

        masterScrollPane.setName("masterScrollPane"); // NOI18N

        masterTable.setName("masterTable"); // NOI18N

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, customerList, masterTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${userId}"));
        columnBinding.setColumnName("User Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fullname}"));
        columnBinding.setColumnName("Fullname");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${age}"));
        columnBinding.setColumnName("Age");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${gender}"));
        columnBinding.setColumnName("Gender");
        columnBinding.setColumnClass(Short.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${address}"));
        columnBinding.setColumnName("Address");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${phone}"));
        columnBinding.setColumnName("Phone");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dateCreate}"));
        columnBinding.setColumnName("Date Create");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        masterScrollPane.setViewportView(masterTable);
        masterTable.getColumnModel().getColumn(0).setMinWidth(20);
        masterTable.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("masterTable.columnModel.title0")); // NOI18N
        masterTable.getColumnModel().getColumn(1).setMinWidth(120);
        masterTable.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("masterTable.columnModel.title1")); // NOI18N
        masterTable.getColumnModel().getColumn(2).setMinWidth(30);
        masterTable.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("masterTable.columnModel.title2")); // NOI18N
        masterTable.getColumnModel().getColumn(3).setMinWidth(20);
        masterTable.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("masterTable.columnModel.title3")); // NOI18N
        masterTable.getColumnModel().getColumn(4).setMinWidth(100);
        masterTable.getColumnModel().getColumn(4).setHeaderValue(resourceMap.getString("masterTable.columnModel.title4")); // NOI18N
        masterTable.getColumnModel().getColumn(5).setMinWidth(50);
        masterTable.getColumnModel().getColumn(5).setHeaderValue(resourceMap.getString("masterTable.columnModel.title5")); // NOI18N
        masterTable.getColumnModel().getColumn(6).setHeaderValue(resourceMap.getString("masterTable.columnModel.title6")); // NOI18N

        btnNext.setText(resourceMap.getString("btnNext.text")); // NOI18N
        btnNext.setName("btnNext"); // NOI18N

        btnBack.setText(resourceMap.getString("btnBack.text")); // NOI18N
        btnBack.setName("btnBack"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfTicket, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(tfName, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(tfPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNewAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(341, 341, 341))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(18, 18, 18)
                        .addComponent(btnNext)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnNewAccount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnNext)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(statusPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(statusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager QLPMPUEntityManager;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNewAccount;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnSearch;
    private java.util.List<entities.Customer> customerList;
    private javax.persistence.Query customerQuery;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JButton newButton;
    private javax.swing.JLabel noteLabel;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JTextArea taNote;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfPhone;
    private javax.swing.JTextField tfTicket;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

}
