package com.guiFrame;

import com.company.apiiDictTranslator;
import com.company.malicTranslator;
import com.company.youdaoXMLtranslator;


import javax.swing.*;
import java.awt.event.*;

public class swingMain {
    static JFrame frame;
    static JPanel panel1;
    static JLabel inputLabelInfo,outputLabelInfo;
    static JTextField inputText;
    static JButton submitBtn;
    static JComboBox translateResource;
    static JTextArea res;
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
        frame=new JFrame("translator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(460,300);

        panel1=new JPanel();
        panel1.setLayout(null);

        inputLabelInfo=new JLabel("input a word");
        inputLabelInfo.setBounds(20,20,80,25);
        panel1.add(inputLabelInfo);

        inputText = new JTextField();
        inputText.setBounds(120,20,165,25);
        panel1.add(inputText);

        submitBtn =new JButton("translate");
        submitBtn.setBounds(310,20,90,25);
        submitBtn.addMouseListener(new MyMouseList());
        panel1.add(submitBtn);

        outputLabelInfo = new JLabel("Translate");
        outputLabelInfo.setBounds(20,60,80,25);
        panel1.add(outputLabelInfo);

        translateResource = new JComboBox();
        translateResource.setBounds(120,60,165,25);
        translateResource.addItem("malic-dict");
        translateResource.addItem("dict.cn");
        translateResource.addItem("fanyi.youdao.com");
        translateResource.setSelectedIndex(1);
        panel1.add(translateResource);

        res=new JTextArea();
        res.setBounds(20,100,400,150);
        res.setLineWrap(true);

        panel1.add(res);

        frame.add(panel1);

        frame.setVisible(true);
    }
}

class MyMouseList extends MouseAdapter
{
    public void mouseClicked(MouseEvent e)
    {
        int transResource=swingMain.translateResource.getSelectedIndex();
        String toLookUpWord=swingMain.inputText.getText();
        switch (transResource)
        {
            case 0:
                malicTranslator s0=new malicTranslator(toLookUpWord);
                outputTranslateResult(s0.translate(),s0.transInfo());

                break;
            case 1:
                apiiDictTranslator s1=new apiiDictTranslator(toLookUpWord);
                outputTranslateResult(s1.translate(),s1.transInfo());

                break;
            case 2:
                youdaoXMLtranslator s2= new youdaoXMLtranslator(toLookUpWord);
                outputTranslateResult(s2.translate(),s2.transInfo());

                break;
        }
    }
    private static void outputTranslateResult(String res,String info)
    {
        swingMain.res.setText(res+"\n");
        swingMain.res.append(info);
    }
}