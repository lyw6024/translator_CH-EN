import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

public class apiiDictTranslator
{
	String wbPageCtx;
	public apiiDictTranslator(String wd)
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
	public void showRawWebpage()
	{
		System.out.println(wbPageCtx);
	}
}
