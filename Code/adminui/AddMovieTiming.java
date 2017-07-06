package adminui;

import java.beans.PropertyVetoException;
import java.util.List;
import javax.swing.JOptionPane;
import model.DAO.movieinfoDAO;
import model.DAO.movietimingDAO;
import model.DAO.screeninfoDAO;
import model.to.movieinfoTO;
import model.to.movietimingTO;
import model.to.screeninfoTO;
import java.sql.Time;
import javax.swing.JInternalFrame;

/**
 *
 * @author Shubham Sethi
 */
public class AddMovieTiming extends javax.swing.JInternalFrame {

    TimeInfo[] alltimes;
    int timingid;

    public AddMovieTiming(movietimingTO cit) {
        this();
        if (cit != null) {
            timingid = cit.getTimingID();
            for(int i = 1; i < jcbMovie.getItemCount(); i++){
                movieinfoTO mit = (movieinfoTO)jcbMovie.getItemAt(i);
                if(mit.getMovieID() == cit.getMovieID()){
                    jcbMovie.setSelectedIndex(i);
                    break;
                }
            }
            jcbMovie.setSelectedItem(cit.getMoviename());
            for(int i = 1; i < jcbScreen.getItemCount(); i++){
                screeninfoTO mit = (screeninfoTO)jcbScreen.getItemAt(i);
                if(mit.getScreenID().equals(cit.getScreenID())){
                    jcbScreen.setSelectedIndex(i);
                    break;
                }
            }
            jcbScreen.setSelectedItem(cit.getScreenname());
            jcbStartTime.setSelectedItem(cit.getStarttime());
            jcbEndTime.setSelectedItem(cit.getEndtime());
            setTitle("Update Movie Timing");
            btnAddMovieTiming.setText("Update");
        }
    }

    public AddMovieTiming() {
        initComponents();
        getRootPane().setDefaultButton(btnAddMovieTiming);
        jcbMovie.removeAllItems();
        jcbMovie.addItem("Choose Movie");
        jcbScreen.removeAllItems();
        jcbScreen.addItem("Choose Screen");
        jcbStartTime.removeAllItems();
        jcbStartTime.addItem("Choose Start Time");
        jcbEndTime.removeAllItems();
        jcbEndTime.addItem("Choose End Time");
        alltimes = TimeInfo.values();
        for (int i = 0; i < alltimes.length - 13; i++) {
            jcbStartTime.addItem(alltimes[i].getTiming());
        }
        List<movieinfoTO> movies = new movieinfoDAO().getAllRecord();
        if (movies != null && movies.size() > 0) {
            for (movieinfoTO ssit : movies) {
                jcbMovie.addItem(ssit);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAddMovieTiming = new javax.swing.JButton();
        jcbMovie = new javax.swing.JComboBox<>();
        jcbScreen = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jcbStartTime = new javax.swing.JComboBox<>();
        jcbEndTime = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setTitle("Add Movie Timing");

        btnAddMovieTiming.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnAddMovieTiming.setText("Add Movie Timing");
        btnAddMovieTiming.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMovieTimingActionPerformed(evt);
            }
        });

        jcbMovie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbMovie.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbMovieItemStateChanged(evt);
            }
        });

        jcbScreen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Select Movie");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Select Start Time");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Select Screen");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Select End Time");

        jcbStartTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbStartTime.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbStartTimeItemStateChanged(evt);
            }
        });

        jcbEndTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jcbMovie, javax.swing.GroupLayout.Alignment.TRAILING, 0, 177, Short.MAX_VALUE)
                    .addComponent(jcbScreen, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcbStartTime, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcbEndTime, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(98, 98, 98))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAddMovieTiming, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(191, 191, 191))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbMovie, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbScreen, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(btnAddMovieTiming, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbMovieItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbMovieItemStateChanged
        jcbScreen.removeAllItems();
        jcbScreen.addItem("Choose Screen");
        if (!(jcbMovie.getSelectedIndex() == 0)) {
            List<screeninfoTO> seats = new screeninfoDAO().getAllRecord();
            if (seats != null && seats.size() > 0) {
                for (screeninfoTO sit : seats) {
                    jcbScreen.addItem(sit);
                }
            }
        }
    }//GEN-LAST:event_jcbMovieItemStateChanged

    private void btnAddMovieTimingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMovieTimingActionPerformed
        String message = "";
        boolean allvalid = true;
        if (jcbMovie.getSelectedIndex() == 0) {
            message += "Please Choose Any Movie\n\n";
            allvalid = false;
        }
        if (jcbScreen.getSelectedIndex() == 0) {
            message += "Please Choose Any Screen\n\n";
            allvalid = false;
        }
        if (jcbStartTime.getSelectedIndex() == 0) {
            message += "Please Choose Start Time\n\n";
            allvalid = false;
        }
        if (jcbEndTime.getSelectedIndex() == 0) {
            message += "Please Choose End Time";
            allvalid = false;
        }

        if (allvalid) {
            movieinfoTO cit = (movieinfoTO) jcbMovie.getSelectedItem();
            screeninfoTO sit = (screeninfoTO) jcbScreen.getSelectedItem();
            movietimingTO ssi = new movietimingTO();
            Time st, et;
            st = (Time) jcbStartTime.getSelectedItem();
            et = (Time) jcbEndTime.getSelectedItem();
            ssi.setMovieID(cit.getMovieID());
            ssi.setScreenID(sit.getScreenID());
            ssi.setStarttime(st);
            ssi.setEndtime(et);
            movietimingDAO action = new movietimingDAO();
            if (btnAddMovieTiming.getText().contains("Add")) {
                if (action.insertRecord(ssi)) {
                    message = "The Screen is Assigned with the Selected Movie at the Selected time";
                    jcbMovie.setSelectedIndex(0);
                    jcbStartTime.setSelectedIndex(0);
                    JInternalFrame[] jif = getDesktopPane().getAllFrames();
                    if (jif != null) {
                        for (JInternalFrame jf : jif) {
                            if (jf instanceof ViewMovieTiming) {
                                ViewMovieTiming vci = (ViewMovieTiming) jf;
                                vci.bindTimingTable();
                                break;
                            }
                        }
                    }
                } else {

                    message = action.getErrormessgae();
                }
            } else if (btnAddMovieTiming.getText().contains("Update")) {
                ssi.setTimingID(timingid);
                if (action.updateRecord(ssi)) {
                    message = "Movie Timing is Updated in System";
                    jcbMovie.setSelectedIndex(0);
                    jcbStartTime.setSelectedIndex(0);
                } else {
                    message = action.getErrormessgae();
                }
                ViewMovieTiming vci = new ViewMovieTiming();
                vci.setVisible(true);
                getDesktopPane().add(vci);
                try {
                    vci.setSelected(true);
                } catch (PropertyVetoException ex) {
                }
                dispose();
            }
        }
        JOptionPane.showMessageDialog(this, message);
    }//GEN-LAST:event_btnAddMovieTimingActionPerformed

    private void jcbStartTimeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbStartTimeItemStateChanged
        jcbEndTime.removeAllItems();
        jcbEndTime.addItem("Choose End Time");
        if (jcbStartTime.getSelectedIndex() > 0) {
            int startindex = jcbStartTime.getSelectedIndex() + 3;
            int endindex = startindex + 11;
            if (startindex < alltimes.length) {
                if (endindex > alltimes.length) {
                    endindex = alltimes.length;
                }
                for (int index = startindex; index < endindex; index++) {
                    jcbEndTime.addItem(alltimes[index].getTiming());
                }
            }

        }
    }//GEN-LAST:event_jcbStartTimeItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddMovieTiming;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox<Object> jcbEndTime;
    private javax.swing.JComboBox<Object> jcbMovie;
    private javax.swing.JComboBox<Object> jcbScreen;
    private javax.swing.JComboBox<Object> jcbStartTime;
    // End of variables declaration//GEN-END:variables
}
