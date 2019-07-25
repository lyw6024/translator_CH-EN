package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;

import java.io.*;
import java.net.*;

public class youdaoXMLtranslator
{
	String wbPageCtx;
	String meaning;
    public youdaoXMLtranslator(String wd)
    {
		getWbCtx(wd);
		xmlParser();
	}
    public String translatorInfo()
    {
        return "\t===== Translated by [fanyi.youdao.com]";
    }
    private void showRawWebpage()
	{
		System.out.println(wbPageCtx);
	}
    private void getWbCtx(String wd)
    {
        String strUrl="http://fanyi.youdao.com/translate?&i="+wd+"&doctype=xml";
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
	private void xmlParser()
    {

        try
        {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new InputSource(new StringReader(wbPageCtx)));

            //Node inpCtx= doc.getElementsByTagName("input").item(0);
            Node transCtx = doc.getElementsByTagName("translation").item(0);
            meaning=transCtx.getTextContent().trim();
        }
        catch (ParserConfigurationException e)
        {
            System.out.println("Doc builder Error");
            System.exit(0);
        }
        catch (SAXException e)
        {
            System.out.println("XML format error");
            System.exit(0);
        }
        catch (IOException e)
        {
            System.out.println("IOE");
            System.exit(0);
        }
    }
    public String translate()
    {
        return meaning+"\n";
    }

}
