package adminui;

import java.beans.PropertyVetoException;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import model.DAO.seattypeDAO;
import model.to.seattypeTO;
import operations.Validations;

/**
 *
 * @author Shubham Sethi
 */
public class AddSeatType extends javax.swing.JInternalFrame {

    int seat;

    public AddSeatType() {
        initComponents();
        getRootPane().setDefaultButton(btnAddSeatType);
    }

    public AddSeatType(seattypeTO cit) {
        this();
        if (cit != null) {
            seat = cit.getTypeID();
            jtfSeatType.setText(cit.getTypename());
            jtfCharges.setText(String.valueOf(cit.getCharges()));
            setTitle("Update Seat Type Information");
            btnAddSeatType.setText("Update");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAddSeatType = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfSeatType = new javax.swing.JTextField();
        jtfCharges = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Add Seat Type");

        btnAddSeatType.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnAddSeatType.setText("Add New Seat Type");
        btnAddSeatType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSeatTypeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Enter Seat Type Name");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Enter Seat Charges");

        jtfSeatType.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jtfCharges.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jtfCharges.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfChargesKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfCharges, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(63, 63, 63)
                        .addComponent(jtfSeatType, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(181, Short.MAX_VALUE)
                .addComponent(btnAddSeatType, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfSeatType, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfCharges, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addComponent(btnAddSeatType, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddSeatTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSeatTypeActionPerformed
        String seattype = jtfSeatType.getText().trim();
        String charges = jtfCharges.getText().trim();
        boolean allvalid = true;
        String message = "";
        if (Validations.isEmpty(seattype)) {
            message+= "Please Provide Seat Name\n\n";
            allvalid = false;
        }
        if(Validations.isEmpty(charges))
        {
            message+="Please Provide Charges";
            allvalid = false;
        }
        if (allvalid) {
            int charge = Integer.parseInt(charges);
            if (charge > 0) {
                seattypeTO stt = new seattypeTO();
                stt.setTypename(seattype);
                stt.setCharges(charge);
                seattypeDAO action = new seattypeDAO();
                if (btnAddSeatType.getText().contains("Add")) {
                    if (action.insertRecord(stt)) {
                        message = "New Seat Type is Added in system";
                        jtfCharges.setText("");
                        jtfSeatType.setText("");
                        JInternalFrame[] jif = getDesktopPane().getAllFrames();
                        if (jif != null) {
                            for (JInternalFrame jf : jif) {
                                if (jf instanceof ViewSeatType) {
                                    ViewSeatType vci = (ViewSeatType) jf;
                                    vci.bindSeatTable();
                                    break;
                                }
                            }
                        }
                    } else {
                        message = action.getErrormessgae();
                    }
                } else if (btnAddSeatType.getText().contains("Update")) {
                    stt.setTypeID(seat);
                    if (action.updateRecord(stt)) {
                        message = "Seat Type is Updated in System";
                        jtfCharges.setText("");
                        jtfSeatType.setText("");
                    } else {
                        message = action.getErrormessgae();
                    }
                    ViewSeatType vci = new ViewSeatType();
                    vci.setVisible(true);
                    getDesktopPane().add(vci);
                    try {
                        vci.setSelected(true);
                    } catch (PropertyVetoException ex) {
                    }
                    dispose();
                }
            }
        }
        JOptionPane.showMessageDialog(this, message);
    }//GEN-LAST:event_btnAddSeatTypeActionPerformed

    private void jtfChargesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfChargesKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfChargesKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddSeatType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jtfCharges;
    private javax.swing.JTextField jtfSeatType;
    // End of variables declaration//GEN-END:variables
}