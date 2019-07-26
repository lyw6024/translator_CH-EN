
package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

public class malicTranslator extends  translator
{
    public malicTranslator(String wd)
    {
        super("http://lab.malic.xyz/dict/query.php?q="+wd);
        apiResource="lab.malic.xyz/dict";
    }
    void parser()
    {
        meaning=wbpageCtx;
    }
}
