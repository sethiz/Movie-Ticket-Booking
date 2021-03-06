package adminui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import model.DAO.movietimingDAO;
import model.to.movietimingTO;

/**
 *
 * @author Shubham Sethi
 */
public class ViewMovieTiming extends javax.swing.JInternalFrame {

    List<movietimingTO> timings;
    int row;
    private JPopupMenu popupmenu;
    public ViewMovieTiming() {
        initComponents();
        bindTimingTable();
        row = -1;
        popupmenu = new JPopupMenu();
        JMenuItem jmiDelete = new JMenuItem("Delete This Record");
        JMenuItem jmiEdit = new JMenuItem("Edit This Record");
        jmiDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteRecord();
            }
        });
        jmiEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editRecord();
            }
        });
        popupmenu.add(jmiDelete);
        popupmenu.add(jmiEdit);
    }
    
    private void editRecord() {
        if (row != -1 && timings != null && row < timings.size()) {
            movietimingTO cit = timings.get(row);
            AddMovieTiming aci = new AddMovieTiming(cit);
            aci.setVisible(true);
            getDesktopPane().add(aci);
            try {
                aci.setSelected(true);
            } catch (PropertyVetoException ex) {
                System.out.println(ex);
            }
            dispose();
        }
    }
    
    private void deleteRecord() {
        if (row != -1 && timings != null && row < timings.size()) {
            int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this record?", "Confirm Delete?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
                movietimingTO cit = timings.get(row);
                if(cit!=null){
                    String message = "";
                    movietimingDAO action = new movietimingDAO();
                    if(action.deleteRecord(String.valueOf(cit.getTimingID()))){
                        message = "Movie Timing is Removed from System";
                        bindTimingTable();
                    }else{
                        message = action.getErrormessgae();
                    }
                    JOptionPane.showMessageDialog(this, message);
                }
            }
        }
        row = -1;
    }

    public void bindTimingTable() {
        timings = new movietimingDAO().getAllRecord();
        String[] colnames = {"Movie Name","Screen Name","Start Time","End Time"};
        Object[][] records = null;
        if (timings != null && timings.size() > 0) {
            records = new Object[timings.size()][colnames.length];
            int i = 0;
            for (movietimingTO sit : timings) {
                records[i] = new Object[]{sit.getMoviename(), sit.getScreenname(), sit.getStarttime(), sit.getEndtime()};
                i++;
            }
        } else {
            records = new Object[1][colnames.length];
            records[0] = new Object[]{"No Records", "No Records", "No Records","No Records"};
        }
        DefaultTableModel dtm = new DefaultTableModel(records, colnames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableMovieTiming.getTableHeader().setReorderingAllowed(false);
        tableMovieTiming.setAutoCreateRowSorter(true);
        tableMovieTiming.setModel(dtm);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRefresh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMovieTiming = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("View Movie Timings");

        btnRefresh.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        tableMovieTiming.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        tableMovieTiming.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableMovieTiming.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMovieTimingMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableMovieTiming);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        bindTimingTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void tableMovieTimingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMovieTimingMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            int rowpos = tableMovieTiming.rowAtPoint(evt.getPoint());
            tableMovieTiming.getSelectionModel().setSelectionInterval(rowpos, rowpos);
            popupmenu.show(tableMovieTiming, evt.getX(), evt.getY());
            row = tableMovieTiming.getSelectedRow();
        }
    }//GEN-LAST:event_tableMovieTimingMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableMovieTiming;
    // End of variables declaration//GEN-END:variables
}
