package Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

import static Main.MainRequest.ID;
import static Main.MainRequest.page;

public class Form {
    private JPanel jPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JButton поискButton;
    private JButton поискПоIDButton;
    private JScrollPane jScrollPane;
    private JTextPane textPane1;
    private JTextField textField3;
    private JButton номерСтраницыButton;


    public JPanel getjPanel() {
        return jPanel;
    }

    public Form() {


        номерСтраницыButton.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                MainRequest.page = textField3.getText();
                textPane1.setText("\n\n" +MainRequest.finalMethodPage()+"\n\nНомер страницы: "+page);
                textPane1.setCaretPosition(0);
            }
        });

        поискПоIDButton.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {

                ID = textField2.getText();

                try {
                    textPane1.setText("\n\n\n\n\n"+MainRequest.finalMethodByID());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                textPane1.setCaretPosition(0);
                ImageIcon imageIcon = new ImageIcon(MainRequest.file);
                textPane1.insertIcon(imageIcon);


            }
        });


        поискButton.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e)  {
                MainRequest.nameOfFilm = textField1.getText();
                textPane1.setText("\n\n" +MainRequest.finalMethod()+"\n\nНомер страницы: 1");
                textPane1.setCaretPosition(0);
//                textPane1.insertIcon ( new ImageIcon ( "Data/poster.jpg" ) );


//                textPane1.insertIcon ( new ImageIcon ( "Data/poster.jpg" ) );
//                MainRequest.finalMethod(new String());
            }

        });

    }
}
