public class youdaoXMLtranslator
{
	public youdaoXMLtranslator()
{
		String strUrl="http://fanyi.youdao.com/translate?&i="+wd+"&doctype=xml";
		try {
            URL url = new URL(strUrl);
            InputStream in = url.openStream();
            InputStreamReader inpstreamreader = new InputStreamReader(in);
            BufferedReader bufreader = new BufferedReader(inpstreamreader);
            String str;
            while ((str = bufreader.readLine()) != null) {
                meaning=str;
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
