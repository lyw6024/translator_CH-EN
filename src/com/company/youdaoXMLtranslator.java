import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

public class youdaoXMLtranslator
{
	String wbPageCtx;
	public youdaoXMLtranslator(String wd)
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
		public void showRawWebpage()
	{
		System.out.println(wbPageCtx);
	}
}
