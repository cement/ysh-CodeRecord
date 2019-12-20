package cn.cement.ysh.coderecord.groovy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class GUIform {
    private JCheckBox checkBox1;
    private JTextArea textArea1;
    private JScrollBar scrollBar1;
    private JTextPane textPane1;
    private JTextPane textPane2;
    private JButton button1;
    private JButton textField1;

    public GUIform() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        textField1.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
                super.componentHidden(e);
            }
        });
    }
}
