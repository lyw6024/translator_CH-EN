package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;

import java.io.*;


public class youdaoXMLtranslator extends translator
{

    public youdaoXMLtranslator(String wd)
    {
        super("http://fanyi.youdao.com/translate?&i="+wd+"&doctype=xml");
        apiResource="fanyi.youdao.com";
	}

	void parser()
    {
        try
        {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new InputSource(new StringReader(wbpageCtx)));

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
}
