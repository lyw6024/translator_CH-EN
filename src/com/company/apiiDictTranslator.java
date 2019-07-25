package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.*;

public class apiiDictTranslator
{
	private String wbPageCtx;
	private String meaning;
	public apiiDictTranslator(String wd)
	{
		getWbCtx(wd);
        regexParser();
	}
    public String translatorInfo()
    {
        return "\n\t===== Translated by [apii.dict.cn/mini.php]";
    }

    private void getWbCtx(String wd)
    {
        String strUrl="http://apii.dict.cn/mini.php?q="+wd;
        try {
            URL url = new URL(strUrl);
            InputStream in = url.openStream();
            InputStreamReader inpstreamreader = new InputStreamReader(in);
            BufferedReader bufreader = new BufferedReader(inpstreamreader);
            String currGetstr;
            wbPageCtx="";
            while ((currGetstr = bufreader.readLine()) != null) {
                wbPageCtx+=currGetstr;
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

	private void regexParser()
    {
        String meaningPattern="<div id=\"e\">(.*?)</div>";

        Pattern meanRegex=Pattern.compile(meaningPattern);
        Matcher meanGp = meanRegex.matcher(wbPageCtx);
        meaning="";
        if(meanGp.find()) {
            String ctxLines[] = meanGp.group(1).split("<br>");
            for(String it : ctxLines)
                meaning=meaning+it+"\n";
        }
    }
    public String translate()
    {
        return meaning;
    }
}
