package adminui;

import java.beans.PropertyVetoException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import model.DAO.DataConnection;

/**
 *
 * @author Shubham Sethi
 */
public class AdminMainScreen extends javax.swing.JFrame {

    public AdminMainScreen() {
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/adminui/s (6).png"));
            setIconImage(icon.getImage());
        } catch (Exception ex) {
        }
        initComponents();
        //setSize(1000, 500);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        deskPane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmiMenu1 = new javax.swing.JMenu();
        jmiNewMovie = new javax.swing.JMenuItem();
        jmiMovieInfo = new javax.swing.JMenuItem();
        jmiMenu2 = new javax.swing.JMenu();
        jmiNewScreen = new javax.swing.JMenuItem();
        jmiViewScreen = new javax.swing.JMenuItem();
        jmiMenu3 = new javax.swing.JMenu();
        jmiNewSeat = new javax.swing.JMenuItem();
        jmiViewSeat = new javax.swing.JMenuItem();
        jmiMenu5 = new javax.swing.JMenu();
        jmiNewScreenSeat = new javax.swing.JMenuItem();
        jmiViewScreenSeat = new javax.swing.JMenuItem();
        jmiMenu4 = new javax.swing.JMenu();
        jmiNewTiming = new javax.swing.JMenuItem();
        jmiViewTiming = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Movie Ticket Booking");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        javax.swing.GroupLayout deskPaneLayout = new javax.swing.GroupLayout(deskPane);
        deskPane.setLayout(deskPaneLayout);
        deskPaneLayout.setHorizontalGroup(
            deskPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1029, Short.MAX_VALUE)
        );
        deskPaneLayout.setVerticalGroup(
            deskPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 494, Short.MAX_VALUE)
        );

        getContentPane().add(deskPane, java.awt.BorderLayout.CENTER);

        jmiMenu1.setText("Movie Info");

        jmiNewMovie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/add.png"))); // NOI18N
        jmiNewMovie.setText("Add New Movie");
        jmiNewMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNewMovieActionPerformed(evt);
            }
        });
        jmiMenu1.add(jmiNewMovie);

        jmiMovieInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/view2.png"))); // NOI18N
        jmiMovieInfo.setText("View Movie Info");
        jmiMovieInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMovieInfoActionPerformed(evt);
            }
        });
        jmiMenu1.add(jmiMovieInfo);

        jMenuBar1.add(jmiMenu1);

        jmiMenu2.setText("Screen Info");

        jmiNewScreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/add.png"))); // NOI18N
        jmiNewScreen.setText("Add New Screen");
        jmiNewScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNewScreenActionPerformed(evt);
            }
        });
        jmiMenu2.add(jmiNewScreen);

        jmiViewScreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/view2.png"))); // NOI18N
        jmiViewScreen.setText("View Screen Info");
        jmiViewScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiViewScreenActionPerformed(evt);
            }
        });
        jmiMenu2.add(jmiViewScreen);

        jMenuBar1.add(jmiMenu2);

        jmiMenu3.setText("Seat Type");

        jmiNewSeat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/add.png"))); // NOI18N
        jmiNewSeat.setText("Add Seat Type");
        jmiNewSeat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNewSeatActionPerformed(evt);
            }
        });
        jmiMenu3.add(jmiNewSeat);

        jmiViewSeat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/view2.png"))); // NOI18N
        jmiViewSeat.setText("View Seat Types");
        jmiViewSeat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiViewSeatActionPerformed(evt);
            }
        });
        jmiMenu3.add(jmiViewSeat);

        jMenuBar1.add(jmiMenu3);

        jmiMenu5.setText("Screen Seat Info");

        jmiNewScreenSeat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/add.png"))); // NOI18N
        jmiNewScreenSeat.setText("Add Screen Seat");
        jmiNewScreenSeat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNewScreenSeatActionPerformed(evt);
            }
        });
        jmiMenu5.add(jmiNewScreenSeat);

        jmiViewScreenSeat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/view2.png"))); // NOI18N
        jmiViewScreenSeat.setText("View Screen Seats");
        jmiViewScreenSeat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiViewScreenSeatActionPerformed(evt);
            }
        });
        jmiMenu5.add(jmiViewScreenSeat);

        jMenuBar1.add(jmiMenu5);

        jmiMenu4.setText("Movie Timings");

        jmiNewTiming.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/add.png"))); // NOI18N
        jmiNewTiming.setText("Add Movie Timing");
        jmiNewTiming.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNewTimingActionPerformed(evt);
            }
        });
        jmiMenu4.add(jmiNewTiming);

        jmiViewTiming.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/view2.png"))); // NOI18N
        jmiViewTiming.setText("View Movie Timings");
        jmiViewTiming.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiViewTimingActionPerformed(evt);
            }
        });
        jmiMenu4.add(jmiViewTiming);

        jMenuBar1.add(jmiMenu4);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jmiNewMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNewMovieActionPerformed
        showScreen(new AddMovieInfo());
    }//GEN-LAST:event_jmiNewMovieActionPerformed

    public void showScreen(JInternalFrame jif) {
        jif.setVisible(true);
        deskPane.add(jif);
        try {
            jif.setSelected(true);
        } catch (PropertyVetoException ex) {
        }
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        DataConnection.closeConnection();
    }//GEN-LAST:event_formWindowClosing

    private void jmiNewScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNewScreenActionPerformed
        showScreen(new AddScreenInfo());
    }//GEN-LAST:event_jmiNewScreenActionPerformed

    private void jmiNewSeatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNewSeatActionPerformed
        showScreen(new AddSeatType());
    }//GEN-LAST:event_jmiNewSeatActionPerformed

    private void jmiNewTimingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNewTimingActionPerformed
        showScreen(new AddMovieTiming());
    }//GEN-LAST:event_jmiNewTimingActionPerformed

    private void jmiNewScreenSeatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNewScreenSeatActionPerformed
        showScreen(new AddScreenSeat());
    }//GEN-LAST:event_jmiNewScreenSeatActionPerformed

    private void jmiMovieInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMovieInfoActionPerformed
        showScreen(new ViewMovieInfo());
    }//GEN-LAST:event_jmiMovieInfoActionPerformed

    private void jmiViewScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiViewScreenActionPerformed
        showScreen(new ViewScreenInfo());
    }//GEN-LAST:event_jmiViewScreenActionPerformed

    private void jmiViewSeatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiViewSeatActionPerformed
        showScreen(new ViewSeatType());
    }//GEN-LAST:event_jmiViewSeatActionPerformed

    private void jmiViewScreenSeatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiViewScreenSeatActionPerformed
        showScreen(new ViewScreenSeat());
    }//GEN-LAST:event_jmiViewScreenSeatActionPerformed

    private void jmiViewTimingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiViewTimingActionPerformed
        showScreen(new ViewMovieTiming());
    }//GEN-LAST:event_jmiViewTimingActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminMainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane deskPane;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jmiMenu1;
    private javax.swing.JMenu jmiMenu2;
    private javax.swing.JMenu jmiMenu3;
    private javax.swing.JMenu jmiMenu4;
    private javax.swing.JMenu jmiMenu5;
    private javax.swing.JMenuItem jmiMovieInfo;
    private javax.swing.JMenuItem jmiNewMovie;
    private javax.swing.JMenuItem jmiNewScreen;
    private javax.swing.JMenuItem jmiNewScreenSeat;
    private javax.swing.JMenuItem jmiNewSeat;
    private javax.swing.JMenuItem jmiNewTiming;
    private javax.swing.JMenuItem jmiViewScreen;
    private javax.swing.JMenuItem jmiViewScreenSeat;
    private javax.swing.JMenuItem jmiViewSeat;
    private javax.swing.JMenuItem jmiViewTiming;
    // End of variables declaration//GEN-END:variables
}
