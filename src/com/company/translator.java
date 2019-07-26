package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class translator {
    public String meaning;
    public String wbpageCtx;
    public String apiResource;
    public translator(String url)
    {
        readWebContent(url);
        parser();
    }
    abstract void parser();

    public String transInfo()
    {
        return "\t===== Translated by ["+apiResource+"]\n";
    };
    public String translate()
    {
        return meaning;
    };
    private void readWebContent(String strUrl)
    {
        try {
            URL url = new URL(strUrl);
            InputStream in = url.openStream();
            InputStreamReader inpstreamreader = new InputStreamReader(in);
            BufferedReader bufreader = new BufferedReader(inpstreamreader);
            String str;
            wbpageCtx="";
            while ((str = bufreader.readLine()) != null) {
                wbpageCtx+=str;
            }
            bufreader.close();
            inpstreamreader.close();
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
}
