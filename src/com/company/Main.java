package com.company;

import java.io.*;
import java.net.*;

public class Main {

    public static void main(String args[]) throws Exception {
        try {
            BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
            String toLookUpWord=bf.readLine();
            String strUrl="http://lab.malic.xyz/dict/query.php?q="+toLookUpWord;
            URL url = new URL(strUrl);
            InputStream in =url.openStream();
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader bufr = new BufferedReader(isr);
            String str;
            while ((str = bufr.readLine()) != null) {
                System.out.println(str);
            }
            bufr.close();
            isr.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
