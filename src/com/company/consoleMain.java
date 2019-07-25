package com.company;

import java.io.*;


public class consoleMain {

    public static void main(String args[])  {
        try {
            BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Input a word:");
            String toLookUpWord=bf.readLine();


            malicTranslator s=new malicTranslator(toLookUpWord);
            System.out.println(s.translatorInfo());
            System.out.println(s.translate());


			apiiDictTranslator s2=new apiiDictTranslator(toLookUpWord);
            System.out.println(s2.translatorInfo());
            System.out.println(s2.translate());


			youdaoXMLtranslator s3= new youdaoXMLtranslator(toLookUpWord);
            System.out.println(s3.translatorInfo());
            System.out.println(s3.translate());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


