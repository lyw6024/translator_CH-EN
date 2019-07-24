package com.company;

import java.io.*;


public class Main {

    public static void main(String args[])  {
        try {
            BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Init OK,\ninput a word:");
            String toLookUpWord=bf.readLine();


            malicTranslator s=new malicTranslator(toLookUpWord);
            System.out.println(s.translatorInfo());
            System.out.println(s.translate());


			apiiDictTranslator s2=new apiiDictTranslator(toLookUpWord);
            System.out.println(s2.translatorInfo());
			s2.regexParser();
            System.out.println(s2.translate());


			youdaoXMLtranslator s3= new youdaoXMLtranslator(toLookUpWord);
            System.out.println(s3.translatorInfo());
			s3.showRawWebpage();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


