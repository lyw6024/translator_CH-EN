package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.*;

public class apiiDictTranslator extends translator
{
    public apiiDictTranslator(String wd)
    {
        super("http://apii.dict.cn/mini.php?q="+wd);
        apiResource="apii.dict.cn";
    }
	void parser()
    {
        String meaningPattern="<div id=\"e\">(.*?)</div>";

        Pattern meanRegex=Pattern.compile(meaningPattern);
        Matcher meanGp = meanRegex.matcher(wbpageCtx);
        meaning="";
        if(meanGp.find()) {
            String ctxLines[] = meanGp.group(1).split("<br>");
            for(String it : ctxLines)
                meaning=meaning+it+"\n";
        }
    }
}
