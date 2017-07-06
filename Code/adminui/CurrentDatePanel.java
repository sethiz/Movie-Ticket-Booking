/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminui;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CurrentDatePanel extends javax.swing.JPanel {

    GregorianCalendar gcal;
    int mon = 0, day = 0;

    public CurrentDatePanel() {
        initComponents();
        gcal = new GregorianCalendar();
        jcbYear.removeAllItems();
        jcbYear.addItem("Year");
        jcbMonth.removeAllItems();
        jcbMonth.addItem("Month");
        jcbDate.removeAllItems();
        jcbDate.addItem("Date");
        int currentyear = gcal.get(Calendar.YEAR);
        for (int year = currentyear; year >= currentyear - 5; year--) {
            jcbYear.addItem(String.valueOf(year));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcbYear = new javax.swing.JComboBox<>();
        jcbMonth = new javax.swing.JComboBox<>();
        jcbDate = new javax.swing.JComboBox<>();

        jcbYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbYear.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbYearItemStateChanged(evt);
            }
        });

        jcbMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbMonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbMonthItemStateChanged(evt);
            }
        });

        jcbDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jcbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbDate, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jcbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jcbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jcbDate, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jcbYearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbYearItemStateChanged
        if (mon == 0) {
            jcbMonth.removeAllItems();
            jcbMonth.addItem("Month");
            if (jcbYear.getSelectedIndex() > 0) {
                MonthName[] allmonths = MonthName.values();
                int startindex = 0;
                int endindex = allmonths.length - 1;
                int selectedyear = Integer.parseInt(jcbYear.getSelectedItem().toString());
                int currentyear = gcal.get(Calendar.YEAR);
                for (int i = startindex; i <= endindex; i++) {
                    jcbMonth.addItem(allmonths[i].toString());
                }
                mon++;
            }

        }
    }//GEN-LAST:event_jcbYearItemStateChanged

    private void jcbMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbMonthItemStateChanged
        jcbDate.removeAllItems();
        jcbDate.addItem("Date");
        if (jcbYear.getSelectedIndex() > 0 && jcbMonth.getSelectedIndex() > 0) {
            int startdate = 1;
            int enddate = 31;
            int selectedyear = Integer.parseInt(jcbYear.getSelectedItem().toString());
            int currentyear = gcal.get(Calendar.YEAR);
            int selectedmonth = jcbMonth.getSelectedIndex();
            int currentmonth = gcal.get(Calendar.MONTH) + 1;
            switch (selectedmonth) {
                case 2:
                    enddate = gcal.isLeapYear(selectedyear) ? 29 : 28;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    enddate = 30;
                    break;
            }
            for (int date = startdate; date <= enddate; date++) {
                jcbDate.addItem(String.valueOf(date));
            }
        }
    }//GEN-LAST:event_jcbMonthItemStateChanged

    public Date getSelectedDate() {
        Date selecteddate = null;
        try {
            if (jcbYear.getSelectedIndex() > 0 && jcbMonth.getSelectedIndex() > 0 && jcbDate.getSelectedIndex() > 0) {
                int year = Integer.parseInt(jcbYear.getSelectedItem().toString());
                int month = jcbMonth.getSelectedIndex();
                int date = jcbDate.getSelectedIndex();
                String datevalue = year + "-" + month + "-" + date;
                selecteddate = Date.valueOf(datevalue);
            }
        } catch (Exception ex) {
        }
        return selecteddate;
    }

    public void setDate(Date date) {
        try {
            String[] values = date.toString().split("-");
            int y = Integer.parseInt(values[0]);
            int m = Integer.parseInt(values[1]);
            int d = Integer.parseInt(values[2]);
            for (int i = 1; i < jcbYear.getItemCount(); i++) {
                int val = Integer.parseInt(jcbYear.getItemAt(i));
                if (val == y) {
                    jcbYear.setSelectedIndex(i);
                    break;
                }
            }
            jcbMonth.setSelectedIndex(m);
            jcbDate.setSelectedIndex(d);
        } catch (Exception ex) {

        }
    }

    public void reset() {
        try {
            jcbYear.setSelectedIndex(0);
            jcbMonth.setSelectedIndex(0);
            jcbDate.setSelectedIndex(0);
        } catch (Exception ex) {

        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jcbDate;
    private javax.swing.JComboBox<String> jcbMonth;
    private javax.swing.JComboBox<String> jcbYear;
    // End of variables declaration//GEN-END:variables
}
