/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package castracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeSupport;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Sang-Hoo
 */
public class DatePicker extends JPanel {

    public JTextField time;
    private JLabel lbl;
    private JButton[] bt = new JButton[49];
    int day, month, year;
    boolean show = false;
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    private Calendar date;

    public DatePicker(final MainFrame mf, final JLabel dates) {
        //get date and year
        date = Calendar.getInstance();
        day = date.get(Calendar.DATE);
        month = date.get(Calendar.MONTH);
        year = date.get(Calendar.YEAR);
        //set size and border
        this.setSize(600, 400);month = date.get(Calendar.MONTH);
        year = date.get(Calendar.YEAR);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setLayout(null);
        time = new JTextField(getPickedTime());
        time.setBounds(110, 270, 370, 30);
        time.setEditable(false);
        time.setHorizontalAlignment(JTextField.CENTER);
        //create button
        JButton btn = new JButton("Cancel");
        btn.setBounds(250, 0, 100, 30);
        btn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
                for (Component c : mf.jPanel1.getComponents()) {
                    c.setEnabled(true);
                    //mf.Time.setEnabled(true);
                }
                
                setVisible(false);
                show = false;


            }
        });
        this.add(time);
        this.add(btn);
        JButton btn1 = new JButton("<-");
        btn1.setBounds(0, 30, 50, 30);
        add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (month == 0) {
                    month = 11;
                    year--;
                } else {
                    month--;
                }
                display();
            }
        });
        //next month Button
        JButton btn2 = new JButton("->");
        btn2.setBounds(535, 30, 50, 30);
        add(btn2);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (month == 11) {
                    month = 0;
                    year++;
                    display();
                } else {
                    month++;
                    display();
                }

            }
        });
        lbl = new JLabel();
        lbl.setHorizontalAlignment(JLabel.CENTER);
        lbl.setBounds(140, 30, 320, 30);
        add(lbl);

        String[] name = {"Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat"};
        for (int i = 0; i <= 6; i++) {
            bt[i] = new JButton(name[i]);
            bt[i].setBounds(i * 84, 60, 84, 30);
            add(bt[i]);
        }
        for (int i = 7; i <= 48; i++) {
            final int selection = i;
            bt[i] = new JButton();
            bt[i].setBounds((i % 7) * 84, i / 7 * 30 + 60, 84, 30);
            add(bt[i]);
            bt[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    if (!bt[selection].getText().equals("")) {
                        Date oldDate = date.getTime();
                        day = Integer.valueOf(bt[selection].getText());
                        date.set(year, month, day);
                        time.setText(getPickedTime());
                        for (Component c : mf.jPanel1.getComponents()) {
                            c.setEnabled(true);
                            //mf.dleTime.setEnabled(true);
                        }
                        dates.setText(getPickedTime());
                        setVisible(false);
                        show = false;

                        pcs.firePropertyChange("time", oldDate, date.getTime());
                    }
                }
            });
        }
        display();


    }

    public void setPickedDate(Date d) {
        year = d.getYear() + 1900;
        month = d.getMonth();
        day = d.getDate();
        date.setTime(d);
        time.setText(getPickedTime());
    }

    private String getPickedTime() {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
                "EEEE, MMMM, dd, YYYY");
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(year, month, day);
        return sdf.format(cal.getTime());
    }

    public Date getPickedDate() {
        return date.getTime();
    }

    private void display() {
        for (int i = 7; i <= 48; i++) {
            bt[i].setText("");
        }
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MMMM, yyyy");
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, 1);

        lbl.setText(sdf.format(cal.getTime()));

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 1; i <= daysInMonth; i++) {
            int st = 6 + dayOfWeek + i - 1;
            bt[st].setText("" + i);
        }
    }
}
