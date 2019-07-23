package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

public class Solver {
    private String meaning;

    public Solver(String wd)
    {
        String strUrl="http://lab.malic.xyz/dict/query.php?q="+wd;
        try {
            URL url = new URL(strUrl);
            InputStream in = url.openStream();
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader bufreader = new BufferedReader(isr);
            String str;
            while ((str = bufreader.readLine()) != null) {
                meaning=str;
            }
            bufreader.close();
            isr.close();
            in.close();
        }
        catch (MalformedURLException e)
        {
            System.out.println("connected error");
            System.exit(0);
        }
        catch (IOException e)
        {
            System.out.println("input error");
            System.exit(0);
        }

    }
    public void translate()
    {
        System.out.println(meaning);
    }

}
