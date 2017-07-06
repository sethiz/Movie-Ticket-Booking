package adminui;

import java.beans.PropertyVetoException;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import model.DAO.movieinfoDAO;
import model.to.movieinfoTO;
import operations.Validations;

/**
 *
 * @author Shubham Sethi
 */
public class AddMovieInfo extends javax.swing.JInternalFrame {

    int movie;

    public AddMovieInfo() {
        initComponents();
        getRootPane().setDefaultButton(btnAddMovieInfo);
    }

    public AddMovieInfo(movieinfoTO cit) {
        this();
        if (cit != null) {
            movie = cit.getMovieID();
            jtfMovieName.setText(cit.getMoviename());
            jtfMovieDesc.setText(cit.getDescription());
            cdpReleaseDate.setDate(cit.getReleasedate());
            cdpEndDate.setDate(cit.getEnddate());
            setTitle("Update Movie Information");
            btnAddMovieInfo.setText("Update");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfMovieName = new javax.swing.JTextField();
        btnAddMovieInfo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtfMovieDesc = new javax.swing.JTextArea();
        cdpReleaseDate = new adminui.CurrentDatePanel();
        cdpEndDate = new adminui.CurrentDatePanel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Add Movie Information");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Enter Movie Name");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Enter Movie Description");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Choose Release Date");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Chosse End Date");

        jtfMovieName.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        btnAddMovieInfo.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnAddMovieInfo.setText("Add Information");
        btnAddMovieInfo.setToolTipText("");
        btnAddMovieInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMovieInfoActionPerformed(evt);
            }
        });

        jtfMovieDesc.setColumns(20);
        jtfMovieDesc.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jtfMovieDesc.setRows(5);
        jScrollPane1.setViewportView(jtfMovieDesc);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(50, 50, 50)
                        .addComponent(cdpReleaseDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(76, 76, 76)
                        .addComponent(cdpEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAddMovieInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfMovieName, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfMovieName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(59, 59, 59)
                        .addComponent(jLabel4)
                        .addGap(121, 121, 121))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(cdpReleaseDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(cdpEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnAddMovieInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(12, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMovieInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMovieInfoActionPerformed
        String moviename = jtfMovieName.getText().trim();
        String description = jtfMovieDesc.getText().trim();
        String message = "";
        boolean allvalid = true;
        if (Validations.isEmpty(moviename)) {
            message+= "Please Provide Movie Name\n\n";
            allvalid = false;
        }
        if(Validations.isEmpty(description)){
            message+= "Please Provide Movie Description\n\n";
            allvalid = false;
        }
        if(cdpReleaseDate.getSelectedDate() == null){
            message+= "Please Choose Proper Release Date\n\n";
            allvalid = false;
        }
        if(cdpEndDate.getSelectedDate() == null){
            message+= "Please Choose Proper End Date";
            allvalid = false;
        }
        if (allvalid) {
            movieinfoTO mit = new movieinfoTO();
            mit.setMoviename(moviename);
            mit.setDescription(description);
            mit.setReleasedate(cdpReleaseDate.getSelectedDate());
            mit.setEnddate(cdpEndDate.getSelectedDate());
            movieinfoDAO action = new movieinfoDAO();
            if (btnAddMovieInfo.getText().contains("Add")) {
                if (action.insertRecord(mit)) {
                    message = "New Movie is added in System";
                    jtfMovieName.setText("");
                    jtfMovieDesc.setText("");
                    cdpReleaseDate.reset();
                    cdpEndDate.reset();
                    JInternalFrame[] jif = getDesktopPane().getAllFrames();
                    if (jif != null) {
                        for (JInternalFrame jf : jif) {
                            if (jf instanceof ViewMovieInfo) {
                                ViewMovieInfo vci = (ViewMovieInfo) jf;
                                vci.bindMovieTable();
                                break;
                            }
                        }
                    }
                } else {
                    message = action.getErrormessgae();
                }
            } else if (btnAddMovieInfo.getText().contains("Update")) {
                mit.setMovieID(movie);
                if (action.updateRecord(mit)) {
                    message = "Movie Details are Updated in System";
                    jtfMovieName.setText("");
                    jtfMovieDesc.setText("");
                    cdpReleaseDate.reset();
                    cdpEndDate.reset();
                } else {
                    message = action.getErrormessgae();
                }
                ViewMovieInfo vci = new ViewMovieInfo();
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
    }//GEN-LAST:event_btnAddMovieInfoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddMovieInfo;
    private adminui.CurrentDatePanel cdpEndDate;
    private adminui.CurrentDatePanel cdpReleaseDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jtfMovieDesc;
    private javax.swing.JTextField jtfMovieName;
    // End of variables declaration//GEN-END:variables
}
