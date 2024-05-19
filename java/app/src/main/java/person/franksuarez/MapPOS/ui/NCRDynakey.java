/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/AWTForms/Frame.java to edit this template
 */
package person.franksuarez.MapPOS.ui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import person.franksuarez.MapPOS.exception.InvalidFormat;
import person.franksuarez.MapPOS.model.PLUList;
import person.franksuarez.MapPOS.model.POS;
import person.franksuarez.MapPOS.model.UPC;
import person.franksuarez.MapPOS.model.UPCA;

/**
 *
 * @author franksuarez
 */
public class NCRDynakey extends java.awt.Frame {

    private POS p = new POS();
    private DefaultListModel<String> transactionListModel = new DefaultListModel<>();

    // called when submitting user input
    private void user_submitUserInput() {

        String userInput = this.txtUserInput.getText();
        String entry = userInput + ": ";
        UPCA u = new UPCA();

        u.fromString(userInput);
        try {
            u.generateDigitOnlyData();
        } catch (InvalidFormat ex) {
            Logger.getLogger(NCRDynakey.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (u.isValid()) {
            entry += "Valid";
        } else {
            entry += "Invalid";
        }

        this.transactionListModel.addElement(entry);
        this.txtUserInput.setText("");

    }

    /**
     * Creates new form NCRDynakey
     */
    public NCRDynakey() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlLeft = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        txtUserInput = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        pnlMid = new javax.swing.JPanel();
        btnDyn1 = new javax.swing.JButton();
        btnDyn2 = new javax.swing.JButton();
        btnDyn3 = new javax.swing.JButton();
        btnDyn4 = new javax.swing.JButton();
        btnDyn5 = new javax.swing.JButton();
        btnDyn6 = new javax.swing.JButton();
        btnDyn7 = new javax.swing.JButton();
        btnDyn8 = new javax.swing.JButton();
        dynLabel1 = new javax.swing.JLabel();
        dynLabel2 = new javax.swing.JLabel();
        dynLabel3 = new javax.swing.JLabel();
        dynLabel4 = new javax.swing.JLabel();
        dynLabel5 = new javax.swing.JLabel();
        dynLabel6 = new javax.swing.JLabel();
        dynLabel7 = new javax.swing.JLabel();
        dynLabel8 = new javax.swing.JLabel();
        pnlRight = new javax.swing.JPanel();
        pnlArrowButtons = new javax.swing.JPanel();
        btnUp = new javax.swing.JButton();
        btnLeft = new javax.swing.JButton();
        btnRight = new javax.swing.JButton();
        btnDown = new javax.swing.JButton();
        pnlButtons = new javax.swing.JPanel();
        pnlMainButtons = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        pnlNumbers = new javax.swing.JPanel();
        btnNum7 = new javax.swing.JButton();
        btnNum8 = new javax.swing.JButton();
        btnNum9 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        btnNum4 = new javax.swing.JButton();
        btnNum5 = new javax.swing.JButton();
        btnNum6 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        btnNum1 = new javax.swing.JButton();
        btnNum2 = new javax.swing.JButton();
        btnNum3 = new javax.swing.JButton();
        btnEnter = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        btnNum0 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1024, 768));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("POS");

        txtUserInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserInputActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(600, 600));
        jScrollPane1.setRowHeaderView(null);

        jList1.setModel(this.transactionListModel);
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setVisibleRowCount(10);
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout pnlLeftLayout = new javax.swing.GroupLayout(pnlLeft);
        pnlLeft.setLayout(pnlLeftLayout);
        pnlLeftLayout.setHorizontalGroup(
            pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
            .addComponent(txtUserInput)
        );
        pnlLeftLayout.setVerticalGroup(
            pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLeftLayout.createSequentialGroup()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUserInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlMid.setLayout(new java.awt.GridBagLayout());

        btnDyn1.setMaximumSize(new java.awt.Dimension(100, 67));
        btnDyn1.setMinimumSize(new java.awt.Dimension(100, 67));
        btnDyn1.setPreferredSize(new java.awt.Dimension(100, 67));
        btnDyn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDyn1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        pnlMid.add(btnDyn1, gridBagConstraints);

        btnDyn2.setMaximumSize(new java.awt.Dimension(100, 67));
        btnDyn2.setMinimumSize(new java.awt.Dimension(100, 67));
        btnDyn2.setPreferredSize(new java.awt.Dimension(100, 67));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        pnlMid.add(btnDyn2, gridBagConstraints);

        btnDyn3.setMaximumSize(new java.awt.Dimension(100, 67));
        btnDyn3.setMinimumSize(new java.awt.Dimension(100, 67));
        btnDyn3.setPreferredSize(new java.awt.Dimension(100, 67));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        pnlMid.add(btnDyn3, gridBagConstraints);

        btnDyn4.setMaximumSize(new java.awt.Dimension(100, 67));
        btnDyn4.setMinimumSize(new java.awt.Dimension(100, 67));
        btnDyn4.setPreferredSize(new java.awt.Dimension(100, 67));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        pnlMid.add(btnDyn4, gridBagConstraints);

        btnDyn5.setMaximumSize(new java.awt.Dimension(100, 67));
        btnDyn5.setMinimumSize(new java.awt.Dimension(100, 67));
        btnDyn5.setPreferredSize(new java.awt.Dimension(100, 67));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        pnlMid.add(btnDyn5, gridBagConstraints);

        btnDyn6.setMaximumSize(new java.awt.Dimension(100, 67));
        btnDyn6.setMinimumSize(new java.awt.Dimension(100, 67));
        btnDyn6.setPreferredSize(new java.awt.Dimension(100, 67));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        pnlMid.add(btnDyn6, gridBagConstraints);

        btnDyn7.setMaximumSize(new java.awt.Dimension(100, 67));
        btnDyn7.setMinimumSize(new java.awt.Dimension(100, 67));
        btnDyn7.setPreferredSize(new java.awt.Dimension(100, 67));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        pnlMid.add(btnDyn7, gridBagConstraints);

        btnDyn8.setMaximumSize(new java.awt.Dimension(100, 67));
        btnDyn8.setMinimumSize(new java.awt.Dimension(100, 67));
        btnDyn8.setPreferredSize(new java.awt.Dimension(100, 67));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        pnlMid.add(btnDyn8, gridBagConstraints);

        dynLabel1.setText("Sign Out");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pnlMid.add(dynLabel1, gridBagConstraints);

        dynLabel2.setText("[Blank]");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pnlMid.add(dynLabel2, gridBagConstraints);

        dynLabel3.setText("[Blank]");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pnlMid.add(dynLabel3, gridBagConstraints);

        dynLabel4.setText("[Blank]");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pnlMid.add(dynLabel4, gridBagConstraints);

        dynLabel5.setText("[Blank]");
        dynLabel5.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pnlMid.add(dynLabel5, gridBagConstraints);

        dynLabel6.setText("[Blank]");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pnlMid.add(dynLabel6, gridBagConstraints);

        dynLabel7.setText("[Blank]");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pnlMid.add(dynLabel7, gridBagConstraints);

        dynLabel8.setText("[Blank]");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pnlMid.add(dynLabel8, gridBagConstraints);

        pnlRight.setLayout(new java.awt.GridBagLayout());

        pnlArrowButtons.setMinimumSize(new java.awt.Dimension(200, 200));
        pnlArrowButtons.setPreferredSize(new java.awt.Dimension(200, 200));
        pnlArrowButtons.setLayout(new java.awt.GridBagLayout());

        btnUp.setText("^");
        btnUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 20;
        pnlArrowButtons.add(btnUp, gridBagConstraints);

        btnLeft.setText("<");
        btnLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeftActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 20;
        pnlArrowButtons.add(btnLeft, gridBagConstraints);

        btnRight.setText(">");
        btnRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRightActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 20;
        pnlArrowButtons.add(btnRight, gridBagConstraints);

        btnDown.setText("V");
        btnDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 20;
        pnlArrowButtons.add(btnDown, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        pnlRight.add(pnlArrowButtons, gridBagConstraints);

        pnlButtons.setLayout(new java.awt.GridBagLayout());

        pnlMainButtons.setLayout(new java.awt.GridBagLayout());

        jButton1.setText("Item");
        jButton1.setMaximumSize(new java.awt.Dimension(100, 67));
        jButton1.setMinimumSize(new java.awt.Dimension(100, 67));
        jButton1.setPreferredSize(new java.awt.Dimension(100, 67));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        pnlMainButtons.add(jButton1, gridBagConstraints);

        jButton2.setText("Transaction");
        jButton2.setMaximumSize(new java.awt.Dimension(100, 67));
        jButton2.setMinimumSize(new java.awt.Dimension(100, 67));
        jButton2.setPreferredSize(new java.awt.Dimension(100, 67));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        pnlMainButtons.add(jButton2, gridBagConstraints);

        jButton3.setText("Misc");
        jButton3.setMaximumSize(new java.awt.Dimension(100, 67));
        jButton3.setMinimumSize(new java.awt.Dimension(100, 67));
        jButton3.setPreferredSize(new java.awt.Dimension(100, 67));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        pnlMainButtons.add(jButton3, gridBagConstraints);

        jButton4.setText("PLU");
        jButton4.setMaximumSize(new java.awt.Dimension(100, 67));
        jButton4.setMinimumSize(new java.awt.Dimension(100, 67));
        jButton4.setPreferredSize(new java.awt.Dimension(100, 67));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        pnlMainButtons.add(jButton4, gridBagConstraints);

        jButton5.setMaximumSize(new java.awt.Dimension(100, 67));
        jButton5.setMinimumSize(new java.awt.Dimension(100, 67));
        jButton5.setPreferredSize(new java.awt.Dimension(100, 67));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        pnlMainButtons.add(jButton5, gridBagConstraints);

        jButton6.setMaximumSize(new java.awt.Dimension(100, 67));
        jButton6.setMinimumSize(new java.awt.Dimension(100, 67));
        jButton6.setPreferredSize(new java.awt.Dimension(100, 67));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        pnlMainButtons.add(jButton6, gridBagConstraints);

        btnClear.setText("Clear");
        btnClear.setMaximumSize(new java.awt.Dimension(100, 67));
        btnClear.setMinimumSize(new java.awt.Dimension(100, 67));
        btnClear.setPreferredSize(new java.awt.Dimension(100, 67));
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        pnlMainButtons.add(btnClear, gridBagConstraints);

        jButton8.setMaximumSize(new java.awt.Dimension(100, 67));
        jButton8.setMinimumSize(new java.awt.Dimension(100, 67));
        jButton8.setPreferredSize(new java.awt.Dimension(100, 67));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        pnlMainButtons.add(jButton8, gridBagConstraints);

        jButton9.setMaximumSize(new java.awt.Dimension(100, 67));
        jButton9.setMinimumSize(new java.awt.Dimension(100, 67));
        jButton9.setPreferredSize(new java.awt.Dimension(100, 67));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        pnlMainButtons.add(jButton9, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        pnlButtons.add(pnlMainButtons, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlRight.add(pnlButtons, gridBagConstraints);

        pnlNumbers.setLayout(new java.awt.GridBagLayout());

        btnNum7.setText("7");
        btnNum7.setMaximumSize(new java.awt.Dimension(67, 67));
        btnNum7.setMinimumSize(new java.awt.Dimension(67, 67));
        btnNum7.setPreferredSize(new java.awt.Dimension(67, 67));
        btnNum7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum7ActionPerformed(evt);
            }
        });
        pnlNumbers.add(btnNum7, new java.awt.GridBagConstraints());

        btnNum8.setText("8");
        btnNum8.setMaximumSize(new java.awt.Dimension(67, 67));
        btnNum8.setMinimumSize(new java.awt.Dimension(67, 67));
        btnNum8.setPreferredSize(new java.awt.Dimension(67, 67));
        btnNum8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum8ActionPerformed(evt);
            }
        });
        pnlNumbers.add(btnNum8, new java.awt.GridBagConstraints());

        btnNum9.setText("9");
        btnNum9.setMaximumSize(new java.awt.Dimension(67, 67));
        btnNum9.setMinimumSize(new java.awt.Dimension(67, 67));
        btnNum9.setPreferredSize(new java.awt.Dimension(67, 67));
        btnNum9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum9ActionPerformed(evt);
            }
        });
        pnlNumbers.add(btnNum9, new java.awt.GridBagConstraints());

        jButton14.setMaximumSize(new java.awt.Dimension(100, 67));
        jButton14.setMinimumSize(new java.awt.Dimension(100, 67));
        jButton14.setPreferredSize(new java.awt.Dimension(100, 67));
        pnlNumbers.add(jButton14, new java.awt.GridBagConstraints());

        btnNum4.setText("4");
        btnNum4.setMaximumSize(new java.awt.Dimension(67, 67));
        btnNum4.setMinimumSize(new java.awt.Dimension(67, 67));
        btnNum4.setPreferredSize(new java.awt.Dimension(67, 67));
        btnNum4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        pnlNumbers.add(btnNum4, gridBagConstraints);

        btnNum5.setText("5");
        btnNum5.setMaximumSize(new java.awt.Dimension(67, 67));
        btnNum5.setMinimumSize(new java.awt.Dimension(67, 67));
        btnNum5.setPreferredSize(new java.awt.Dimension(67, 67));
        btnNum5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        pnlNumbers.add(btnNum5, gridBagConstraints);

        btnNum6.setText("6");
        btnNum6.setMaximumSize(new java.awt.Dimension(67, 67));
        btnNum6.setMinimumSize(new java.awt.Dimension(67, 67));
        btnNum6.setPreferredSize(new java.awt.Dimension(67, 67));
        btnNum6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum6ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        pnlNumbers.add(btnNum6, gridBagConstraints);

        jButton17.setMaximumSize(new java.awt.Dimension(100, 67));
        jButton17.setMinimumSize(new java.awt.Dimension(100, 67));
        jButton17.setPreferredSize(new java.awt.Dimension(100, 67));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        pnlNumbers.add(jButton17, gridBagConstraints);

        btnNum1.setText("1");
        btnNum1.setMaximumSize(new java.awt.Dimension(67, 67));
        btnNum1.setMinimumSize(new java.awt.Dimension(67, 67));
        btnNum1.setPreferredSize(new java.awt.Dimension(67, 67));
        btnNum1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        pnlNumbers.add(btnNum1, gridBagConstraints);

        btnNum2.setText("2");
        btnNum2.setMaximumSize(new java.awt.Dimension(67, 67));
        btnNum2.setMinimumSize(new java.awt.Dimension(67, 67));
        btnNum2.setPreferredSize(new java.awt.Dimension(67, 67));
        btnNum2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        pnlNumbers.add(btnNum2, gridBagConstraints);

        btnNum3.setText("3");
        btnNum3.setMaximumSize(new java.awt.Dimension(67, 67));
        btnNum3.setMinimumSize(new java.awt.Dimension(67, 67));
        btnNum3.setPreferredSize(new java.awt.Dimension(67, 67));
        btnNum3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        pnlNumbers.add(btnNum3, gridBagConstraints);

        btnEnter.setText("Enter");
        btnEnter.setMaximumSize(new java.awt.Dimension(100, 134));
        btnEnter.setMinimumSize(new java.awt.Dimension(100, 134));
        btnEnter.setPreferredSize(new java.awt.Dimension(100, 134));
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        pnlNumbers.add(btnEnter, gridBagConstraints);

        jButton22.setText(".");
        jButton22.setMaximumSize(new java.awt.Dimension(67, 67));
        jButton22.setMinimumSize(new java.awt.Dimension(67, 67));
        jButton22.setPreferredSize(new java.awt.Dimension(67, 67));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        pnlNumbers.add(jButton22, gridBagConstraints);

        btnNum0.setText("0");
        btnNum0.setMaximumSize(new java.awt.Dimension(134, 67));
        btnNum0.setMinimumSize(new java.awt.Dimension(134, 67));
        btnNum0.setPreferredSize(new java.awt.Dimension(134, 67));
        btnNum0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum0ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        pnlNumbers.add(btnNum0, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        pnlRight.add(pnlNumbers, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(pnlLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlMid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(144, 144, 144))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(pnlLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(5, 5, 5))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void btnRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRightActionPerformed

    private void btnLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeftActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLeftActionPerformed

    private void btnUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpActionPerformed
        // -1 if nothing selected
        int selectedIndex = this.jList1.getSelectedIndex();
        if (selectedIndex > 0) {
            this.jList1.setSelectedIndex(selectedIndex - 1);
        } 
        
        this.jList1.ensureIndexIsVisible(selectedIndex-1);
        //this.txtUserInput.setText(String.valueOf(selectedIndex));
    }//GEN-LAST:event_btnUpActionPerformed

    private void btnDyn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDyn1ActionPerformed


    }//GEN-LAST:event_btnDyn1ActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        this.pack();
    }//GEN-LAST:event_formComponentShown

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:

        this.txtUserInput.setText("");

    }//GEN-LAST:event_btnClearActionPerformed

    private void btnNum0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum0ActionPerformed
        // TODO add your handling code here:

        this.txtUserInput.setText(this.txtUserInput.getText() + "0");

    }//GEN-LAST:event_btnNum0ActionPerformed

    private void btnNum1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum1ActionPerformed
        // TODO add your handling code here:

        this.txtUserInput.setText(this.txtUserInput.getText() + "1");
    }//GEN-LAST:event_btnNum1ActionPerformed

    private void btnNum2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum2ActionPerformed
        // TODO add your handling code here:
        this.txtUserInput.setText(this.txtUserInput.getText() + "2");
    }//GEN-LAST:event_btnNum2ActionPerformed

    private void btnNum3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum3ActionPerformed
        // TODO add your handling code here:
        this.txtUserInput.setText(this.txtUserInput.getText() + "3");
    }//GEN-LAST:event_btnNum3ActionPerformed

    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed
        // TODO add your handling code here:
        this.transactionListModel.addElement(this.txtUserInput.getText());
        this.txtUserInput.setText("");

    }//GEN-LAST:event_btnEnterActionPerformed

    private void txtUserInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserInputActionPerformed
        user_submitUserInput();
    }//GEN-LAST:event_txtUserInputActionPerformed

    private void btnNum4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum4ActionPerformed
        // TODO add your handling code here:
        this.txtUserInput.setText(this.txtUserInput.getText() + "4");


    }//GEN-LAST:event_btnNum4ActionPerformed

    private void btnNum5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum5ActionPerformed
        // TODO add your handling code here:
        this.txtUserInput.setText(this.txtUserInput.getText() + "5");
    }//GEN-LAST:event_btnNum5ActionPerformed

    private void btnNum6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum6ActionPerformed
        // TODO add your handling code here:
        this.txtUserInput.setText(this.txtUserInput.getText() + "6");
    }//GEN-LAST:event_btnNum6ActionPerformed

    private void btnNum7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum7ActionPerformed
        // TODO add your handling code here:
        this.txtUserInput.setText(this.txtUserInput.getText() + "7");
    }//GEN-LAST:event_btnNum7ActionPerformed

    private void btnNum8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum8ActionPerformed
        // TODO add your handling code here:
        this.txtUserInput.setText(this.txtUserInput.getText() + "8");
    }//GEN-LAST:event_btnNum8ActionPerformed

    private void btnNum9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum9ActionPerformed
        // TODO add your handling code here:
        this.txtUserInput.setText(this.txtUserInput.getText() + "9");
    }//GEN-LAST:event_btnNum9ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        PLUList plu_list = new PLUList();
        try {
            plu_list.loadFromCSVResource("plu.csv");
            
            
            for (int k: plu_list.keySet()) {
                this.transactionListModel.addElement(
                        String.format("%- 20d %s", k,plu_list.get(k))
                
                
                );
                
            }
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(NCRDynakey.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownActionPerformed
        // -1 if nothing selected
        int selectedIndex = this.jList1.getSelectedIndex();
        
        // check if at end of list
        // setSelectedIndex will not set an index past the end of the list
        this.jList1.setSelectedIndex(selectedIndex + 1);
        
        this.jList1.ensureIndexIsVisible(selectedIndex+1 );
        
        //this.txtUserInput.setText(String.valueOf(selectedIndex));
    }//GEN-LAST:event_btnDownActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                //new NCRDynakey().setVisible(true);
                NCRDynakey d = new NCRDynakey();
                d.setExtendedState(JFrame.MAXIMIZED_BOTH);
                
                d.setVisible(true);

            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDown;
    private javax.swing.JButton btnDyn1;
    private javax.swing.JButton btnDyn2;
    private javax.swing.JButton btnDyn3;
    private javax.swing.JButton btnDyn4;
    private javax.swing.JButton btnDyn5;
    private javax.swing.JButton btnDyn6;
    private javax.swing.JButton btnDyn7;
    private javax.swing.JButton btnDyn8;
    private javax.swing.JButton btnEnter;
    private javax.swing.JButton btnLeft;
    private javax.swing.JButton btnNum0;
    private javax.swing.JButton btnNum1;
    private javax.swing.JButton btnNum2;
    private javax.swing.JButton btnNum3;
    private javax.swing.JButton btnNum4;
    private javax.swing.JButton btnNum5;
    private javax.swing.JButton btnNum6;
    private javax.swing.JButton btnNum7;
    private javax.swing.JButton btnNum8;
    private javax.swing.JButton btnNum9;
    private javax.swing.JButton btnRight;
    private javax.swing.JButton btnUp;
    private javax.swing.JLabel dynLabel1;
    private javax.swing.JLabel dynLabel2;
    private javax.swing.JLabel dynLabel3;
    private javax.swing.JLabel dynLabel4;
    private javax.swing.JLabel dynLabel5;
    private javax.swing.JLabel dynLabel6;
    private javax.swing.JLabel dynLabel7;
    private javax.swing.JLabel dynLabel8;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlArrowButtons;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPanel pnlLeft;
    private javax.swing.JPanel pnlMainButtons;
    private javax.swing.JPanel pnlMid;
    private javax.swing.JPanel pnlNumbers;
    private javax.swing.JPanel pnlRight;
    private javax.swing.JTextField txtUserInput;
    // End of variables declaration//GEN-END:variables
}