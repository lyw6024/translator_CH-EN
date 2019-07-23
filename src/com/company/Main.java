 

import java.io.*;


public class Main {

    public static void main(String args[])  {
        try {
            BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Init OK,\ninput a word:");
            String toLookUpWord=bf.readLine();
            malicTranslator s=new malicTranslator(toLookUpWord);

            System.out.println(s.translate());
			apiiDictTranslator s2=new apiiDictTranslator(toLookUpWord); 
			s2.showRawWebpage();
			
			youdaoXMLtranslator s3= new youdaoXMLtranslator(toLookUpWord);
			s3.showRawWebpage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


