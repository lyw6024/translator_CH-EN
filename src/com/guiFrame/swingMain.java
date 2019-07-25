package com.guiFrame;

import javax.swing.*;

public class swingMain {
    public static void main(String[] argv)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
    private static void createAndShowGUI()
    {
//        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame=new JFrame("translator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(460,300);

        JPanel panel1=new JPanel();
        panel1.setLayout(null);

        JLabel inputLabelInfo=new JLabel("input a word");
        inputLabelInfo.setBounds(20,20,80,25);
        panel1.add(inputLabelInfo);

        JTextField inputText = new JTextField();
        inputText.setBounds(120,20,165,25);
        panel1.add(inputText);

        JButton sumbitBtn =new JButton("translate");
        sumbitBtn.setBounds(310,20,90,25);
        panel1.add(sumbitBtn);

        JLabel outputLabelInfo = new JLabel("Translate");
        outputLabelInfo.setBounds(20,60,80,25);
        panel1.add(outputLabelInfo);

        JTextArea res=new JTextArea();
        res.setBounds(20,100,400,150);
        panel1.add(res);

        frame.add(panel1);



        frame.setVisible(true);
    }
}
